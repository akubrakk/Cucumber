package ua.tests.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ua.tests.driver.DriverManager;

public class ScreenshotHook {

    private static final String PNG_FILE_EXTENSION = "image/png";

    @After
    public void takeScreenshot(Scenario scenario){
        scenario.attach(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES),
                PNG_FILE_EXTENSION, scenario.getName());

    }
}
