package org.libertas.crud;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private Connection conexao;
	
	public Conexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://trabalho1.mysql.database.azure.com/libertas?useTimezone=true&serverTimezone=UTC";
			conexao = DriverManager.getConnection(url, "trabely@trabalho1", "Potejoao22");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desconecta() {
		try {
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() {
		return conexao;
	}
	
	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

}
