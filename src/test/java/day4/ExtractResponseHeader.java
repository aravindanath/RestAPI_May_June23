
package day4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ExtractResponseHeader {
    String token;

    @Test
    public void post_LoginUser() {
        RestAssured.baseURI = "https://api.getpostman.com";
        RestAssured.basePath = "/me"; // End point
//        Header header = new Header("X-API-Key","PMAK-64982556eae6bf00386ee183-4e31a992c7c9708eee37d0284d11c0bb3b");

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("X-API-Key","PMAK-64982556eae6bf00386ee183-4e31a992c7c9708eee37d0284d11c0bb3b");

        Response resp = given().headers(params)
                .log().all().get();

       String date =  resp.then().extract().header("Date");
       System.out.println("Response Header: "+date);

    }



}
