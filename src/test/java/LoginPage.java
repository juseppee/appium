import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @AndroidFindBy(id = "com.vkontakte.android:id/login_button")
    public WebElement logButton;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    public WebElement refuseButton;

    @AndroidFindBy(id = "com.vkontakte.android:id/email_or_phone")
    public WebElement enterLogin;

    @AndroidFindBy(id = "com.vkontakte.android:id/vk_password")
    public WebElement enterPassword;

    @AndroidFindBy(id = "com.vkontakte.android:id/continue_btn")
    public WebElement enterButton;

    void tapOnLoginButton(){
        logButton.click();
    }

    void refuseSuggestion(){
        waitingLocatorByID("com.google.android.gms:id/credentials_hint_picker_title");
        refuseButton.click();
    }

    void enterLogin(){
        enterLogin.sendKeys(ConfProperties.getProperty("login"));
    }

    void enterPassword(){
        enterPassword.sendKeys(ConfProperties.getProperty("password"));
    }

    void tapOnEnterButton(){
        enterButton.click();
    }
}
