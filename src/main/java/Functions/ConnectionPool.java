package Functions;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
    private static final String user="postgres";
    private static final String password="root";
    private static final int pool_size=5;
    private static final List<Connection> CONNECTIONS=new ArrayList<Connection>();
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i=1;i<=5;i++){
            CONNECTIONS.add(createConnection());
        }
    }
    private static Connection createConnection()  {
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Connection getConnection(){
        if(CONNECTIONS.size()>0){
            return CONNECTIONS.remove(0);
        }
        return createConnection();
    }
    public static void closeConnection(Connection connection){
        if(CONNECTIONS.size()<pool_size){
            CONNECTIONS.add(connection);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }
}
