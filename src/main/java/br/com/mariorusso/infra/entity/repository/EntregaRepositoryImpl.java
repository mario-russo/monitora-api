package br.com.mariorusso.infra.entity.repository;

import br.com.mariorusso.domain.repository.RepositoryCore;
import br.com.mariorusso.infra.entity.EntregaEntity;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class EntregaRepositoryImpl implements RepositoryCore<EntregaEntity> {

    @Override
    public Uni<EntregaEntity> save(EntregaEntity entity) {
        return entity.persist()
                .replaceWith(entity);
    }

    @Override
    public Uni<List<EntregaEntity>> listAll() {
        return EntregaEntity.<EntregaEntity>listAll();
    }

    @Override
    public Uni<EntregaEntity> findById(Long id) {
        return EntregaEntity.<EntregaEntity>findById(id);    }

    @Override
    public Uni<EntregaEntity> update(EntregaEntity entrega) {
        return EntregaEntity.<EntregaEntity>findById(entrega.id)
                .onItem().ifNotNull().invoke(entity -> {

                    entity.empresa = entrega.empresa;
                    entity.entregador = entrega.entregador;
                    entity.clienteNome = entrega.clienteNome;
                    entity.clienteTelefone = entrega.clienteTelefone;
                    entity.endereco = entrega.endereco;
                    entity.localizacaoAtual = entrega.localizacaoAtual;
                    entity.numeroCupom = entrega.numeroCupom;
                    entity.status = entrega.status;
                    entity.aceitoEm = entrega.aceitoEm;
                    entity.iniciadoEm = entrega.iniciadoEm;
                    entity.entregueEm = entrega.entregueEm;
                })
                .map(entity -> entity);
    }
}
