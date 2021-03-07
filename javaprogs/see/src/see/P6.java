package see;

import java.util.Random;

class T1 extends Thread{
	int val;
	T1(int n){
		val=n;
	}
	public void run() {
		for(int i=1;i<=3;i++) {
			 try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Square of "+(val + i) + ": " + Math.pow((val + i), 2));
		}
	}
}

class T2 extends Thread{
	int val;
	T2(int n){
		val=n;
	}
	public void run() {
		for(int i=1;i<=3;i++) {
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Cube of "+(val + i) + ": " + Math.pow((val + i), 3));
		}
	}
}

public class P6 {
	public static void main(String[] args) {
		Random rand = new Random();
		 int x = rand.nextInt(11);
		 System.out.println("Random generated number:"+x+"\n");
		 T1 thread1 = new T1(x);
		 thread1.start();
		 T2 thread2 = new T2(x);
		 thread2.start();
	}
}