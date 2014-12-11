package ie.gmit;

import filecounter.servlet.FileDao;

import java.io.IOException;
import java.io.PrintWriter;

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
	  public void doGet(HttpServletRequest req, HttpServletResponse rsp) 
			  throws ServletException, IOException
	  {
		  fs = new FibService();

			String rType = req.getParameter("request-type");
			System.out.println(rType);
			if(rType.equals("Add"))
			{
				String jobNumber = "";
				jobNumber += fs.add(Integer.parseInt(req.getParameter("jobNumber")));
				//rsp.sendRedirect("FibReq.jsp");
			
				req.getSession().setAttribute("jobNumber", jobNumber);
				req.getSession().setAttribute("Timer", 10);
				req.getSession().setAttribute("request-type", "poll");
				req.getRequestDispatcher("FibReq.jsp").forward(req, rsp);
			}
			
			else if(rType.equals("pull"))
			{
				String jobNumber ="";
				jobNumber += fs.add(req.getParameter("jobNumber"));
				rsp.sendRedirect("Result.jsp");
				if(fs.getResult(Integer.parseInt(jobNumber)) != null)
				{
					//Send to client
				}
				else
				{
					//response.getRequest
				}
			
			}
	    // Set a cookie for the user, so that the counter does not increate
	    // every time the user press refresh
	    HttpSession session = req.getSession(true);
	    
	    
	    // Set the session valid for 10 secs
	    session.setMaxInactiveInterval(10);
	    rsp.setContentType("text/plain");
	    PrintWriter out = rsp.getWriter();
	    if (session.isNew()) {
	      count++;
	    }
	    out.println("This site has been accessed " + count + " times.");
	  }

	  
	  @Override
	  public void init() throws ServletException {
	    dao = new FileDao();
	    try {
	      count = dao.getCount();
	    } catch (Exception e) {
	      getServletContext().log("An exception occurred in FileCounter", e);
	      throw new ServletException("An exception occurred in FileCounter"
	          + e.getMessage());
	    }
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