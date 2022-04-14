import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
	
	    static String url = "jdbc:postgresql://localhost:5432/kaan";
	    static Connection conn = null;
	   
	    public static Connection connect() {
	    	try {				
	    		conn = DriverManager.getConnection(url,"postgres","123");																					    	
	    	System.out.println ("Baðlantý Gerçekleþti");
	    	return conn;
	    	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
return null;
	    }	

static ResultSet listele(String sorgu) {
	try {			
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sorgu);
		return rs;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
}