package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    Properties p ;
    String path = System.getProperty("user.dir" )+"/Configurations/config.properties";


    public  ReadConfig()  {
     try{
        p = new Properties();
        FileInputStream fis = new FileInputStream(path);
        p.load(fis);
        System.out.println(p.getProperty("browser"));
        }
     catch (Exception e)
     {
         e.printStackTrace();
     }
    }

    public String baseURL(){
        String baseURl =p.getProperty("baseURl");
            return baseURl;
        }


     public String browser(){
        String browser = p.getProperty("browser");
        return  browser;
     }

}




