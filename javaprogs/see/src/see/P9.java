package see;

class First extends Thread{
	public void display(String msg) throws InterruptedException{
		 System.out.print("["+msg);
		 Thread.sleep(1500);
		 System.out.print("]");
	}
}

class Second extends Thread{
	First fobj;
	String msg;
	Second(First fp,String msg){
		fobj = fp;
		this.msg = msg;
		start();
	}
	public void run() {
		synchronized(fobj) {
			try {
				fobj.display(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class P9 {
	public static void main(String[] args) {
		First fnew = new First();
		 Second s1 = new Second(fnew,"welcome");
		 Second s2 = new Second(fnew,"to");
		 Second s3 = new Second(fnew,"java");
	}
}