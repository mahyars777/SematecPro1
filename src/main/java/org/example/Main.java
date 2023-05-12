package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Account account = null;
        Customer customer = null;

        try {

            account = new Account();
            customer = new Customer();
            OutPut outPut = new OutPut();
            customer.start();
            customer.join();
            account.start();
            account.join();
           outPut.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}