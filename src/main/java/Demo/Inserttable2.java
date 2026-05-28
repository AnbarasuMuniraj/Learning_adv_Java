package Demo;




import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Inserttable2 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
            String username="postgres";
            String password="root";
            Connection connection=DriverManager.getConnection(url,username,password);
            String sql="insert into product values(01,'shoe',499,4,'nike')";
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

