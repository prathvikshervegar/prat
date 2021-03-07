package see;

import java.awt.print.Printable;

abstract class Figure{
	int x,y;
	abstract int area();
}

class Rect extends Figure{
	Rect(int l,int b){
		x=l;
		y=b;
	}
	int area() {
		return x*y;
	}	
}

class Tri extends Figure{
	Tri(int b,int h){
		x=b;
		y=h;
	}
	int area() {
		return (int) (0.5*x*y);
	}
}

class Sq extends Figure{
	Sq(int s){
		x=y=s;
	}
	int area() {
		return x*x;
	}
}

public class P3 {
	public static void main(String[] args) {
		Figure f;
		Rect r=new Rect(2,3);
		Tri t=new Tri(3,4);
		Sq s=new Sq(5);
		r.area();
		t.area();
		s.area();
		f=r;
		System.out.println("Area of Rectangle="+f.area());
		f=t;
		System.out.println("Area of Triangle="+f.area());
		f=s;
		System.out.println("Area of Square="+f.area());
	}
}
