package see;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class Swingbig implements ActionListener,ListSelectionListener{
	JTextField t1,t2;
	JRadioButton r1,r2,r3;
	String[] Cities = {"Mlore","Blore","Mysuru","Madikeri","Udupi","Bhatkal","Puttur","Sullia"};
	JList<String> jlist=new JList<String>(Cities);
	JScrollPane jsp;
	JCheckBox c1,c2,c3;
	Swingbig(){
		JFrame jf=new JFrame("User details");
		jf.setSize(300,300);
		jf.setLayout(new FlowLayout());
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		t1=new JTextField(25);
		t2=new JTextField(20);
		jf.add(t1);
		jf.add(t2);
		
		r1=new JRadioButton("Male");
		r1.addActionListener(this);
		r2=new JRadioButton("Female");
		r2.addActionListener(this);
		r3=new JRadioButton("Others");
		r3.addActionListener(this);
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		jf.add(r1);
		jf.add(r2);
		jf.add(r3);
		
		jlist.addListSelectionListener(this);
		jsp=new JScrollPane(jlist);
		jsp.setPreferredSize(new Dimension(150,100));
		jf.add(jsp);
		
		c1=new JCheckBox("Dancing");
		c1.addActionListener(this);
		c2=new JCheckBox("Singing");
		c2.addActionListener(this);
		c3=new JCheckBox("Reading");
		c3.addActionListener(this);
		jf.add(c1);
		jf.add(c2);
		jf.add(c3);
		
		JButton b=new JButton("SUBMIT");
		b.addActionListener(this);
		jf.add(b);
		
		jf.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String val = e.getActionCommand();
		String city,name,num,gender,hobby="";
		 if(val.equals("SUBMIT")){
		 city = jlist.getSelectedValue();
		 name = t1.getText();
		 num = t2.getText();
		 if(r1.isSelected())
		 gender = r1.getActionCommand();
		 else if(r2.isSelected())
		 gender = r2.getActionCommand();
		 else
		 gender = r3.getActionCommand();
		 if(c1.isSelected())
		 hobby+=(c1.getActionCommand()+"   ");
		 if(c2.isSelected())
		 hobby+=(c2.getActionCommand()+"   ");
		 if(c3.isSelected())
		 hobby+=(c3.getActionCommand()+"   ");
		 String res = "Name: "+name+"\nNumber: "+num+"\nGender: "+gender+"\nCity: "+city+"\nHobbies: "+hobby+"\n";
		 JOptionPane.showMessageDialog(null,res);
		 }
	}
	public void valueChanged(ListSelectionEvent e) {
		
	}
}

public class P10 {
	public static void main(String[] args) {
		new Swingbig();
	}
}
