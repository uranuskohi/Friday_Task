package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hook {

    @Before
    public void setUpRestAssured() {
        RestAssured.baseURI = "https://reqres.in/api"; // Replace with your base URI
        // Optionally, you can set other configurations like base path, authentication, etc.
    }
}
