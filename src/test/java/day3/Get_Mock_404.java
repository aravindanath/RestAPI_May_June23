package day3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get_Mock_404 {

    @Test
    public void post_LoginUser() {


        RestAssured.baseURI = "https://5c35697e-c0e2-469f-bda6-9cc432902a23.mock.pstmn.io";
        RestAssured.basePath = "/get/404"; // End point


       Response resp =  given().log().all().get();
       String msg = resp.then().extract().path("message").toString();
//       System.out.println(msg);
//       System.out.println(resp.getStatusCode());
    }

}
