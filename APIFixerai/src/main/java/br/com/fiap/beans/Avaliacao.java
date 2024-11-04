package br.com.fiap.beans;

public class Avaliacao {
	private int idAvaliacao;
	private String descricao;
	private String nota;
	
	
	
	public Avaliacao() {
		super();
	}


	public Avaliacao(int idAvaliacao, String descricao, String nota) {
		super();
		this.idAvaliacao = idAvaliacao;
		this.descricao = descricao;
		this.nota = nota;
	}
	
	
	public int getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(int idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	
}
