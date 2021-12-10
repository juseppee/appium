import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage {
    private AndroidDriver driver;

    void waitingLocatorByXPath(String xPath){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    void waitingLocatorByID(String id){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public FavoritesPage(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    void pasteMessage(){
        waitingLocatorByID("com.vkontakte.android:id/writebar_edit");
        driver.findElementById("com.vkontakte.android:id/writebar_edit").sendKeys("message for deleting");
    }

    void sendMessage(){
        driver.findElementByAccessibilityId("Send").click();
    }

    void pickMessage(){
        waitingLocatorByXPath("//android.view.ViewGroup[@content-desc=\"Danil Yusupov. message for deleting. Red message\"]/android.widget.TextView");
        driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Danil Yusupov. message for deleting. Red message\"]/android.widget.TextView").click();
    }

    void deleteMessage(){
        waitingLocatorByXPath("//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.ImageView");
        driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.ImageView").click();
    }

    void confirmDeleting(){
        waitingLocatorByID("android:id/button1");
        driver.findElementById("android:id/button1").click();
    }

    void addAttachment(){
        driver.findElementByAccessibilityId("Add attachment").click();
    }

    void pickPhoto() {
        waitingLocatorByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView").click();
    }

    void tapOnPhoto(){
        waitingLocatorByXPath("(//android.widget.ImageView[@content-desc=\"Photo\"])[1]");
        driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Photo\"])[1]").click();
    }

    void attachPhoto(){
        waitingLocatorByID("com.vkontakte.android:id/acv_bottom_panel_counter");
        driver.findElementById("com.vkontakte.android:id/acv_bottom_panel_counter").click();
    }

    void sendPhoto(){
        driver.findElementByAccessibilityId("Send").click();
    }

    void allowVk(){
        waitingLocatorByID("android:id/button1");
        driver.findElementById("android:id/button1").click();
    }

    void allowAndroid(){
        waitingLocatorByID("com.android.packageinstaller:id/permission_allow_button");
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
    }
}
