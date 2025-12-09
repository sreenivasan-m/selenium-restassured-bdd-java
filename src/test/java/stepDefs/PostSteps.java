package stepDefs;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostSteps {

    String requestBody;
    Response response;

    @Given("the base URI is {string}")
    public void the_base_uri_is(String uri) {
        RestAssured.baseURI = uri;
    }

    @Given("I have a valid JSON request body")
    public void i_have_a_valid_json_request_body() {
        requestBody = "{\n" +
                "   \"name\": \"Apple MacBook Pro 16\",\n" +
                "   \"data\": {\n" +
                "      \"year\": 2019,\n" +
                "      \"price\": 1849.99,\n" +
                "      \"CPU model\": \"Intel Core i9\",\n" +
                "      \"Hard disk size\": \"1 TB\"\n" +
                "   }\n" +
                "}";
    }

    @When("I send a POST request to {string}")
    public void i_send_a_post_request_to(String endpoint) {
        response = RestAssured
                .given()
                .header("Accept", "*/*")
                .header("Authorization", "Basic dXNlcjpwYXNzd29yZA==")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("I print the post response body")
    public void i_print_the_response_body() {
        System.out.println("Response Body => " + response.asPrettyString());
    }
}
