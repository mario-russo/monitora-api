package br.com.mariorusso.adapters.output.repository;

import br.com.mariorusso.adapters.output.entity.EmpresaEntity;
import br.com.mariorusso.adapters.output.entity.EntregadorEntity;
import br.com.mariorusso.adapters.output.entity.EntregaEntity;
import br.com.mariorusso.domain.model.Entrega;
import br.com.mariorusso.domain.output.repository.FindByFields;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

@ApplicationScoped
public class EntregaRepositoryImpl implements RepositoryCore<Entrega>, FindByFields<Entrega> {

    // =========================
    // SAVE
    // =========================
    @Override
    @WithTransaction
    public Uni<Entrega> save(Entrega entrega) {

        return EmpresaEntity.<EmpresaEntity>findById(entrega.getEmpresa())
                .onItem().ifNull()
                .failWith(() -> new NotFoundException("Empresa não encontrada"))

                .chain(empresa ->
                        EntregadorEntity.<EntregadorEntity>findById(entrega.getEntregador())
                                .onItem().ifNull()
                                .failWith(() -> new NotFoundException("Entregador não encontrado"))

                                .map(entregador -> {
                                    EntregaEntity entity = EntregaEntity.fromEntrega(entrega);
                                    entity.setEmpresaId(empresa.id);
                                    entity.setEntregadorId(entregador.id);
                                    return entity;
                                })
                )

                .chain(entity -> entity.<EntregaEntity>persist())

                .map(persisted -> {
                    entrega.setId(persisted.id);
                    return entrega;
                });
    }

    // =========================
    // LIST ALL
    // =========================
    @Override
    public Uni<List<Entrega>> listAll() {
        return EntregaEntity.<EntregaEntity>listAll()
                .map(list -> list.stream()
                        .map(EntregaEntity::toDomain)
                        .toList());
    }

    // =========================
    // FIND BY ID
    // =========================
    @Override
    public Uni<Entrega> findById(Long id) {
        return EntregaEntity.<EntregaEntity>findById(id)
                .onItem().ifNull()
                .failWith(() -> new NotFoundException("Entrega não encontrada"))
                .onItem()
                .transform(EntregaEntity::toDomain);
    }

    // =========================
    // UPDATE
    // =========================
    @Override
    @WithTransaction
    public Uni<Entrega> update(Entrega entrega) {

        return EntregaEntity.<EntregaEntity>findById(entrega.getId())
                .onItem().ifNull()
                .failWith(() -> new NotFoundException("Entrega não encontrada"))

                .chain(entity ->
                        EmpresaEntity.<EmpresaEntity>findById(entrega.getEmpresa())
                                .onItem().ifNull()
                                .failWith(() -> new NotFoundException("Empresa não encontrada"))

                                .chain(empresa ->
                                        EntregadorEntity.<EntregadorEntity>findById(entrega.getEntregador())
                                                .onItem().ifNull()
                                                .failWith(() -> new NotFoundException("Entregador não encontrado"))

                                                .invoke(entregador -> {
                                                    entity.setEmpresaId(empresa.id);
                                                    entity.setEntregadorId(entregador.id);

                                                    entity.setClienteNome(entrega.getClienteNome());
                                                    entity.setClienteTelefone(entrega.getClienteTelefone());
                                                    entity.setEndereco(entrega.getEndereco());
                                                    entity.setLocalizacaoAtual(entrega.getLocalizacaoAtual());
                                                    entity.setNumeroCupom(entrega.getNumeroCupom());
                                                    entity.setStatus(entrega.getStatus());
                                                    entity.setAceitoEm(entrega.getAceitoEm());
                                                    entity.setIniciadoEm(entrega.getIniciadoEm());
                                                    entity.setEntregueEm(entrega.getEntregueEm());
                                                })
                                )
                                .replaceWith(entity)
                )

                .map(EntregaEntity::toDomain);
    }

    // =========================
    // FIND BY FIELD
    // =========================
    @Override
    public Uni<List<Entrega>> findByField(String key, Object value) {
        return EntregaEntity.<EntregaEntity>find(key, value)
                .list()
                .map(list -> list.stream()
                        .map(EntregaEntity::toDomain)
                        .toList());
    }
}