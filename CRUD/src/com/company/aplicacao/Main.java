package com.company.aplicacao;

import java.util.Scanner;

import com.mycompany.dao.ModeloDao;
import com.mycompany.modelo.Cliente;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			
			ModeloDao modeloDao = new ModeloDao();
			
			System.out.println("1.Criar\n2.Atualizar\n3.Deletar\n4.Listar");
			System.out.println("Qual operação deseja realizar: ");	
			int opcao = scanner.nextInt();
			
			if(opcao == 1) {
				System.out.println("Digite um nome: ");
				String nome = scanner.next();
				
				System.out.println("Digite seu email; ");
				String email = scanner.next();
				
				System.out.println("Digite o numero do cartão: ");
				Long numeroCartao = scanner.nextLong();
				
				Cliente contato = new Cliente();
				contato.setNome(nome);
				contato.setEmail(email);
				contato.setNumeroCartao(numeroCartao);
				
				modeloDao.save(contato);
			}
			else if(opcao == 2) {
				//atualizar contatos
				System.out.println("Digite um nome: ");
				String nome = scanner.next();
				
				System.out.println("Digite seu email; ");
				String email = scanner.next();
				
				System.out.println("Digite o numero do cartão: ");
				Long numeroCartao = scanner.nextLong();
				
				System.out.println("Digite o ID: ");
				int id = scanner.nextInt();
				
				Cliente c1 = new Cliente();
				c1.setNome(nome);
				c1.setEmail(email);
				c1.setNumeroCartao(numeroCartao);
				c1.setId(id);
				
				modeloDao.update(c1);
			}
			else if(opcao == 3) {
				//remover registro da tabela pelo ID
				System.out.println("Digite o ID: ");
				int id = scanner.nextInt();
				
				modeloDao.deleteByID(id);
			}
			else {
			//visualizar os registros
				for(Cliente c : modeloDao.getClientes()) {
					System.out.println("Cliente: " + c.getNome());
				}
			}
		}	
	}
}