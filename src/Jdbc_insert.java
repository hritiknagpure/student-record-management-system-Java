import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Jdbc_insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			PreparedStatement psmt = con.prepareStatement("insert into empp values(?,?,?)");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
//				empid
				System.out.print("enter Emp No: ");
				int eno = Integer.parseInt(br.readLine());
//				ename
				System.out.print("enter Emp Ename: ");
				String ename = br.readLine();
//				salary
				System.out.print("enter Emp sal: ");
				double esal = Double.parseDouble(br.readLine());
				psmt.setInt(1, eno);
				psmt.setString(2, ename);
				psmt.setDouble(3, esal);
				int count = psmt.executeUpdate();
				if (count > 0) 
					System.out.println(count + " record inserted");
				else 
					System.out.println("no record inserted");
					System.out.println("do you want to moree records.[yes/no]");
					String ch=br.readLine();
					if(ch.equalsIgnoreCase("no"))
					break;
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}

	}

}
