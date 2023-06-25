
package day4;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ExtractResponseHeader2 {
    String token;

    @Test
    public void post_LoginUser() {
        RestAssured.baseURI = "https://api.getpostman.com";
        RestAssured.basePath = "/me"; // End point
//        Header header = new Header("X-API-Key","PMAK-64982556eae6bf00386ee183-4e31a992c7c9708eee37d0284d11c0bb3b");

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("X-API-Key","PMAK-64982556eae6bf00386ee183-4e31a992c7c9708eee37d0284d11c0bb3b");

        Headers resp = given().headers(params)
                .log().all().when().get()
                .then().extract().headers();
       System.out.println("Response Header: "+resp.get("x-frame-options").getName());

    }



}
