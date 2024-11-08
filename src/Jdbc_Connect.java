import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc_Connect {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			Statement smt=con.createStatement();
			smt.executeUpdate("create table empp(eno number,ename varchar(12),esal number)");
			System.out.println("tabel is create succesfully");
			con.close();
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
		

	}

}
