package org.example.StepDef;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class configuration {
    public static void set(String key,String value) throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("config.properties");
        prop.load(fis);
        prop.setProperty(key,value);
        fis.close();
        FileOutputStream fos=new FileOutputStream("config.properties");
        prop.store(fos,"");
    }
    public static String get(String key) throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("config.properties");
        prop.load(fis);
        String value=prop.getProperty(key);
        fis.close();
        return value;
    }
}
