package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.LoadProperties;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverClass {

    public static WebDriver driver;
    public static Properties properties;
    public static LoadProperties loadPropFiles = new LoadProperties();
    private Logger logger = LoggerFactory.getLogger(DriverClass.class);


    public static WebDriver getDriverDuringLaunch() {
        try {
            properties = loadPropFiles.getPropertyFileValue("testData.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (System.getProperty("browser") == null) {
            if (properties.getProperty("browser.name").equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            } else if (properties.getProperty("browser.name").equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else if (properties.getProperty("browser.name").equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        } else {
            if (System.getProperty("browser").equalsIgnoreCase("Edge")) {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            } else if (System.getProperty("browser").equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            } else if (System.getProperty("browser").equalsIgnoreCase("IE")) {
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        }
    }


    protected void launchApp() throws Exception {
        driver = getDriverDuringLaunch();
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.debug(driver.getTitle());
        getDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void scrollDown() throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,1500)");
    }

    public void closeDriver() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();
    }

    public void quitDriver() {
        driver.quit();
    }

    public void dynamicDelay(String elementId, String identificationType) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            switch (identificationType.toLowerCase()) {
                case "classname":
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(elementId)));
                    break;
                case "cssselector":
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(elementId)));
                    break;
                case "linktext":
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText(elementId)));
                    break;
                case "name":
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(elementId)));
                    break;
                case "xpath":
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementId)));
                    break;
                default:
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(elementId)));
                    break;
            }
        } catch (Throwable t) {
            logger.debug(elementId + "is not found for dynamic delay. Identification Type " + identificationType + " "
                    + t.getMessage());
        }
    }

    public void click(String elementId, String identificationType) throws Exception {
        try {
            switch (identificationType.toLowerCase()) {
                case "classname":
                    driver.findElement(By.className(elementId)).click();
                    break;
                case "cssselector":
                    driver.findElement(By.cssSelector(elementId)).click();
                    break;
                case "linktext":
                    driver.findElement(By.linkText(elementId)).click();
                    break;
                case "name":
                    driver.findElement(By.name(elementId)).click();
                    break;
                case "xpath":
                    driver.findElement(By.xpath(elementId)).click();
                    break;
                default:
                    driver.findElement(By.id(elementId)).click();
                    break;
            }
        } catch (Throwable t) {
            throw new Exception(elementId + " is not clicked. Identification Type " + identificationType);
        }
    }

    public void sendText(String elementId, String textToBeEnter, String identificationType) throws Exception {
        logger.info("Send Text " + elementId + "Text To Be Enter " + textToBeEnter + " Identification Type "
                + identificationType);
        try {
            switch (identificationType.toLowerCase()) {
                case "classname":
                    driver.findElement(By.className(elementId)).sendKeys(textToBeEnter);
                    break;
                case "cssselector":
                    driver.findElement(By.cssSelector(elementId)).sendKeys(textToBeEnter);
                    break;
                case "linktext":
                    driver.findElement(By.linkText(elementId)).sendKeys(textToBeEnter);
                    break;
                case "name":
                    driver.findElement(By.name(elementId)).sendKeys(textToBeEnter);
                    break;
                case "xpath":
                    driver.findElement(By.xpath(elementId)).sendKeys(textToBeEnter);
                    break;
                default:
                    driver.findElement(By.id(elementId)).sendKeys(textToBeEnter);
                    break;
            }
        } catch (Throwable t) {
            throw new Exception("Element: " + elementId + " not clicked: " + t.getMessage());
        }
    }

    public String getElementText(String elementId, String identificationType) throws Exception {
        String text = "";
        try {
            switch (identificationType.toLowerCase()) {
                case "classname":
                    text = driver.findElement(By.className(elementId)).getText();
                    break;
                case "cssselector":
                    text = driver.findElement(By.cssSelector(elementId)).getText();
                    break;
                case "linktext":
                    text = driver.findElement(By.linkText(elementId)).getText();
                    break;
                case "name":
                    text = driver.findElement(By.name(elementId)).getText();
                    break;
                case "xpath":
                    text = driver.findElement(By.xpath(elementId)).getText();
                    break;
                default:
                    text = driver.findElement(By.id(elementId)).getText();
                    break;
            }
        } catch (Throwable t) {
            throw new Exception("Element: " + elementId + " not clicked: " + t.getMessage());
        }
        return text;
    }

    public boolean isElementFound(String elementId, String identificationType) throws Exception {
        boolean flag = false;
        try {
            switch (identificationType.toLowerCase()) {
                case "classname":
                    flag = driver.findElement(By.className(elementId)).isDisplayed();
                    break;
                case "cssselector":
                    flag = driver.findElement(By.cssSelector(elementId)).isDisplayed();
                    break;
                case "linktext":
                    flag = driver.findElement(By.linkText(elementId)).isDisplayed();
                    break;
                case "name":
                    flag = driver.findElement(By.name(elementId)).isDisplayed();
                    break;
                case "xpath":
                    flag = driver.findElement(By.xpath(elementId)).isDisplayed();
                    break;
                default:
                    flag = driver.findElement(By.id(elementId)).isDisplayed();
                    break;
            }
        } catch (Throwable t) {
            logger.info("Element: " + elementId + " not available: " + t.getMessage());
        }
        return flag;
    }

    public void verifyElement(String elementId, String identificationType) throws Exception {
        try {
            switch (identificationType.toLowerCase()) {
                case "classname":
                    driver.findElement(By.className(elementId)).isDisplayed();
                    break;
                case "cssselector":
                    driver.findElement(By.cssSelector(elementId)).isDisplayed();
                    break;
                case "linktext":
                    driver.findElement(By.linkText(elementId)).isDisplayed();
                    break;
                case "name":
                    driver.findElement(By.name(elementId)).isDisplayed();
                    break;
                case "xpath":
                    driver.findElement(By.xpath(elementId)).isDisplayed();
                    break;
                default:
                    driver.findElement(By.id(elementId)).isDisplayed();
                    break;
            }
        } catch (Throwable t) {
            throw new Exception("Element: " + elementId + " not displayed: " + t.getMessage());
        }
    }

}
