package Demo;


import java.sql.Connection;

import java.sql.*;
public class CreateTble2 {
    public static void main(String args[]) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://LocalHost:5432/learning_adv_java";
            String username="postgres";
            String password="root";
            Connection connection=DriverManager.getConnection(url, username, password);
            String sql="create table product(product_id integer primary key,product_name character varying,product_price double precision,quantity integer,brand character varying)";
            Statement statement=connection.createStatement();
            statement.execute(sql);
            System.out.println("tablae has been created");
            connection.close();
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
