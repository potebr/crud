package org.libertas.crud;

import java.util.LinkedList;

public class Lista {
private static LinkedList<Produto> lista = new LinkedList<Produto>();
	
	public void inserir(Produto p) {
		lista.add(p);
	}
	
	public LinkedList<Produto> listar() {
		return lista;
	}
	
	public double getTotalPrecoVenda() {
		double total = 0.0;
		for (Produto p : lista) {
			total += p.getPrecoVenda();
		}
		return total;
	}
	
	public double getTotalPrecoCusto() {
		double total = 0.0;
		for (Produto p : lista) {
			total += p.getPrecoCusto();
		}
		return total;
	}
	
	public double getTotalSaldo() {
		double saldo = 0.0;
		for (Produto p : lista) {
			saldo += p.getSaldo();
		}
		return saldo;
	}
}
