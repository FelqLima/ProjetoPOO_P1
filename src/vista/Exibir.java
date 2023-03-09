package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Produto;
import persistencia.Conexao;
import persistencia.JDBCProduto;

public class Exibir extends JInternalFrame {
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exibir frame = new Exibir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Exibir() {
		setBounds(100, 100, 500, 400);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexao fabrica = new Conexao();
				JDBCProduto gerente = new JDBCProduto(fabrica.abrirConexao());
				ArrayList<Produto> produtos = new ArrayList<Produto>();
				produtos = gerente.listarProdutos();
				fabrica.fecharConexao();
				
				//Adicionar na tabela
				DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
				modelo.setNumRows(0);
				
				for (Produto p: produtos) {
					Object[] dados = {p.getId(), p.getNome(), p.getValor(), p.getQuantidade()};
					modelo.addRow(dados);
				}
				
			}
		});
		btnListar.setBounds(33, 10, 85, 21);
		desktopPane.add(btnListar);
		
		JButton btnApagarTudo = new JButton("Apagar Tudo");
		btnApagarTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexao fabrica = new Conexao();
				JDBCProduto gerente = new JDBCProduto(fabrica.abrirConexao());
				gerente.apagarTudo();
				fabrica.fecharConexao();
				
				//Apagando tela da aplicação
				DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
				modelo.setNumRows(0);
				
			}
		});
		btnApagarTudo.setBounds(128, 10, 102, 21);
		desktopPane.add(btnApagarTudo);
		
		tabela = new JTable();
		tabela.setBackground(new Color(255, 255, 255));
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Valor", "Quantidade"
			}
		));
		tabela.setBounds(32, 99, 423, 245);
		desktopPane.add(tabela);

	}
}
