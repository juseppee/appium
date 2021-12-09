import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {

    void confirmEntering(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
//        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"Messenger\"]/android.widget.ImageView")));
        waiter.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Messenger\"]")));
//        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"Мессенджер\"]/android.widget.ImageView")));
    }

    void switchToMessage(AndroidDriver driver){
         driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Messenger\"]/android.widget.ImageView").click();
//        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Мессенджер\"]/android.widget.ImageView").click();
    }

    void clickOnMenu(AndroidDriver driver){
        driver.findElementByAccessibilityId("Open menu").click();
//        driver.findElementByAccessibilityId("Открыть меню").click();
    }

    void switchTheme(AndroidDriver driver) {
//        WebDriverWait waiter = new WebDriverWait(driver, 5000);
//        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id("Переключить тему")));
        driver.findElementByAccessibilityId("Switch modes").click();
//        driver.findElementByAccessibilityId("Переключить тему").click();
    }

    void switchToSettings(AndroidDriver driver){
        driver.findElementByAccessibilityId("Settings").click();
//        driver.findElementByAccessibilityId("Настройки").click();
    }


    void clickButton(AndroidDriver driver){
        driver.findElementById("com.vkontakte.android:id/largeLabel").click();
    }

    public boolean atPage(AndroidDriver driver)
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/notifications_button")));
        return !(element == null);
    }
}
