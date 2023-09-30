package com.mycompany.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.conexao.PontoConexao;
import com.mycompany.modelo.Passagem;

public class ModeloDaoPassagem {
	//CRUD
	public void save(Passagem ticket) {
		String sql = "INSERT INTO passagem(dataIda, dataVolta, origem, destino, assento, horario, portao) VALUES(?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar uma conexão com o banco de dados
			conn = PontoConexao.createConnectionToMySQL();
			
			//criamos uma prepared statement para executar uma query
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, new Date(ticket.getDataIda().getTime()));
			pstm.setString(2, ticket.getDataVolta());
			pstm.setString(3, ticket.getOrigem());
			pstm.setString(4, ticket.getDestino());
			pstm.setString(5, ticket.getAssento());
			pstm.setString(6, ticket.getHorario());
			pstm.setInt(7, ticket.getPortao());
			
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

	public void update(Passagem ticket) {
		String sql = "UPDATE passagem SET dataIda = ?, dataVolta = ?, origem = ?, destino = ?,assento = ?,horario = ?,portao = ?, "+ "WHERE id_passagem = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexão com banco
			conn = PontoConexao.createConnectionToMySQL();
			
			//criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//add os valores para atualizar
			pstm = conn.prepareStatement(sql);
			pstm.setDate(1, new Date(ticket.getDataIda().getTime()));
			pstm.setString(2, ticket.getDataVolta());
			pstm.setString(3, ticket.getOrigem());
			pstm.setString(4, ticket.getDestino());
			pstm.setString(5, ticket.getAssento());
			pstm.setString(6, ticket.getHorario());
			pstm.setInt(7, ticket.getPortao());
			
			//qual o id do registro que quer atualizar
			pstm.setInt(8, ticket.getId_passagem());
			
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
		String sql = "DELETE FROM clientes WHERE id_passagem = ?";
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
	
	
	
	public List<Passagem> getPassagem(){
		String sql = "SELECT * FROM passagem";
		List<Passagem> ticket = new ArrayList<Passagem>();
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;
		
		try {
			conn = PontoConexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Passagem bilhete = new Passagem();
				
				bilhete.setDataIda(rset.getDate("dataIda"));
	
				bilhete.setDataVolta(rset.getString("datVolta"));

				bilhete.setOrigem(rset.getString("origem"));
			
				bilhete.setDestino(rset.getString("destino"));
				
				bilhete.setAssento(rset.getString("assento"));
		
				bilhete.setHorario(rset.getString("horario"));
			
				bilhete.setPortao(rset.getInt("portao"));
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
		return ticket;
	}
}
