package com.aplication;



import com.domain.ports.ExcelReader;
import com.infrastructure.XmlReader;


import java.io.IOException;

public class App {

    public static void main(String[] args)  {
        try {
            ExcelReader excelReader = new XmlReader();
            String filePath = "ExcelReader\\src\\main\\resource\\jadlospis2.xlsx";
            excelReader.read(filePath);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
