import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_Update {

	public static void main(String[] args) {
		String value;
		int eid;
		double esal;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabaseName", "root", "@hritik");
			Statement smt = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter Emp ID: ");
			value = br.readLine();
			eid = Integer.parseInt(value); 
			System.out.print("Enter Emp new salary: ");
			value = br.readLine();
			esal = Double.parseDouble(value);
			int count = smt.executeUpdate("UPDATE empp SET esal=" + esal + " WHERE eno=" + eid);
			
			// Print the result
			if (count > 0)
				System.out.println(count + " rows updated");
			else
				System.out.println("No record found");
			
			// Close the connection
			con.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
