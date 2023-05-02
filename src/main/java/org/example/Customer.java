package org.example;

public class Customer {
    private int RecordNumber;
    private int CustomerID;
    private String CustomerName;
    private String CustomerSurname;
    private String CustomerAddress;
    private String CustomerZipcode;
    private int CustomerNationalId;
    private String CustomerBirthDate;

    @Override
    public String toString() {
        return "Customer{" +
                "RecordNumber=" + RecordNumber +
                ", CustomerID=" + CustomerID +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerSurname='" + CustomerSurname + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", CustomerZipcode='" + CustomerZipcode + '\'' +
                ", CustomerNationalId=" + CustomerNationalId +
                ", CustomerBirthDate='" + CustomerBirthDate + '\'' +
                '}';
    }

    public int getRecordNumber() {
        return RecordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        RecordNumber = recordNumber;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerSurname() {
        return CustomerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        CustomerSurname = customerSurname;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCustomerZipcode() {
        return CustomerZipcode;
    }

    public void setCustomerZipcode(String customerZipcode) {
        CustomerZipcode = customerZipcode;
    }

    public int getCustomerNationalId() {
        return CustomerNationalId;
    }

    public void setCustomerNationalId(int customerNationalId) {
        CustomerNationalId = customerNationalId;
    }

    public String getCustomerBirthDate() {
        return CustomerBirthDate;
    }

    public void setCustomerBirthDate(String customerBirthDate) {
        CustomerBirthDate = customerBirthDate;
    }


}
