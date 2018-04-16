import java.sql.Date; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User extends Utilities {
	public String email;
	public String Password;
	public String fName;
	public String lName;
	public String phone;
	public Date birthDate;
	public int emailPref;
	public int status;
	public String street;
	public String city;
	public String state;
	public int zip;
	
	String l= "'"; //Use these to make life easier while formatting
	String L = "','";
	
	// Create user 
	public User( String email,String Password, String fName,
	 String lName,String phone,Date birthDate ,int emailPref, int status,
	 String street, String city, String state,int zip)	{
		this.email= email;
	        this.Password = Password;
	        this.fName =  fName;
	        this.lName=  lName;
	        this.phone = phone;
	        this.birthDate = birthDate;
		this.emailPref= emailPref;
	        this.status = status;
	        this.street =  street;
	        this.city=  city;
	        this.state = state;
	        this.zip=   zip;
	}
	public User() {}
	
	
		
	//Selecting user ---- Only use if user is registered
	public void getUser(Statement s, String email){
		try {
			
		ResultSet r = s.executeQuery("SELECT * from user WHERE email="+l+email+l);
			r.next();
	        this.email= r.getString(1);
	        this.phone = r.getString(2);
	        this.fName =  r.getString(3);
	        this.lName=  r.getString(4);
	        this.Password = r.getString(5);
	        this.birthDate = r.getDate(6);
		this.emailPref= r.getInt(7);
	        this.status = r. getInt(8);
	        this.street =  r.getString(9);
		this.city=  r.getString(10);
	        this.state = r.getString(11);
	        this.zip=   r.getInt(12);
		}
	
		catch (SQLException e) {
		System.out.println("Getuser "+ e);
		}
		
		
	    }
	//Create user then call user.register(s)
	public void register(Statement s) {
		try {
		s.executeUpdate("Insert into user values("+l+email+L+fName+L+lName+L+phone+L+Password+L+birthDate+L+emailPref+
				L+status+L+street+L+city+L+state+L+zip+l+")");
		}
		
		catch (SQLException e) {
		System.out.println("register "+ e);
		}
	}
	
	
	public void login(Statement s, String  email, String password) {
		User u = new User();
		u.getUser( s,  email);
		if (u.Password.equals(password)) {
			System.out.println("Logged In");
		}
		else {
			System.out.println("NOPE");
		}
		
	}
	
	public void logout() {
		
	}
	//user.changeInfo(s, field,info, n)
	public void changeInfo(Statement s, String field, String info,int n ) {
	try {
	if (n == 0) {
		s.executeUpdate("Update user "+ 
			"SET "+field+"="+l+info+l + 
			"WHERE email="  +l+email+l); 
	}
	else {
		s.executeUpdate("Update user "+ 
			"SET "+field+"="+l+info+l + 
			"WHERE email="  +l+email+l) ;
	}
	}
	catch (SQLException e) {
		System.out.println("Change INfo "+ e);
	}
	}
	//user.ChangePassword(s, passwd)
	public void changePassword(Statement s, String passwd) {
		try {
		s.executeUpdate("Update user SET password ="+l+passwd+l+" WHERE email="+l+email+l);								
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}
	
	public void changeEmail(Statement s, String emailAddr) {
		try {
		s.executeUpdate("Update user SET email="+l+emailAddr+l+" WHERE email="+l+email+l);
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}
	
	//should we be saving the security codes? === NOPE. Will fix that in the DB
	public void savePayment(Statement s, CreditCardInfo c ) {
		try {
	s.executeUpdate("insert into payment_info" + 
			" values("+ l+c.email_id+L+c.cardName +L+c.cardNumber +L+c.cardHolderName+
			L+c.expDate+L+c.street+L+c.city+L+c.state+L+c.zip+"')" );
	}
	catch (SQLException e) {
		System.out.println("savePayment "+ e);
		}
	}
	//Get PAyment Method
	public CreditCardInfo getPayment(Statement s, String cardName, int cardNumber) {	
		CreditCardInfo c= new CreditCardInfo();
		c.getCreditCardInfo(s, this.email,  cardName,  cardNumber);
		return c;
	
	} 
	
	public void viewPurchase(Statement s) {
		try {
		ResultSet r = s.executeQuery("Select t.ticket_id, m.movie_name, t.movie_id,t.date, t.time "+
					     "FROM ticket as t, registered_tickets as rt,movie as m "+
					     "WHERE rt.user_email="+l+email+l);
		String h = " ";
		while (r.next()) {
			System.out.print(r.getInt(1)+h+r.getString(2)+h+r.getDate(3)+h+ r.getTime(4) );
			}
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}

}
