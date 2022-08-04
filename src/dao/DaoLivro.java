package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entities.Livro;
import interfaces.ICrud;



public class DaoLivro implements ICrud<Livro> {
	public Connection abrirConexao() {
		Connection con= Conexao.conectar();
		return con;
		
	}
	

	@Override
	public boolean salvar(Livro obj) {
		String sql="insert into livro (titulo, autor, anoPublicacao, editora, volume) values(?,?,?,?,?)";
		try {
			PreparedStatement stm= abrirConexao().prepareStatement(sql);
		stm.setString(1, obj.getTitulo());
		stm.setString(2, obj.getAutor());
		stm.setInt(3, obj.getAnoPublicacao());
		stm.setString(4, obj.getEditora());
		stm.setInt(5, obj.getVolume());
		stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			Conexao.fechar();
		}
		
		return true;
	}

	@Override
	public boolean alterar(Livro obj) {
		String sql= "update livro set "
				+ "titulo=?, autor=?, anoPublicacao=?, editora=?, volume=?"
				+ "where id=? ";
		try {
			PreparedStatement stm= abrirConexao().prepareStatement(sql);
			stm.setString(1, obj.getTitulo());
			stm.setString(2, obj.getAutor());
			stm.setInt(3, obj.getAnoPublicacao());
			stm.setString(4, obj.getEditora());
			stm.setInt(5, obj.getVolume());
			stm.setInt(6, obj.getId());
			stm.execute();	
			
		} catch (SQLException e) {
			System.out.println("Erro: " + e);
		}
		finally {
			Conexao.fechar();
		}
		return true;
	}

	@Override
	public void excluir(int id) {
		String sql= "delete from livro where id=?";
		try {
			PreparedStatement stm= abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: "+ e);
		}
		finally {
			Conexao.fechar();
		}
		
	}

	@Override
	public List<Livro> consultar() {
		List<Livro> livros= new ArrayList<>();
		String sql="select * from livro";
		try {
			PreparedStatement stm= abrirConexao().prepareStatement(sql);
			ResultSet rs= stm.executeQuery();
			while(rs.next()) {
				Livro livro= new Livro();
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
				livro.setEditora(rs.getString("editora"));
				livro.setVolume(rs.getInt("volume"));
				livros.add(livro);
			}
		} catch (SQLException e) {
			System.out.println("Erro: "+ e);
		}finally {
			Conexao.fechar();
		}
		return livros;
	}

	@Override
	public Livro consultar(int id) {
		Livro livro=new Livro();
		String sql="select * from livro where id=?";
		try {
			PreparedStatement stm= abrirConexao().prepareStatement(sql);
			stm.setInt(1, id);
			ResultSet rs= stm.executeQuery();
			if(rs.next()) {
				livro.setId(rs.getInt("id"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
				livro.setEditora(rs.getString("editora"));
				livro.setVolume(rs.getInt("volume"));
			}
				
		} catch (SQLException e) {
			System.out.println("Erro: "+ e);
		}finally {
			Conexao.fechar();
		}
		return livro;
	}

}
