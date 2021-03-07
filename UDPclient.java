package see;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPclient {
	private static DatagramSocket ds;
	private static DatagramPacket in,out;
	private static int port=1234;
	private static byte buffer[];
	private static InetAddress host;
	public static void main(String[] args) throws SocketException, UnknownHostException {
		ds=new DatagramSocket();
		host=InetAddress.getLocalHost();
		accessserver();
	}
	public static void accessserver() {
		buffer=new byte[256];
		Scanner s=new Scanner(System.in);
		String msgin="",msgout="";
		try {
		do {
			System.out.println("Enter the message:");
			msgout=s.next();
			out=new DatagramPacket(msgout.getBytes(), msgout.length(),host,port);
			ds.send(out);
			in=new DatagramPacket(buffer, buffer.length);
			ds.receive(in);
			msgin=new String(in.getData(),0,in.getLength());
			System.out.println("Server> "+msgin);
		}while(!msgout.equals("Close"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			ds.close();
			System.out.println("Closing connection...");
			System.exit(1);
		}
	}
}