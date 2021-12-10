import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private AndroidDriver driver;

    public ProfilePage(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    void waitingLocatorByID(String id){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    void confirmEntering(){
        waitingLocatorByID("com.vkontakte.android:id/right_menu_main_action");
    }

    void clickOnRightMenu(){
        driver.findElementById("com.vkontakte.android:id/right_menu_main_action").click();
    }

    void switchTheme(){
        driver.findElementByAccessibilityId("Switch modes").click();
    }

    void switchToSettings(){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waitingLocatorByID("com.vkontakte.android:id/menu_settings");
        driver.findElementById("com.vkontakte.android:id/menu_settings").click();
    }
}
