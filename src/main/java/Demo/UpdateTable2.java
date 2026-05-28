package Demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable2 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
            String username="postgres";
            String passworrd="root";
            Connection connection=DriverManager.getConnection(url, username, passworrd);
            String sql="update product set quantity=5 where product_id=01";
            Statement statement=connection.createStatement();
            int result= statement.executeUpdate(sql);
            connection.close();
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
