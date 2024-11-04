package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.beans.Cliente;
import br.com.fiap.conexao.ConexaoFactory;

public class ClienteDAO {
    
    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    
    public ClienteDAO() {
        try {
            
            this.connection = new ConexaoFactory().conexao();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao obter conexão: " + e.getMessage());
        }
    }

    public void insertCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (cpf, nome, email, data_nasc, logradouro, numero, cep, bairro, complemento, telefone, num_cnh, dt_val_cnh, dt_emissao_cnh, categoria_cnh) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEmail());
            stmt.setDate(4, java.sql.Date.valueOf(cliente.getDataNasc()));
            stmt.setString(5, cliente.getLogradouro());
            stmt.setInt(6, cliente.getNumero());
            stmt.setString(7, cliente.getCep());
            stmt.setString(8, cliente.getBairro());
            stmt.setString(9, cliente.getComplemento());
            stmt.setString(10, cliente.getTelefone());
            stmt.setString(11, cliente.getNumeroCNH());
            stmt.setDate(12, java.sql.Date.valueOf(cliente.getDataVali()));
            stmt.setDate(13, java.sql.Date.valueOf(cliente.getDataEmissao()));
            stmt.setString(14, cliente.getCategoria());

            stmt.executeUpdate();

            System.out.println("Cliente inserido com sucesso! " + cliente.getCpf());

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public Cliente getClienteByCpf(String cpf) {
        String sql = "SELECT * FROM clientes WHERE cpf = ?";
        Cliente cliente = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setDataNasc(rs.getDate("data_nasc").toLocalDate());
                    cliente.setLogradouro(rs.getString("logradouro"));
                    cliente.setNumero(rs.getInt("numero"));
                    cliente.setCep(rs.getString("cep"));
                    cliente.setBairro(rs.getString("bairro"));
                    cliente.setComplemento(rs.getString("complemento"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setNumeroCNH(rs.getString("num_cnh"));
                    cliente.setDataVali(rs.getDate("dt_val_cnh").toLocalDate());
                    cliente.setDataEmissao(rs.getDate("dt_emissao_cnh").toLocalDate());
                    cliente.setCategoria(rs.getString("categoria_cnh"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cliente: " + e.getMessage());
        }

        return cliente;
    }
    
    
    
    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, data_nasc = ?, logradouro = ?, numero = ?, cep = ?, bairro = ?, complemento = ?, telefone = ?, num_cnh = ?, dt_val_cnh = ?, dt_emissao_cnh = ?, categoria_cnh = ? "
                + "WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setDate(3, java.sql.Date.valueOf(cliente.getDataNasc()));
            stmt.setString(4, cliente.getLogradouro());
            stmt.setInt(5, cliente.getNumero());
            stmt.setString(6, cliente.getCep());
            stmt.setString(7, cliente.getBairro());
            stmt.setString(8, cliente.getComplemento());
            stmt.setString(9, cliente.getTelefone());
            stmt.setString(10, cliente.getNumeroCNH());
            stmt.setDate(11, java.sql.Date.valueOf(cliente.getDataVali()));
            stmt.setDate(12, java.sql.Date.valueOf(cliente.getDataEmissao()));
            stmt.setString(13, cliente.getCategoria());
            stmt.setString(14, cliente.getCpf());

            stmt.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void deleteCliente(String cpf) {
        String sql = "DELETE FROM clientes WHERE cpf = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Cliente excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }
}
