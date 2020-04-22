package br.edu.unifebe.modelo;

import java.util.ArrayList;
import java.util.List;

public class Produto {

	private int id;
	private String nome;
	private double precoNormal;
	private double precoVenda;
	private String detalhe;
	private boolean displayDestaque;
	private boolean displayOferta;
	private boolean displayHome;
	private boolean displayStatus;
	private boolean displayLancamento;

	// Categoria e subcategoria
	private Categoria categoria;
	private Marca marca;
	private List<ProdutoFoto> fotos;

	// construtor default para o padrão javabean
	public Produto() {
		this.fotos = new ArrayList<ProdutoFoto>();
	}

	public Produto(int id, String nome, Categoria categoria, Marca marca) {
		this.fotos = new ArrayList<ProdutoFoto>();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.marca = marca;
	}

	public Produto(int id, String nome, double precoNormal, double precoVenda, String detalhe, boolean displayDestaque,
			boolean displayOferta, boolean displayHome, boolean displayStatus, boolean displayLancamento,
			Categoria categoria, Marca marca) {
		this.fotos = new ArrayList<ProdutoFoto>();
		this.id = id;
		this.nome = nome;
		this.precoNormal = precoNormal;
		this.precoVenda = precoVenda;
		this.detalhe = detalhe;
		this.displayDestaque = displayDestaque;
		this.displayOferta = displayOferta;
		this.displayHome = displayHome;
		this.displayStatus = displayStatus;
		this.displayLancamento = displayLancamento;
		this.categoria = categoria;
		this.marca = marca;
	}
	
	public String getFotoCapa() {
		//primeira imagem salva... 
		//dá para melhorar isso permitindo o usuário escolher qual foto quer como capa!
		return this.fotos.isEmpty() ? "" : this.fotos.get(0).getArquivo() ;
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

	public double getPrecoNormal() {
		return precoNormal;
	}

	public void setPrecoNormal(double precoNormal) {
		this.precoNormal = precoNormal;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public boolean isDisplayDestaque() {
		return displayDestaque;
	}

	public void setDisplayDestaque(boolean displayDestaque) {
		this.displayDestaque = displayDestaque;
	}

	public boolean isDisplayOferta() {
		return displayOferta;
	}

	public void setDisplayOferta(boolean displayOferta) {
		this.displayOferta = displayOferta;
	}

	public boolean isDisplayHome() {
		return displayHome;
	}

	public void setDisplayHome(boolean displayHome) {
		this.displayHome = displayHome;
	}

	public boolean isDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(boolean displayStatus) {
		this.displayStatus = displayStatus;
	}

	public boolean isDisplayLancamento() {
		return displayLancamento;
	}

	public void setDisplayLancamento(boolean displayLancamento) {
		this.displayLancamento = displayLancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<ProdutoFoto> getFotos() {
		return fotos;
	}

	public void setFotos(List<ProdutoFoto> fotos) {
		this.fotos = fotos;
	}
	
	public void adicionarFoto(ProdutoFoto foto) {
		this.fotos.add(foto);
	}

}
