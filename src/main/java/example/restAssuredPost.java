package example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class restAssuredPost {
    public static void main(String[] args) {

        // Base URI
        RestAssured.baseURI = "https://api.restful-api.dev";

        // Request body
        String requestBody = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Accept", "*/*")
                .header("Authorization", "Basic dXNlcjpwYXNzd29yZA==")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/objects")
                .then()
                .extract()
                .response();

        // Print response
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response: \n" + response.asPrettyString());
    }
}
