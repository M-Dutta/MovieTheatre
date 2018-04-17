import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Utilities {


/**
 * Server Information
 * Note that localhost:8000/ value will vary depending on your MySQL local server 
 */
public final  static String user = "root";
public final static String pswd = "root"; 
public final  static String DBname = "movie_theater?useSSL=false"; 
public final  static String Driver ="com.mysql.jdbc.Driver";
public final static  String connectionURL ="jdbc:mysql://localhost:8000/";
public  static Statement stmt = null;
public  static Connection con = null;

public Utilities() {
	/**
try {
	DriverManager.registerDriver(Driver);
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
*/
try
{
	Class.forName(Driver);
} catch (ClassNotFoundException e) {
	System.out.println(e);
}
try 
{
	con = DriverManager.getConnection(connectionURL+
			DBname,user,pswd);
	stmt=con.createStatement();
	System.out.println("connected to:" + con); 
	System.out.println("COnnected");
} 
catch (SQLException e) {
	System.out.println(e);
}
}

public static  Date DateConverter (String date) throws ParseException {
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date utilDate = formatter.parse(date);
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
return sqlDate;
}
public static String hasher (String st) {
	String f = "";
	for (int i = 0; i <st.length(); i++) {
		f += (st.charAt(i)*7)*17;
	}
	return f;

}

public void RegistrationEmail(Statement s, String email)	{
	 // Recipient's email ID needs to be mentioned.
	   String to = email;

	   // Sender's email ID needs to be mentioned
	   String from = "theater_3@outlook.com";

	   // Assuming you are sending email from localhost
	   String host = "localhost";

	   // Get system properties
	   Properties properties = System.getProperties();

	   properties.setProperty("mail.user", "theater_3@outlook.com");
	   properties.setProperty("mail.password", "securePassword");
	   
	   // Setup mail server
	   properties.setProperty("mail.smtp.host", host);

	   // Get the default Session object.
	   Session session = Session.getDefaultInstance(properties);

	   try {
	      // Create a default MimeMessage object.
	      MimeMessage message = new MimeMessage(session);

	      // Set From: header field of the header.
	      message.setFrom(new InternetAddress(from));

	      // Set To: header field of the header.
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	      // Set Subject: header field
	      message.setSubject("Register Confirmation");

	      // Now set the actual message
	      message.setText("Click this link to confirm registration (add link here)");

	      // Send message
	      Transport.send(message);
	      System.out.println("Sent message successfully....");
	   } catch (MessagingException mex) {
	      mex.printStackTrace();
	   }
	}

public void ResetPasswordEmail(Statement s, String email) {
	 // Recipient's email ID needs to be mentioned.
	   String to = "theater_3@outlook.com";

	   // Sender's email ID needs to be mentioned
	   String from = "theater_3@outlook.com";

	   // Assuming you are sending email from localhost
	   String host = "localhost";

	   // Get system properties
	   Properties properties = System.getProperties();

	   properties.setProperty("mail.user", "theater_3@outlook.com");
	   properties.setProperty("mail.password", "securePassword");
	   
	   // Setup mail server
	   properties.setProperty("mail.smtp.host", host);

	   // Get the default Session object.
	   Session session = Session.getDefaultInstance(properties);

	   try {
	      // Create a default MimeMessage object.
	      MimeMessage message = new MimeMessage(session);

	      // Set From: header field of the header.
	      message.setFrom(new InternetAddress(from));

	      // Set To: header field of the header.
	      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	      // Set Subject: header field
	      message.setSubject("Password Reset");

	      // Now set the actual message
	      message.setText("Click this link to confirm Reset Password (add link here)");

	      // Send message
	      Transport.send(message);
	      System.out.println("Sent message successfully....");
	   } catch (MessagingException mex) {
	      mex.printStackTrace();
	   }
	}
	



/**
 * Loader txt file information 
 * Paste the location for flight_data.text  <- the file that landon updated  
 
public static String fileLoc ="'C:/Users/Mishuk/Documents/SQL Printout/Flights.txt'";	
public static String Loader = "LOAD DATA LOCAL INFILE "+fileLoc
+" into table Flights columns terminated by ' '";
*/
}