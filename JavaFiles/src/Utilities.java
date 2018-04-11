import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DemoUtilities {


/**
 * Server Information
 * Note that localhost:8000/ value will vary depending on your MySQL local server 
 */
public final static String user = "root";
public final static String pswd = "root"; 
public final static String DBname = "Website?useSSL=false"; 
public final static String Driver ="com.mysql.jdbc.Driver";
public final static String connectionURL ="jdbc:mysql://localhost:8000/";

protected static ArrayList <String>companynames= new ArrayList<String>();

/**
 * Loader txt file information 
 * Paste the location for flight_data.text  <- the file that landon updated  
 
public static String fileLoc ="'C:/Users/Mishuk/Documents/SQL Printout/Flights.txt'";	
public static String Loader = "LOAD DATA LOCAL INFILE "+fileLoc
+" into table Flights columns terminated by ' '";
*/
