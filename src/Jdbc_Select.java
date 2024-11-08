import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_Select {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabaseName", "hritik", "@hritik");
	                //to execute the string querry
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery("SELECT * FROM empp");
			while(rs.next()) {
				int eno = rs.getInt(1);
				String ename = rs.getString(2);
				double esal = rs.getDouble(3);
				
				System.out.println("Emp Id: " + eno);
				System.out.println("Emp Name: " + ename);
				System.out.println("Emp Salary: " + esal);
				System.out.println();
			}
			
			// Close the connection
			con.close();
		}
		catch (Exception e) {
			System.out.print(e);
		}
	}
}
