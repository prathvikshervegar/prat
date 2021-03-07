package see;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPclient {
	private static int port=1234;
	private static InetAddress host;
	public static void main(String[] args){
		try {
			host = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		accessserver1();
	}
	public static void accessserver1() {
		Socket link=null;
		try {
			link = new Socket(host,port);
			Scanner in=new Scanner(System.in);
			Scanner s=new Scanner(link.getInputStream());
			PrintWriter pw = new PrintWriter(link.getOutputStream(),true);
			String msg,response;
			do{
				System.out.println("Enter the message:");
				msg = in.nextLine();
				pw.println(msg);
				response = s.nextLine();
				System.out.println("\nSERVER>"+response);
			}while(!msg.equals("Close"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				link.close();
				System.out.println("Closing connection...");
				System.exit(1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}