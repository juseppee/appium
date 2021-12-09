import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage {

    void loadingCheck(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/list")));
    }

    void swipeDown(AndroidDriver driver){
        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(649, 1450))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(new PointOption().withCoordinates(622, 726))
                .release()
                .perform();
    }
    void doNotDisturb(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.TextView")));
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.TextView").click();
    }

    void pickForHour(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")));
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]").click();
    }

    void enterLogout(AndroidDriver driver){
        driver.findElementById("com.vkontakte.android:id/logout").click();
    }

    void tappingCheck(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
    }

    void confirmingLogout(AndroidDriver driver){
        driver.findElementById("android:id/button1").click();
    }

    public boolean atPage(AndroidDriver driver)
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/vk_passport_action")));
        return !(element == null);
    }
}
