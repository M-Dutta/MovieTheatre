import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class driver extends Utilities {
	public static void main (String [] args) throws InterruptedException, ParseException {
		try
		{
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
			@SuppressWarnings("unused")
			Statement stmt = null;
			Connection con = null;
		try 
		{
			con = DriverManager.getConnection(connectionURL+
					DBname,user,pswd);
			stmt=con.createStatement();
			System.out.println("connected to:" + con);
		} 
		catch (SQLException e) {
			System.out.println(e);
		}
		
	     /*
		User jeff = new User( "Mynameisfeff@taylorSwift.com","jesusholdthewheel", "Jeff",
				 "TK","666-777", DateConverter("1996-03-03")  ,1, 0,"Bronx", "detroit", "themoon", 66666);	
		jeff.register(stmt);
		**/
		User dummy = new User("1","", null, null, null, null, 0, 0, null, null, null, 0);
		User u  = new User();
		u.getUser( stmt, "Mynameisfeff@taylorSwift.com");
		System.out.println(u.email);
		u.login( stmt, "Mynameisfeff@taylorSwift.com", "jesusholdthewheel" ) ;
		dummy.login( stmt, "Mynameisfeff@taylorSwift.com","jesusholdthewheel" ) ;
}
	
	
	
	
}