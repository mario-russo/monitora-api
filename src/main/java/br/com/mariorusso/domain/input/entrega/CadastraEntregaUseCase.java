package br.com.mariorusso.domain.input.entrega;

import br.com.mariorusso.domain.model.Entrega;
import io.smallrye.mutiny.Uni;

public interface CadastraEntregaUseCase {

    public Uni<Entrega> cadastra(Entrega entrega);
}
