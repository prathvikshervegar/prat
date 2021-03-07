package see;

import java.util.Scanner;

class Bankacc{
	int accno;
	String name;
	float bal;
	Scanner s=new Scanner(System.in);
	Bankacc(int a,String b, float c) {
		accno=a;
		name=b;
		bal=c;
	}
	void show() {
		System.out.println("Account number:"+accno+"\nName:"+name+"\nBalance:"+bal);
	}
	void deposit() {
		System.out.println("Enter the amount to be deposited:");
		float dep=s.nextFloat();
		bal=bal+dep;
		System.out.println("Updated balance:"+bal);
	}
	void withdraw() {
		System.out.println("Enter the amount to be withdrawn:");
		float with=s.nextFloat();
		if(with>bal)
			System.out.println("Insufficient funds\n");
		else {
			bal=bal-with;
			System.out.println("Updated balance:"+bal);
		}
	}
}

public class P2 {
	public static void main(String[] args) {
		Bankacc ba = new Bankacc(111, "Prathvik", 500);
		boolean flag=true;
		Scanner s1=new Scanner(System.in);
		while(flag) {
			System.out.println("1.Deposit 2.Withdraw 3.Display 4.Exit");
			System.out.println("Enter the choice");
			int ch=s1.nextInt();
			switch(ch) {
			case 1:ba.deposit();
			break;
			case 2:ba.withdraw();
			break;
			case 3:ba.show();
			break;
			default:flag=false;
			break;
			}
		}
	}
}