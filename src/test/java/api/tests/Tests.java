package api.tests;

import api.endpoints.Queries;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tests {
    @Test
    public void getUser(){
        Response response = Queries.getUser();
        response.then().log().all();
    }

}
