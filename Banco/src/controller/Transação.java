package controller;

import java.util.concurrent.Semaphore;

public class Transação extends Thread{
	
	private int ID;
	private Semaphore Saque;
	private Semaphore Deposito;
	
	public Transação (int ID, Semaphore semaforo, Semaphore Deposito) {
		this.ID = ID;
		this.Saque = semaforo;
		this.Deposito = Deposito;
	}
	public void run () {
		int Saldo = (int) (Math.random()*900)+450;
		int transação =(int) (Math.random()*450)+1;
		if ((int) (Math.random()*2) == 0 ) {
			
			Saque(Saldo,transação);
		}else {
			Deposito(Saldo,transação);
		}
	}
	public void Saque(int saldo, int transação) {
		try {
			Saque.acquire();
			System.out.println("A conta "+ID+" esta fazendo um saque de "+transação+"$, Dixando seu antigo saldo de "+saldo+"$ igual a "+(saldo-transação)+"$.");
			sleep(194);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Saque.release();
		}
	}
	public void Deposito(int saldo, int transação) {
		try {
			Deposito.acquire();
			System.out.println("A conta "+ID+" esta fazendo um Deposito de "+transação+"$, Dixando seu antigo saldo de "+saldo+"$ igual a "+(saldo+transação)+"$.");
			sleep(194);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Deposito.release();
		}
	}
}
