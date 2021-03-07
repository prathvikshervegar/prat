package see;

class Customer
{
 int amount=100;

 synchronized void withdraw(int amount)
 {
 System.out.println("going to withdraw...");

 if(this.amount<amount)
 {
 System.out.println("Less balance; waiting for deposit...");
 try
 {
 wait();
 }
 catch(Exception e)
 {
 }
 }
 this.amount-=amount;
 System.out.println("withdraw completed...");
 System.out.println("Balance= "+ this.amount);
 }

 synchronized void deposit(int amount)
 {
 System.out.println("going to deposit...");
 this.amount+=amount;
 System.out.println("deposit completed... ");
 notify();
 }
}
public class abc
{
public static void main(String[] args)
{
final Customer c=new Customer();
 Thread t1 =new Thread()
 {
 public void run()
 {
 c.withdraw(150);
 }
};
 t1.start();
Thread t2= new Thread()
{
 public void run()
 {
c.deposit(100);
 }
};
t2.start();
}
}
