
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			Statement smt = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
//				empid
				System.out.print("enter deletion Emp Id: ");
				int eno = Integer.parseInt(br.readLine());
				int count = smt.executeUpdate("delete from empp where eno=" + eno);
				if (count == 1)
					System.out.println(count + " rows deleted");
				else
					System.out.println("no record deletion");
				System.out.println("do you want to moree records.[yes/no]");
				String ch = br.readLine();
				if (ch.equalsIgnoreCase("no"))
					break;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}

	}

}
