package Threads;

public class Synchronized {

	int balance = 0;
	
	public static void main(String[] args) {
	
		Synchronized sync = new Synchronized();
		sync.syncing();
	}
	
	public void syncing(){
		
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 10000; i++) {
					add();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 10000; i++) {
					substract();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		System.out.println("Balance : " + balance);
		
	}
	
	private void add() {
		balance++;
	}
	
	private void substract() {
		balance--;
	}
	
}
