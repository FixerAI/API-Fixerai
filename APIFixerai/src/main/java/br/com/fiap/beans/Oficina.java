package br.com.fiap.beans;
 
import java.sql.Time;
 
public class Oficina {
	private String cnpj;
	private Avaliacao idAvaliacao;
	private String nome;
	private String bairro;
	private String email;
	private String logradouro;
	private String longitude;
	private String latitude;
	private Time horarioFuncionamento;
	private String complemento;
	private int cep;
	private String telefone;
 
	public Oficina() {
		super();
	}
 
	public Oficina(String cnpj, Avaliacao idAvaliacao, String nome, String bairro, String email, String logradouro,
			String longitude, String latitude, Time horarioFuncionamento, String complemento,
			int cep, String telefone) {
		super();
		this.cnpj = cnpj;
		this.idAvaliacao = idAvaliacao;
		this.nome = nome;
		this.bairro = bairro;
		this.email = email;
		this.logradouro = logradouro;
		this.longitude = longitude;
		this.latitude = latitude;
		this.horarioFuncionamento = horarioFuncionamento;
		this.complemento = complemento;
		this.cep = cep;
		this.telefone = telefone;
	}
 
	public String getCnpj() {
		return cnpj;
	}
 
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
 
	public Avaliacao getIdAvaliacao() {
		return idAvaliacao;
	}
 
	public void setIdAvaliacao(Avaliacao idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}
 
	public String getNome() {
		return nome;
	}
 
	public void setNome(String nome) {
		this.nome = nome;
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
 
	public String getLogradouro() {
		return logradouro;
	}
 
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
 
	public String getLongitude() {
		return longitude;
	}
 
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
 
	public String getLatitude() {
		return latitude;
	}
 
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
 

 
	public Time getHorarioFuncionamento() {
		return horarioFuncionamento;
	}
 
	public void setHorarioFuncionamento(Time horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
 
	public String getComplemento() {
		return complemento;
	}
 
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
 
	public int getCep() {
		return cep;
	}
 
	public void setCep(int cep) {
		this.cep = cep;
	}
 
	public String getTelefone() {
		return telefone;
	}
 
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
 
}