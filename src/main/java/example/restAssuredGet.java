package example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class restAssuredGet {

    public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://dummyjson.com/products";

        // GET request
        Response response = RestAssured
                .given()
                .get()
                .then()
                .extract()
                .response();

        // Print full response body
        System.out.println("Response Body => " + response.asPrettyString());

        // Get reviews list size
        int reviewCount = response.jsonPath().getInt("products[0].reviews.size()");
        System.out.println("Total Reviews: " + reviewCount);

        // Iterate & print reviewer emails
        for (int i = 0; i < reviewCount; i++) {
            String email = response.jsonPath().getString("products[0].reviews[" + i + "].reviewerEmail");
            System.out.println("Reviewer Email [" + i + "]: " + email);
        }
    }
}