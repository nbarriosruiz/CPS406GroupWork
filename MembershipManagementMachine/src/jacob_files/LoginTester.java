import java.io.*;
public class LoginTester {

	public static void main(String[] args) 
	{
		LoginInterface login = new LoginInterface();
		Customer bill = new Customer("Bill", "password123");
		Customer jill = new Customer("Jill", "password123");
		try
		{
			FileOutputStream fileout = new FileOutputStream("Customer1.ser");
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
			FileOutputStream fileout2 = new FileOutputStream("Customer2.ser");
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
