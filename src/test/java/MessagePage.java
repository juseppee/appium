import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.time.Duration;

public class MessagePage {

    private AndroidDriver driver;

    public MessagePage(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    void waitingLocatorByXPath(String xPath){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Мессенджер\"]/android.widget.ImageView")
    public WebElement button;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.ImageView")
    public WebElement toProfile;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    public WebElement toFavourites;

    void swipeDown () {
        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(539, 1610))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(new PointOption().withCoordinates(555, 628))
                .release()
                .perform();
    }

    void clickOnButton() {
        button.click();
    }

    void switchToProfile(){
        waitingLocatorByXPath("//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.ImageView");
        toProfile.click();
    }

    void switchToFav(){
        waitingLocatorByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        toFavourites.click();
    }

    public boolean atPage()
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/im_dialogs_list_container")));
        return !(element == null);
    }
}
