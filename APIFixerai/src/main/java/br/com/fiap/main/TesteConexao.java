package br.com.fiap.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.conexao.ConexaoFactory;

public class TesteConexao {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection cn = new ConexaoFactory().conexao();
	      
	      System.out.println("Conectado com o banco de dados!");
	      
	      cn.close();

	}

}
