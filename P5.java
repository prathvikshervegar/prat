package see;

import java.util.Scanner;

class Students{
	int rno;
	String name;
	Students(int usn,String name){
		this.rno=usn;
		this.name=name;
	}
	void show() {
		System.out.println("USN:"+rno+"\nName:"+name);
	}
}

public class P5 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of students:");
		int n=s.nextInt();
		Students st[]=new Students[n];
		try {
			for(int i=0;i<n;i++) {
				System.out.println("Enter USN:");
				int x=s.nextInt();
				System.out.println("Enter name:");
				String y=s.next();
				st[i]=new Students(x,y);
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		System.out.println("Enter the first character: ");
		char c=s.next().charAt(0);
		try {
			int count=0;
			for(int i=0;i<n;i++) {
				if(c==st[i].name.charAt(0)) {
					st[i].show();
					count++;
				}
			}
			if(count==0) {
				System.out.println("Invalid character!");
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}