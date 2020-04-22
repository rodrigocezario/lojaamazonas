package br.edu.unifebe.testes;

import java.sql.SQLException;

import br.edu.unifebe.dao.MarcaDao;
import br.edu.unifebe.modelo.Marca;

public class TestaMarcas {

	public static void main(String[] args) {
		
		try {
			MarcaDao dao = new MarcaDao();
			
			System.out.println("=== marcas ===");
			
			//testando getListar
			for(Marca marca : dao.getListar()) {
				System.out.println(marca.getNome());
			}
			
			//getSelecionar
			System.out.println("Código 1: "+ dao.getSelecionar(1).getNome());
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}

	}

}
