
package day4;

import day1.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class ExampleAPIKey {
    String token;

    @Test
    public void post_LoginUser() {
        RestAssured.baseURI = "https://api.getpostman.com";
        RestAssured.basePath = "/me"; // End point


        Response resp = given().header("X-API-Key","PMAK-64982556eae6bf00386ee183-4e31a992c7c9708eee37d0284d11c0bb3b")
                .log().all().get();

        resp.prettyPrint();

    }



}
