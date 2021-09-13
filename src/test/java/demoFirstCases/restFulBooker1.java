package demoFirstCases;

import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.given;
public class restFulBooker1 {
    @Test
    public void getBookingIdsAndVerifyStatus(){
        String baseURL = "https://restful-booker.herokuapp.com";
        given().baseUri(baseURL)
                .when()
                .get("/booking")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("bookingid[3]",Matchers.equalTo(6));
    }

}
