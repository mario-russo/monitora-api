package br.com.mariorusso.adapters.input.web;

import br.com.mariorusso.domain.model.Localizacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/ws/localizacao")
public class EnviaLocalizacao {

    // 👥 clientes conectados
    private static Set<Session> sessions = ConcurrentHashMap.newKeySet();

    // 📡 quem está inscrito em qual entregador
    private static Map<Long, Set<Session>> subscribers = new ConcurrentHashMap<>();

    private static ObjectMapper mapper = new ObjectMapper();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("🟢 Conectou: " + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        try {
            // 🧠 tenta ler como mapa (pra detectar subscribe)
            Map<String, Object> msg = mapper.readValue(message, Map.class);

            // 📌 CASO 1: cliente quer se inscrever
            if ("subscribe".equals(msg.get("tipo"))) {
                Long entregadorId = ((Number) msg.get("entregadorId")).longValue();

                subscribers
                        .computeIfAbsent(entregadorId, k -> ConcurrentHashMap.newKeySet())
                        .add(session);

                System.out.println("👀 Cliente inscrito no entregador " + entregadorId);
                return;
            }

            // 📌 CASO 2: é localização (entregador)
            Localizacao loc = mapper.readValue(message, Localizacao.class);

            System.out.println("📥 Localização recebida: " + message);

            // pega quem quer esse entregador
            Set<Session> interessados = subscribers.get(loc.longitude);

            if (interessados != null) {
                String json = mapper.writeValueAsString(loc);

                interessados.forEach(s -> {
                    if (s.isOpen()) {
                        s.getAsyncRemote().sendText(json);
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);

        // 🔥 remove de todas as inscrições
        subscribers.values().forEach(set -> set.remove(session));

        System.out.println("🔴 Desconectou: " + session.getId());
    }
}