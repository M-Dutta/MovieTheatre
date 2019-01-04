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
		
	   
	}
}
