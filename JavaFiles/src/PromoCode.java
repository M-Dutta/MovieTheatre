import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class PromoCode {
	public String promo_code;
	public double discount_percent;
	public Date exp_date;
	String l = "'";
	String L = "','";

	public PromoCode(String promo_code, double discount_percent, Date exp_date ) {
		this.promo_code = promo_code;
		this.discount_percent = discount_percent;
		this.exp_date = exp_date;
	}
	public PromoCode() {}
	
	public void addPromoCode(Statement s, PromoCode p) {
		try {
			s.executeUpdate("INSERT into promo_code values=("+l+promo_code+L+discount_percent+L+exp_date+l+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

