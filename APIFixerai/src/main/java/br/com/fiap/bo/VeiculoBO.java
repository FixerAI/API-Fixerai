package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.beans.Veiculo;
import br.com.fiap.dao.VeiculoDAO;

public class VeiculoBO {
    private VeiculoDAO veiculoDAO = new VeiculoDAO();


    public void cadastrarVeiculo(Veiculo veiculo) throws SQLException {
        veiculoDAO.inserirVeiculo(veiculo);
    }

    public Veiculo buscarVeiculo(String placa) throws SQLException {
        return veiculoDAO.buscarVeiculo(placa);
    }

    public List<Veiculo> listarVeiculosPorCliente(String cpf) throws SQLException {
        return veiculoDAO.listarVeiculosPorCliente(cpf);
    }

    public void atualizarVeiculo(Veiculo veiculo) throws SQLException {
        veiculoDAO.atualizarVeiculo(veiculo);
    }

    public void deletarVeiculo(String placa) throws SQLException {
        veiculoDAO.deletarVeiculo(placa);
    }
}
