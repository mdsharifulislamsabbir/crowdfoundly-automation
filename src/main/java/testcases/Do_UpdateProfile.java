package testcases;

import modules.Login;
import modules.SetupProfile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Config;
import utils.DriverManager;
import utils.Urls;

import java.util.concurrent.TimeUnit;

public class Do_UpdateProfile {
    WebDriver driver = null;

    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }
    @Test
    public void testCase() {
        Config.setEnv("dev"); //for DEV: dev & LIVE: live
        invokeBrowser();
        driver.get(Urls.getURLS("root"));
        Config.allow_cookies();
        Login.loginToAccount("organizer");
        SetupProfile.updateProfile("organizer");
    }
}
