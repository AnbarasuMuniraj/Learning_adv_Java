import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Getinput {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
            String username="postgres";
            String password="root";
            Connection connection=DriverManager.getConnection(url, username, password);
            System.out.println("Enter the username");
            String un=sc.next();
            System.out.println("enter the password ");
            String pass=sc.next();
            String sql="select * from login where username='"+un+"' and password='"+pass+"'";
            Statement statement=connection.createStatement();
            statement.execute(sql);
            ResultSet rs=statement.getResultSet();
            if(rs.next()){
                System.out.println("loggedin sucessfully");
            }
            else {
                System.out.println("loggedin failed");
                System.out.println("give the coorect password and the username");
            }
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
