package br.com.mariorusso.adapters.config;

import br.com.mariorusso.application.entregador.BuscaEntregadorPorEmpresa;
import br.com.mariorusso.application.entregador.BuscaEntregadorPorId;
import br.com.mariorusso.application.entregador.CadastraEntregadorUseCaseImpl;
import br.com.mariorusso.domain.input.entregador.BuscaPorIdUseCase;
import br.com.mariorusso.domain.input.entregador.CadastraEntregadorUseCase;
import br.com.mariorusso.domain.input.entregador.EntregadorDaEmpresaUseCase;
import br.com.mariorusso.domain.model.Entregador;
import br.com.mariorusso.domain.output.repository.FindByFields;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

public class BeanConfigurationEntregador {

    @Produces
    @ApplicationScoped
    public CadastraEntregadorUseCase cadastrarEntregadorUseCase(RepositoryCore<Entregador> repositoryCore){
         return new CadastraEntregadorUseCaseImpl(repositoryCore);
    }
    @Produces
    @ApplicationScoped
    public EntregadorDaEmpresaUseCase buscaEntregadorPorEmpresa(FindByFields<Entregador> repositoryCore){
         return new BuscaEntregadorPorEmpresa(repositoryCore);
    }
    @Produces
    @ApplicationScoped
    public BuscaPorIdUseCase buscaPorIdUseCase(RepositoryCore<Entregador> repository){
        return new BuscaEntregadorPorId(repository);
    }
}
