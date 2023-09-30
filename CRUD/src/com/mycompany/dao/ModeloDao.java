package com.mycompany.dao;

import java.sql.Connection;

//import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.jdbc.*;

import com.mycompany.conexao.PontoConexao;
import com.mycompany.modelo.Cliente;

public class ModeloDao {
	//CRUD
	public void save(Cliente contato) {
		String sql = "INSERT INTO clientes(nome, email, numeroCartao) VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar uma conexão com o banco de dados
			conn = PontoConexao.createConnectionToMySQL();
			
			//criamos uma prepared statement para executar uma query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setLong(3, contato.getNumeroCartao());
			
			//EXECUTAR A QUERY
			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	public void update(Cliente contato) {
		String sql = "UPDATE clientes SET nome = ?, email = ?, numeroCartao = ? "+ "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexão com banco
			conn = PontoConexao.createConnectionToMySQL();
			
			//criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//add os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getEmail());
			pstm.setLong(3, contato.getNumeroCartao());
			
			//qual o id do registro que quer atualizar
			pstm.setInt(4, contato.getId());
			
			//executar a query
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteByID(int id) {
		String sql = "DELETE FROM clientes WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = PontoConexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public List<Cliente> getClientes(){
		String sql = "SELECT * FROM clientes";
		List<Cliente> contatos = new ArrayList<Cliente>();
		Connection conn = null;
		PreparedStatement pstm = null;
		//class que vai recuperar dados do baNCO
		ResultSet rset = null;
		
		try {
			conn = PontoConexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente contato = new Cliente();
				
				//recuperar o id 
				contato.setId(rset.getInt("id"));
				//recuperar nome
				contato.setNome(rset.getString("nome"));
				//recuperar idade
				contato.setEmail(rset.getString("email"));
				//recuperar data de cadastro
				contato.setNumeroCartao(rset.getLong("numeroCartao"));
				
				contatos.add(contato);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}
}
