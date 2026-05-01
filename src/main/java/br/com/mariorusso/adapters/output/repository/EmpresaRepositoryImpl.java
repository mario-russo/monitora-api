package br.com.mariorusso.adapters.output.repository;

import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import br.com.mariorusso.adapters.output.entity.EmpresaEntity;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EmpresaRepositoryImpl implements RepositoryCore<Empresa> {

    @Override
    @WithTransaction
    public Uni<Empresa> save(Empresa empresa) {
        EmpresaEntity entity = EmpresaEntity.fromDomain(empresa);

        return  entity.persist()
                .replaceWith(entity.toDomain());

    }

    @Override
    public Uni<List<Empresa>> listAll() {

        return EmpresaEntity.<EmpresaEntity>listAll()
                .map(lista -> lista.stream()
                        .map(EmpresaEntity::toDomain)
                        .toList());
    }

    @Override
    public Uni<Empresa> findById(Long id) {
        return EmpresaEntity.<EmpresaEntity>findById(id)
                .map(entity -> entity != null ? entity.toDomain() : null);
    }

    @Override
    public Uni<Empresa> update(Empresa empresa) {
        return EmpresaEntity.<EmpresaEntity>findById(empresa.getId())
                .onItem().ifNotNull().invoke(entity -> {
                    entity.nome = empresa.getNome();
                    entity.cnpj = empresa.getCnpj();
                    entity.email = empresa.getEmail();
                    entity.telefone = empresa.getTelefone();
                    entity.senha = empresa.getSenha();
                    entity.criadoEm = empresa.getCriadoEm();
                })
                .map(entity -> entity != null ? entity.toDomain() : null);
    }
}
