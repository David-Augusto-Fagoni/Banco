package View;
import java.util.concurrent.Semaphore;

import controller.Transação;

public class Sistema {
	public static void main(String args[]) {
		Semaphore Sema = new Semaphore(2);
		for (int J=0;J<20;J++) {
			Transação T = new Transação(J,Sema);
			T.run();
		}
	}
}
