package com.git.qa.StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.git.qa.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Hooks extends TestBase{


    public  Hooks() throws IOException {
    	super();
    }

    @Before
    public void setUp() throws IOException
    {

    	setBrowser();
        System.out.println("Driver is ="+driver);
    }

   @After(order = 0)
    public void tearDown()
    {
        driver.quit();
    }
    @After(order =1)
    public void takeScreenshotOnFailure(Scenario scenario) {

    if (scenario.isFailed()) {
    	//driver.get("https://www.ebay.ca/");
    TakesScreenshot ts = (TakesScreenshot) driver;

    byte[] src = ts.getScreenshotAs(OutputType.BYTES);
    scenario.attach(src, "image/png", "screenshot");
    }

    }

}
