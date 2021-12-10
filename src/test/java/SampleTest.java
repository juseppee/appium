import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.JSONException;
import org.json.JSONObject;
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
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeSuite;

public class SampleTest {

    private AndroidDriver driver;
    private static LoginPage loginPage;
    private static NewsPage newsPage;
    private static MessagePage messagePage;
    private static ProfilePage profilePage;
    private static SettingsPage settingsPage;
    private static FavoritesPage favoritesPage;
    private DesiredCapabilities capabilities;

    @Before
    public void setUp() throws MalformedURLException {

        switch (Configuration.DEVICE) {
            case meizu:
                setAndroidCapabilities(ConfProperties.getProperty("pathMeizu"));
                break;
            case browserstack:
                setAndroidCapabilities(ConfProperties.getProperty("pathBrowserStack"));
                break;
            default:
                throw new RuntimeException("Incorrect device");
        }

        loginPage = new LoginPage(driver);
        newsPage = new NewsPage(driver);
        messagePage = new MessagePage(driver);
        profilePage = new ProfilePage(driver);
        settingsPage = new SettingsPage(driver);
        favoritesPage = new FavoritesPage(driver);

        loginPage.tapOnLoginButton();
//        loginPage.refuseSuggestion();
        loginPage.enterLogin();
        loginPage.enterPassword();
        loginPage.tapOnEnterButton();
    }

    private void setAndroidCapabilities(String path) throws JSONException {
        this.capabilities = new DesiredCapabilities();
        JSONObject appiumJson = SetCapability.readJsonFromFile(this.getClass().getClassLoader().getResource(path).getPath());
        JSONObject caps = SetCapability.getCapabilities(appiumJson);
        caps.keySet().forEach(keyStr -> this.capabilities.setCapability(keyStr, caps.get(keyStr)));
        try {
            this.driver = new AndroidDriver<MobileElement>(new URL(SetCapability.getUrl(appiumJson)), this.capabilities);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void sendAndDeleteMessage(){
        newsPage.confirmEntering();
        newsPage.switchToMessage();
        newsPage.clickButton();
        messagePage.switchToFav();
        favoritesPage.pasteMessage();
        favoritesPage.sendMessage();
        favoritesPage.pickMessage();
        favoritesPage.deleteMessage();
        favoritesPage.confirmDeleting();
    }

    @Test
    public void doNoDisturb(){
        newsPage.confirmEntering();
        newsPage.clickOnMenu();
        newsPage.switchToSettings();
        settingsPage.doNotDisturb();
        settingsPage.pickForHour();
    }

    @Test
    public void sendPhoto(){
        newsPage.confirmEntering();
        newsPage.switchToMessage();
        newsPage.clickButton();
        messagePage.switchToFav();
        favoritesPage.addAttachment();
        favoritesPage.allowVk();
        favoritesPage.allowAndroid();
        favoritesPage.pickPhoto();
        favoritesPage.attachPhoto();
        favoritesPage.sendPhoto();
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}