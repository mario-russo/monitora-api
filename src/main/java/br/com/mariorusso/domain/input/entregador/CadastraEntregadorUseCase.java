package br.com.mariorusso.domain.input.entregador;

import br.com.mariorusso.domain.model.Entregador;
import io.smallrye.mutiny.Uni;

public interface CadastraEntregadorUseCase {

    public Uni<Entregador> execute(Entregador entregador);
}
