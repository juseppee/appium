import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    void confirmEntering(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/right_menu_main_action")));
    }

    void clickOnRightMenu(AndroidDriver driver){
        driver.findElementById("com.vkontakte.android:id/right_menu_main_action").click();
    }



    void switchTheme(AndroidDriver driver){
        driver.findElementByAccessibilityId("Switch modes").click();
    }

    void switchToSettings(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/menu_settings")));
        driver.findElementById("com.vkontakte.android:id/menu_settings").click();
    }
}
