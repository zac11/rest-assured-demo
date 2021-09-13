package demoFirstCases;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class demoFirstPatch {

    @Test
    public void demoFirstPatchTest(){
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
                .patch()
                .then()
                .statusCode(200)
                .body("job", Matchers.equalTo("zion resident"));
    }
}
