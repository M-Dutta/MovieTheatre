
public class Admin Extends {
	public int adminId;
	public String designation;
	public String adminEmail;
	public String adminPassword;
	
	public Admin(int adminId, String designation, String adminEmail, String adminPassword) {
		this.adminId = adminId;
		this.designation =designation;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}
	
	public getAdmin(Statement s, id) {
	try {
		ResultSet r = s.executeQuery("SELECT * from admin WHERE admin_id="+l+adminId+l)
		this.adminId = r.getInt(1);
		this.designation = r.getString(2);
		this.adminEmail = r.getString(3);
		this.adminPassword = r.adminPassword(3);
	}
		
	catch (SQLException e) {
		System.out.println("savePayment "+ e);
		}
	
	public void login(int id, String password) {
		
	}
	
	public void logout(){
		
	}

	public void changePassword(Statement s, String passwd) {
		try {
		s.executeUpdate("Update Admin SET admin_password ="+l+passwd+l+" WHERE admin_id=" AdminId)								
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
		
	}

	public void changeUserInfo(User registeredUser) {
		
	}

	//idk what the parameters are supposed to be
	public void forceResetPassword(entity) {
		
	} 
	
	public void changeEmployeeInfo(Employee employee) {
		
	}
	
	public void addUser(User registeredUser) {
		
	}
	
	public void addEmployee(Employee employee){
		
	}
	
	public void addManager(Manager user){
		
	}
	
	public void addMovie(Movie movie){
	
	}
	
	public void changeMovieInfo(Movie movie) {
		
	}
	
	public void removeMovie(Movie movie) {
		
	}
	
	public void removieUser(User registeredUser) {
		
	}
	
	public void RemoveEmployee(Employee employee){
		
	}
	
	public void removeManager(Manager manager) {
		
	}
	
	public PromoCode addPromoCode(PromoCode code) {
		
	}
	
	public void removePromoCode(Promocode code) {
		
	}
	
}
