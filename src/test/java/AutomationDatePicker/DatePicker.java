package AutomationDatePicker;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DatePicker {
        AndroidDriver driver;
        @Test
    public void setUP(){


        File f = new File("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\test\\java");
        File fs = new File(f,"Spin The Wheel Random Picker_v2.4.1_apkpure.com.apk");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator1");
        cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
        //cap.setCapability(MobileCapabilityType.UDID,"");
        cap.setCapability("session-override","true");

        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
            // driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap); //run from command line
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        //URL url = new URL("http://127.0.0.1:4723/wd/hub");
        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url,cap);
    }
}
