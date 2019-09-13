package com.dbs.banking.poc.bankingdemo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestController {
    public static void main(String args[]){

//        String date="2017-03-08T12:30:54";
//        LocalDateTime fromDate= LocalDateTime.parse(date);
//        System.out.println(date);
//        System.out.println(fromDate);

//        String date = "2017-03-08 12:30:54";
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime dateTime = LocalDateTime.parse(date, format);
//        System.out.println("origional date as string: " + date);
//        System.out.println("generated LocalDateTime: " + dateTime);

        //Read more: https://javarevisited.blogspot.com/2017/08/how-to-format-parse-dates-with-LocalDateTime-Java-8.html#ixzz5zP0OLDv9

        String date = "2016-08-16";
        LocalDate localDate = LocalDate.parse(date);
        System.out.println(localDate);


    }
}

