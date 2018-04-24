import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyEmailServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
    response.setContentType("text/html; charset=UTF-8");
    
      String email = request.getParameter("email");
  	  int verifID = Integer.parseInt(request.getParameter("verification"));
  	User u = new User();
	u.getUser(Utilities.stmt, email);
    try 
    {
    	ResultSet r = Utilities.stmt.executeQuery("select * from verify as v where v.verifyID="+ verifID);
    		r.next();
    		if (email.equals(r.getString(1) ) && verifID == r.getInt(2) ) {
    			u.getUser(Utilities.stmt, email);
    			u.changeInfo(Utilities.stmt, "status", "1", 1);
    			System.out.println("Confirmed");
    			Utilities.stmt.executeUpdate("DELETE from verify where verifyID="+ verifID);
    			response.sendRedirect("accountConfirmation.html");
    		}
    		else {
    			response.sendRedirect("verifyEmail.html");
    		}
    		
    	} catch (SQLException e) {
		e.printStackTrace();
    	}
    }
	
	
    
  //  dispatcher.forward(request, response);
}
	


