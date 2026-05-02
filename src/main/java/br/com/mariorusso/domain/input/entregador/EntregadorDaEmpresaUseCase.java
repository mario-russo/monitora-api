package br.com.mariorusso.domain.input.entregador;

import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.model.Entregador;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface EntregadorDaEmpresaUseCase {
    public Uni<List<Entregador>> execute(Empresa entregador);
}
