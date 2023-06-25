
package day4;

import day1.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Iterator;

import static io.restassured.RestAssured.given;

public class AddContact_usingJSON_usingDataprovide {
    String token;

    @Test(priority = 1, dataProvider = "loginData")
    public void post_LoginUser(String userName, String password) {
        RestAssured.baseURI = Constants.baseURL;
        RestAssured.basePath = Constants.loginUser; // End point
        Response resp = given().log().all().body("{\n" +
                "    \"email\": \""+userName+"\",\n" +
                "    \"password\": \""+password+"\"\n" +
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




    @DataProvider
    public Object[][] loginData(){
        Object[][] obj = new Object[1][2];
        obj[0][0] = "ri@testmail.com";
        obj[0][1] = "myPassword";
        return obj;
    }


}
