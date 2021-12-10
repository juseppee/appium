import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @AndroidFindBy(id = "com.vkontakte.android:id/writebar_edit")
    public WebElement pasteMes;

    @AndroidFindBy(accessibility = "Send")
    public WebElement sendMes;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Danil Yusupov. message for deleting. Red message\"]/android.widget.TextView")
    public WebElement pickMes;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.ImageView")
    public WebElement delMes;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement confButton;

    @AndroidFindBy(accessibility = "Add attachment")
    public WebElement addAttach;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement pickPhoto;

    @AndroidFindBy(id = "com.vkontakte.android:id/acv_bottom_panel_counter")
    public WebElement attachPhoto;

    @AndroidFindBy(id = "android:id/button1")
    public WebElement allowVK;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public WebElement allowAndroid;

    void pasteMessage(){
        waitingLocatorByID("com.vkontakte.android:id/writebar_edit");
        pasteMes.sendKeys("message for deleting");
    }

    void sendMessage(){
        sendMes.click();
    }

    void pickMessage(){
        waitingLocatorByXPath("//android.view.ViewGroup[@content-desc=\"Danil Yusupov. message for deleting. Red message\"]/android.widget.TextView");
        pickMes.click();
    }

    void deleteMessage(){
        waitingLocatorByXPath("//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.ImageView");
        delMes.click();
    }

    void confirmDeleting(){
        waitingLocatorByID("android:id/button1");
        confButton.click();
    }

    void addAttachment(){
        addAttach.click();
    }

    void pickPhoto() {
        waitingLocatorByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
        pickPhoto.click();
    }

    void attachPhoto(){
        waitingLocatorByID("com.vkontakte.android:id/acv_bottom_panel_counter");
        attachPhoto.click();
    }

    void sendPhoto(){
        sendMes.click();
    }

    void allowVk(){
        waitingLocatorByID("android:id/button1");
        allowVK.click();
    }

    void allowAndroid(){
        waitingLocatorByID("com.android.packageinstaller:id/permission_allow_button");
        allowAndroid.click();
    }
}
