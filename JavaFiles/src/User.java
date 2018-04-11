
public class User extends Utilities {
	public String email;
	public String Password;
	public String fName;
	public String lName;
	public String phone;
	public String birthDate;
	public int emailPref;
	public int status;
	public String street;
	public String city;
	public String state;
	public int zip;
	l= "'" //Use these to make life easier while formatting
	L = "','"
	
	// Create User 
	public User( String email,String Password, String fName,
	 String lName,String phone,String birthDate ,int emailPref, int status,
	 String street, String city, String state,int zip)	{
		this.email= email;
	        this.Password = Password;
	        this.fname =  fName;
		his.lname=  lname;
	        this.phone = phone;
	        this.birthDate = birthDate;
		this.emailPref= emailPref;
	        this.status = status;
	        this.street =  street;
		this.city=  city;
	        this.state = state;
	        this.zip= =  zip;
	}
	public User() {}
	
	
		
	//Selecting user ---- Only use if user is registered
	public void getUser(Statement s, String email){
		try {
		ResultSet r = s.executeQuery("SELECT * from users WHERE email="+l+email+l);
		
	        this.email= r.getString(1);
	        this.paswd = r.getString(2);
	        this.fname =  r.getString(3);
		his.lname=  r.getString(4);
	        this.phone = r.getInt(5);
	        this.birthDate = r.getDate(6);
		this.emailPref= r.getInt(7);
	        this.status = r. getInt(8);
	        this.street =  r.getString(9);
		this.city=  r.getString(10);
	        this.state = r.getString(11);
	        this.zip= =  r.getInt(12);
		}
	
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
		}
		
		
	    }
	//Create User then call User.register(s)
	public void register(Statement s) {
		try {
		s.executeUpdate("Insert into users values("+l+email+L+paswd+L+fname+L+lname+L+phone+L+birthDate+L+emailPref+
				L+status+L+street+L+city+L+state+L+zip+l+")");
		}
		
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
		}
	}
			
	
	public void login(String emailAddr, String password) {
		
	}
	
	public void logout() {
		
	}
	//User.changeInfo(s, field,info, n)
	public void changeInfo(Statement s, String field, String info,int n ) {
	try {
	if n = 0 {
		s.executeUpdate("Update Users "+ 
			"SET "+field+"="+l+info+l + 
			"WHERE email="  +l+email+l); 
	}
	else {
		s.executeUpdate("Update Users "+ 
			"SET "+field+"="+l+int(info)+l + 
			"WHERE email="  +l+email+l) ;
	}
	}
	catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}
	//user.ChangePassword(s, passwd)
	public void changePassword(Statement s, String passwd) {
		try {
		s.executeUpdate("Update Users SET password ="+l+passwd+l+" WHERE email="+l+email+l);								
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}
	
	public void changeEmail(Statement s, String emailAddr) {
		try {
		s.executeUpdate("Update Users SET email="+l+emailAddr+l+" WHERE email="+l+email+l);
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}
	
	//should we be saving the security codes? === NOPE. Will fix that in the DB
	public void savePayment(Statement s, String card_name, String card_number,String cardholder_name, 
			String exp_date, String street,String city,String state,String zip ) {
	try {
	s.executeUpdate("insert into payment_info" + 
			" values("+ l+email_id+L+card_name +L+card_number +L+cardholder_name 
			+L+exp_date+L+ street+L+city+L+state+L+zip+"')" );
	}
	catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	
	} 
	
	public void viewPurchase(Statement s) {
		try {
		ResultSet r = s.executeQuery("Select t.ticket_id, m.movie_name, t.movie_id,t.date, t.time "+
					     "FROM ticket as t, registered_tickets as rt,movie as m "+
					     "WHERE rt.user_email=" l+email+l);
		while (r.next()) {
			System.out.print (r.getInt(1), r.getString(2),r.getDate(3), r.getTime(4) );
			}
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}

}
