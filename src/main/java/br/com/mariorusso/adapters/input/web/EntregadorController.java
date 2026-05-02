package br.com.mariorusso.adapters.input.web;


import br.com.mariorusso.application.entregador.BuscaEntregadorPorEmpresa;
import br.com.mariorusso.application.entregador.BuscaEntregadorPorId;
import br.com.mariorusso.domain.input.entregador.BuscaPorIdUseCase;
import br.com.mariorusso.domain.input.entregador.CadastraEntregadorUseCase;
import br.com.mariorusso.domain.input.entregador.EntregadorDaEmpresaUseCase;
import br.com.mariorusso.domain.model.Empresa;
import br.com.mariorusso.domain.model.Entregador;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/v1/entregador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntregadorController {

    @Inject
    CadastraEntregadorUseCase cadastraEntregador;

    @Inject
    EntregadorDaEmpresaUseCase entregadorDaEmpresaUseCase;

    @Inject
    BuscaPorIdUseCase buscaEntregadorPorId;


    @POST
    @WithTransaction
    public Uni<Response> cadastra (Entregador entregador){
        return  cadastraEntregador.execute(entregador)
                .map(item -> Response.status(Response.Status.CREATED)
                        .entity(item).build())
                .onFailure().recoverWithItem(err-> Response.status(Response.Status.BAD_REQUEST)
                        .entity("Erro ao cadastrar: " + err.getMessage())
                        .build());
    }

    @GET
    @Path("/empresa/{id}")

    public Uni<List<Entregador>> entregadorEmpresa(@PathParam("id") Long id){
        return entregadorDaEmpresaUseCase.execute(new Empresa().setId(id));

    }

    @GET
    @Path("/{id}")

    public Uni<Entregador> BuscaPorId(@PathParam("id") Long id){
        return buscaEntregadorPorId.buscaPorId(id);

    }
}
