package br.com.fiap.beans;

public class Servico {
	private int idServico;
	private String descricao;
	
	
	public Servico() {
		super();
	}

	public Servico(int idServico, String descricao) {
		super();
		this.idServico = idServico;
		this.descricao = descricao;
	}
	
	
	public int getIdServico() {
		return idServico;
	}
	public void setIdServico(int idServico) {
		this.idServico = idServico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
}
