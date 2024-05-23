package br.com.fiap.model;

import br.com.fiap.exception.InsufficientBalanceException;

public class Conta {
	
	private String cliente;	
	private double saldo = 300;
	
	public void retirada(double valor) throws InsufficientBalanceException {
		if (valor > saldo) {
			throw new InsufficientBalanceException(Double.toString(saldo - valor));
		}
		this.saldo = this.saldo - valor;
	}
	
	public void deposito(double valor) {
		this.saldo = this.saldo + valor;
	}
	
	
	public static void main(String[] args) {
		Conta c = new Conta();
		c.deposito(200);
		c.deposito(100);
		try {
			c.retirada(250);
			c.retirada(300);
			c.retirada(300);
		} catch (InsufficientBalanceException e) {
			e.printStackTrace();
			//System.out.println("Cliente nao possui saldo para retirada");
		}
		System.out.println("Finalizando o programa");
	}

}
