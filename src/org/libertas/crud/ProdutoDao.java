package org.libertas.crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class ProdutoDao {
	public void inserir(Produto p) {
		Conexao con = new Conexao();
		try {
			String sql = "INSERT INTO produto (descricao, marca, precocusto, precovenda, saldoestoque) " + 
						"VALUES(?, ?, ?, ?, ?);";
			PreparedStatement prep = con.getConexao().prepareStatement(sql);
			prep.setString(1, p.getDescricao());
			prep.setString(2, p.getMarca());
			prep.setDouble(3, p.getPrecoCusto());
			prep.setDouble(4, p.getPrecoVenda());
			prep.setDouble(5, p.getSaldo());
			prep.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.desconecta();
	}
	
	public LinkedList<Produto> listar() {
		LinkedList<Produto> lst = new LinkedList<Produto>();
		Conexao con = new Conexao();
		try {
			String sql = "SELECT idproduto, descricao, marca, precocusto, precovenda, saldoestoque " + 
					"FROM produto order by descricao;";
			Statement sta = con.getConexao().createStatement();
			ResultSet res = sta.executeQuery(sql);
			while (res.next()) {
				Produto p = new Produto();
				p.setIdproduto(res.getInt("idproduto"));
				p.setDescricao(res.getString("descricao"));
				p.setMarca(res.getString("marca"));
				p.setPrecoCusto(res.getDouble("precocusto"));
				p.setPrecoVenda(res.getDouble("precovenda"));
				p.setSaldo(res.getDouble("saldoestoque"));
				lst.add(p);
			}
			res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lst;
	}
	
	public void excluir(int idproduto) {
		Conexao con = new Conexao();
		try {
			String sql = "delete from produto where idproduto = ?";
			PreparedStatement pre = con.getConexao().prepareStatement(sql);
			pre.setInt(1, idproduto);
			pre.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		con.desconecta();
	}
	
	public double getTotalPrecoVenda(LinkedList<Produto> lista) {
		double total = 0.0;
		for (Produto p : lista) {
			total += p.getPrecoVenda();
		}
		return total;
	}
	
	public double getTotalPrecoCusto(LinkedList<Produto> lista) {
		double total = 0.0;
		for (Produto p : lista) {
			total += p.getPrecoCusto();
		}
		return total;
	}
	
	public double getTotalSaldo(LinkedList<Produto> lista) {
		double saldo = 0.0;
		for (Produto p : lista) {
			saldo += p.getSaldo();
		}
		return saldo;
	}
}
