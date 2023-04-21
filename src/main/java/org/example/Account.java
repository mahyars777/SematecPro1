package org.example;

public class Account {
private int Record_Number;
private int AccountNumber;
private int AccountType;
private int AccountCustomerId;
private String AccountOpenDate;
private int Balance;

    @Override
    public String toString() {
        return "Account{" +
                "Record_Number=" + Record_Number +
                ", AccountNumber=" + AccountNumber +
                ", AccountType=" + AccountType +
                ", AccountCustomerId=" + AccountCustomerId +
                ", AccountOpenDate='" + AccountOpenDate + '\'' +
                ", Balance=" + Balance +
                '}';
    }

    public int getRecord_Number() {
        return Record_Number;
    }

    public void setRecord_Number(int record_Number) {
        Record_Number = record_Number;
    }

    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }

    public int getAccountType() {
        return AccountType;
    }

    public void setAccountType(int accountType) {
        AccountType = accountType;
    }

    public int getAccountCustomerId() {
        return AccountCustomerId;
    }

    public void setAccountCustomerId(int accountCustomerId) {
        AccountCustomerId = accountCustomerId;
    }

    public String getAccountOpenDate() {
        return AccountOpenDate;
    }

    public void setAccountOpenDate(String accountOpenDate) {
        AccountOpenDate = accountOpenDate;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }
}
