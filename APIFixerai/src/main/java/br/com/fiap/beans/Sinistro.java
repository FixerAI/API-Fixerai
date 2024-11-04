package br.com.fiap.beans;

import java.time.LocalDate;

public class Sinistro {
	private int id;
	private String descricao;
	private LocalDate dataOcorrida;
	
	
	
	public Sinistro() {
		super();
	}


	public Sinistro(int id, String descricao, LocalDate dataOcorrida) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataOcorrida = dataOcorrida;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataOcorrida() {
		return dataOcorrida;
	}
	public void setDataOcorrida(LocalDate dataOcorrida) {
		this.dataOcorrida = dataOcorrida;
	}
	
	
	public void criarSinistro() {
		//futuramente criaremos a logica para registrar o sinistro
		
		System.out.println("\nSinistro criado");
	};
	
}
