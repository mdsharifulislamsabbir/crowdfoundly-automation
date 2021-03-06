package testcases;

import modules.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Config;
import utils.DriverManager;
import utils.Menus;
import utils.Urls;

import java.util.concurrent.TimeUnit;

public class Do_DeleteCampaign {
    WebDriver driver = null;

    public void invokeBrowser() {
        driver = DriverManager.driver;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCase() {
        Config.setEnv("dev"); //for DEV: dev & LIVE: live
        invokeBrowser();
        driver.get(Urls.getURLS("root"));
        Config.allow_cookies();
        Login.loginToAccount("organizer");
//        CreateSubscription.createSubs(driver, "plus");
//        Menus.profileMenu.clickSubscription();
//        Menus.profileMenu.clickAllPlans();
//        CreateOrganization.create(driver);
//        CreateCampaign.create(driver, "donation", "nodate", "");
        DeleteCampaign.deleteAllCampaign(driver);
//        DeleteCampaign.deleteCampaign(driver, 2);
    }
}
