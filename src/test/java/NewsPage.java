import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {
    private AndroidDriver driver;

    public NewsPage(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    void waitingLocatorByXPath(String xPath){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    void confirmEntering(){
        waitingLocatorByXPath("//android.widget.FrameLayout[@content-desc=\"Messenger\"]/android.widget.ImageView");
    }

    void switchToMessage(){
         driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Messenger\"]/android.widget.ImageView").click();
    }

    void clickOnMenu(){
        driver.findElementByAccessibilityId("Open menu").click();
    }

    void switchTheme() {
        driver.findElementByAccessibilityId("Switch modes").click();
    }

    void switchToSettings(){
        driver.findElementByAccessibilityId("Settings").click();
    }


    void clickButton(){
        driver.findElementById("com.vkontakte.android:id/largeLabel").click();
    }

    public boolean atPage(AndroidDriver driver)
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/notifications_button")));
        return !(element == null);
    }
}
