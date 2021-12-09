import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavoritesPage {
    void pasteMessage(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/writebar_edit")));
        driver.findElementById("com.vkontakte.android:id/writebar_edit").sendKeys("message for deleting");
    }

    void sendMessage(AndroidDriver driver){
        driver.findElementByAccessibilityId("Send").click();
    }

    void pickMessage(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Danil Yusupov. message for deleting. Red message\"]/android.widget.TextView")));
        driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Danil Yusupov. message for deleting. Red message\"]/android.widget.TextView").click();
    }

    void deleteMessage(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.ImageView")));
        driver.findElementByXPath("//android.widget.LinearLayout[@content-desc=\"Delete\"]/android.widget.ImageView").click();
    }

    void confirmDeleting(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        driver.findElementById("android:id/button1").click();
    }

    void addAttachment(AndroidDriver driver){
//        WebDriverWait waiter = new WebDriverWait(driver, 5000);
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("Add attachment")));
        driver.findElementByAccessibilityId("Add attachment").click();
    }

    void pickPhoto(AndroidDriver driver) {
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView")));
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView").click();
    }

    void tapOnPhoto(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.ImageView[@content-desc=\"Photo\"])[1]")));
        driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"Photo\"])[1]").click();
    }

    void attachPhoto(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/acv_bottom_panel_counter")));
        driver.findElementById("com.vkontakte.android:id/acv_bottom_panel_counter").click();
    }

    void sendPhoto(AndroidDriver driver){
//        WebDriverWait waiter = new WebDriverWait(driver, 5000);
//        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("Send")));
        driver.findElementByAccessibilityId("Send").click();
    }

    void allowVk(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        driver.findElementById("android:id/button1").click();
    }

    void allowAndroid(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));
        driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
    }


}
