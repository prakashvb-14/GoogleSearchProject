package pageobject;

import driver.DriverClass;
import org.junit.Assert;
import pageelement.WebCustElement;


public class JPMorganPage extends DriverClass {
    public static final String ID_XPATH = "xpath";
    public static final String ID_NAME = "name";

    private WebCustElement log_jpMorgan;

    public JPMorganPage() {
        log_jpMorgan = new WebCustElement("(//img[@class='first-logo'])[1]", ID_XPATH);
    }

    public void verifyJpMorgonLogo() throws Exception {
        verifyElement(log_jpMorgan.getElemId(), ID_XPATH);
    }

    public void verifyJpMorgonLogoIsNotDisplayed() throws Exception {
        Assert.assertFalse("LOGO is displayed", isElementFound(log_jpMorgan.getElemId(), ID_XPATH));
    }


    public void clickRequiredUrl(String url) throws Exception {
        click("//*[text()='" + url + "']", ID_XPATH);
    }

    public void dismissConsentPageIfVisible() throws Exception {
        if (isElementFound("//*[text()='Close [x]']", ID_XPATH)) {
            click("//*[text()='Close [x]']", ID_XPATH);
        }
    }


}
