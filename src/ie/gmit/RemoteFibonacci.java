package ie.gmit;

import java.rmi.Remote;

public interface RemoteFibonacci extends Remote{
	
	public void getFibonacci(int max);

}
