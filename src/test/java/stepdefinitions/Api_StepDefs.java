package stepdefinitions;


import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Objects;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class Api_StepDefs {


//    ---------------------------------------------------------------------------------------
//    TC_01

    private Response response;
    private String newUserPayload;
    private String registerPayload;


    @Given("send a get request for list of users")
    public void send_a_get_request_for_list_of_users() {

        response = given()
                .queryParam("page", 2) // Set the query parameter 'page' to 2
                .when()
                .get("/users");
        response.prettyPrint();

    }

    @And("the response status code for lists of users should be {int}")
    public void the_response_status_code_should_be(int code) {

//        response.then().statusCode(200).contentType(ContentType.JSON);

        assertEquals(code, response.statusCode());

    }

    @Then("send a get request for single user with id {string}")
    public void send_a_get_request_for_single_user_with_id(String id) {

        response = given()
                .pathParams("first", "users", "second", "11")
                .when().get("{first}/{second}");
        response.prettyPrint();

    }

    @Then("the response status code for user should be {int}")
    public void theResponseStatusCodeForUserShouldBe(int arg1) {
        assertEquals(arg1, response.statusCode());
    }

    @Then("the response should contain user details")
    public void the_response_should_contain_user_details() {
        Assert.assertEquals(response.statusCode(),200);

        // If the status code is 200, it means we got the exact value that we were looking for
        // We asked for user with id=11 and response body is giving us all the user details
        // Niceee
    }

    @Then("set the payload for new user")
    public void set_the_payload_for_new_user() {

        // Example payload for creating a new user, adjust as per your API's requirements
        newUserPayload = "{ \"name\": \"Peter\", \"job\": \"Sales\" }";

    }

    @Then("send a post request foe new user")
    public void send_a_post_request_foe_new_user() {

        response = given()
                .contentType("application/json")
                .body(newUserPayload)
                .when()
                .post("/users");
        response.prettyPrint();

        // always remember to go back to your notes.

    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int arg0) {
        assertEquals(arg0, response.statusCode());
    }


    @Then("set the payload for registration with email only")
    public void setThePayloadForRegistrationWithEmailOnly() {
        registerPayload = "{ \"email\": \"test@example.com\" }"; // Payload without password
        System.out.println("registerPayload = " + registerPayload);
    }

    @When("send a post request to register")
    public void sendAPostRequestToRegister() {
        response = given()
                .contentType("application/json")
                .body(registerPayload)
                .when()
                .post("https://reqres.in/api/register");
        response.prettyPrint();
    }

    @Then("the response should contain an error message {string}")
    public void the_response_should_contain_an_error_message(String message) {
        response.then().body("error", equalTo(message));
        response.prettyPrint();

    }

    @Then("the response status code for email should be {int}")
    public void theResponseStatusCodeForEmailShouldBe(int code1) {
        assertEquals(code1, response.statusCode());
    }
     /*
            {
            "name": "Peter",
            "job": "Sales"
             }
             // registerPayload = "{ \"email\": \"test@example.com\" }";
         */





//    ----------------------------------------------------------------------------------------
//    TC_02


    /*
            •	Create a test that will interact with 2 endpoints.
            •	First, send a request to “GET, LIST USERS”. And extract the object of “id=11” from the “data” array of the response
            •	Then, send a request to “GET, SINGLE USER” using the id value “11”
            •	Now, check that the data extracted from the first request is the same as the data returned from the second request.

     */


//    String Id="11";
    String email;
    String first_name;
    String last_name;
    String avatar;
    public static Integer userId;
    String email2;
    String first_name2;
    String last_name2;
    String avatar2;

    @Given("user sends a get request from list users")
    public void userSendsAGetRequestFromListUsers() {

        response = given()
                .queryParam("page", 2) // Set the query parameter 'page' to 2 to get the id of all the data
                .when()
                .get("/users");
        response.prettyPrint();

    }

    @And("get the user id {string}")
    public void getTheUserId(String id) {

        /*
             {
            "id": 11,
            "email": "george.edwards@reqres.in",
            "first_name": "George",
            "last_name": "Edwards",
            "avatar": "https://reqres.in/img/faces/11-image.jpg"
        },

        This is the values for id = 11

         */
        JsonPath json = response.jsonPath();
        // As our response is in json so therefor we can use jsonPath() to have access to the data and take them out of response

        for (int i = 0; i <100 ; i++) {
            if (Objects.equals(json.getString("data[" + i + "].id"),id)){
                id= json.getString("data["+i+"].id");
                System.out.println("Id = " + id);
                email= json.getString("data["+i+"].email");
                System.out.println("email = " + email);
                first_name= json.getString("data["+i+"].first_name");
                System.out.println("first_name = " + first_name);
                last_name= json.getString("data["+i+"].last_name");
                System.out.println("last_name = " + last_name);
                avatar= json.getString("data["+i+"].avatar");
                System.out.println("avatar = " + avatar);
                break;
            }
        }
        response.prettyPrint();
    }

    @And("send get request from single user with id {string}")
    public void sendGetRequestFromSingleUserWithId(String id) {

        response = given().
                pathParams("first","users","second",id).when().get("{first}/{second}");
        response.prettyPrint();

        JsonPath json = response.jsonPath();

        email2= json.getString("data.email");
        System.out.println("email2 = " + email2);
        first_name2= json.getString("data.first_name");
        System.out.println("first_name2 = " + first_name2);
        last_name2= json.getString("data.last_name");
        System.out.println("last_name2 = " + last_name2);
        avatar2= json.getString("data.avatar");
        System.out.println("avatar2 = " + avatar2);
    }

    @Then("check if values are the same")
    public void checkIfValuesAreTheSame() {

        Assert.assertEquals(email,email2);
        Assert.assertEquals(first_name,first_name2);
        Assert.assertEquals(last_name,last_name2);
        Assert.assertEquals(avatar,avatar2);

}



}

