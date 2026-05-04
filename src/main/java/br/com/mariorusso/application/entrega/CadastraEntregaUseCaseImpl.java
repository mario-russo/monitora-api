package br.com.mariorusso.application.entrega;

import br.com.mariorusso.domain.input.entrega.CadastraEntregaUseCase;
import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.model.Entrega;
import br.com.mariorusso.domain.model.Entregador;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.NotFoundException;

public class CadastraEntregaUseCaseImpl implements CadastraEntregaUseCase {

    private final RepositoryCore<Entrega> entregaRepository;
    private final RepositoryCore<Empresa> empresaRepository;
    private final RepositoryCore<Entregador> entregadorRepository;

    public CadastraEntregaUseCaseImpl(RepositoryCore<Entrega> entregaRepository,
                                      RepositoryCore<Empresa> empresaRepository,
                                      RepositoryCore<Entregador> entregadorRepository) {
        this.entregaRepository = entregaRepository;
        this.empresaRepository = empresaRepository;
        this.entregadorRepository = entregadorRepository;
    }

    @Override
    public Uni<Entrega> cadastra(Entrega entrega) {


        return empresaRepository.findById(entrega.getEmpresa())
                .onItem().ifNull()
                .failWith(() -> new NotFoundException("Empresa não encontrada"))

                .chain(() ->
                        entregadorRepository.findById(entrega.getEntregador())
                                .onItem().ifNull()
                                .failWith(() -> new NotFoundException("Entregador não encontrado"))
                )

                .chain(() -> entregaRepository.save(entrega));
    }
}
