package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {

    WebDriver driver=null;

       public Object[][] testData(String excelPath, String sheetName) {
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        int rowCount=excel.getRowCount();
        int colCount=excel.getColCount();

        Object data[][]=new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
              String cellData=  excel.getCellDataString(i,j);
              //System.out.print(cellData+"    ");
              data[i-1][j]=cellData;
            }
            System.out.println();
        }
        return data;

    }

    public Object[][] testDataInt(String excelPath, String sheetName) {
        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        int rowCount=excel.getRowCount();
        int colCount=excel.getColCount();

        Object data[][]=new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++){
            for (int j=0;j<colCount;j++){
                double cellData=  excel.getCellDataNumber(i,j);
                //System.out.print(cellData+"    ");
                data[i-1][j]=cellData;
            }
            System.out.println();
        }
        return data;

    }
}