package Testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.ejb.EJBMetaData;
import javax.xml.crypto.Data;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class Tests {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    public int Id = 1;
    public String Username = "TestUser";
    public String Firstname = "Ahmed";
    public String Lastname = "Mohamed";
    public String Email = "Test@gmail.com";
    public String Password = "P@ssw0rd1";
    public String Phone = "0227544132";

    public String UpdatedFirstname = "testUpdateFirstname";
    public String UpdatedLastname = "testUpdateLastname";
    public String UpdatedEmail = "TestUserUpdate@gmail.com";
    public String UpdatedPassword = "P@ssw0rd1234";
    public String UpdatedPhone = "0267522111";



    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void CreateUser() throws JSONException {
        // Given
        String Request = Util.Request.CreateUser(Username,Id,Firstname,Lastname, Email,Password,Phone);
        System.out.println(Request);

        // When
        Response response = given().contentType(ContentType.JSON).body(Request).post("/user");

        // Then
        assertEquals(response.getStatusCode(),200);
        System.out.println("Response Body: " + response.getBody().asString());

    }

    @Test
    public void RetrieveUser() throws JSONException {
        // Given
        CreateUser();
        // When
        Response response = given().pathParam("username", Username).get("/user/{username}");

        // Then
        assertEquals(response.getStatusCode(),200);
        assertEquals(response.jsonPath().getString("username"), Username);
        assertEquals(response.jsonPath().getString("email"), Email);
    }

    @Test
    public void DeleteUser() throws JSONException {
        // Given
        CreateUser(); // Create a user for deletion

        // When
        Response response = given().pathParam("username", Username).delete("/user/{username}");

        // Then
        assertEquals(200, response.getStatusCode());

        // Verify that the user has been deleted
        response = given().pathParam("username", Username).get("/user/{username}");

        assertEquals(response.getStatusCode(),404);
        assertTrue(response.getBody().asString().contains("User not found"));
    }

    @Test
    public void UpdateUser() throws JSONException {
        // Given
        CreateUser(); // Create the user to be updated

        // When
        String Request = Util.Request.CreateUser(Username,Id,UpdatedFirstname,UpdatedLastname, UpdatedEmail,UpdatedPassword,UpdatedPhone);

        Response updateResponse = given().contentType(ContentType.JSON).body(Request).put("/user/{username}", Username);

        // Then
        assertEquals(200, updateResponse.getStatusCode());

        // Optionally, you can print the response body
        System.out.println("Update Response Body: " + updateResponse.getBody().asString());
    }
}


