package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    public static Properties intialzeProperties() throws IOException {
        Properties pro=new Properties();
        File profile= new File(System.getProperty("user.dir") + "/src/test/resources/config.properties");

        try {
            FileInputStream fis = new FileInputStream(profile);
            pro.load(fis);
        }
        catch (Throwable e){
            e.printStackTrace();
        }
        return pro;
    }

    public static Properties TestDataReader() throws IOException {
        Properties prop = new Properties();
        File profile1 = new File(System.getProperty("user.dir") + "/src/test/resources/TestData.properties");

        try{
            FileInputStream fis=new FileInputStream(profile1);
            prop.load(fis);
        }
        catch (Throwable e){
            e.printStackTrace();

        }
        return prop;
    }
}
