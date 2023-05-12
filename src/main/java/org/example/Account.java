package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.util.stream.Stream;

public class Account extends Thread {
    public void Csv() throws IOException {
        String path = "C:\\Users\\Mahyar\\Documents\\account.csv";
        String jpath = "C:\\Users\\Mahyar\\Documents\\Error2.json";
        boolean validation = false;
        Reader reader = null;
        FileWriter fileWriter = new FileWriter(jpath);


        try {
            reader = Files.newBufferedReader(Paths.get(path));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            JSONObject jsonObject = new JSONObject();


            for (CSVRecord csvRecord : csvParser) {
                Record_Number = csvRecord.getRecordNumber();
                AccountNumber = csvRecord.get(0);
                AccountType = csvRecord.get(1);
                AccountCustomerId = csvRecord.get(2);
                AccountOpenDate = csvRecord.get(3);
                AccountBalance = Long.parseLong(csvRecord.get(4));
                AccountLimit = Long.parseLong(csvRecord.get(5));
                if (AccountBalance < AccountLimit) {
                    String message = "Account Balance Is Less than account limit!" + "\t" + "for record number :" + Record_Number;
                    jsonObject.put("Message", message);


                    fileWriter.write(jsonObject.toJSONString());


                    validation = true;
                }
                if (AccountNumber.length() < 10) {
                    String message = "Account Number Must be at least 22 digits" + "for record number :" + Record_Number;
                    jsonObject.put("Message", message);
                    fileWriter.write(jsonObject.toJSONString());

                    validation = true;
                }
                if (AccountNumber == null || AccountType == null || AccountCustomerId == null || AccountOpenDate == null || AccountBalance == 0 || AccountLimit == 0) {
                    String message = "All fields must have value!" + "for record number :" + Record_Number;
                    jsonObject.put("Message", message);
                    fileWriter.write(jsonObject.toJSONString());
                    validation = true;
                }
                if (validation == true) {
                    System.out.println("record number:" + Record_Number + "has been skipped");
                    validation = false;


                    continue;

                } else {
                    String url = "jdbc:mysql://localhost:3306/sematec";
                    String username = "root";
                    String password = "22674591";
                    Connection connection;
                    Statement statement;
                    ResultSet resultSet;
                    String query;


                    {
                        try {
                            connection = DriverManager.getConnection(url, username, password);
                            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `sematec`.`account` (`AccountNumber`, `AccountType`, `AccountCustomerID`, `Balance`, `AccountLimit`, `AccountOpenDate`) VALUES (?, ?, ?, ?, ?, ?)");
                            preparedStatement.setString(1, AccountNumber);
                            preparedStatement.setString(2, AccountType);
                            preparedStatement.setLong(3, Long.parseLong(AccountCustomerId));
                            preparedStatement.setLong(4, AccountBalance);
                            preparedStatement.setString(5, Long.toString(AccountLimit));
                            preparedStatement.setString(6,(AccountOpenDate));
                            preparedStatement.executeUpdate();


                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }


                    }


                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            fileWriter.close();
        }
    }

    @Override
    public void run() {
        try {
            this.Csv();
            System.out.println("Done");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Long Record_Number;
    private String AccountNumber;
    private String AccountType;
    private String AccountCustomerId;
    private long AccountBalance;
    private long AccountLimit;
    private String AccountOpenDate;
    private Long Balance;


    public long getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        AccountBalance = Long.parseLong(accountBalance);
    }

    public long getAccountLimit() {
        return AccountLimit;
    }

    public void setAccountLimit(String accountLimit) {
        AccountLimit = Long.parseLong(accountLimit);
    }


    public Long getRecord_Number() {
        return Record_Number;
    }

    public void setRecord_Number(Long record_Number) {
        Record_Number = record_Number;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public String getAccountCustomerId() {
        return AccountCustomerId;
    }

    public void setAccountCustomerId(String accountCustomerId) {
        AccountCustomerId = accountCustomerId;
    }

    public String getAccountOpenDate() {
        return AccountOpenDate;
    }

    public void setAccountOpenDate(String accountOpenDate) {
        AccountOpenDate = accountOpenDate;
    }

    public Long getBalance() {
        return Balance;
    }

    public void setBalance(Long balance) {
        Balance = balance;
    }


    public Account() throws IOException {
    }


}



