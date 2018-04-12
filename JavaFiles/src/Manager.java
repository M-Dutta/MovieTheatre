import java.sql.SQLException;
import java.sql.Statement;

public class Manager {

	public int managerId;
	public String designation;
	public String managerEmail;
	public String managerPassword;
	String l = "'";
	String L = "','";
	
	public void login(String id, String password) {
		
	}
	
	public void logout() {
		
	}
	
	public void changePassword(Statement s, String passwd) {
		try {
			s.executeUpdate("Update Users SET password ="+l+passwd+l+" WHERE email="+l+managerEmail+l);								
			}
			catch (SQLException e) {
			System.out.println("changePassword "+ e);
		}
		
	}
	
	public void addUser(Statement s,User registeredUser) {
		registeredUser.register(s);
	}
	
	
	public void addEmployee(Statement s, Employee employee){
		try {
			s.executeUpdate("Insert into users values("+l+employee.id+L+employee.ssn+L+employee.fName+L+employee.lName+
					L+employee.street+L+employee.city+L+employee.state+L+employee.zip+
					L+employee.stat+L+employee.designation+l+")");
			}
			
			catch (SQLException e) {
			System.out.println("addEmployee "+ e);
			}
	}
	
	public void changeUserInfo(Statement s,String userEmail,String field,String info, int n) {
		User u = new User();
		u.getUser(s,userEmail);
		u.changeInfo(s, field, info, n);
		
		
	}

	public void changeEmployeeInfo(Statement s,int id,String field,String info, int n) {
		Employee emp = new Employee();
		emp.getEmployee(s,id);
		emp.changeInfo(s, field, info, n);
	}
	
	public void changeMovieInfo(Movie movie){
		
	}
	
}
