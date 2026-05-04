package br.com.mariorusso.adapters.config;

import br.com.mariorusso.application.entrega.BuscaPorEmpresaUseCaseImpl;
import br.com.mariorusso.application.entrega.BuscaPorEntregadorUseCaseImpl;
import br.com.mariorusso.application.entrega.CadastraEntregaUseCaseImpl;

import br.com.mariorusso.domain.input.entrega.BuscaEntregaPorEmpresaUseCase;
import br.com.mariorusso.domain.input.entrega.BuscaEntregaPorEntregadorUseCase;
import br.com.mariorusso.domain.input.entrega.CadastraEntregaUseCase;
import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.model.Entrega;
import br.com.mariorusso.domain.model.Entregador;
import br.com.mariorusso.domain.output.repository.FindByFields;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

public class BeanConfigurationEntrega {

    @Produces
    @ApplicationScoped
    public CadastraEntregaUseCase cadastraEntregaUseCase(RepositoryCore<Entrega> entregaRepository,
                                                         RepositoryCore<Empresa> empresaRepository,
                                                         RepositoryCore<Entregador> entregadorRepository){
    return new CadastraEntregaUseCaseImpl(entregaRepository,empresaRepository,entregadorRepository);
    }

    @Produces
    @ApplicationScoped
    public BuscaEntregaPorEntregadorUseCase buscaEntregaPorEntregadorUseCase(FindByFields<Entrega> fields){
        return  new BuscaPorEntregadorUseCaseImpl(fields);
    }

    @Produces
    @ApplicationScoped
    public BuscaEntregaPorEmpresaUseCase buscaEntregadorPorEmpresa(FindByFields<Entrega> fields){
        return  new BuscaPorEmpresaUseCaseImpl(fields);
    }
}
