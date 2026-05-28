package Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class GetData {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
            String username="postgres";
            String password="root";
            Connection connection=DriverManager.getConnection(url, username, password);
            String sql="select * from student";
            Statement statement=connection.createStatement();
            statement.execute(sql);
            ResultSet rs=statement.getResultSet();
            while(rs.next()) {
                System.out.println(rs.getInt(1)+" " + rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getBoolean(4)+" "+rs.getDate(5)+" "+rs.getLong(6));
            }
            connection.close();
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}

