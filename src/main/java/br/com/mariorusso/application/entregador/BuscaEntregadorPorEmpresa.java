package br.com.mariorusso.application.entregador;

import br.com.mariorusso.domain.input.entregador.EntregadorDaEmpresaUseCase;
import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.model.Entregador;
import br.com.mariorusso.domain.output.repository.FindByFields;
import br.com.mariorusso.domain.output.repository.RepositoryCore;
import io.smallrye.mutiny.Uni;

import java.util.List;

public class BuscaEntregadorPorEmpresa implements EntregadorDaEmpresaUseCase {

    final FindByFields<Entregador> findByField;

    public BuscaEntregadorPorEmpresa(FindByFields<Entregador> fields) {
        this.findByField = fields;
    }

    @Override
    public Uni<List<Entregador>> execute(Empresa empresa) {
        return findByField.findByField("empresa.id", empresa.getId());
    }
}
