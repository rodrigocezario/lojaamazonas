package br.edu.unifebe.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	// subcategorias
	private List<Categoria> subcategorias;
	private int id;
	private String nome;
	private boolean status;
	
	public Categoria() {
		this.subcategorias = new ArrayList<Categoria>();
	}
	
	public Categoria getSubcategoria() {
		return subcategorias.get(0);
	}
	
	public void adicionaSubCategoria(Categoria categoria) {
		this.subcategorias.add(categoria);
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<Categoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
