package br.com.mariorusso.application.empresa;

import br.com.mariorusso.domain.input.empresa.usecase.CadastraEmpresaUseCase;
import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import io.smallrye.mutiny.Uni;

public class CadastraEmpresaUseCaseImpl implements CadastraEmpresaUseCase {
    private final RepositoryCore<Empresa> repository;

    public CadastraEmpresaUseCaseImpl(RepositoryCore<Empresa> repositoryCore) {
    this.repository = repositoryCore;
    }

    @Override
    public Uni<Empresa> exec(Empresa empresa) {
        return repository.save(empresa);
    }
}
