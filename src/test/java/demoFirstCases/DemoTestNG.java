package demoFirstCases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class DemoTestNG {

    @Test
    public void firstTestCaseRestAssured(){
        String baseURL = "https://reqres.in/api/users?page=2";
        given()
                .when()
                .get(baseURL)
                .then()
                .assertThat()
                .statusCode(200);
    }

}
