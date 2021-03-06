package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.CampaignPage;
import pom.NewCampaign;
import utils.Config;
import utils.DriverManager;
import utils.Menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static utils.Config.quickCampTitle;

public class CreateCampaign {
    public static void create(String start_fundraising, String cmp_type, String duration, String other_info, String do_donate) {
        WebDriver driver = DriverManager.driver;
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        try {
            if(!start_fundraising.equals("yes")){
                Thread.sleep(1000);
                Menus.clickCampaigns();
                // Add new campaign
                WebElement add_new = driver.findElement(By.xpath(CampaignPage.Locators.add_new_xpth));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", add_new);
            }

            // Campaign type
            if (cmp_type.equals("reward")) {
                driver.findElement(By.xpath(NewCampaign.Locator.cam_type_reward_xpth)).click();
            } else {
                driver.findElement(By.xpath(NewCampaign.Locator.cam_type_donation_xpth)).click();
            }

            // Campaign Catagory
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_catagory_xpth)).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_cat_nxt_btn_xpth)).click();
            System.out.println(cmp_type + "a: Catagory Page Done");

            // Write title
            driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).clear();
            if (cmp_type.equals("reward") && duration.equals("nodate")) {
                if (Config.quickCreate) {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(quickCampTitle() + NewCampaign.Text.rwd_nodate_cmp_title_txt);
                } else {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(NewCampaign.Text.rwd_nodate_cmp_title_txt);
                }
            } else if (cmp_type.equals("reward") && duration.equals("date")) {
                if (Config.quickCreate) {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(quickCampTitle() + NewCampaign.Text.rwd_date_cmp_title_txt);
                } else {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(NewCampaign.Text.rwd_date_cmp_title_txt);
                }
            } else if (cmp_type.equals("donation") && duration.equals("nodate")) {
                if (Config.quickCreate) {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(quickCampTitle() + NewCampaign.Text.donate_nodate_cmp_title_txt);
                } else {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(NewCampaign.Text.donate_nodate_cmp_title_txt);
                }
            } else {
                if (Config.quickCreate) {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(quickCampTitle() + NewCampaign.Text.donate_date_cmp_title_txt);
                } else {
                    driver.findElement(By.xpath(NewCampaign.Locator.cam_title_xpth)).sendKeys(NewCampaign.Text.donate_date_cmp_title_txt);
                }
            }
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_title_nxt_btn_xpth)).click();
            System.out.println(cmp_type + " b: Campaign Title Done");


            // Target amount
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_trgt_amount_xpth)).sendKeys(NewCampaign.Text.ammout_txt);
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_trgt_amt_nxt_btn_xpth)).click();
            System.out.println(cmp_type + " c: Target Amount is set");

            // Duration
            if (duration.equals("date")) {
                driver.findElement(By.xpath(NewCampaign.Locator.cmp_deadline_xpth)).click();
                driver.findElement(By.id(NewCampaign.Locator.cmp_target_date_id)).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath(NewCampaign.Locator.next_month_xpth)).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath(NewCampaign.Locator.date_xpth)).click();
            } else {
                driver.findElement(By.xpath(NewCampaign.Locator.cmp_nodeadline_xpth)).click();
            }

            driver.findElement(By.xpath(NewCampaign.Locator.cmp_dur_nxt_btn_xpth)).click();
            System.out.println(cmp_type + " d: Campaign Duration is set");


            // Gallery
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_upload_img_xpth)).click();
            Thread.sleep(1000);

            Runtime.getRuntime().exec(System.getProperty("user.dir") + "/autoit/CreateCampaign/cmp_fileupload.exe");
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.img_crop_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_gal_nxt_btn_xpth)).click();
            System.out.println(cmp_type + " e: Campaign Gallery is set");

            // Video
            driver.findElement(By.id(NewCampaign.Locator.cmp_upload_vdo_id)).click();
            driver.findElement(By.id(NewCampaign.Locator.cmp_upload_vdo_id)).sendKeys(NewCampaign.Text.youtube_vdo_link);
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_add_vdo_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_vdo_nxt_btn)).click();
            System.out.println(cmp_type + " f: Campaign Video is set");

            // Story
            // H1
            driver.findElement(By.xpath(NewCampaign.Locator.stry_h1_xpth)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_h1_field_id)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_h1_field_id)).sendKeys(NewCampaign.Text.header_txt);

            // Add quote
            driver.findElement(By.xpath(NewCampaign.Locator.stry_add_quote_xpth)).click();

            // Quote
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.stry_quote_xpth)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_quote_field_id)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_quote_field_id)).sendKeys(NewCampaign.Text.quote_txt);

            // Add Body text
            driver.findElement(By.xpath(NewCampaign.Locator.stry_add_body_xpth)).click();

            // Body text
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.stry_bodytxt_xpth)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_bodytxt_field_id)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_bodytxt_field_id)).sendKeys(NewCampaign.Text.body_txt);

            // Add Image
            driver.findElement(By.xpath(NewCampaign.Locator.stry_add_img_xpth)).click();

            // Image
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.stry_img_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.stry_img_field_xpth)).click();
            Thread.sleep(1000);
            Runtime.getRuntime().exec(System.getProperty("user.dir") + "/autoit/CreateCampaign/Story/stry_fileupload.exe");
//            Runtime.getRuntime().exec("C:\\Users\\shari\\IdeaProjects\\CROWDFUNDLY\\autoit\\CreateCampaign\\Story\\stry_fileupload.exe");
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.stry_img_crp_xpth)).click();

            // Add Video
            driver.findElement(By.xpath(NewCampaign.Locator.stry_add_vdo_xpth)).click();

            // Video
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.stry_vdo_xpth)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_vdo_field_id)).click();
            driver.findElement(By.id(NewCampaign.Locator.stry_vdo_field_id)).sendKeys(NewCampaign.Text.vimeo_vdo_link);
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.cmp_sty_nxt_btn_xpth)).click();
            System.out.println(cmp_type + " g: Campaign Story is set");

            //Other Information

            if(other_info.equals("yes")){
                driver.findElement(By.xpath(NewCampaign.Locator.oi_add_new_field_xpth)).click();
                Thread.sleep(1000);
                driver.findElement(By.id(NewCampaign.Locator.oi_section_title_id)).click();
                driver.findElement(By.id(NewCampaign.Locator.oi_section_title_id)).clear();
                driver.findElement(By.id(NewCampaign.Locator.oi_section_title_id)).sendKeys(NewCampaign.Text.oi_section_title_text);

                driver.findElement(By.xpath(NewCampaign.Locator.oi_consent_disable_enable_toggle_xpth)).click();

                driver.findElement(By.id(NewCampaign.Locator.oi_consent_text_id)).click();
                driver.findElement(By.id(NewCampaign.Locator.oi_consent_text_id)).clear();
                driver.findElement(By.id(NewCampaign.Locator.oi_consent_text_id)).sendKeys(NewCampaign.Text.oi_consent_text);

                Select type = new Select(driver.findElement(By.id(NewCampaign.Locator.oi_type_id)));
                type.selectByVisibleText("Number");
                driver.findElement(By.id(NewCampaign.Locator.oi_label_id)).click();
                driver.findElement(By.id(NewCampaign.Locator.oi_label_id)).sendKeys(NewCampaign.Text.oi_label_n_placeholder_text);

                driver.findElement(By.id(NewCampaign.Locator.oi_placeholder_id)).click();
                driver.findElement(By.id(NewCampaign.Locator.oi_placeholder_id)).sendKeys(NewCampaign.Text.oi_label_n_placeholder_text);

                driver.findElement(By.xpath(NewCampaign.Locator.oi_required_yes_xpth)).click();
            }

            if (cmp_type.equals("reward")) {
                // Other Information
                driver.findElement(By.xpath(NewCampaign.Locator.other_info_nxt_btn_xpth)).click();

                driver.findElement(By.xpath(NewCampaign.Locator.add_new_reward_xpth)).click();
                CreateReward.create(driver, "no");
                Thread.sleep(1000);
                driver.findElement(By.xpath(NewCampaign.Locator.published_rwrd_btn_xpth)).click();
                System.out.println(cmp_type + " h: Campaign Reward is set");
            } else {
                Thread.sleep(1000);
                driver.findElement(By.xpath(NewCampaign.Locator.published_don_btn_xpth)).click();
            }

            if (Config.quickCreate) {
                driver.findElement(By.xpath(NewCampaign.Locator.go_to_dashboard_xpth)).click();
            } else {
                driver.findElement(By.xpath(NewCampaign.Locator.edit_campaign_xpth)).click();

                // Update Thank you message & Brochure
                Edit_camp();

                // Post Update
                post_Update();

                // View Campaign
                if(!start_fundraising.equals("yes")){
                    driver.findElement(By.xpath(NewCampaign.Locator.view_campaign_xpth)).click();
                    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                    driver.close();
                    driver.switchTo().window(tabs.get(1));
                }
            }


            if (!Config.quickCreate) {
                if (do_donate.equals("yes")) {
                    System.out.println(cmp_type + " i: Going to Donate");
//                    GiveDonation.donate(driver, url, cmp_type, tip, log, other_info);
                    GiveOnlineDonation.donate("", cmp_type, "yes", "yes", other_info);
                } else {
                    Config.allow_cookies();
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void Edit_camp(){
        WebDriver driver = DriverManager.driver;
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        try {
            // Update Thank you message
            driver.findElement(By.xpath(NewCampaign.Locator.thankyou_message_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.ty_msg_input_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.ty_msg_input_xpth)).clear();
            driver.findElement(By.xpath(NewCampaign.Locator.ty_msg_input_xpth)).sendKeys(NewCampaign.Text.ty_msg_text);
            driver.findElement(By.xpath(NewCampaign.Locator.ty_save_msg_xpth)).click();

            // Update Brochure
            driver.findElement(By.xpath(NewCampaign.Locator.brochure_xpth)).click();
            driver.findElement(By.id(NewCampaign.Locator.flyder_txt_id)).click();
            driver.findElement(By.id(NewCampaign.Locator.flyder_txt_id)).clear();
            driver.findElement(By.id(NewCampaign.Locator.flyder_txt_id)).sendKeys(NewCampaign.Text.brochure_msg_text);
            driver.findElement(By.xpath(NewCampaign.Locator.update_summary_btn_xpth)).click();
            Thread.sleep(1000);
//                driver.findElement(By.xpath(NewCampaign.Locator.dwnld_pdf_xpth)).click();

            // Post Update

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void post_Update(){
        WebDriver driver = DriverManager.driver;
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        try {
            // Post Update
            driver.findElement(By.xpath(NewCampaign.Locator.post_update_xpth)).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath((NewCampaign.Locator.post_update_btn_xpth))).click();

            driver.findElement(By.xpath(NewCampaign.Locator.message_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.message_xpth)).clear();
            driver.findElement(By.xpath(NewCampaign.Locator.message_xpth)).sendKeys(NewCampaign.Text.post_update_mesg_txt);

            driver.findElement(By.xpath(NewCampaign.Locator.image_xpth)).click();
            Thread.sleep(1000);
            Runtime.getRuntime().exec(System.getProperty("user.dir") + "/autoit/SetPostUpdate/post_update_fileupload.exe");
            Thread.sleep(1000);
            driver.findElement(By.xpath(NewCampaign.Locator.post_img_crop_xpth)).click();

            driver.findElement(By.xpath(NewCampaign.Locator.add_video_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.vdo_url_xpth)).click();
            driver.findElement(By.xpath(NewCampaign.Locator.vdo_url_xpth)).clear();
            driver.findElement(By.xpath(NewCampaign.Locator.vdo_url_xpth)).sendKeys(NewCampaign.Text.vdo_url);

            driver.findElement(By.xpath(NewCampaign.Locator.post_an_update_btn_xpth)).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath(NewCampaign.Locator.cross_modal_xpth)).click();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}