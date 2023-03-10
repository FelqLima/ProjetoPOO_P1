package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Cliente {

	private int idCliente;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Date dataNascimento;
	private ArrayList<Gastos> gastos;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Gastos> getGastos() {
		return gastos;
	}
	public void setGastos(ArrayList<Gastos> gastos) {
		this.gastos = gastos;
	}
	
}
