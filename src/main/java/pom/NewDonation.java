package pom;

public class NewDonation {
    public static class Locator {
        public static final String login_btn1_xpth = "/html/body/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/ul/li[2]/div/a";
        public static final String login_btn2_xpth = "/html/body/div/div/div/div/div[3]/div/div/div/div[2]/div[2]/ul/li[1]/div/a";


        public static final String backit_contribute_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/div[1]/div/div[2]/div/div[4]/button";

        public static final String get_now_btn_xpth = "//*[@id=\"backModal\"]/div/div[2]/div/div/div[2]/div/div/div/div[3]/button";
        public static final String custom_amnt_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/div[2]/input";
        public static final String custom_amnt_nxt_btn_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/button";

        public static final String tip_amnt_field_id = "tip-amount";
        public static final String tip_amnt_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/form/div[1]/div/div[3]/div/h5";
        public static final String tip_amnt_continue_btn_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/form/button";


        public static final String message_id = "message";
        public static final String name_id = "name";
        public static final String email_id = "email";

        public static final String contribute_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/form/button";

        public static final String debit_crd_xpth = "//*[@id=\"paymentOptions\"]/div[2]/button";
        public static final String debit_crd_iframe_xpth = "//*[@id=\"public\"]/div/div[4]/div/div[1]/div[2]/div/div/div/iframe";
        public static final String debit_crd_num_name = "cardnumber";
        public static final String debit_crd_postal_name = "postal";

        public static final String contribute_now_btn_xpth = "//*[@id=\"public\"]/div/div[4]/div/div[1]/div[2]/div/button/span";

        public static final String dwnld_pdf_flyer_xpth = "/html/body/div/div/div/div/div[4]/div/div/div/div/div[3]/div/div[2]/a";

        public static final String oi_number_id = "Mobile NumbercampaignAdditionalData";
        public static final String oi_agree_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/form/div[5]/div/div[2]/div[2]/div/label";
        public static final String oi_agree_2_xpth = "//*[@id=\"public\"]/div/div[4]/div/div/div/div/form/div[6]/div/div[2]/div[2]/div/label";
    }

    public static class Text {
        public static final String custom_amnt_text = "1234.56";

        public static final String message_txt = "Lorem Ipsum is simply a dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. Lorem Ipsum is simply a dummy text of the printing and typesetting industry.\n";
        public static final String name_txt = "Sabbir";
        public static final String email_txt = "forusualtest+c1@gmail.com";

        public static final String debit_crd_num_txt = "42424242424242420242123";
        public static final String debit_crd_postal_txt = "54321";

        public static final String oi_number_txt = "01622152381";
    }

    public static class OfflineLocator {
        public static final String action_btn_xpth = "/html/body/div[1]/div/div/div/div[6]/div[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[7]/div/div[1]/button/div/img";
        public static final String manage_xpth = "/html/body/div[1]/div/div/div/div[6]/div[2]/div/div[2]/div[2]/div/table/tbody/tr[1]/td[7]/div/div[1]/ul/li[1]/button/i";

        public static final String offline_con_xpth = "//*[@id=\"public\"]/div/div[5]/div[1]/div/div[2]/ul[1]/li[4]/a";
        public static final String add_btn_xpth = "//*[@id=\"public\"]/div/div[5]/div[2]/div/div/div[1]/div[2]/button/i";

        // Informations
        public static final String name_id = "name";
        public static final String email_id = "email";
        public static final String address_id = "address";
        public static final String amount_id = "amount";
        public static final String do_anonymous_xpth = "//*[@id=\"offlineDonationModal\"]/div/div[2]/div/div/form/div[5]/div/label";

        public static final String add_con_btn_xpth  = "//*[@id=\"offlineDonationModal\"]/div/div[2]/div/div/form/button/span";
    }

    public static class OfflineText {
        public static final String name_txt = "Sabbir the offline contributor";
        public static final String email_txt = "forusualtest+offline@gmail.com";
        public static final String address_txt = "House: 345/B, Road: 45/C" +
                "Sector: 45, Land of people, Earth, universe.";
        public static final String amount_txt = "321.45";
    }
}
