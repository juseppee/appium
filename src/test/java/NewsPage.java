import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
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

    @AndroidFindBy (xpath = "//android.widget.FrameLayout[@content-desc=\"Messenger\"]/android.widget.ImageView")
    public WebElement messengerButton;

    @AndroidFindBy (accessibility = "Open menu")
    public WebElement openMenu;

    @AndroidFindBy (accessibility = "Switch modes")
    public WebElement switchModes;

    @AndroidFindBy (accessibility = "Settings")
    public WebElement settings;

    @AndroidFindBy (id = "com.vkontakte.android:id/largeLabel")
    public WebElement button;

    void confirmEntering(){
        waitingLocatorByXPath("//android.widget.FrameLayout[@content-desc=\"Messenger\"]/android.widget.ImageView");
    }

    void switchToMessage(){
        messengerButton.click();
    }

    void clickOnMenu(){
        openMenu.click();
    }

    void switchTheme() {
        switchModes.click();
    }

    void switchToSettings(){
        settings.click();
    }


    void clickButton(){
        button.click();
    }

    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/notifications_button")));
        return !(element == null);
    }
}
