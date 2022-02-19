package openweathermap.home.StepsInfo;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import openweathermap.home.constants.EndPoints;

import java.util.HashMap;

public class WeatherAppSteps {

    ValidatableResponse response;

    @Step("Getting Weather for London Uk")
    public void getAllResponse(String city) {
        String authKEY = "476de8ed6f525c633dac3252c9b95332";
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("q", city);
        qParams.put("appid", authKEY);

        response = SerenityRest.rest()
                .given()
                .queryParams(qParams).log().all()
                .when()
                .get(EndPoints.GET_WEATHER)
                .then()
                .log().all();
    }

    @Step("Getting 200 status code")
    public int getStatusCode() {
        return response.extract().statusCode();
    }

    @Step("Getting current weather condition at city")
    public String displayCurrentWeatherByCity() {
        return response.extract().path("weather[0].description");
    }
}








