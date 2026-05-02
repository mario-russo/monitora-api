package br.com.mariorusso.adapters.config;

import br.com.mariorusso.application.empresa.CadastraEmpresaUseCaseImpl;
import br.com.mariorusso.domain.input.empresa.usecase.CadastraEmpresaUseCase;
import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

public class BeanConfigurationEmpresa {

    @Produces
    @ApplicationScoped
    public CadastraEmpresaUseCase cadastraEmpresaUseCase (RepositoryCore<Empresa> repositoryCore){
        return new CadastraEmpresaUseCaseImpl(repositoryCore);
    }
}
