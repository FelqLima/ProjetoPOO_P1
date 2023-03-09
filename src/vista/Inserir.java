package vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;

import modelo.Produto;
import persistencia.Conexao;
import persistencia.JDBCProduto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inserir extends JInternalFrame {
	private JTextField campoNome;
	private JTextField campoValor;
	private JTextField campoQuantidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserir frame = new Inserir();
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
	public Inserir() {
		setBounds(100, 100, 400, 300);
		
		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 70, 45, 13);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setBounds(10, 110, 45, 13);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(10, 150, 45, 13);
		desktopPane.add(lblNewLabel_2);
		
		campoNome = new JTextField();
		campoNome.setBounds(95, 67, 149, 19);
		desktopPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoValor = new JTextField();
		campoValor.setBounds(95, 107, 149, 19);
		desktopPane.add(campoValor);
		campoValor.setColumns(10);
		
		campoQuantidade = new JTextField();
		campoQuantidade.setBounds(95, 147, 149, 19);
		desktopPane.add(campoQuantidade);
		campoQuantidade.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = campoNome.getText();
				int valor = Integer.parseInt(campoValor.getText());
				int quantidade = Integer.parseInt(campoQuantidade.getText());
				
				Produto p = new Produto(nome, valor, quantidade);
				
				//Persistindo
				Conexao fabrica = new Conexao();
				JDBCProduto gerente = new JDBCProduto(fabrica.abrirConexao());
				gerente.inserirProduto(p);
				fabrica.fecharConexao();
				
				campoNome.setText("");
				campoValor.setText("");
				campoQuantidade.setText("");
				campoNome.requestFocus();
				
			}
		});
		btnNewButton.setBounds(268, 215, 85, 21);
		desktopPane.add(btnNewButton);

	}
}
