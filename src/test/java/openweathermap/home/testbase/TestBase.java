package openweathermap.home.testbase;

import io.restassured.RestAssured;
import openweathermap.home.constants.Path;
import openweathermap.home.utils.PropertyReader;
import org.junit.BeforeClass;


public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        RestAssured.basePath = Path.BASE;

     }
   }

