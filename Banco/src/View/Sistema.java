package View;
import java.util.concurrent.Semaphore;

import controller.Transação;

public class Sistema {
	public static void main(String args[]) {
		Semaphore Saque = new Semaphore(2);
		Semaphore Deposito = new Semaphore(2);
		for (int J=0;J<20;J++) {
			Transação T = new Transação(J,Saque,Deposito);
			T.run();
		}
	}
}
