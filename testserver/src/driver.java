
import java.text.ParseException;

public class driver  {
	public static void main (String [] args) throws InterruptedException, ParseException {
	
	     
		User jeff = new User( "Mynameisfeff@taylorSwift.com","jesusholdthewheel", "Jeff",
				 "TK","666-777", Utilities.DateConverter("1996-03-03")  ,1, 0,"Bronx", "detroit", "themoon", 66666);	
		jeff.register(Utilities.stmt);
		
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