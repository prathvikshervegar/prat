package see;

import java.io.*;
import java.util.*;

public class P11 {
	private static final int REC_SIZE = 42;
	private static final int NAME_SIZE = 15;
	private static RandomAccessFile ranFile;
	private static long accno;
	private static String name;
	private static float bal;
	public static void main(String[] args) throws IOException {
		 ranFile = new RandomAccessFile("acc.dat","rw");
		 Scanner s=new Scanner(System.in);
		 boolean flag=true;
		while(flag) {
			System.out.println("1.Insert record 2.Display record 3.Exit\nEnter the choice");
			int ch=s.nextInt();
			switch(ch) {
			case 1: System.out.println("Create user account");
			 		System.out.println("Enter account number:");
			 		accno=s.nextInt();
			 		System.out.println("Enter name");
			 		name=s.next();
			 		System.out.println("Enter balance:");
			 		bal=s.nextFloat();
			 		writeRecord(accno,name,bal);
			 		break;
			case 2: System.out.println("RECORDS:");
					showRecords();
				 	break;
			default:flag=false;
			 	 break;
			}
		 }
	}
	public static void writeRecord(long accno, String name, float bal) throws IOException {
		 long pos = ranFile.length();
		 ranFile.seek(pos);
		 ranFile.writeLong(accno);
		 writeString(name,NAME_SIZE);
		 ranFile.writeFloat(bal);
	}
	public static void writeString(String name, int size) throws IOException {
		int len = name.length();
		 if(len<size){
			 ranFile.writeChars(name);
			 for(int i=len;i<size;i++)
				 ranFile.writeChar(' ');
		 }
		 else{
			 ranFile.writeChars(name.substring(0,size));
		 }
	}
	public static void showRecords() throws IOException {
		 long n = ranFile.length()/REC_SIZE;
		 ranFile.seek(0);
		 for(int i=0;i<n;i++){
			 accno = ranFile.readLong();
			 name = readString(NAME_SIZE);
			 bal = ranFile.readFloat();
		 System.out.println(accno+" "+name+" "+bal);
		 }
	}
	public static String readString(int size) throws IOException {
		String res = "";
		 for(int i=0;i<size;i++)
			 res+=ranFile.readChar();
		 return res;
	}
}
