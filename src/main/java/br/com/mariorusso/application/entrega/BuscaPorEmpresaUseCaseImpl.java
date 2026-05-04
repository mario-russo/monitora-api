package br.com.mariorusso.application.entrega;

import br.com.mariorusso.domain.input.entrega.BuscaEntregaPorEmpresaUseCase;
import br.com.mariorusso.domain.model.Entrega;
import br.com.mariorusso.domain.output.repository.FindByFields;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class BuscaPorEmpresaUseCaseImpl implements BuscaEntregaPorEmpresaUseCase {

    private final FindByFields<Entrega> fields;

    public BuscaPorEmpresaUseCaseImpl(FindByFields<Entrega> fields) {
        this.fields = fields;
    }

    @Override
    public Uni<List<Entrega>> buscaPorEnpresa(Long id) {
        return  fields.findByField("empresa.id", id);
    }
}
