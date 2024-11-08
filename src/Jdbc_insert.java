import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_Insert {

	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDatabaseName", "root", "@hritik");
			PreparedStatement psmt = con.prepareStatement("INSERT INTO empp VALUES (?, ?, ?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while (true) {
				System.out.print("Enter Emp No: ");
				int eno = Integer.parseInt(br.readLine());
				System.out.print("Enter Emp Name: ");
				String ename = br.readLine();
				System.out.print("Enter Emp Salary: ");
				double esal = Double.parseDouble(br.readLine());
				
				psmt.setInt(1, eno);
				psmt.setString(2, ename);
				psmt.setDouble(3, esal);
				int count = psmt.executeUpdate();
				
				if (count > 0) 
					System.out.println(count + " record inserted");
				else 
					System.out.println("No record inserted");
				
				System.out.print("Do you want to insert more records? [yes/no]: ");
				String ch = br.readLine();
				
				// Exit loop if the user enters "no"
				if (ch.equalsIgnoreCase("no"))
					break;
			}
			
			// Close the connection
			con.close();
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
