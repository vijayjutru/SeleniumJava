package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class readExcel {

    public static FileInputStream fis;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;
    public static XSSFRow row;
    public static XSSFCell cell;



    public static int totalrow(String Filepath,String Sheetname) throws IOException {

    fis = new FileInputStream(Filepath);
    wb = new XSSFWorkbook(fis);
    sh = wb.getSheet(Sheetname);
    int ttlrows = sh.getLastRowNum()+1;

    wb.close();
    fis.close();
        return ttlrows;


    }

    public static int totalcols(String Filepath, String Sheetname) throws IOException {

        fis = new FileInputStream(Filepath);
        wb = new XSSFWorkbook(fis);
        sh = wb.getSheet(Sheetname);
       int ttlcols = sh.getRow(0).getLastCellNum();
        wb.close();
        fis.close();
        return ttlcols;
    }

    public static String getCellValue(String Filepath, String Sheetname, int rownum,int cellnum ) throws IOException {

        fis = new FileInputStream(Filepath);
        wb = new XSSFWorkbook(fis);
        sh = wb.getSheet(Sheetname);
        row = sh.getRow(rownum);
        cell = row.getCell(cellnum);

        String cellValue = "";

        switch(cell.getCellType() ) {

            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case NUMERIC:
                cellValue = String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                cellValue = String.valueOf(cell.getCellFormula());
            case BLANK:
                cellValue = "";
                Default:
                cellValue = "";
        }

        wb.close();
        fis.close();

        return cellValue;



        }


    }





