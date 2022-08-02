package stepDefinitions;


import driver.DriverClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks extends DriverClass {

    private Logger logger = LoggerFactory.getLogger(Hooks.class);


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        if (getDriver() != null) {
            quitDriver();
        }
        logger.info("Closing the test");
    }
}