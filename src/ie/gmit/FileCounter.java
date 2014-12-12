package ie.gmit;

import filecounter.servlet.FileDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class FileCounter
 */
@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {
	  private static final long serialVersionUID = 1L;
	  private FibService fs;
	  
	  int count;
	  private FileDao dao;

	  @Override
	  public void init() throws ServletException {
	    dao = new FileDao();
	    fs = new FibService();
	    try {
	    	Fibonacci fibonacci=new Fibonacci(1099);
	    	LocateRegistry.createRegistry(1099);
	    	Naming.bind("fibo",fibonacci);
	      count = dao.getCount();
	    } catch (Exception e) {
	      getServletContext().log("An exception occurred in FileCounter", e);
	      throw new ServletException("An exception occurred in FileCounter"
	          + e.getMessage());
	    }
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest req, HttpServletResponse rsp) 
			  throws ServletException, IOException
	  {
		 

			String rType = req.getParameter("request-type");
			System.out.println(rType);
			
			if(rType.equals("Add"))
			{
				String jobNumber = "";
				jobNumber += fs.add(Integer.parseInt(req.getParameter("max")));
				
				//rsp.sendRedirect("FibReq.jsp");
			
				req.getSession().setAttribute("jobNumber", jobNumber);
				//req.getSession().setAttribute("Timer", 10);
				//req.getSession().setAttribute("request-type","pull");
				req.getRequestDispatcher("FibReq.jsp").forward(req, rsp);
			}
			
			else if(rType.equals("pull"))
			{
				System.out.println("This is pull");
				String result = null;
				try {
					RemoteFibonacci remote=(RemoteFibonacci)Naming.lookup("rmi://localhost:1099/fibo");
					System.out.println(req.getSession().getAttribute("max"));
					//result=remote.getFibonacci(Integer.valueOf((String) req.getSession().getAttribute("max")));
					result=remote.getFibonacci(Integer.valueOf(String.valueOf(req.getSession().getAttribute("max"))));

					System.out.println(result);
					req.setAttribute("result",result);
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String jobNumber =null;
				try{
					jobNumber = fs.getResult(Integer.parseInt((String) req.getParameter("jobNum")));
					System.out.println(jobNumber);

				}
				catch(Exception e)
				{
					e.getMessage();
				}
				//jobNumber += fs.add(req.getParameter("jobNumber"));
				//rsp.sendRedirect("Result.jsp");
				//if(fs.getResult(Integer.parseInt(jobNumber)) != null)
				////if(jobNumber!=null)  
				//{
					//Send to client
					//req.setAttribute("jobNumber", jobNumber);
				    rsp.sendRedirect("Result.jsp?result="+result);	
				//}
//				else
//				{
//					rsp.sendRedirect("FibReq.jsp");	
//					//response.getRequest
//				}
			
			}
	    // Set a cookie for the user, so that the counter does not increate
	    // every time the user press refresh
	   // HttpSession session = req.getSession(true);
	    
	    
	    // Set the session valid for 10 secs
	  //  session.setMaxInactiveInterval(10);
	    //rsp.setContentType("text/plain");
//	    PrintWriter out = rsp.getWriter();
//	    if (session.isNew()) {
//	      count++;
//	    }
	    //out.println("This site has been accessed " + count + " times.");
	  }

	  
	 
	  
	  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		  doGet(req,resp);
	}

	public void destroy() {
	    super.destroy();
	    try {
	      dao.save(count);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

	}