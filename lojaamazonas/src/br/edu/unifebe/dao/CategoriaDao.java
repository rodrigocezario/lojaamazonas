package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.modelo.Categoria;
import br.edu.unifebe.modelo.Marca;

public class CategoriaDao implements IDao<Categoria> {

	private Connection conexao = null;

	public CategoriaDao() throws SQLException {
		// usando nosso singleton
		this.conexao = Conexao.getConnection();
	}

	@Override
	public void setSalvar(Categoria e) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categoria> getListar() throws SQLException {
		// retornar todas categorias com suas respectivas categorias..
		String sql = "Select * from Categoria";

		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();

		List<Categoria> listaCategoria = new ArrayList<Categoria>();

		while (rs.next()) {

			Categoria categoria = new Categoria();
			categoria.setId(rs.getInt("CatID"));
			categoria.setNome(rs.getString("CatNome"));

			// adicionar as subcategoria..
			String sqlSubCat = "select * from SubCategoria where CatID = ?";
			PreparedStatement prmtSubCat = this.conexao.prepareStatement(sqlSubCat);
			prmtSubCat.setInt(1, rs.getInt("CatID"));

			ResultSet rsSubCat = prmtSubCat.executeQuery();

			while (rsSubCat.next()) {
				Categoria subcategoria = new Categoria();
				subcategoria.setId(rsSubCat.getInt("SubCatID"));
				subcategoria.setNome(rsSubCat.getString("SubCatNome"));

				categoria.adicionaSubCategoria(subcategoria);
			}
			// adicionar na lista de categoria
			listaCategoria.add(categoria);
		}
		return listaCategoria;
	}

	//seleciona subcategoria -> categoria
	@Override
	public Categoria getSelecionar(int id) throws SQLException {
		Categoria categoria = null;
		
		String sql = "SELECT Categoria.CatID, Categoria.CatNome, "
				+ "SubCategoria.SubCatID, SubCategoria.SubCatNome FROM "
				+ "Categoria INNER JOIN SubCategoria ON Categoria.CatID = "
				+ "SubCategoria.CatID WHERE SubCategoria.SubCatID = ?";
		
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, id);

		ResultSet rs = prmt.executeQuery();

		if (rs.next()) {
			categoria = new Categoria();
			categoria.setId(rs.getInt("CatID"));
			categoria.setNome(rs.getString("CatNome"));
			
			Categoria subCategoria = new Categoria();
			subCategoria.setId(rs.getInt("SubCatID"));
			subCategoria.setNome(rs.getString("SubCatNome"));	
			
			categoria.adicionaSubCategoria(subCategoria);
		}
		
		rs.close();
		prmt.close();
		
		return categoria;
	}
	
	//mesmo que getSelecionar
	public Categoria getSubCategoria(int id) throws SQLException {
		return this.getSelecionar(id);
	}

	@Override
	public void setAlterar(Categoria e) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setExcluir(Categoria e) throws SQLException {
		// TODO Auto-generated method stub

	}

}
