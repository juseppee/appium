import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BrowserStackSample {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {



    }
    public AndroidDriver setAndroidCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "bsuser_HqgejK");
        caps.setCapability("browserstack.key", "zKbP9pm7gQoUEb2wubzi");

        // Set URL of the application under test
        caps.setCapability("app", "bs://44b9ce6caf496a96c4439ab28783418d23abd4be");
        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S8");
        caps.setCapability("os_version", "7.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = null;
        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Write your test case statements here

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        return driver;

    }
}