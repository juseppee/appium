import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SampleTest {

    private AndroidDriver driver;
    private static LoginPage loginPage;
    private static NewsPage newsPage;
    private static MessagePage messagePage;
    private static ProfilePage profilePage;
    private static SettingsPage settingsPage;
    private static Inspector inspector;
    private static BrowserStackSample browserStackSample;
    private static FavoritesPage favoritesPage;

    @Before
    public void setUp() throws MalformedURLException {

        browserStackSample = new BrowserStackSample();
        inspector = new Inspector();

        driver = browserStackSample.setAndroidCapabilities();
        //driver = inspector.setAndroidCapabilities();

        loginPage = new LoginPage();
        newsPage = new NewsPage();
        messagePage = new MessagePage();
        profilePage = new ProfilePage();
        settingsPage = new SettingsPage();
        favoritesPage = new FavoritesPage();

        loginPage.tapOnLoginButton(driver);
//        loginPage.refuseSuggestion(driver);
        loginPage.enterLogin(driver);
        loginPage.enterPassword(driver);
        loginPage.tapOnEnterButton(driver);
    }



    @Test
    public void sendAndDeleteMessage(){
        newsPage.confirmEntering(driver);
        newsPage.switchToMessage(driver);
        newsPage.clickButton(driver);
        messagePage.switchToFav(driver);
        favoritesPage.pasteMessage(driver);
        favoritesPage.sendMessage(driver);
        favoritesPage.pickMessage(driver);
        favoritesPage.deleteMessage(driver);
        favoritesPage.confirmDeleting(driver);
    }

    @Test
    public void doNoDisturb(){
        newsPage.confirmEntering(driver);
        newsPage.clickOnMenu(driver);
        newsPage.switchToSettings(driver);
        settingsPage.doNotDisturb(driver);
        settingsPage.pickForHour(driver);
    }

    @Test
    public void sendPhoto(){
        newsPage.confirmEntering(driver);
        newsPage.switchToMessage(driver);
        newsPage.clickButton(driver);
        messagePage.switchToFav(driver);
        favoritesPage.addAttachment(driver);
        favoritesPage.allowVk(driver);
        favoritesPage.allowAndroid(driver);
        favoritesPage.pickPhoto(driver);
        favoritesPage.attachPhoto(driver);
        favoritesPage.sendPhoto(driver);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}