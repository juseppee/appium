import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePage {

    void swipeDown (AndroidDriver driver) {
        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(539, 1610))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(new PointOption().withCoordinates(555, 628))
                .release()
                .perform();
    }

    void clickOnButton(AndroidDriver driver) {
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Мессенджер\"]/android.widget.ImageView");
    }

    void switchToProfile(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.ImageView")));
        driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.ImageView").click();
    }

    void switchToFav(AndroidDriver driver){
        WebDriverWait waiter = new WebDriverWait(driver, 5000);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")));
        driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]").click();
    }


    public boolean atPage(AndroidDriver driver)
    {
        WebElement element = new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.id("com.vkontakte.android:id/im_dialogs_list_container")));
        return !(element == null);
    }
}
