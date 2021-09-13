package demoFirstCases;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;

public class demoFirstPost {

    @Test
    public void returnPostMethod(){
        String jsonValue = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
        String baseURL = "https://restful-booker.herokuapp.com/auth";

        given()
                .baseUri(baseURL)
                    .contentType(ContentType.JSON)
                    .body(jsonValue)
                .when()
                    .post()
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("token", Matchers.notNullValue())
                    .body("token.length()", Matchers.is(15))
                    .body("token", Matchers.matchesRegex("^[a-z0-9]+$"));


    }



}
