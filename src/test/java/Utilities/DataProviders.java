package Utilities;


import java.io.IOException;

public class DataProviders {

    @org.testng.annotations.DataProvider(name = "exceldata")
    public String[][] UserDetails() throws IOException {
        String FileName = System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx";
        int totalrowss = readExcel.totalrow (FileName,"Sheet1");
        int totalcolss = readExcel.totalcols(FileName,"Sheet1") ;

        String[][] userData = new String [totalrowss-1][totalcolss];

        for (int rowNumber = 1; rowNumber < totalrowss; rowNumber++ )
        {
            for(int colNumber = 0; colNumber < totalcolss; colNumber++)
            {
                userData[rowNumber-1][colNumber] = readExcel.getCellValue(FileName, "Sheet1",rowNumber,colNumber );

            }
        }
        return userData;

    }



}
