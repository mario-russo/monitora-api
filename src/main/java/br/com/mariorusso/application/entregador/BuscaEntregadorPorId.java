package br.com.mariorusso.application.entregador;

import br.com.mariorusso.adapters.output.entity.EntregadorEntity;
import br.com.mariorusso.domain.input.entregador.BuscaPorIdUseCase;
import br.com.mariorusso.domain.model.Entregador;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class BuscaEntregadorPorId implements BuscaPorIdUseCase {

    final RepositoryCore<Entregador> repositoryCore;

    public BuscaEntregadorPorId(RepositoryCore<Entregador> repositoryCore) {
        this.repositoryCore = repositoryCore;
    }

    @Override
    public Uni<Entregador> buscaPorId(Long id) {
        return repositoryCore.findById(id);
    }
}
