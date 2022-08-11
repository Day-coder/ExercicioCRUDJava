package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection con=null;
	
	public static Connection conectar() {
		String url= ""; 
		String user= ""; 
		String senha= "";
		try {
			con= DriverManager.getConnection(url, user, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void fechar() {
		con=null;
	}

}
