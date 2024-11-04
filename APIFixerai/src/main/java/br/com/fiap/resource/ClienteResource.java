package br.com.fiap.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.Cliente;
import br.com.fiap.bo.ClienteBO;
import br.com.fiap.exceptions.ClienteNaoEncontradoException;

@Path("/clientes")
public class ClienteResource {

    private ClienteBO clienteBO = new ClienteBO();
    
    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClienteByCPF(@PathParam("cpf") String cpf) {
        try {
            Cliente cliente = clienteBO.getClienteByCPF(cpf);
            return Response.ok(cliente).build();
        } catch (ClienteNaoEncontradoException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionarCliente(Cliente cliente, @Context UriInfo uriInfo) throws SQLException {
        clienteBO.inserirCliente(cliente);
        UriBuilder uri = uriInfo.getAbsolutePathBuilder();
        uri.path(cliente.getCpf());
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }

    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarCliente(@PathParam("cpf") String cpf, Cliente cliente) {
        try {
            cliente.setCpf(cpf);
            clienteBO.updateCliente(cliente);
            return Response.ok(cliente).build();
        } catch (ClienteNaoEncontradoException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarCliente(@PathParam("cpf") String cpf) {
        try {
            clienteBO.deleteCliente(cpf);
            return Response.noContent().build();
        } catch (ClienteNaoEncontradoException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
