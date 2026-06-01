package Batch;

import java.sql.*;

public class Batch1 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java?user=postgres&password=root";
            Connection connection= DriverManager.getConnection(url);
            String sql="insert into student values(?,?,?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,109);
            ps.setString(2,"Boopathy");
            ps.setDouble(3,49);
            ps.setBoolean(4,true);
            ps.setDate(5, Date.valueOf("2005-09-13"));
            ps.setLong(6,93663636);
            ps.addBatch();
            ps.setInt(1,110);
            ps.setString(2,"Abishek");
            ps.setDouble(3,49);
            ps.setBoolean(4,true);
            ps.setDate(5, Date.valueOf("2005-02-13"));
            ps.setLong(6,936635436);
            ps.addBatch();
            ps.setInt(1,111);
            ps.setString(2,"saamy");
            ps.setDouble(3,49);
            ps.setBoolean(4,true);
            ps.setDate(5, Date.valueOf("2004-09-13"));
            ps.setLong(6,936636536);
            ps.addBatch();
            ps.executeBatch();
            System.out.println("data saved sucessfully");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
