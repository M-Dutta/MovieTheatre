import java.io.IOException; 

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signInServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	ServletConfig config = this.getServletConfig();
	ServletContext context = config.getServletContext();
	
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	User nU = new User();
	nU.login(Utilities.stmt, email, password);
	
	RequestDispatcher dispatcher = context.getRequestDispatcher("/index.html");
	dispatcher.forward(request, response);
		
	}
}	
