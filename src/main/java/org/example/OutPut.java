package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class OutPut extends Thread {

    public void json() {


        String url = "jdbc:mysql://localhost:3306/sematec";
        String username = "root";
        String password = "22674591";
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        String query;


        try {

            String jpath = "C:\\Users\\Mahyar\\Documents\\output.json";

            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select sematec.customers.CustomerID, sematec.customers.CustomerName, sematec.customers.CustomerSurname, sematec.customers.CustomerNationalID, sematec.account.AccountNumber, sematec.account.Balance from sematec.account inner join sematec.customers on sematec.account.AccountCustomerID = sematec.customers.CustomerID where sematec.account.Balance>1000; ");
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            while (resultSet.next()) {
             JSONObject record = new JSONObject();
             record.put("CustomerId",resultSet.getLong("CustomerID"));
             record.put("CustomerName",resultSet.getString("CustomerName"));
             record.put("CustomerSurname", resultSet.getString("CustomerSurname"));
             record.put("CustomerNationalID", resultSet.getString("CustomerNationalID"));
             record.put("AccountNumber", resultSet.getString("AccountNumber"));
             record.put("Balance",resultSet.getLong("Balance"));
             jsonArray.add(record);
             FileWriter fileWriter = new FileWriter(jpath);
             fileWriter.write(jsonArray.toJSONString());

            }

        } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




    @Override
    public void run() {
        this.json();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
