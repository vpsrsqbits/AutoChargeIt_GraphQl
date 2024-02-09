package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {
    public void getLog(Object query){
        //"284b63"
        given().log().body()
                .contentType(ContentType.JSON)
                .header("Authorization",Routes.token)
                .body(query)
                .when()
                .post(Routes.base_URL)
                .then().log().body()
                .assertThat()
                .statusCode(200);
    }


    public Response getResponse(Object query){
        return  given()
                .contentType(ContentType.JSON)
                .header("Authorization",Routes.token)
                .body(query)
                .when()
                .post(Routes.base_URL);
    }
}
