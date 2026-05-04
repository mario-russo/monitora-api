package br.com.mariorusso.application.entrega;

import br.com.mariorusso.domain.input.entrega.BuscaEntregaPorEntregadorUseCase;
import br.com.mariorusso.domain.model.Entrega;
import br.com.mariorusso.domain.output.repository.FindByFields;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class BuscaPorEntregadorUseCaseImpl implements BuscaEntregaPorEntregadorUseCase {

    private final FindByFields<Entrega> fields;

    public BuscaPorEntregadorUseCaseImpl(FindByFields<Entrega> fields) {
        this.fields = fields;
    }

    @Override
    public Uni<List<Entrega>> buscaPorEntregador(Long id) {
        return fields.findByField("entregador.id", id);
    }
}
