Feature: Get Product Reviews

  @API
  Scenario: Fetch product reviews and print reviewer emails
    Given the API base URL is "https://dummyjson.com/products"
    When I send a GET request
    Then I print the get response body
    And I get the count of reviews
    And I print all reviewer emails

  @API
  Scenario: Create a new object using POST request
    Given the base URI is "https://api.restful-api.dev"
    And I have a valid JSON request body
    When I send a POST request to "/objects"
    Then the response status code should be 200
    And I print the post response body