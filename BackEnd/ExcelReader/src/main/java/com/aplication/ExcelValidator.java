package com.aplication;



import com.domain.ports.ExcelReader;
import com.infrastructure.XmlReader;


import java.io.IOException;

public class ExcelValidator {

    public static void main(String[] args)  {
        try {
            ExcelReader excelReader = new XmlReader();
            String filePath = "D:\\PROGRAMOWANIE\\etmeall2\\EatMeAll\\Docker\\excel\\jadlospis2.xlsx";
            excelReader.read(filePath);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
