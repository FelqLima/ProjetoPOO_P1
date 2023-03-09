package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection conexao;

	public Connection abrirConexao() {
		String url = "jdbc:mysql://localhost:3306/mercadinho?useTimeZone=true&serverTimeZone=UTC";
		String user = "root";
		String password = "";
		
		try {
			conexao = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	public void fecharConexao() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
