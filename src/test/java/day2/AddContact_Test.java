
package day2;

import day1.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddContact_Test {
    String token;

    @Test(priority = 1)
    public void post_LoginUser() {
        RestAssured.baseURI = Constants.baseURL;
        RestAssured.basePath = Constants.loginUser; // End point

        LoginUser_pojo lp = new LoginUser_pojo();
        lp.setEmail("ri@testmail.com");
        lp.setPassword("myPassword");
//
        Response resp = given().log().all().body(lp).contentType(ContentType.JSON).post();
        int respCode = resp.getStatusCode();
        Assert.assertEquals(respCode, 200, "Invalid Response Code");
        token = resp.then().extract().path("token");
        System.out.println("Token: " + token);
    }

    @Test(priority = 2)
    public void post_AddContact() {
        RestAssured.baseURI = Constants.baseURL;
        RestAssured.basePath = Constants.contacts; // End point

        AddContactPOJO ap = new AddContactPOJO();
        ap.setCity(Generic.city());
        ap.setBirthdate(Generic.birthdate());
        ap.setStateProvince(Generic.stateProvince());
        ap.setCountry(Generic.country());
        ap.setEmail(Generic.email());
        ap.setPhone(Generic.phone());
        ap.setFirstName(Generic.firstName());
        ap.setLastName(Generic.lastName());
        ap.setCountry(Generic.country());
        ap.setStreet1(Generic.address());
        ap.setPostalCode(Generic.pincode());
        ap.setStreet2(Generic.streetName());
        Response reps = given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(ap).post();
        try {
            System.err.println(reps.then().extract().path("message").toString());
        }catch(Exception e){
            System.err.println("id: "+reps.then().extract().path("_id").toString());
        System.err.println("owner: "+reps.then().extract().path("owner").toString());
        }

        int respCode = reps.getStatusCode();
        Assert.assertEquals(respCode, 201, "Invalid Response Code");

        reps.prettyPrint();


    }


}
