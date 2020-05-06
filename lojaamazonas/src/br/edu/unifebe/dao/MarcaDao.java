package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.modelo.Marca;

public class MarcaDao implements IDao<Marca> {

	private Connection conexao = null;
	
	public MarcaDao() throws SQLException {
		this.conexao = Conexao.getConnection();
	}

	@Override
	public void setSalvar(Marca e) throws SQLException {
		String sql = "insert into Marca (MarcaNome, MarcaSite, MarcaStatus) values (?, ?, 1)";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setString(1, e.getNome());
		prmt.setString(2, e.getSite());
		prmt.execute();
		prmt.close();
	}
	
	@Override
	public List<Marca> getListar() throws SQLException {
		List<Marca> marcas = new ArrayList<Marca>();
		String sql = "select * from Marca";
		
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		
		while(rs.next()) {
			//a cada interação é um registro de marca
			Marca marca = new Marca();
			
			//setei os valores com o que estava no bd
			marca.setId(rs.getInt("MarcaID"));
			marca.setNome(rs.getString("MarcaNome"));
			marca.setSite(rs.getString("MarcaSite"));
			
			//adicionar a lista
			marcas.add(marca);
		}
		
		rs.close();
		prmt.close();
		
		return marcas; //temos que alterar..
	}

	@Override
	public Marca getSelecionar(int id) throws SQLException {
		Marca marca = null;
		
		String sql = "select * from Marca where MarcaID = ?";
		
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, id);

		ResultSet rs = prmt.executeQuery();

		if (rs.next()) {
			marca = new Marca();
			marca.setId(rs.getInt("MarcaID"));
			marca.setNome(rs.getString("MarcaNome"));
			marca.setSite(rs.getString("MarcaSite"));
		}
		
		rs.close();
		prmt.close();
		
		return marca;
	}

	@Override
	public void setAlterar(Marca e) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExcluir(Marca e) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	

}
