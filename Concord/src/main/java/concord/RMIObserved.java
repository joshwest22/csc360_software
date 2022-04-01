package concord;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIObserved extends Remote
{
	public void addObserver(RMIObserver o) throws RemoteException;
	public void removeObserver(RMIObserver o) throws RemoteException;
}
