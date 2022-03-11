package mathServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathServerInterface extends Remote
{
	//returns the sum of two nums
	public int addNumbers(int a, int b) throws RemoteException;
	
	//return substraction of two nums
	public int subtractNumbers(int a,int b) throws RemoteException;
	
}
