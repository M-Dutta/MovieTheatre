
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class driver  {
	public static void main (String [] args) throws InterruptedException, ParseException {
	
	     
		try {
			ResultSet r = Utilities.stmt.executeQuery("select * from admin where admin_id='1'");
			r.next();
			System.out.println(r.getInt(1)+r.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/**
		User dummy = new User("1","", null, null, null, null, 0, 0, null, null, null, 0);
		User u  = new User();
		u.getUser( stmt, "Mynameisfeff@taylorSwift.com");
		System.out.println(u.email);
		u.login( stmt, "Mynameisfeff@taylorSwift.com", "jesusholdthewheel" ) ;
		dummy.login( stmt, "Mynameisfeff@taylorSwift.com","jesusholdthewheel" ) ;
		*/
}
	
	
	
	
}