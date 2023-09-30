package com.mycompany.modelo;

import java.util.Date;

public class Passagem {
	private int id_passagem;
	private Date dataIda;
	private String dataVolta;
	public String origem;
	public String destino;
	public String assento;
	public String horario;
	public int portao;
	
	public int getId_passagem() {
		return id_passagem;
	}
	public void setId_passagem(int id_passagem) {
		this.id_passagem = id_passagem;
	}
	public Date getDataIda() {
		return dataIda;
	}
	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}
	public String getDataVolta() {
		return dataVolta;
	}
	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getAssento() {
		return assento;
	}
	public void setAssento(String assento) {
		this.assento = assento;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public int getPortao() {
		return portao;
	}
	public void setPortao(int portao) {
		this.portao = portao;
	}

}
