
import java.io.IOException; 
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditPromoServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("save") != null)
	{

	}
	
	if (request.getParameter("back") != null)
	{
		response.sendRedirect("adminPromoDetails.html");	
	}
	
	if (request.getParameter("saveNew") != null)
	{
		String Code = request.getParameter("Code");
		String Discount = request.getParameter("Discount");
		String exp = request.getParameter("ExpirationDate");
		try {
			PromoCode p = new PromoCode(Code,Double.parseDouble(Discount), Utilities.DateConverter(exp));
			p.addPromoCode(Utilities.stmt, p);
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
}