package br.com.mariorusso.domain.input.entrega;

import br.com.mariorusso.domain.model.Entrega;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface BuscaEntregaPorEmpresaUseCase {

    public Uni<List<Entrega>> buscaPorEnpresa(Long id);
}
