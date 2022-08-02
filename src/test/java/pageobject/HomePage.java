package pageobject;

import driver.DriverClass;
import pageelement.WebCustElement;


public class HomePage extends DriverClass {
    public static final String ID_XPATH = "xpath";
    public static final String ID_NAME = "name";
    private WebCustElement inf_googleSearch;
    private WebCustElement btn_acceptAll;
    private WebCustElement btn_googleSearch;
    private WebCustElement btn_iAmFeelingLucky;

    public HomePage() {
        inf_googleSearch = new WebCustElement("//*[@type='text']", ID_XPATH);
        btn_acceptAll = new WebCustElement("//*[text()='Accept all']", ID_XPATH);
        btn_googleSearch = new WebCustElement("//input[@aria-label='Google Search']", ID_XPATH);
        btn_iAmFeelingLucky = new WebCustElement("//input[@aria-label='I'm Feeling Lucky']", ID_XPATH);
    }

    public void launchUrl() throws Exception {
        launchApp();
    }

    public void clickAcceptAll() throws Exception {
        dynamicDelay(btn_acceptAll.getElemId(), ID_XPATH);
        click(btn_acceptAll.getElemId(), ID_XPATH);
    }

    public void enterGoogleSearchKeyWord(String text) throws Exception {
        dynamicDelay(inf_googleSearch.getElemId(), ID_XPATH);
        sendText(inf_googleSearch.getElemId(), text, ID_XPATH);
    }

    public void clickGoogleSearch() throws Exception {
        dynamicDelay(btn_googleSearch.getElemId(), ID_XPATH);
        if(!isElementFound(btn_googleSearch.getElemId(), ID_XPATH)){
            click("(//input[@aria-label='Google Search'])[2]", ID_XPATH);
        } else {
            click(btn_googleSearch.getElemId(), ID_XPATH);
        }
    }

    public void clickIamFeelLucky() throws Exception {
        dynamicDelay(btn_iAmFeelingLucky.getElemId(), ID_XPATH);
        click(btn_iAmFeelingLucky.getElemId(), ID_XPATH);
    }


}
