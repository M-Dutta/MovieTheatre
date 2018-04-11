
public class User {
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
	L = "',"
	
	public void register(String email,String paswd, String fname, String lname, String phone,String birthDate, 
			    int emailPref, int status, String street, String city, String state, String zip) {
	
	s.executeUpdate("Insert into users values("+l+email+L+paswd+L+fname+L+lname+L+phone+L+birthDate+L+emailPref+
			L+status+L+street+L+city+L+state+L+zip+l+")")  
	}
	
	public void login(String emailAddr, String password) {
		
	}
	
	public void logout() {
		
	}
	
	public void changeInfo(Statement s, String email, String field, String info,int n ) {
	if n = 0 {
		s.executeUpdate("Update Users "+ 
			"SET "+field+"="+l+info+l + 
			"WHERE email="  +l+email+l)  
	}
	else {
		s.executeUpdate("Update Users "+ 
			"SET "+field+"="+l+int(info)+l + 
			"WHERE email="  +l+email+l)  
	}
	}
	
	public void changePassword(Statement s, String passwd,String emailAddr,) {
		s.executeUpdate("Update Users 
			SET + "='"+passwd+"'" + 
			"WHERE emailAddr="'"+emailAddr+"'")								
	}
	
	public void changeEmail(Statement s, String emailAddr) {
		
		
		
	}
	
	//should we be saving the security codes? === NOPE. Will fix that in the DB
	public void savePayment(Statement s, String email,  int cardNum, String cardHolderName, String expDate) {
	try {
	s.executeUpdate("insert into payment_info" + 
			" values(" l+email_id+L+card_name +L+card_number +L+cardholder_name 
			+L+exp_date+L+ street+L+city+L+state+L+zip+"');" );
}
	catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	
	} 
	
	public void viewPurchase(Statement s, String email) {
		ResultSet r = s.executeQuery("Select t.ticket_id, m.movie_name, t.movie_id,t.date, t.time "+
					     "FROM ticket as t, registered_tickets as rt,movie as m "+
					     "WHERE rt.user_email=" l+email+l)
		while (r.next()) {
		System.out.print (r.getInt(1), r.getString(2),r.getDate(3), r.getTime(4) );
		}
		
	}

}
