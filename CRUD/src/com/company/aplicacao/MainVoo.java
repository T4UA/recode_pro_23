package com.company.aplicacao;

import com.mycompany.dao.ModeloDaoVoo;
import com.mycompany.modelo.Voo;

public class MainVoo {

	public static void main(String[] args) {
		ModeloDaoVoo modeloDaoVoo = new ModeloDaoVoo();
		try {
		Voo v1 = new Voo();
			v1.setEmpresa("Gol");
			v1.setNumeroAssentos(55);
			
			modeloDaoVoo.save(v1);
		}finally {
			System.out.println("OK");
		}
			/*
			//atualizar contatos
			Voo v1 = new Voo();
			v1.setEmpresa("Gol");
			v1.setNumeroAcentos(55);
			v1.setId(8);
			
			//modeloDaoVoo.update(v1);
			
			//remover registro da tabela pelo ID
			modeloDaoVoo.deleteByID(9);
		
			//visualizar os registros
			for(Voo c : modeloDaoVoo.getVoo()) {
				System.out.println("Aeronave: " + c.getEmpresa());
			}*/

		}	
	}