package br.com.mariorusso.domain.input.empresa.usecase;

import br.com.mariorusso.domain.model.Empresa;
import io.smallrye.mutiny.Uni;

public interface CadastraEmpresaUseCase {
    public Uni<Empresa> exec(Empresa empresa);
}
