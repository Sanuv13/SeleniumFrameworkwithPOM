package org.example.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    //Read the data from data.properties and give anyone who want wth keys
    public static String readKey(String key){
        Properties p;
        String user_Dir=System.getProperty("user.dir");
        String file_path=user_Dir+"/src/main/java/Resources/Data.properties";
        try{
            FileInputStream fileinputstream=new FileInputStream(file_path);
            p=new Properties();
            p.load(fileinputstream);
        }catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return p.getProperty(key);
    }

}
