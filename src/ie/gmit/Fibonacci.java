package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Fibonacci 
extends UnicastRemoteObject implements RemoteFibonacci{

	/*public String getFibonacciSequence(int max) throws RemoteException
	{
		return max;
	}*/
	
	public Fibonacci() throws RemoteException
	{
		super();
	}
	
	@Override
	public String getFibonacci(int max) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	public List<Integer> genFib(int fibNum) throws RemoteException{
		List<Integer> results = new ArrayList<Integer>();
		for (int i=0; i<fibNum; i++){
			results.add((int) Math.round(Math.pow(Math.sqrt(5)+1, i) / (Math.pow(2, i) * Math.sqrt(5))));
		}
		return results;
	}

	public String call(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public String add(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
	
}