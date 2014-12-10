package ie.gmit;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse rsp) 
			throws IOException
	{
		CrunchifyFibonacci fs = null;
		
		String rType = req.getParameter("Request-type");
		if(rType.equals("Add"))
		{
			String jobNum = fs.add(req.getParameter("max"));
			//out.write("Job No.");
		}
		else if(rType.equals("poll"))
		{
			String jobNum = fs.add(req.getParameter("Job No"));
	
		}
			//out.flush();
	}
	
}
