package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Config {
    //Allow cookies button
    public static final String allow_cookies_btn_xpth = "//*[@id=\"public\"]/div[2]/div/button";

    //Environment set
    public static boolean live = false;
    public static boolean dev = false;

    // Crowdfundly
    public static boolean auto_approval = false;
    public static boolean allow_public_fundrise = false;
    public static boolean update_auto_approval = false;
    public static boolean allow_tip = false;
    public static boolean ahow_similar_campaigns = false;
    public static boolean allow_login = false;
    public static boolean escrow = false;
    public static boolean allow_refund = false;

    public static void setEnv(String env) {
        if (env.equals("live")) {
            live = true;
        } else if (env.equals("dev")) {
            dev = true;
        } else {
            System.out.println("PLEASE CHOOSE A CORRECT ENVIRONMENT. EX: dev OR live");
            System.exit(0);
        }
    }


    public static boolean quickCreate = false;

    public static String quickCampTitle() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(date);
        String name = time.replace(":", "");
        String title = name + " ";
        return title;
    }

    public static void allow_cookies() {
        WebDriver driver = DriverManager.driver;
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        if (driver.findElements(By.xpath(allow_cookies_btn_xpth)).size() != 0) {
            driver.findElement(By.xpath(allow_cookies_btn_xpth)).click();
        }
    }
}
