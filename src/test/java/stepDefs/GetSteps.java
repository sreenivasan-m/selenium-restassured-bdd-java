package stepDefs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.cucumber.java.en.*;

public class GetSteps {

    private Response response;

    @Given("the API base URL is {string}")
    public void the_api_base_url_is(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @When("I send a GET request")
    public void i_send_a_get_request() {
        response = RestAssured
                .given()
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

    @Then("I print the get response body")
    public void i_print_the_response_body() {
        System.out.println("Response Body => " + response.asPrettyString());
    }

    @Then("I get the count of reviews")
    public void i_get_the_count_of_reviews() {
        int reviewCount = response.jsonPath().getInt("products[0].reviews.size()");
        System.out.println("Total Reviews: " + reviewCount);
    }

    @Then("I print all reviewer emails")
    public void i_print_all_reviewer_emails() {
        int size = response.jsonPath().getInt("products[0].reviews.size()");

        for (int i = 0; i < size; i++) {
            String email = response.jsonPath()
                    .getString("products[0].reviews[" + i + "].reviewerEmail");

            System.out.println("Reviewer Email [" + i + "]: " + email);
        }
    }
}
