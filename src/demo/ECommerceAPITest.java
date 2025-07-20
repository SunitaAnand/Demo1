package demo; 
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;

public class ECommerceAPITest {

    public static void main(String[] args) {
        // Step 1: Login and get token + userId
        HashMap<String, String> loginPayload = new HashMap<>();
        loginPayload.put("userEmail", "rahulshetty@gmail.com");
        loginPayload.put("userEmail1", "rahulshetty1@gmail.com");
        loginPayload.put("userPassword", "Iamking@000");
        loginPayload.put("userPassword1", "Iamking1@000");

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        Response loginResponse = RestAssured
            .given()
                .header("Content-Type", "application/json")
                .body(loginPayload)
            .when()
                .post("/api/ecom/auth/login")
            .then()
                .assertThat().statusCode(200)
                .extract().response();

        String token = loginResponse.path("token");
        String userId = loginResponse.path("userId");

        System.out.println("Token: " + token);
        System.out.println("UserId: " + userId);

        // Step 2: Upload product
        Response addProductResponse = RestAssured
            .given()
                .header("Authorization", token)
                .contentType("multipart/form-data")
                .multiPart("productName", "MyPhoto")
                .multiPart("productAddedBy", userId)
                .multiPart("productCategory", "fashion")
                .multiPart("productSubCategory", "shirts")
                .multiPart("productPrice", "11500")
                .multiPart("productDescription", "Adidas Originals")
                .multiPart("productFor", "women")
                .multiPart("productImage", new File("C:\\Users\\Sunita\\Desktop\\PLAYWRIGHT.png")) // 🔁 Update this to actual path
            .when()
                .post("/api/ecom/product/add-product")
            .then()
                .log().all()
                .extract().response();

        System.out.println("Add product status code: " + addProductResponse.statusCode());
    }
}