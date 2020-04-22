package br.edu.unifebe.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<E> {

	//vamos utilizar Generics
	
	//vamos definir operações triviais com DB
	//CRUD
	//O que é o crud?
	//Create (salvar)
	//Read (listar e selecionar)
	//Update
	//Delete
	
	public void setSalvar(E e) throws SQLException;
	
	public List<E> getListar() throws SQLException;
	
	public E getSelecionar(int id) throws SQLException;
	
	public void setAlterar(E e) throws SQLException;
	
	public void setExcluir(E e) throws SQLException;
	
}
