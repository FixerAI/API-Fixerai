package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Veiculo;
import br.com.fiap.conexao.ConexaoFactory;

public class VeiculoDAO {
	private Connection connection;

	public VeiculoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public VeiculoDAO() {
        try {
            
            this.connection = new ConexaoFactory().conexao();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao obter conexão: " + e.getMessage());
        }
    }

	public void inserirVeiculo(Veiculo veiculo) throws SQLException {
		String sql = "INSERT INTO veiculos (placa, marca, modelo, tipo, cor, ano, cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, veiculo.getPlaca());
			stmt.setString(2, veiculo.getMarca());
			stmt.setString(3, veiculo.getModelo());
			stmt.setString(4, veiculo.getTipo());
			stmt.setString(5, veiculo.getCor());
			stmt.setDate(6, java.sql.Date.valueOf(veiculo.getAno()));
			stmt.setString(7, veiculo.getCliente().getCpf());
			stmt.executeUpdate();
			System.out.println("Veículo cadastrado com sucesso!" + veiculo.getPlaca());
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar o veículo" + e.getMessage());
		}
	}
	

	public Veiculo buscarVeiculo(String placa) throws SQLException {
        String sql = "SELECT * FROM veiculos WHERE placa = ?";
        Veiculo veiculo = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            		veiculo = new Veiculo();
                    veiculo.setPlaca(rs.getString("placa"));
                    veiculo.setMarca(rs.getString("marca"));
                    veiculo.setModelo(rs.getString("modelo"));
                    veiculo.setTipo(rs.getString("tipo"));
                    veiculo.setCor(rs.getString("cor"));
                    veiculo.setAno(rs.getDate("ano").toLocalDate());
            }
        } catch (SQLException e) {
			System.out.println("Erro ao procurar o veículo" + e.getMessage());
		}
        return veiculo;
    }
	
	public void atualizarVeiculo(Veiculo veiculo) throws SQLException {
		String sql = "UPDATE veiculos SET marca = ?, modelo = ?, tipo = ?, cor = ?, ano = ?, cpf = ? WHERE placa = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, veiculo.getMarca());
			stmt.setString(2, veiculo.getModelo());
			stmt.setString(3, veiculo.getTipo());
			stmt.setString(4, veiculo.getCor());
			stmt.setDate(5, java.sql.Date.valueOf(veiculo.getAno()));
			stmt.setString(6, veiculo.getCliente().getCpf());
			stmt.setString(7, veiculo.getPlaca());
			stmt.executeUpdate();
			System.out.println("Veiculo atualizado com sucesso!");
		}
		catch (SQLException e) {
			System.out.println("Erro ao atualizar veículo" + e.getMessage());
		}
	}

	

	public void deletarVeiculo(String placa) throws SQLException {
		String sql = "DELETE FROM veiculos WHERE placa = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, placa);
			stmt.executeUpdate();
			System.out.println("Veículo excluido com sucesso!");
		}
		catch (SQLException e) {
			System.out.println("Erro ao deletar veículo" + e.getMessage());
		}
	}
	
	public List<Veiculo> listarVeiculosPorCliente(String cpf) throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculos WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Veiculo veiculo = new Veiculo(
                        rs.getString("placa"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("tipo"),
                        rs.getString("cor"),
                        rs.getDate("ano").toLocalDate(),
                        null
                    );
                    veiculos.add(veiculo);
                }
            }
        }
        catch (SQLException e) {
			System.out.println("Erro ao listar veículos" + e.getMessage());
		}
        return veiculos;
    }
}
