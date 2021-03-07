package see;

import java.io.*;
import java.net.*;
import java.util.*;

public class TCPserver {
	private static ServerSocket ds;
	private static int port=1234;
	public static void main(String[] args)  {
		try {
			System.out.println("Opening port...");
			ds=new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		handleclient1();
	}
	public static void handleclient1() {
		Socket link=null;
		try {
			link=ds.accept();
			Scanner s=new Scanner(link.getInputStream());
			PrintWriter pw=new PrintWriter(link.getOutputStream(),true);
			int n=0;
			String msg;
			msg=s.nextLine();
			while(!msg.equals("Close")){
				System.out.println("Received");
				n++;
				pw.println("Message "+n+": "+msg);
				msg=s.nextLine();
			}
			pw.println(n+" messages received");
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