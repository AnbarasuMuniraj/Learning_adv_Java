package Demo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Preparedstatement {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/learning_adv_java";
            String user = "postgres";
            String password = "root";

            Connection connection =
                    DriverManager.getConnection(url, user, password);
            String query =
                    "insert into student values(?,?,?,?,?,?)";
            PreparedStatement ps =
                    connection.prepareStatement(query);
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter ID : ");
            ps.setInt(1, sc.nextInt());

            System.out.println("Enter Name : ");
            ps.setString(2, sc.next());

            System.out.println("Enter Weight : ");
            ps.setDouble(3, sc.nextDouble());

            System.out.println("Enter Mstatus : ");
            ps.setBoolean(4, sc.nextBoolean());

            System.out.println("Enter DOB (yyyy-mm-dd) : ");
            String date = sc.next();
            ps.setDate(5, Date.valueOf(date));
            System.out.println("Enter Your Mobile No : ");
            ps.setLong(6, sc.nextLong());
            int i = ps.executeUpdate();
            System.out.println(i + " row inserted successfully");
            ps.close();
            connection.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}