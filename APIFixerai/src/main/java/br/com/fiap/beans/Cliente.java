package br.com.fiap.beans;
 
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
 
public class Cliente {
 
	private String cpf;
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNasc;
	private String bairro;
	private String email;
	private String cep;
	private int numero;
	private String complemento;
	private String logradouro;
	private String telefone;
	private String numeroCNH;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataVali;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataEmissao;
	
	
	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	private String categoria;
 
	public Cliente() {
		super();
	}
 
	public Cliente(String cpf, String nome, LocalDate dataNasc, String bairro, String email, String cep, int numero,
			String complemento, String logradouro, String telefone, String numeroCNH, LocalDate dataVali,
			String categoria) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.bairro = bairro;
		this.email = email;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.logradouro = logradouro;
		this.telefone = telefone;
		this.numeroCNH = numeroCNH;
		this.dataVali = dataVali;
		this.categoria = categoria;
	}
 
	public String getCpf() {
		return cpf;
	}
 
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
 
	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
	}
 
	public LocalDate getDataNasc() {
		return dataNasc;
	}
 
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
 
	public String getBairro() {
		return bairro;
	}
 
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
 
	public String getEmail() {
		return email;
	}
 
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getCep() {
		return cep;
	}
 
	public void setCep(String cep) {
		this.cep = cep;
	}
 
	public int getNumero() {
		return numero;
	}
 
	public void setNumero(int numero) {
		this.numero = numero;
	}
 
	public String getComplemento() {
		return complemento;
	}
 
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
 
	public String getLogradouro() {
		return logradouro;
	}
 
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
 
	public String getTelefone() {
		return telefone;
	}
 
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
 
	public String getNumeroCNH() {
		return numeroCNH;
	}
 
	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
 
	public LocalDate getDataVali() {
		return dataVali;
	}
 
	public void setDataVali(LocalDate dataVali) {
		this.dataVali = dataVali;
	}
 
	public String getCategoria() {
		return categoria;
	}
 
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
 
}
 