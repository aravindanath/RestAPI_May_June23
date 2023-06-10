
package day2;

import day1.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddContact_usingJSON {
    String token;

    @Test(priority = 1)
    public void post_LoginUser() {
        RestAssured.baseURI = Constants.baseURL;
        RestAssured.basePath = Constants.loginUser; // End point
        Response resp = given().log().all().body("{\n" +
                "    \"email\": \"ri@testmail.com\",\n" +
                "    \"password\": \"myPassword\"\n" +
                "}").contentType(ContentType.JSON).post();
        int respCode = resp.getStatusCode();
        Assert.assertEquals(respCode, 200, "Invalid Response Code");
        token = resp.then().extract().path("token");
        System.out.println("Token: " + token);
    }

    @Test(priority = 2)
    public void post_AddContact() {
        RestAssured.baseURI = Constants.baseURL;
        RestAssured.basePath = Constants.contacts; // End point

        String path = System.getProperty("user.dir")+ File.separator+"addContact.json";

       Response reps =  given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .body(path).post();

        reps.prettyPrint();


    }


}
