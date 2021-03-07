package see;

import java.sql.*;
import java.util.*;

class bank{
	static Connection con;
	static Statement stm;
	static ResultSet rs;
	bank() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://172.16.2.3/student","student","student");
		stm=con.createStatement();
	}
	void insertinfo() throws SQLException{
		int r1=0;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter accNum");
		int accno=s.nextInt();
		System.out.println("Enter name");
		String name=s.next();
		System.out.println("Enter balance");
		float bal=s.nextFloat();
		String s1 = "insert into Account85 values("+accno+",'"+name+"',"+bal+")";
		r1 = stm.executeUpdate (s1);
		System.out.println(r1 +"rows affected");
	}
	void deleteinfo() throws SQLException{
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the account no.");
		int acc = s1.nextInt();
		String s2 = "DELETE FROM Account85 WHERE accNum="+acc ;
		stm.executeUpdate (s2);
		System.out.println("Database deleted successfully!!!!");
	}
	void displayinfo() throws SQLException{
		String s = "SELECT * FROM Account85";
		rs = stm.executeQuery (s);
		while(rs.next()) {
			System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t" + rs.getFloat(3));
		}
	}
	void close() throws SQLException {
		rs.close();
		stm.close();
		con.close();
	}
}

public class JDBCbank {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		bank b=new bank();
		Scanner s=new Scanner(System.in);
		boolean flag=true;
		while(flag) {
			System.out.println("!.Insert 2.Delete 3.Display 4.Exit\nEnter choice");
			int ch=s.nextInt();
			switch(ch) {
			case 1:b.insertinfo();
			break;
			case 2:b.deleteinfo();
			break;
			case 3:b.displayinfo();
			break;
			default:flag=false;
			break;
			}
		}
		b.close();
	}
}