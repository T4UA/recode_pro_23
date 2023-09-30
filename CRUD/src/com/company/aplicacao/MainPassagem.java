package com.company.aplicacao;

import java.util.Date;
//import java.util.Scanner;

import com.mycompany.dao.ModeloDaoPassagem;
import com.mycompany.modelo.Passagem;


public class MainPassagem {
	public static void main(String[] args){
		
			ModeloDaoPassagem modeloDaoPassagem = new ModeloDaoPassagem();
			try{
						Passagem p1 = new Passagem();
							p1.setDataIda(new Date());
							p1.setDataVolta("2024-12-05");
							p1.setOrigem("Salvador");
							p1.setDestino("Rio de Janeiro");
							p1.setAssento("25e");
							p1.setPortao(27);
							p1.setHorario("14:20");
							
							modeloDaoPassagem.save(p1);
						}finally {
							System.out.println("OK");
						}
						
						//atualizar contatos
			/*Scanner scanner = new Scanner(System.in)) {
				System.out.println("Digite o ID: ");
				int id_passagem = scanner.nextInt();
				
				Passagem p1 = new Passagem();
					p1.setId_passagem(id_passagem);
					p1.setDataIda(new Date());
					p1.setDataVolta("2024-12-05");
					p1.setOrigem("Pernanbuco");
					p1.setDestino("Minas Gerais");
					p1.setAssento("35f");
					p1.setPortao(12);
					p1.setHorario("16:20");
					
				modeloDaoPassagem.update(p1);
			}
			
			remover registro da tabela pelo ID
			modeloDaoPassagem.deleteByID(1);
	*/}
}