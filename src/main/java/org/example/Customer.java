package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.stream.Stream;

public class Customer extends Thread {

    public void Csv() throws Exception{
        boolean validation = false;
        try{
            String path = "D:\\Projects\\Customer.csv";
            String jpath = "D:\\Projects\\Error2.json";
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            JSONObject jsonObject = new JSONObject();
            FileWriter fileWriter = new FileWriter(jpath);
            for(CSVRecord csvRecord : csvParser){
                RecordNumber = csvRecord.getRecordNumber();
                CustomerID = csvRecord.get(0);
                CustomerName = csvRecord.get(1);
                CustomerSurname = csvRecord.get(2);
                CustomerAddress = csvRecord.get(3);
                CustomerZipcode = csvRecord.get(4);
                CustomerNationalId = csvRecord.get(5);
                CustomerBirthDate = csvRecord.get(6);
                LocalDate localDate = LocalDate.parse(CustomerBirthDate);
                int year = localDate.getYear();
                LocalDateTime now = LocalDateTime.now();

                if (CustomerNationalId.length() < 10){
                    String message = "National Id must be at least 10 digits!";
                    jsonObject.put("RecordNumber",RecordNumber);
                    jsonObject.put("Error Description:",message);
                    jsonObject.put("Error Date:", now);
                    fileWriter.write(jsonObject.toJSONString());
                    validation = true;
                }
                if (year<1995){
                    String message = "Your birth year must be above 1995!";
                    jsonObject.put("RecordNumber",RecordNumber);
                    jsonObject.put("Error Description:",message);
                    jsonObject.put("Error Date:", now);
                    fileWriter.write(jsonObject.toJSONString());
                    validation = true;
                }
                if (validation == true) {
                    System.out.println("record number:" + RecordNumber + "has been skipped");
                    validation = false;


                    continue;

                } else {
                    //insert data to database
                    System.out.println(RecordNumber + "\t" + CustomerName + "\t");


                }




            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }



    }

    @Override
    public void run() {
        try {
            this.Csv();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private long RecordNumber;
    private String CustomerID;
    private String CustomerName;
    private String CustomerSurname;
    private String CustomerAddress;
    private String CustomerZipcode;
    private String CustomerNationalId;
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




}
