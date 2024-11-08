import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbc_Delete {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Update the connection URL for MySQL
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "root", "@Hritik");
            
            Statement smt = con.createStatement();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            while (true) {
                // empid
                System.out.print("Enter deletion Emp Id: ");
                int eno = Integer.parseInt(br.readLine());
                
                // Execute the delete query
                int count = smt.executeUpdate("DELETE FROM empp WHERE eno=" + eno);
                
                // Check the result of the deletion
                if (count == 1)
                    System.out.println(count + " rows deleted");
                else
                    System.out.println("No record deletion");
                
                System.out.println("Do you want to delete more records? [yes/no]");
                String ch = br.readLine();
                
                // Exit if the user inputs "no"
                if (ch.equalsIgnoreCase("no"))
                    break;
            }

        } catch (Exception e) {
            // Handle any exceptions
            System.out.print(e);
        }
    }
}
