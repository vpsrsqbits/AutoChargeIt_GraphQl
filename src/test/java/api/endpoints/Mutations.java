package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class Mutations {
    public static Response addVehicle(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.addVehicle())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response deleteVehicle(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.deleteVehicle())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response addCard(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.addCard())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response deleteCard(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.deleteCard())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response setDefaultCard(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.setDefaultCard())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response setDefaultVehicle(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.setDefaultVehicle())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response updateUser(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.updateUser())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response updateVehicle(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.updateVehicle())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response updateChargePreference(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.updateChargePreference())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response updateChargeRate(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.updateChargeRate())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response scanNodeQR(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.scanNodeQR())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response updateStatus(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.updateStatus())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response resetNodeValues(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.resetNodeValues())
                .when()
                .post("/graphql");
        return response;
    }
    public static Response updateVehicleCharging(){

        Response response =  given()
                .contentType(ContentType.JSON)
//                .body(User.updateVehicleCharging())
                .when()
                .post("/graphql");
        return response;
    }
}
