package KayakAutomation.com.kayak.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProprtyUtil {
    public Properties propObject;
    public String getValue(String key){
        //Property file initialization
        propObject= new Properties();
        FileInputStream file=null;
        try {
            file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\KayakAutomation\\com\\kayak\\config\\config.properties");
            propObject.load(file);
        }catch (IOException e){e.printStackTrace();}
        if(key.equals("url"))
        return propObject.getProperty("URL");
        if(key.equals("browser"));
        return propObject.getProperty("BROWSER");
    }
}
