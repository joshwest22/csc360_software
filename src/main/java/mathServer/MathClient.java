package mathServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MathClient
{

	public static void main(String[] args)
	{
		try
		{
			MathServerInterface ms = (MathServerInterface)
					Naming.lookup("rmi://127.0.0.1/MATHS");
			int answer = ms.addNumbers(5, 10);
			System.out.println("Answer is " + answer);
		} catch (MalformedURLException | RemoteException | NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
