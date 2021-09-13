package demoFirstCases;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;

public class demoFirstPut {

    @Test
    public void demoFirstPutRequest(){
        String jsonPayload = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}";
        String baseURL = "https://reqres.in/api/users/2";

        given()
                .baseUri(baseURL)
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .when()
                .put()
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", Matchers.equalTo("morpheus"));

    }
}
