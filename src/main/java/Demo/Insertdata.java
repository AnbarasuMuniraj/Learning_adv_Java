package Demo;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Insertdata {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
            String username="postgres";
            String password="root";
            Connection connection=DriverManager.getConnection(url,username,password);
            String sql="insert into student values(108,'Arivu',55.6,false,'15/09/2003',45)";
            Statement statement=connection.createStatement();
            statement.execute(sql);
        }
        catch(ClassNotFoundException e) {
            System.out.println("class is not found");
            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
