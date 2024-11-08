import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc_Connect {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYSQL", "root", "@hritik");
			Statement smt = con.createStatement();
			smt.executeUpdate("CREATE TABLE empp (eno INT, ename VARCHAR(12), esal DECIMAL(10, 2))");
			System.out.println("Table is created successfully");
			con.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
}
