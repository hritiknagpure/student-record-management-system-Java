import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String value;
		int eid;
		double esal;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			Statement smt= con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				System.out.print("enter Emp no: ");
				value=br.readLine();
//				than covert
				eid=Integer.parseInt(value);
				System.out.print("enter Emp new salary: ");
				value=br.readLine();
				esal=Double.parseDouble(value);
				int count = smt.executeUpdate("update empp set esal="+esal+" where eno="+eid);
				if (count > 0)
					System.out.println(count + " rows updated");
				else
					System.out.println("no record forund");
				
			}

		catch(

	Exception e)
	{
		// TODO: handle exception
		System.out.print(e);
	}

}

}
