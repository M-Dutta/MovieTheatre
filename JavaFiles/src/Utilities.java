import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Utilities {


/**
 * Server Information
 * Note that localhost:8000/ value will vary depending on your MySQL local server 
 */
public final static String user = "root";
public final static String pswd = "root"; 
public final static String DBname = "movie_theater?useSSL=false"; 
public final static String Driver ="com.mysql.jdbc.Driver";
public final static String connectionURL ="jdbc:mysql://localhost:8000/";


public static Date DateConverter (String date) throws ParseException {
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date utilDate = formatter.parse(date);
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
return sqlDate;
}
/**
 * Loader txt file information 
 * Paste the location for flight_data.text  <- the file that landon updated  
 
public static String fileLoc ="'C:/Users/Mishuk/Documents/SQL Printout/Flights.txt'";	
public static String Loader = "LOAD DATA LOCAL INFILE "+fileLoc
+" into table Flights columns terminated by ' '";
*/
}