package br.edu.unifebe.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.unifebe.jdbc.Conexao;

public class TestaConexao {

	public static void main(String[] args) {
		
		try {
			
			Connection conexao = Conexao.getConnection();
			System.out.println("Conexão com bd realizada com sucesso!");
			
		} catch (SQLException e) {
			System.out.println("Erro ao abrir bd: "+ e.getMessage());
		}

	}

}
