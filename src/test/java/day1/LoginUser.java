package day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginUser {

    @Test
    public void post_LoginUser(){

        /*
            from Json file
             map
             jsonObject
             POJO
             Yaml
             Directly putting the jSON
         */

        /**
         * https://thinking-tester-contact-list.herokuapp.com -->prod
         * https://thinking-tester-contact-list.v1herokuapp.com -->Test env
         * https://thinking-tester-contact-list.v2herokuapp.com -->Staging env
         */
        RestAssured.baseURI ="https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath="/users/login"; // End point

       Response resp =  given().log().all().body("{\n" +
               "    \"email\": \"ri@testmail.com\",\n" +
               "    \"password\": \"myPassword\"\n" +
               "}").contentType(ContentType.JSON).post();

       int respCode =  resp.getStatusCode();
        Assert.assertEquals(respCode,200,"Invalid Response Code");

        resp.prettyPrint();
    }


}
