package com.infrastructure;

import com.domain.model.MealExcel;
import com.domain.model.ProductsExcel;
import com.domain.ports.ExcelReader;


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlReader implements ExcelReader {


    @Override
    public List<MealExcel> read(String sourceFilePath) throws IOException {

        List<MealExcel> typeMeal = new ArrayList<>();
        Workbook workbook = null;

            workbook = WorkbookFactory.create(new File(sourceFilePath));


        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = firstSheet.rowIterator();
        int lastRowNum = firstSheet.getLastRowNum();
        System.out.println(lastRowNum);

        Integer nestedRow = 0;
        int currentRow = 0;
        while (currentRow <= lastRowNum ) {
            MealExcel meal = new MealExcel();
//            rowIterator.next();
            for (int currentCell = 0; currentCell <= 11; currentCell++) {
                if (currentCell == 0) {
                    Cell cell = firstSheet.getRow(currentRow).getCell(currentCell);

                    System.out.println(cell);
                    meal.setId(cell.getNumericCellValue());
                }
                if (currentCell == 1) {
                    Cell cell = firstSheet.getRow(currentRow).getCell(currentCell);
                    meal.setTypeMeal(cell.getStringCellValue());

                }
                if (currentCell == 2) {
                    Cell cell = firstSheet.getRow(currentRow).getCell(currentCell);
                    meal.setPrepaidTime((int) cell.getNumericCellValue());
                }
                if (currentCell == 3) {
                    Cell cell = firstSheet.getRow(currentRow).getCell(currentCell);
                    meal.setTitle(cell.getStringCellValue());
                }
                if (currentCell == 4) {
                    nestedRow = currentRow;
                    List<ProductsExcel> productsList = new ArrayList<>();
                    Cell cell1 = firstSheet.getRow(nestedRow).getCell(currentCell);

                    do {

                        ProductsExcel products = new ProductsExcel();
                        for (int j = 4; j <= 7; j++) {

                            if (j == 4) {
                                Cell cell = firstSheet.getRow(nestedRow).getCell(j);
                                products.setName(cell.getStringCellValue());
                            }

                            if (j == 5) {
                                Cell cell = firstSheet.getRow(nestedRow).getCell(j);
                                products.setAmount(cell.getNumericCellValue());
                            }
                            if (j == 6) {
                                Cell cell = firstSheet.getRow(nestedRow).getCell(j);
                                products.setUnit(cell.getStringCellValue());
                            }
                            if (j == 7) {
                                Cell cell = firstSheet.getRow(nestedRow).getCell(j);
                                products.setSpecialUnit(cell.getStringCellValue());
                            }

                        }

                        nestedRow++;

                        productsList.add(products);
                        cell1 = firstSheet.getRow(nestedRow).getCell(currentCell);
                    } while ((!cell1.getStringCellValue().equals("X")));
                    meal.setProducts(productsList);
                }
                if (currentCell == 8) {
                    Cell cell = firstSheet.getRow(currentRow).getCell(currentCell);
                    meal.setReceipt(cell.getStringCellValue());
                }
                if (currentCell == 9) {
                    Cell cell = firstSheet.getRow(currentRow).getCell(currentCell);
                    meal.setCalories(cell.getNumericCellValue());
                }
                if (currentCell == 10) {
                    Cell cell = firstSheet.getRow(currentRow).getCell(currentCell);
                    meal.setAuthor(cell.getStringCellValue());
                }
            }
            currentRow = nestedRow + 1;


            System.out.println("CURRENT ROW  ---------------------------------------------------- " + currentRow);


            System.out.println(meal);
            typeMeal.add(meal);
        }
        workbook.close();
        return typeMeal;
    }
}

