package com.mycompany.modelo;

public class Voo {
	private int id_voo;
	public String empresa;
	private int numeroAssentos;
	
	public int getId_voo() {
		return id_voo;
	}
	public void setId_voo(int id) {
		this.id_voo = id;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getNumeroAssentos() {
		return numeroAssentos;
	}
	public void setNumeroAssentos(int numeroAssentos) {
		this.numeroAssentos = numeroAssentos;
	}
	

}
