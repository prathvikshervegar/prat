package see;

import java.util.Scanner;

class Student{
	int usn;
	String name;
	Scanner s=new Scanner(System.in);
	void read(){
		System.out.println("Enter the USN:");
		usn=s.nextInt();
		System.out.println("Enter the name:");
		name=s.next();
	}
	void show() {
		System.out.println("USN:"+usn+"\nName:"+name);
	}
}

class Test extends Student{
	int m1,m2,m3;
	Scanner s1=new Scanner(System.in);
	void readmarks(){
		System.out.println("Enter 3 subject marks");
		m1=s1.nextInt();
		m2=s1.nextInt();
		m3=s1.nextInt();
	}
	void showmarks() {
		System.out.println("Subject 1 marks= "+m1);
		System.out.println("Subject 2 marks= "+m2);
		System.out.println("Subject 3 marks= "+m3);
	}
}

interface sports{
	final int sportswt=40;
	void showsportswt();
}

class Result extends Test implements sports{
	void read() {
		super.read();
		readmarks();
	}
	void show() {
		super.show();
		showmarks();
		showsportswt();
		int total=m1+m2+m3+sportswt;
		System.out.println("Total marks="+total);
	}
	public void showsportswt() {
		System.out.println("Sports weight= "+sportswt);
	}
}

public class P4 {
	public static void main(String[] args) {
		Result r=new Result();
		r.read();
		r.show();
	}
}
