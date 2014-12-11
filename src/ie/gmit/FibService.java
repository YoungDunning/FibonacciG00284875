package ie.gmit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class FibService {

	private LinkedList<FibRequest> inque = new LinkedList<FibRequest>();
	private Map <Integer, String> outque = new HashMap<Integer, String>();
	
	
	
	public int add(int max)
	{
		Random random = new Random(System.currentTimeMillis());
		int number = ((random.nextInt(199)+1));
		inque.add(new FibRequest(number, max));
		//Generates a random number
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

	public String add(String parameter) {
		return null;
	}
}
