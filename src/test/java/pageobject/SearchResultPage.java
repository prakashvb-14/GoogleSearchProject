package pageobject;

import driver.DriverClass;
import pageelement.WebCustElement;


public class SearchResultPage extends DriverClass {
    public static final String ID_XPATH = "xpath";
    public static final String ID_NAME = "name";

    private WebCustElement log_google;

    public SearchResultPage() {
        log_google = new WebCustElement("//img[@alt='Google']", ID_XPATH);
    }

    public void verifyPage() throws Exception {
        verifyElement(log_google.getElemId(), ID_XPATH);
    }


    public void clickRequiredUrl(String url) throws Exception {
        if(!isElementFound("//*[text()='" + url + "']", ID_XPATH)){
            scrollDown();
        }
        click("//*[text()='" + url + "']", ID_XPATH);
    }

    public void verifyRequiredUrl(String url) throws Exception {
        verifyElement("//*[text()='" + url + "']", ID_XPATH);
    }




}
