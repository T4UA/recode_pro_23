package com.mycompany.dao;

import java.sql.Connection;

//import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.jdbc.*;

import com.mycompany.conexao.PontoConexao;
import com.mycompany.modelo.Voo;

public class ModeloDaoVoo {
	//CRUD
	public void save(Voo contato) {
		String sql = "INSERT INTO voo(empresa, numeroAssentos) VALUES(?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar uma conexão com o banco de dados
			conn = PontoConexao.createConnectionToMySQL();
			
			//criamos uma prepared statement para executar uma query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getEmpresa());
			pstm.setInt(2, contato.getNumeroAssentos());
			
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

	public void update(Voo v3) {
		String sql = "UPDATE voo SET empresa = ?, numeroAssentos = ? "+ "WHERE id_voo = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexão com banco
			conn = PontoConexao.createConnectionToMySQL();
			
			//criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//add os valores para atualizar
			pstm.setString(1, v3.getEmpresa());
			pstm.setInt(2, v3.getNumeroAssentos());
			
			//qual o id do registro que quer atualizar
			pstm.setInt(4, v3.getId_voo());
			
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
		String sql = "DELETE FROM voo WHERE id_voo = ?";
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
	
	public List<Voo> getVoo(){
		String sql = "SELECT * FROM voo";
		List<Voo> v2 = new ArrayList<Voo>();
		Connection conn = null;
		PreparedStatement pstm = null;
		//class que vai recuperar dados do baNCO
		ResultSet rset = null;
		
		try {
			conn = PontoConexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Voo v = new Voo();
				
				//recuperar o id 
				v.setId_voo(rset.getInt("id_voo"));
				//recuperar nome
				v.setEmpresa(rset.getString("empresa"));
				//recuperar idade
				v.setNumeroAssentos(rset.getInt("numeroAssentos"));
				
				v2.add(v);
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
		return v2;
	}
}
