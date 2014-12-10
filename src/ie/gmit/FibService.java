package ie.gmit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FibService {

	private LinkedList<FibRequest> inque = new LinkedList<FibRequest>();
	private Map <Integer, String> outque = new HashMap<Integer, String>();
	
	
	
	public int add(int max)
	{
		//Generates a random number
		int number = (int) Math.random();
		return number;
	}
	
	public String getResult(int jobNum)
	{
		if(outque.containsKey(jobNum))
		{
			String result = outque.get(jobNum);
			outque.remove(jobNum);
			return result;
		}
		else
		{
			return null;
		}
	}
}
