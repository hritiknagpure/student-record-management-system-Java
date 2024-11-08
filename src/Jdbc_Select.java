import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc_Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from empp");
			while(rs.next()) {
				int eno=rs.getInt(1);
				String ename=rs.getString(2);
				Double esal=rs.getDouble(3);
				System.out.println("Emp Id"+eno);
				System.out.println("Emp Ename"+ename);
				System.out.println("Emp Esal"+esal);
				System.out.println("\n");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}

	}

}
