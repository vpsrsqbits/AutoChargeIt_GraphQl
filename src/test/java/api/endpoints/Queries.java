package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class Queries {
    public static Response getUser(){

        Response response = given()
                .headers("Authorization","Bearer",Routes.user_Token)
                .contentType(ContentType.JSON)
                .accept("application/json, text/plain, */*")
                .body("query MyQuery {\n  getUser {\n    userdata {\n      address\n      displayName\n      name\n      email\n      building\n      city\n      state\n      zipcode\n      phone\n      company\n    }\n  }\n}\n")
                .when()
                .post(Routes.URL);
        return response;
    }
    public static Response listCreditCards(User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.URL);
        return response;
    }
    public static Response getDefaultCreditCard(User payload) {

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.URL);
        return response;

    }
    public static Response listChargingVehicles(User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.URL);
        return response;
    }
    public static Response listVehicles(User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.URL);
        return response;
    }
    public static Response getDefaultVehicle(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.URL);
        return response;
    }
    public static Response listAllSites(User payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.URL);
        return response;
    }
    public static Response listAvailableStalls(User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.URL);
        return response;
    }
}
