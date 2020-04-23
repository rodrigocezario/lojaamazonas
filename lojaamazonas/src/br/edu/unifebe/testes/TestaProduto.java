package br.edu.unifebe.testes;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.edu.unifebe.dao.ProdutoDao;
import br.edu.unifebe.modelo.Produto;

public class TestaProduto {

	public static void main(String[] args) {

		ProdutoDao dao;
		int codigo;
		Scanner sc = new Scanner(System.in);

		try {
			dao = new ProdutoDao();

			/*
			 * System.out.println("=== Produtos ===");
			 * 
			 * //testando getListar for(Produto p : dao.getListar()) {
			 * System.out.println(p.getId() +" - "+ p.getNome());
			 * System.out.println("Preço normal: "+ p.getPrecoNormal());
			 * System.out.println("Preço venda: "+ p.getPrecoVenda());
			 * System.out.println("Home: "+ p.isDisplayHome()); System.out.println("Foto: "+
			 * p.getFotoCapa()); System.out.println("Categoria/Subcategoria: "+
			 * p.getCategoria().getNome() + "/" +
			 * p.getCategoria().getSubcategoria().getNome());
			 * System.out.println("\n========\n"); }
			 * 
			 */

			// System.out.println("Informe o código do produto: ");
			// codigo = sc.nextInt();

			// Produto p = dao.getSelecionar(codigo);

			List<Produto> p = dao.getSuperDestaque();
			//List<Produto> p = dao.getGrandesOfertas();
			 //List<Produto> p = dao.getMenoresPrecos();

			imprimir(p);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void imprimir(Produto p) {
		if (p != null) {
			System.out.println(p.getId() + " - " + p.getNome());
			System.out.println("Preço normal: " + p.getPrecoNormal());
			System.out.println("Preço venda: " + p.getPrecoVenda());
			System.out.println("Foto: " + p.getFotoCapa());
			
			System.out.println("Categoria/Subcategoria: " + p.getCategoria().getNome() + "/"
					+ p.getCategoria().getSubcategoria().getNome());
			System.out.println("\n========\n");
		} else
			System.out.println("Produto não encontrado...");

	}

	public static void imprimir(List<Produto> produtos) {
		System.out.println("=== Produtos ===");

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		
		// testando getListar
		for (Produto p : produtos) {
			System.out.println(p.getId() + " - " + p.getNome());
			System.out.println("Preço normal: " + nf.format(p.getPrecoNormal()));
			System.out.println("Preço venda: " + nf.format(p.getPrecoVenda()));
			System.out.println("Foto: " + p.getFotoCapa());
			System.out.println("Categoria/Subcategoria: " + p.getCategoria().getNome() + "/"
					+ p.getCategoria().getSubcategoria().getNome());
			System.out.println("\n========\n");
		}
	}

}
