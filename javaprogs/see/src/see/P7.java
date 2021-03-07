package see;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

class Swingsmall  implements ActionListener {
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	JLabel l;
	Swingsmall(){
		JFrame jf=new JFrame("Calculator");
		
		jf.setSize(300,300);
		jf.setLayout(new FlowLayout());
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		t1=new JTextField(25);
		t2=new JTextField(25);
		t3=new JTextField(25);
		
		jf.add(t1);
		jf.add(t2);
		jf.add(t3);
		
		b1=new JButton("Sum");
		b1.addActionListener(this);
		
		b2=new JButton("Average");
		b2.addActionListener(this);
		
		b3=new JButton("Largest");
		b3.addActionListener(this);
		
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		
		l=new JLabel("Result");
		jf.add(l);
		
		jf.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		double a = Double.parseDouble(t1.getText());
		double b = Double.parseDouble(t2.getText());
		double c = Double.parseDouble(t3.getText());
		double largest;
		if(e.getActionCommand()=="Sum"){
			l.setText((a+b+c)+"");
		}
		else if(e.getActionCommand()=="Average"){
			l.setText((a+b+c)/3+"");
		}
		else{
			if(a>b && a>c)
				largest = a;
			else if(b>a && b>c)
				largest = b;
			else
				largest = c;
			l.setText(largest+"");
		}
	}
	
}

public class P7 {
	public static void main(String[] args) {
		new Swingsmall();
	}
}