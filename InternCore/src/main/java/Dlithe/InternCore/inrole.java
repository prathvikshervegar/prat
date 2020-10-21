package Dlithe.InternCore;

public class inrole
{
     public static void main(String[] args) 
     {
		System.out.println("Dlithe Consultancy");
		Holder student1=new Holder();
		student1.name="Prathvik";student1.mobile=9023563545L;student1.cgpa=9.2;student1.skill="java";
		student1.confirm();
	}
}

class Holder
{
	String name,skill;
	Long mobile; Double cgpa;
	public void confirm()
	{
		System.out.println(this.name);
		System.out.println(this.skill);
		System.out.println(this.cgpa);
		System.out.println(this.mobile);
	}
}