import java.io.IOException; 
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Date DateConverter (String date) throws ParseException {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date utilDate = formatter.parse(date);
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	return sqlDate;
	}
	
@Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws IOException, ServletException {
      // Set the response message's MIME type
      response.setContentType("text/html; charset=UTF-8");
      // Allocate a output writer to write the response message into the network socket
      //PrintWriter out = response.getWriter();
      
    	  String fName = request.getParameter("firstName");
    	  String lName = request.getParameter("lastName");
    	  String email = request.getParameter("email");
    	  String Password = request.getParameter("Password");
    	  String passConfirm = request.getParameter("passConfirm");
    	  String[] checkbox = request.getParameterValues("checkbox");
    
      System.out.println("Name " +fName);
      System.out.println("Lname " +lName);
      System.out.println("email " +email);
      System.out.println("pass " +Password);
      System.out.println("pass " +passConfirm);
      System.out.println("cb " +checkbox);
      
      if (Password.equals(passConfirm)) {
    	  Password = Utilities.hasher(Password);  
      }
     
	try {
		User nU = new User( email, Password,  fName, lName, "phone",DateConverter("1990-01-01") ,0, 0, "Blank", "Blank","Blank",0000000);
		nU.register(Utilities.stmt);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
      
   	}
}