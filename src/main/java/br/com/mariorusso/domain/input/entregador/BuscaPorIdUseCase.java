package br.com.mariorusso.domain.input.entregador;


import br.com.mariorusso.domain.model.Entregador;
import io.smallrye.mutiny.Uni;

public interface BuscaPorIdUseCase {
    public Uni<Entregador> buscaPorId(Long id);
}
