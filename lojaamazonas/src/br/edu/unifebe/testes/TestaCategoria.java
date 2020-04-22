package br.edu.unifebe.testes;

import java.sql.SQLException;

import br.edu.unifebe.dao.CategoriaDao;
import br.edu.unifebe.modelo.Categoria;
import br.edu.unifebe.modelo.Marca;

public class TestaCategoria {

	public static void main(String[] args) {
		
		try {
			CategoriaDao dao = new CategoriaDao();
			
			System.out.println("=== Categorias e Subcategorias ===");
			
			//testando getListar
			for(Categoria categoria : dao.getListar()) {
				System.out.println("- " + categoria.getNome());
				for (Categoria subCategoria : categoria.getSubcategorias()) {
					System.out.println(" -- " + subCategoria.getNome());
				}
			}
			
			System.out.println("\n\n");
			
			//getSelecionar subcategoria = 1
			System.out.println("Categoria/Subcategoria 1: "+ dao.getSelecionar(1).getNome() 
					+ " / "+ dao.getSelecionar(1).getSubcategorias().get(0).getNome());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
