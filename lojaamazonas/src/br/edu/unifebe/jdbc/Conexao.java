package br.edu.unifebe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	//usando o padrão singleton
	/*
	 * 1 - Não posso permitir a criação de instância dela
	 * 2 - Ela será um ponto ÚNICO de acesso 
	 * 3 - Não permitir cópia (não posso permitir clonar ela)
	 */
	
	private static Connection conexao = null;
	private static String url = "jdbc:sqlite:/Users/rodrigocezario/loja.db";
	
	//no windows
	//private static String url = "jdbc:sqlite:c:\\loja.db";

	
	//construtor
	private Conexao() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		if (conexao == null)
			conexao = DriverManager.getConnection(url);
		return conexao;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		 return new CloneNotSupportedException(""
		 		+ "Não é permitido clonar um singleton...") ;
	}

}
