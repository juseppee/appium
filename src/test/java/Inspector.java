import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Inspector {
    private AndroidDriver driver;


    public AndroidDriver setAndroidCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "MEIZU PRO");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("udid", "860BCML222FF");
        desiredCapabilities.setCapability("appPackage", "com.vkontakte.android");
        desiredCapabilities.setCapability("appActivity", "com.vkontakte.android.MainActivity");
        URL remoteUrl = null;
        try {
            remoteUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
