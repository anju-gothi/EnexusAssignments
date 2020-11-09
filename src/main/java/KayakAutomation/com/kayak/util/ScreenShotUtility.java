package KayakAutomation.com.kayak.util;
import KayakAutomation.com.kayak.base.BaseClass;
import com.relevantcodes.extentreports.model.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtility {
    public static String takeScreenshot(WebDriver driver,String ScreenShotname){
        //this datename will append with sceenshot file
        String dateName= new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
                TakesScreenshot screenshot = (TakesScreenshot)driver;

        File srcfile = screenshot.getScreenshotAs(OutputType.FILE);
        String destFile=System.getProperty("user.dir")+"\\src\\main\\java\\KayakAutomation\\com\\kayak\\failedTestScreenShot\\"+ScreenShotname+dateName+".png";
        try {
            FileUtils.copyFile(srcfile, new File(destFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return destFile;
    }


}
