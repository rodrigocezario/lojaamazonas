package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.modelo.Produto;
import br.edu.unifebe.modelo.ProdutoFoto;

public class ProdutoDao implements IDao<Produto> {
	
	private Connection conexao = null;
	
	public ProdutoDao() throws SQLException {
		this.conexao = Conexao.getConnection();
	}

	@Override
	public void setSalvar(Produto e) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produto> getListar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		
		String sql = "Select * from Produto";

		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();

		while(rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("ProdID"));
			p.setNome(rs.getString("ProdNome"));
			p.setPrecoNormal(rs.getDouble("ProdPrecoNormal"));
			p.setPrecoVenda(rs.getDouble("ProdPrecoVenda"));
			p.setDetalhe(rs.getString("ProdDetalhe"));
			
			//chave estrangeira de Produto - SubCategoria
			p.setCategoria(new CategoriaDao().getSelecionar(rs.getInt("SubCatID")));
			//marca
			p.setMarca(new MarcaDao().getSelecionar(rs.getInt("MarcaID")));
			//fotos
			p.setFotos(listaFotos(rs.getInt("ProdID")));
			
			p.setDisplayDestaque(rs.getBoolean("ProdDisplayDestaque"));
			p.setDisplayOferta(rs.getBoolean("ProdDisplayOferta"));
			p.setDisplayHome(rs.getBoolean("ProdDisplayHome"));
			p.setDisplayStatus(rs.getBoolean("ProdDisplayStatus"));
			p.setDisplayLancamento(rs.getBoolean("ProdDisplayLancamento"));
			
			produtos.add(p);
		}
		rs.close();
		prmt.close();
		
		return produtos;
	}

	@Override
	public Produto getSelecionar(int id) throws SQLException {
		Produto p = null;
		
		String sql = "SELECT Produto.ProdID, Produto.ProdNome, "
				+ "Produto.ProdPrecoVenda, Produto.ProdPrecoNormal, "
				+ "Produto.ProdDetalhe, Categoria.CatID, Categoria.CatNome, "
				+ "SubCategoria.SubCatID, SubCategoria.SubCatNome, Marca.MarcaID, "
				+ "Marca.MarcaNome, (Select ProdFotoArquivo from ProdutoFoto "
				+ "Where ProdutoFoto.ProdID = Produto.ProdID LIMIT 1) As ProdFoto " + 
				"FROM Marca INNER JOIN ((Categoria INNER JOIN SubCategoria ON "
				+ "Categoria.CatID = SubCategoria.CatID) INNER JOIN Produto ON "
				+ "SubCategoria.SubCatID = Produto.SubCatID) ON Marca.MarcaID = "
				+ "Produto.MarcaID WHERE Produto.ProdID = ?";

		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, id);
		ResultSet rs = prmt.executeQuery();

		if(rs.next()) {
			p = new Produto();
			
			p.setId(rs.getInt("ProdID"));
			p.setNome(rs.getString("ProdNome"));
			p.setPrecoNormal(rs.getDouble("ProdPrecoNormal"));
			p.setPrecoVenda(rs.getDouble("ProdPrecoVenda"));
			p.setDetalhe(rs.getString("ProdDetalhe"));
			
			//chave estrangeira de Produto - SubCategoria
			p.setCategoria(new CategoriaDao().getSelecionar(rs.getInt("SubCatID")));
			//marca
			p.setMarca(new MarcaDao().getSelecionar(rs.getInt("MarcaID")));
			//fotos
			p.setFotos(listaFotos(rs.getInt("ProdID")));
			
		}
		
		rs.close();
		prmt.close();
		
		return p;
	}

	@Override
	public void setAlterar(Produto e) throws SQLException {
		String sql = "update Produto set ProdNome = ?, ProdDisplayHome = ? where ProdID = ?";
		
		
	}

	@Override
	public void setExcluir(Produto e) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	private List<ProdutoFoto> listaFotos(int prodID) throws SQLException{
		List<ProdutoFoto> fotos = new ArrayList<ProdutoFoto>();
		String sql = "select ProdFotoArquivo from ProdutoFoto where ProdID = ?";
		
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, prodID);

		ResultSet rs = prmt.executeQuery();
		
		while (rs.next()) {
			fotos.add(new ProdutoFoto(rs.getString("ProdFotoArquivo")));
		}
		
		rs.close();
		prmt.close();
		
		return fotos;
	}
	
	private List<Produto> listarGenerico(String sql) throws SQLException{
		List<Produto> produtos = new ArrayList<Produto>();
		
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();

		while(rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("ProdID"));
			p.setNome(rs.getString("ProdNome"));
			p.setPrecoNormal(rs.getDouble("ProdPrecoNormal"));
			p.setPrecoVenda(rs.getDouble("ProdPrecoVenda"));
			
			//categoria e subcategoria
			p.setCategoria(new CategoriaDao().getSelecionar(rs.getInt("SubCatID")));
			//marca
			p.setMarca(new MarcaDao().getSelecionar(rs.getInt("MarcaID")));
			//foto capa
			p.adicionarFoto(new ProdutoFoto(rs.getString("ProdFoto")));
			
			produtos.add(p);
		}
		rs.close();
		prmt.close();
		
		return produtos;
	}
	
	public List<Produto> getSuperDestaque() throws SQLException{
		
		String sql = "SELECT Produto.ProdID, Produto.ProdNome, "
				+ "Produto.ProdPrecoVenda, Produto.ProdPrecoNormal, "
				+ "Categoria.CatID, Categoria.CatNome, SubCategoria.SubCatID, "
				+ "SubCategoria.SubCatNome, Marca.MarcaID, Marca.MarcaNome, "
				+ "(Select ProdFotoArquivo from ProdutoFoto Where "
				+ "ProdutoFoto.ProdID = Produto.ProdID LIMIT 1) As ProdFoto "
				+ "FROM Marca INNER JOIN ((Categoria INNER JOIN SubCategoria ON Categoria.CatID = SubCategoria.CatID) INNER JOIN Produto ON SubCategoria.SubCatID = Produto.SubCatID) ON Marca.MarcaID = Produto.MarcaID\n" + 
				"WHERE ((Produto.ProdDisplayStatus = 1) AND "
				+ "(Produto.ProdDisplayDestaque = 1) AND "
				+ "(Produto.ProdDisplayHome = 1)) ORDER BY RANDOM() LIMIT 4";
		
		return listarGenerico(sql);
	}
	
	public List<Produto> getGrandesOfertas() throws SQLException{
		String sql = "SELECT Produto.ProdID, Produto.ProdNome, "
				+ "Produto.ProdPrecoVenda, Produto.ProdPrecoNormal, "
				+ "Categoria.CatID, Categoria.CatNome, SubCategoria.SubCatID, "
				+ "SubCategoria.SubCatNome, Marca.MarcaID, Marca.MarcaNome, "
				+ "(Select ProdFotoArquivo from ProdutoFoto Where "
				+ "ProdutoFoto.ProdID = Produto.ProdID LIMIT 1) "
				+ "As ProdFoto FROM Marca INNER JOIN ((Categoria INNER "
				+ "JOIN SubCategoria ON Categoria.CatID = SubCategoria.CatID) "
				+ "INNER JOIN Produto ON SubCategoria.SubCatID = "
				+ "Produto.SubCatID) ON Marca.MarcaID = Produto.MarcaID " 
				+ "WHERE ((Produto.ProdDisplayStatus = 1) AND " 
				+ "(Produto.ProdDisplayOferta = 1)) " 
				+ "ORDER BY RANDOM() LIMIT 8";
		return listarGenerico(sql);
	}
	
	public List<Produto> getMenoresPrecos() throws SQLException{
		String sql = "SELECT Produto.ProdID, Produto.ProdNome, "
				+ "Produto.ProdPrecoVenda, Produto.ProdPrecoNormal, "
				+ "Categoria.CatID, Categoria.CatNome, SubCategoria.SubCatID, "
				+ "SubCategoria.SubCatNome, Marca.MarcaID, Marca.MarcaNome, "
				+ "(Select ProdFotoArquivo from ProdutoFoto Where "
				+ "ProdutoFoto.ProdID = Produto.ProdID LIMIT 1) As ProdFoto "
				+ "FROM Marca INNER JOIN ((Categoria INNER JOIN SubCategoria "
				+ "ON Categoria.CatID = SubCategoria.CatID) INNER JOIN "
				+ "Produto ON SubCategoria.SubCatID = Produto.SubCatID) ON "
				+ "Marca.MarcaID = Produto.MarcaID WHERE "
				+ "((Produto.ProdDisplayStatus = 1) AND "
				+ "(Produto.ProdDisplayOferta = 1) AND "
				+ "(Produto.ProdDisplayLancamento = 1)) "
				+ "ORDER BY RANDOM() LIMIT 4";
		return listarGenerico(sql);
	}

}
