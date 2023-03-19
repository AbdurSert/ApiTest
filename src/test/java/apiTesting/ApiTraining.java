package apiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class ApiTraining {


    @Test

    public void restCountries(){

        Response response = RestAssured.given().contentType(ContentType.ANY).pathParam("city", "Ankara").
                get("https://restcountries.com/v3.1/capital/{city}");

        response.body().prettyPrint();

        String body = response.body().asString();

        String expectedCountry = "Turkey";

        Assert.assertTrue(body.contains(expectedCountry));

    }

    @Test

    public void restfulBooker(){

        Response response = RestAssured.given().contentType(ContentType.ANY).pathParam("id", 175).
                get("https://restful-booker.herokuapp.com/booking/{id}");

        response.prettyPrint();

        String body = response.asString();

        String expectedName = "Smith";

        Assert.assertTrue(body.contains(expectedName));

    }

    @Test

    public void theBoredApi(){

        Response response = RestAssured.given().contentType(ContentType.ANY).queryParam("key", 9324336).
                get("http://www.boredapi.com/api/activity");

        response.prettyPrint();

        String body = response.body().asString();

        String expectedText = "Clean out your refrigerator";

        Assert.assertTrue(body.contains(expectedText));

    }

}
