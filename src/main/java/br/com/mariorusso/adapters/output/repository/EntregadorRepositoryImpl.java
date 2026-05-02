package br.com.mariorusso.adapters.output.repository;

import br.com.mariorusso.adapters.output.entity.EmpresaEntity;
import br.com.mariorusso.adapters.output.entity.EntregadorEntity;
import br.com.mariorusso.domain.model.Entregador;
import br.com.mariorusso.domain.output.repository.FindByFields;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EntregadorRepositoryImpl implements RepositoryCore<Entregador>, FindByFields<Entregador> {


    @Override
    @WithTransaction
    public Uni<Entregador> save(Entregador entregador) {
        EntregadorEntity entity = EntregadorEntity.fromEntregador(entregador);

        return EmpresaEntity.<EmpresaEntity>findById(
                        entregador.getEmpresa().getId()
                )
                .onItem().ifNull()
                .failWith(() -> new RuntimeException("Empresa não encontrada"))

                .chain(empresa -> {
                    entity.setEmpresa(empresa);

                    return entity.persist()
                            .replaceWith(entity.toDomain());
                });
    }

    @Override
    public Uni<List<Entregador>> listAll() {
        return EntregadorEntity.<EntregadorEntity>listAll()
                .map(lista -> lista.stream()
                        .map(EntregadorEntity::toDomain)
                        .toList());
    }

    @Override
    @WithTransaction
    public Uni<Entregador> findById(Long id) {
        return EntregadorEntity.<EntregadorEntity>findById(id)
                .map(entity -> entity != null ? entity.toDomain() : null);
    }

    @Override
    public Uni<Entregador> update(Entregador entregador) {

        return EntregadorEntity.<EntregadorEntity>findById(entregador.getId())
                .onItem().ifNull()
                .failWith(() -> new RuntimeException("Entregador não encontrado"))

                .chain(entity -> {

                    entity.setNomeCompleto(entregador.getNomeCompleto());
                    entity.setCpf(entregador.getCpf());
                    entity.setTelefone(entregador.getTelefone());
                    entity.setEmail(entregador.getEmail());
                    entity.setVeiculo(entregador.getVeiculo());
                    entity.setPlaca(entregador.getPlaca());

                    // Se veio empresa para alterar relacionamento
                    if (entregador.getEmpresa() != null &&
                            entregador.getEmpresa().getId() != null) {

                        return EmpresaEntity.<EmpresaEntity>findById(
                                        entregador.getEmpresa().getId()
                                )
                                .onItem().ifNull()
                                .failWith(() -> new RuntimeException("Empresa não encontrada"))

                                .map(empresa -> {
                                    entity.setEmpresa(empresa);
                                    return entity.toDomain();
                                });
                    }

                    return Uni.createFrom().item(entity.toDomain());
                });
    }
    @Override
    @WithTransaction
    public Uni<List<Entregador>> findByField(String key, Object value) {

        return EntregadorEntity.<EntregadorEntity>find(key, value)
                .list()
                .map(lista -> lista.stream()
                        .map(EntregadorEntity::toDomain)
                        .toList());
    }
}
