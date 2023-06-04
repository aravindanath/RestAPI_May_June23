
package day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddContact {
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

        HashMap<String,String> newContact = new HashMap<String,String>();
        newContact.put("firstName","Akshya");
        newContact.put("lastName","Nair");
        newContact.put("birthdate","1996-01-01");
        newContact.put("email","an@gamil.com");
        newContact.put("phone","452345234");
        newContact.put("street1","banglagoe");
        newContact.put("street2","asdsdf");
        newContact.put("city","Bangalore");
        newContact.put("stateProvince","Kar");
        newContact.put("postalCode","345232345");
        newContact.put("country","USA");

       Response reps =  given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .body(newContact).post();

        reps.prettyPrint();


    }


}
