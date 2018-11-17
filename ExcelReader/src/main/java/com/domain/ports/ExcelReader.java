package com.domain.ports;

import com.domain.model.MealExcel;


import java.io.IOException;
import java.util.List;

public interface ExcelReader {
    List<MealExcel> read(String sourceFilePath) throws IOException;
}
