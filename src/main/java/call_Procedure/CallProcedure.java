package call_Procedure;

import java.sql.*;

public class CallProcedure {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java?user=postgres&password=root";
            Connection connection= DriverManager.getConnection(url);
            String sql="call get_bill(?)";
            CallableStatement cs=connection.prepareCall(sql);
            cs.setInt(1,0);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println("bill is"+cs.getInt(1));
            connection.close();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
