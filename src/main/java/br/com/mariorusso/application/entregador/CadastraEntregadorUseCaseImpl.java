package br.com.mariorusso.application.entregador;

import br.com.mariorusso.adapters.output.entity.EmpresaEntity;
import br.com.mariorusso.domain.input.empresa.usecase.CadastraEmpresaUseCase;
import br.com.mariorusso.domain.input.entregador.CadastraEntregadorUseCase;
import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.model.Entregador;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;

public class CadastraEntregadorUseCaseImpl implements CadastraEntregadorUseCase {

    private final RepositoryCore<Entregador> repositoryCore;

    public CadastraEntregadorUseCaseImpl(RepositoryCore<Entregador> repositoryCore) {
        this.repositoryCore = repositoryCore;
    }

    @Override
    @WithTransaction
    public Uni<Entregador> execute(Entregador entregador) {
        if (entregador.getEmpresa() != null && entregador.getEmpresa().getId() != null) {
            return EmpresaEntity.<EmpresaEntity>findById(entregador.getEmpresa().getId())
                    .onItem().ifNull().failWith(() -> new IllegalArgumentException("Empresa não encontrada"))
                    .onItem().transformToUni(empresaEntity -> {
                        // Converte EmpresaEntity para Empresa (domain)
                        Empresa empresaDomain = empresaEntity.toDomain();
                        entregador.setEmpresa(empresaDomain);
                        return repositoryCore.save(entregador);
                    });
        }
        return repositoryCore.save(entregador);
    }
}
