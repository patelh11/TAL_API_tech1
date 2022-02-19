package openweathermap.home.cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import openweathermap.home.StepsInfo.WeatherAppSteps;
import org.junit.Assert;

public class WeatherStepDefs {
    @Steps
    WeatherAppSteps weatherAppSteps;

    @Given("^I am on Weather Website$")
    public void iAmOnWeatherWebsite() {
        System.out.println("I am on Weather Website");
    }

    @When("^As a user I want to get weather of city \"([^\"]*)\"$")
    public void asAUserIWantToGetWeatherOf(String city) {
        weatherAppSteps.getAllResponse(city);
    }

    @Then("^I am receiving status code (\\d+)$")
    public void iAmReceivingStatusCode(int statusCode) {
        int actualCode = weatherAppSteps.getStatusCode();
        Assert.assertEquals(actualCode, statusCode);
    }

    @And("^I get Weather of city$")
    public void iGotWeatherOfCity() {
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The current weather at City at : " + weatherAppSteps.displayCurrentWeatherByCity());
        System.out.println("------------------End of Test---------------------------");
    }

}