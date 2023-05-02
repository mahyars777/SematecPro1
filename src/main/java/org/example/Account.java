package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class Account extends Thread {
    public void Csv() throws IOException {
        String path = "D:\\Projects\\Account.csv";

        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(path));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                Record_Number = csvRecord.getRecordNumber();
                AccountNumber = csvRecord.get(0);
                AccountType = csvRecord.get(1);
                AccountCustomerId = csvRecord.get(2);
                AccountOpenDate = csvRecord.get(3);
                System.out.println(Record_Number + "\t" + AccountNumber + "\t" + AccountType + "\t" + AccountCustomerId + "\t" + AccountOpenDate);


            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void run() {
        try {
            this.Csv();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Long Record_Number;
    private String AccountNumber;
    private String AccountType;
    private String AccountCustomerId;

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

    private String AccountOpenDate;
    private Long Balance;

    public Account() throws IOException {
    }


}



