import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private AndroidDriver driver;

    void waitingLocatorByID(String id){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public LoginPage(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    void tapOnLoginButton(){
        driver.findElementById("com.vkontakte.android:id/login_button").click();
    }

    void refuseSuggestion(){
        waitingLocatorByID("com.google.android.gms:id/credentials_hint_picker_title");
        driver.findElementById("com.google.android.gms:id/cancel").click();
    }

    void enterLogin(){
        driver.findElementById("com.vkontakte.android:id/email_or_phone").sendKeys(ConfProperties.getProperty("login"));
    }

    void enterPassword(){
        driver.findElementById("com.vkontakte.android:id/vk_password").sendKeys(ConfProperties.getProperty("password"));
    }

    void tapOnEnterButton(){
        driver.findElementById("com.vkontakte.android:id/continue_btn").click();
    }
}
