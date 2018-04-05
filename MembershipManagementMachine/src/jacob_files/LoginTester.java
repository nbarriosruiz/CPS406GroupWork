package jacob_files;
import java.io.*;
public class LoginTester {

	public static void main(String[] args) 
	{
		LoginInterface login = new LoginInterface();
		Customer jill = new Customer("Jill","Stein","123 This St.",1,"jill","password123");
		Customer bill = new Customer("Bill","Stein","123 This St.",2,"bill","password456");
		try
		{
			FileOutputStream fileout = new FileOutputStream("bill.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(bill);
			out.close();
			fileout.close();
		}
		catch(IOException i)
		{
			
		}
		try
		{
			FileOutputStream fileout2 = new FileOutputStream("jill.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(fileout2);
			out2.writeObject(jill);
			out2.close();
			fileout2.close();
		}
		catch(IOException e)
		{
		}
	}
}
