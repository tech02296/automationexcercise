package com.automationexercise.steps;


import com.automationexercise.propertyreader.PropertyReader;
import com.automationexercise.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {
    @Before
    public void setUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));

    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final  byte[] screenshot = getScreenShot();
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
        closeBrowser();
    }
}
