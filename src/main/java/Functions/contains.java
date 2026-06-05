package Functions;

import java.sql.*;
public  class contains {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://LocalHost:5432/learning_adv_java?user=postgres&password=root";
            Connection connection = DriverManager.getConnection(url);
            String sql="select contains_char(?)";
            CallableStatement cs=connection.prepareCall(sql);
            cs.setString(1,"A");
            ResultSet rs=cs.executeQuery();
            rs.next();
            System.out.println("count is:"+rs.getInt(1));
            connection.close();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
