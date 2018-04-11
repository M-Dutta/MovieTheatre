import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class driver extends Utilities {
	public static void main (String [] args) throws InterruptedException {
		try
		{
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
			@SuppressWarnings("unused")
			Statement stmt = null;
			Connection con = null;
			try {
				con = DriverManager.getConnection(connectionURL+
						DBname,user,pswd);
				stmt=con.createStatement();
				System.out.println("connected to:" + con);
			} catch (SQLException e) {
				System.out.println(e);
			}
	}
}