package Demo;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
            String username="postgres";
            String password="root";
            Connection connection=DriverManager.getConnection(url,username,password);
            String sql="create table orders(id integer primary key, name character varying, price integer)";
            Statement statement=connection.createStatement();
            statement.execute(sql);
            System.out.println("Table has been created");
            connection.close();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
