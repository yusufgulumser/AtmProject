import java.sql.*;
public class Db {
	Connection c;
	Statement s;
	public Db() {
		
		try {
			
			c=DriverManager.getConnection("jdbc:mysql:///atmProject","root","deneme123");
			s=c.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
