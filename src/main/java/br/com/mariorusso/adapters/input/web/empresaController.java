package br.com.mariorusso.adapters.input.web;


import br.com.mariorusso.application.empresa.CadastraEmpresaUseCaseImpl;
import br.com.mariorusso.domain.input.empresa.usecase.CadastraEmpresaUseCase;
import br.com.mariorusso.domain.model.Empresa;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("empresa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class empresaController {
    @Inject
    CadastraEmpresaUseCase empresaUseCase;

    @POST
    public Uni<Response> cadastra(Empresa empresa){
        return empresaUseCase.exec(empresa)
                .map(item -> Response.status(Response.Status.CREATED)
                        .entity(item).build())
                .onFailure().recoverWithItem(err-> Response.status(Response.Status.BAD_REQUEST)
                        .entity("Erro ao cadastrar: " + err.getMessage())
                        .build());

    }

}
