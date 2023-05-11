package org.example;

import java.sql.*;

public class Model {

    public static void connection(String result) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/sematec";
        String username = "root";
        String password = "22674591";
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        String query;
        query = result;

        {
            try {
                connection = DriverManager.getConnection(url,username,password);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);

                while (resultSet.next()){
                    System.out.println(resultSet.getInt(1));
                    System.out.println(resultSet.getInt(2));
                    System.out.println(resultSet.getInt(3));
                    System.out.println(resultSet.getInt(4));
                    System.out.println(resultSet.getInt(5));
                    System.out.println(resultSet.getInt(6));
                    System.out.println(resultSet.getDate(7));
                    System.out.println(resultSet.getInt(8));


                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
