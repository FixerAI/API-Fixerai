package br.com.fiap.beans;

import java.time.LocalDate;

public class Agendamento {
	private int protocoloAgendamento;
	private LocalDate data;
	
	
	public Agendamento() {
		super();
	}


	public Agendamento(int protocoloAgendamento, LocalDate data) {
		super();
		this.protocoloAgendamento = protocoloAgendamento;
		this.data = data;
	}
	
	public int getProtocoloAgendamento() {
		return protocoloAgendamento;
	}
	public void setProtocoloAgendamento(int protocoloAgendamento) {
		this.protocoloAgendamento = protocoloAgendamento;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	
	
	public void criarAgendamento() {
		System.out.println("Agendamento Criado");
	}
}
