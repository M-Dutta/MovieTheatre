
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
	l= "'"
	public void login(String emailAddr, String password) {
		
	}
	
	public void logout() {
		
	}
	
	public void changeInfo(Statement s, String email, String field, String info) {
	s.executeUpdate("Update Users "+ 
			"SET "+field+"="+l+info+l + 
			"WHERE email="  +l+email+l)  
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
			" values('" +email_id+"','"+card_name +"','"+card_number +"','"+cardholder_name 
			+"','"+exp_date+"','"+ street+"','"+city+"','"+state+"','"+zip+"');" );
}
	catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	
	} 
	
	public void viewPurchase() {
	}

}
