import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    void tapOnLoginButton(AndroidDriver driver){
        driver.findElementById("com.vkontakte.android:id/login_button").click();
    }

    void refuseSuggestion(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.gms:id/credentials_hint_picker_title")));
        driver.findElementById("com.google.android.gms:id/cancel").click();
    }

    void enterLogin(AndroidDriver driver){
        driver.findElementById("com.vkontakte.android:id/email_or_phone").sendKeys(ConfProperties.getProperty("login"));
    }

    void enterPassword(AndroidDriver driver){
        driver.findElementById("com.vkontakte.android:id/vk_password").sendKeys(ConfProperties.getProperty("password"));
    }

    void tapOnEnterButton(AndroidDriver driver){
        driver.findElementById("com.vkontakte.android:id/continue_btn").click();
    }
}
