package see;

import java.io.*;
import java.util.*;

public class P8 {
	public static void main(String[] args) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("f3.txt"));
		 Scanner s1 = new Scanner(new File("f1.txt"));
		 Scanner s2 = new Scanner(new File("f2.txt"));
		 while(s1.hasNext()){
		 String temp = s1.nextLine();
		 pw.print(temp+" ");
		 }
		 while(s2.hasNext()){
		 String temp = s2.nextLine();
		 pw.print(temp);
		 }
		 pw.flush();
	}
}
