package step_defs;

import cucumber.api.Scenario;
import cucumber.api.java.After;

import utils.Driver;

public class Hooks {

    //How do you take a screenshot in Selenium? Why would I want to have this capability in my framework?
    //How do you run your tests in different browsers?
    @After
    public void tearDown(Scenario scenario){
        Driver.takeScreenshot(scenario);
    }
}
