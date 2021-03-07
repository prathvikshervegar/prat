package see;

import java.io.*;
import java.net.*;

public class UDPserver {
	private static DatagramSocket ds;
	private static DatagramPacket in,out;
	private static int port=1234;
	private static byte buffer[];
	public static void main(String[] args) throws SocketException {
		ds=new DatagramSocket(port);
		System.out.println("Opening Port...");
		handleclient();
	}
	public static void handleclient() {
		buffer=new byte[256];
		String msgin="",msgout="";
		int n=0;
		try {
		do {
			in=new DatagramPacket(buffer, buffer.length);
			ds.receive(in);
			InetAddress host= in.getAddress();
			int cp=in.getPort();
			msgin=new String(in.getData(),0,in.getLength());
			if(!msgin.equals("Close")) {
				n++;
				System.out.println("Recieved");
				msgout="Message"+n+":"+msgin;
			}
			else {
				msgout=n+" messages recieved.";
			}
			out=new DatagramPacket(msgout.getBytes(), msgout.length(),host,cp);
			ds.send(out);
		}while(!msgin.equals("Close"));
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