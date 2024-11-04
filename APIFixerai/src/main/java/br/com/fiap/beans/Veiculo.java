package br.com.fiap.beans;

import java.time.LocalDate;

public class Veiculo {
	private String placa;
	private String marca;
	private String modelo;
	private String tipo;
	private LocalDate ano;
	private String cor;
	private Cliente cliente;
	
	
	public Veiculo() {
		super();
	}

	public Veiculo(String placa, String marca, String modelo, String tipo, LocalDate ano, String cor, Cliente cliente) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.ano = ano;
		this.cor = cor;
		this.cliente = cliente;
	}
	

	public Veiculo(String string, String string2, String string3, String string4, String string5, LocalDate localDate,
			Object object) {
		// TODO Auto-generated constructor stub
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public LocalDate getAno() {
		return ano;
	}
	public void setAno(LocalDate ano) {
		this.ano = ano;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
