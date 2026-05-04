package br.com.mariorusso.domain.input.entrega;

import br.com.mariorusso.domain.model.Entrega;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface BuscaEntregaPorEntregadorUseCase {

    public Uni<List<Entrega>> buscaPorEntregador(Long id);
}
