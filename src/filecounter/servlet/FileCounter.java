package filecounter.servlet;

import ie.gmit.Fibonacci;
import ie.gmit.Fibonacci;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import filecounter.dao.FileDao;

/**
 * Servlet implementation class FileCounter
 */
@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {
	  private static final long serialVersionUID = 1L;

	  int count;
	  private FileDao dao;

	  @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse rsp) 
			  throws ServletException, IOException
	  {
		  Fibonacci fs = null;
			
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
	    // Set a cookie for the user, so that the counter does not increate
	    // every time the user press refresh
	    HttpSession session = req.getSession(true);
	    // Set the session valid for 5 secs
	    session.setMaxInactiveInterval(5);
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