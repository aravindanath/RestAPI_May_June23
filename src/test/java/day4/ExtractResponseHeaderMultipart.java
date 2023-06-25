
package day4;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractResponseHeaderMultipart {
    String token;

    @Test
    public void post_LoginUser() {
        RestAssured.baseURI = "https://api.getpostman.com";
        RestAssured.basePath = "/me"; // End point
//        Header header = new Header("X-API-Key","PMAK-64982556eae6bf00386ee183-4e31a992c7c9708eee37d0284d11c0bb3b");

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("X-API-Key","PMAK-64982556eae6bf00386ee183-4e31a992c7c9708eee37d0284d11c0bb3b");

        Headers resp = given().headers(params)
                .when().get()
                .then().extract().headers();

        List<String> values = resp.getValues("Content-Type");
        System.out.println(values.size());
//        System.out.println(values.get(0));
        for(String value : values){
            System.out.println(value);
        }
//


    }



}
