package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.com.fiap.beans.Cliente;
import br.com.fiap.beans.Veiculo;
import br.com.fiap.bo.VeiculoBO;

@Path("/clientes/veiculos") // Corrigido para não incluir {cpf} no Path
public class VeiculoResource {

    private VeiculoBO veiculoBO = new VeiculoBO();

    public VeiculoResource(VeiculoBO veiculoBO) {
        this.veiculoBO = veiculoBO;
    }
    
    public VeiculoResource() {
        this.veiculoBO = new VeiculoBO(); // Ou você pode fazer a injeção de dependência de outra forma
    }


    @POST
    @Path("/{cpf}") // Adicionando CPF como parte do Path
    public Response cadastrarVeiculo(@PathParam("cpf") String cpf, Veiculo veiculo) {
        try {
            // Aqui você deve associar o cliente ao veículo, usando o CPF
        	if (veiculo.getCliente() == null) {
                veiculo.setCliente(new Cliente());
                veiculo.getCliente().setCpf(cpf);// Cria um novo Cliente se não existir
            }
            veiculo.getCliente().setCpf(cpf);
            veiculoBO.cadastrarVeiculo(veiculo);
            return Response.status(Response.Status.CREATED).entity(veiculo).build(); // Retorna 201 Created
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro ao cadastrar veículo: " + e.getMessage()).build();
        }
    }

    @GET
    @Path("/{cpf}")// Para listar veículos de um cliente
    public Response listarVeiculosPorCliente(@PathParam("cpf") String cpf) {
        try {
            List<Veiculo> veiculos = veiculoBO.listarVeiculosPorCliente(cpf);
            System.out.println(veiculos);
            return Response.ok(veiculos).build(); // Retorna 200 OK
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro ao listar veículos: " + e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{placa}") // Para atualizar um veículo
    public Response atualizarVeiculo(@PathParam("placa") String placa, Veiculo veiculo) {
        try {
            veiculo.setPlaca(placa); // Atualiza a placa do veículo
            veiculoBO.atualizarVeiculo(veiculo);
            return Response.ok(veiculo).build(); // Retorna 200 OK
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro ao atualizar veículo: " + e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{placa}") // Para deletar um veículo
    public Response deletarVeiculo(@PathParam("placa") String placa) {
        try {
            veiculoBO.deletarVeiculo(placa);
            return Response.noContent().build(); // Retorna 204 No Content
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Erro ao excluir veículo: " + e.getMessage()).build();
        }
    }
}
