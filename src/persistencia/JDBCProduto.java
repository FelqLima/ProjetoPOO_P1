package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Produto;

public class JDBCProduto {

	Connection conexao;
	
	
	public JDBCProduto(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void inserirProduto(Produto p) {
		String sql = "INSERT INTO produto (nome, valor, quantidade) VALUES ( ?, ?, ?)";
		PreparedStatement ps;
		
		try {
			ps = this.conexao.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getValor());
			ps.setInt(3, p.getQuantidade());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Produto> listarProdutos() {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String sql = "SELECT * FROM produto";
		
		try {
			Statement declaracao = conexao.createStatement();
			ResultSet resposta = declaracao.executeQuery(sql);
			
			while(resposta.next()) {
				
				int id = resposta.getInt("id");
				String nome = resposta.getString("nome");
				int valor = resposta.getInt("valor");
				int quantidade = resposta.getInt("quantidade");
				
				Produto p = new Produto(id, nome, valor, quantidade);
				produtos.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}
	public void apagarTudo() {
		String sql = "DELETE FROM produto";
		PreparedStatement ps;
		
		try {
			ps = this.conexao.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
