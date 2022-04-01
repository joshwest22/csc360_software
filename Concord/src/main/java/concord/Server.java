package concord;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements RMIObserved
{

	private static final long serialVersionUID = 2580829118905122035L;
	protected Server() throws RemoteException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	ArrayList<RMIObserver> observers = new ArrayList<RMIObserver>();
	@Override
	public void addObserver(RMIObserver o) throws RemoteException
	{
		observers.add(o);
	}

	@Override
	public void removeObserver(RMIObserver o) throws RemoteException
	{
		observers.remove(o);
	}
	
	public void notifyObservers()
	{
		for(RMIObserver o : observers)
		{
			try
			{
				o.notifyFinished();
			} catch (RemoteException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void makeDonuts()
	{
		//example method should be more complicated in implementation
		notifyObservers();
	}
	
}
