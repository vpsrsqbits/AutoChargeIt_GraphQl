package graphql;

// TODO: We can embed the requests and response data in the excel.

import endpoints.Request;
import endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

public class QueryTest {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("QUERIES");
    int rowCount = -1;
    String[] headers ={"QUERIES","Request","Response"};
    @Test(priority = 0)
    public void setHeaders(){
        rowCount++;
        XSSFRow row = sheet.createRow(rowCount);
        for (int c=0;c<=2;c++)
        {
            XSSFCell cell = row.createCell(c);
            cell.setCellValue(headers[c]);
        }
    }

    @Test(priority = 1)
    public void getUser() throws IOException {
        rowCount++;
        XSSFRow row = sheet.createRow(rowCount);
        Response response ;
        String query = "{\n" +
                "  \"query\": \"query GetUser { getUser { address, displayName, name, email, building, city, state, zipcode, phone, company, preferenceId, pk, sk, paymentCustomerid, firebaseToken }}\"\n" +
                "}";
        System.out.println("------ Get User -----------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
//        System.out.println(response.then().log().body());
//        String responseBody = response.then().log().body().toString();
//        String requestBody = String.valueOf(response);
//        System.out.println(String.valueOf(response.body().print()));

        XSSFCell queryName = row.createCell(0);
        queryName.setCellValue("getUser()");

        XSSFCell queryRequest = row.createCell(1);
        queryRequest.setCellValue(query);

        XSSFCell queryResponse = row.createCell(2);
        queryResponse.setCellValue(response.body().print());

        FileOutputStream fileOutputStream = new FileOutputStream("/home/squarebits/IdeaProjects/AutoChargeIt_GraphQl/src/test/java/graphql/test1.xlsx");
        workbook.write(fileOutputStream);
    }

    @Test(priority = 2)
    public void listCreditCards(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query ListCreditCards { listCreditCards { pk, sk, ccToken, lastFour, cardName, expiration, isDefault, paymentMethodid }}\"\n" +
                "}";
        System.out.println("------ List Credit Cards -------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        XSSFCell queryName = row.createCell(0);
        queryName.setCellValue("getUser()");

        XSSFCell queryRequest = row.createCell(1);
        queryRequest.setCellValue(query);

        XSSFCell queryResponse = row.createCell(2);
        queryResponse.setCellValue(response.body().print());

        FileOutputStream fileOutputStream = new FileOutputStream("/home/squarebits/IdeaProjects/AutoChargeIt_GraphQl/src/test/java/graphql/test1.xlsx");
        workbook.write(fileOutputStream);
        System.out.println(response.then().log().body());

    }

//    @Test(priority = 3)
    public void getDefaultCreditCard(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query GetDefaultCreditCard { getDefaultCreditCard { pk, sk, ccToken, lastFour, cardName, expiration, isDefault, paymentMethodid }}\"\n" +
                "}";
        System.out.println("------ Get Default Credit Card ------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());
    }

//    @Test(priority = 4)
    public void listChargingVehicles(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query ListChargingVehicles { listChargingVehicles { pk, sk, data, activeCharge, activeParked, status, cardnoxCustomerId, cardSK, vehicleSK, xRefNum, preferenceId, stallId, scanTime }}\"\n" +
                "}";

        System.out.println("------ List Charging Vehicles ---------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());
    }

//    @Test(priority = 5)
    public void listVehicles(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query ListVehicles { listVehicles { pk, sk, make, model, carYear, color, licensePlate, vehicleName, storedVehicleQR, isDefault, vehicleImage, state }}\"\n" +
                "}";

        System.out.println("------ List Vehicles -------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

//    @Test(priority = 6)
    public void getDefaultVehicle(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query GetDefaultVehicle { getDefaultVehicle { pk, sk, make, model, carYear, color, licensePlate, vehicleName, storedVehicleQR, isDefault, vehicleImage, state }}\"\n" +
                "}";

        System.out.println("------ Get Default Vehicle ------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

//    @Test(priority = 7)
    public void listAllSites(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query ListAllSites { listAllSites { pk, sk, address, offPeak { rate, surcharge, id, }, priority { rate, surcharge, id }, normal { rate, surcharge, id} }}\"\n" +
                "}";

        System.out.println("------ List All Sites --------------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

//    @Test(priority = 8)
    public void listDefaultPreferences(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query ListDefaultPreferences { listDefaultPreferences { defaultVehicle { pk, sk, make, model, carYear, color, licensePlate, vehicleName, storedVehicleQR, isDefault, vehicleImage, state } defaultCard { pk, sk, ccToken, lastFour, cardName, expiration, isDefault, paymentMethodid } defaultOption { priority { isDefault, id }, normal { isDefault, id }, offpeak { isDefault, id } } }}\"\n" +
                "}";

        System.out.println("------ List Default Preferences --------------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

//    @Test(priority = 9)
    public void getStallInfo(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query GetStallInfo { getStallInfo { pk, sk, data, activeCharge, activeParked, status, cardnoxCustomerId, cardSK, vehicleSK, xRefNum, preferenceId, stallId, scanTime }}\"\n" +
                "}";

        System.out.println("------ Get Stall Info --------------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

//    TODO: What SK needs to be passed?
//    @Test(priority = 10)
    public void onUserScan(){
        Response response;
        String query = "{\n" +
                "  \"query\": \"query OnUserScan { onUserScan { pk sk data activeCharge status cardnoxCustomerId cardSK vehicleSK xRefNum preferenceId stallId scanTime activeParked }}\"\n" +
                "}";

        System.out.println("------ On User Scan --------------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }


//    TODO: What PK, SK needs to be passed ?
//    @Test(priority = 11)
    public void listStallChargePreference(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  listStallChargePreferences {    priority    normal    offPeak  }}\"}";

        System.out.println("------ List Stall Charge Preference ----------------------------------");
        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

   }

//    TODO: what pk, sk needs to be provided ?
//    @Test@Test(priority = 12)
    public void getQueueLengths(){
        Response response;
        String query = "query GetQueueLengths($pk:String!,$sk:String!) {\n" +
                "    getQueueLengths(input: { pk: $pk, sk: $sk }) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        priorityQueue\n" +
                "        normalQueue\n" +
                "        offpeakQueue\n" +
                "    }\n" +
                "}";

        System.out.println("------ Get Queue Lengths ----------------------------------");
        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

//    TODO: what sk needs to be provided ?
//    @Test(priority = 13)
    public void getPricing(){
        Response response;
        String query = "query GetPricing($sk:String!) {\n" +
                "    getPricing(input: { sk: $sk }) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        address\n" +
                "        normal {\n" +
                "            rate\n" +
                "            surcharge\n" +
                "            id\n" +
                "        }\n" +
                "        priority {\n" +
                "            rate\n" +
                "            surcharge\n" +
                "            id\n" +
                "        }\n" +
                "        offPeak {\n" +
                "            rate\n" +
                "            surcharge\n" +
                "            id\n" +
                "        }\n" +
                "    }\n" +
                "}\n";

        System.out.println("------ Get Pricing ----------------------------------");
        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }
    @AfterClass
    public void teardown() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("/home/squarebits/IdeaProjects/AutoChargeIt_GraphQl/src/test/java/graphql/test1.xlsx");
        workbook.write(fileOutputStream);
    }
}