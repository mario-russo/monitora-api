package br.com.mariorusso.adapters.input.web;


import br.com.mariorusso.domain.input.entrega.CadastraEntregaUseCase;
import br.com.mariorusso.domain.model.Entrega;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/entrega")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntregaController {

    @Inject
    CadastraEntregaUseCase  cadastraEntrega;

    @POST

    public Uni<Response> cadastraEntrega(Entrega entrega) {
        return cadastraEntrega.cadastra(entrega)
                .onItem()
                .ifNull()
                .failWith(() -> new WebApplicationException("Erro ao cadastrar entrega", 400))
                .onItem()
                .transform(result ->
                        Response.status(Response.Status.CREATED)
                                .entity(result)
                                .build()
                );
    }

}
