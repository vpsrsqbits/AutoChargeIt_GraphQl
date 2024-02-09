package endpoints;

import io.restassured.response.Response;

public class Query {


    public void getUser() {
        Response response ;
        String query = "{\"query\":\"query MyQuery { getUser { userdata { address displayName name email building city state zipcode phone company chargePreference } }}\"}";

        System.out.println("------ Get User -----------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

    public void listCreditCards(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  listCreditCards {    creditcard {      pk      sk      ccToken      lastFour      cardName      expiration      isDefault    }  }}\"}";

        System.out.println("------ List Credit Cards -------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

    public void getDefaultCreditCard(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  getDefaultCreditCard {    creditcard {      pk      sk      ccToken      lastFour      cardName      expiration      isDefault    }  }}\"}";
        System.out.println("------ Get Default Credit Card ------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());
    }

    public void listChargingVehicles(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  listChargingVehicles {    stalls {      pk      sk      data      activeCharge      activeParked      status      scanTime   cardnoxCustomerId cardSK vehicleSK xRefNum preferenceId stallId }  }}\"}";

        System.out.println("------ List Charging Vehicles ---------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());
    }

    public void listVehicles(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  listVehicles {    vehicles {      pk      sk      make      model      carYear      color      licensePlate      vehicleName      storedVehicleQR      isDefault      vehicleImage      state    }  }}\"}";

        System.out.println("------ List Vehicles -------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

    public void getDefaultVehicle(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  getDefaultVehicle {    vehicles {      pk      sk      make      model      carYear      color      licensePlate      vehicleName      storedVehicleQR      isDefault      vehicleImage      state    }  }}\"}";

        System.out.println("------ Get Default Vehicle ------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

    public void listAllSites(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  listAllSites {    normal {      id    }    offPeak {      id    }    priority {      id    }  }}\"}";

        System.out.println("------ List All Sites --------------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }





//    FIXME: Does not exists anymore.
    public void listAvailableStalls(){
        Response response;
        String query = "{\"query\":\"query MyQuery {  listAvailableStalls {    stalls {      pk      sk      data      activeCharge      activeParked      status      scanTime   cardnoxCustomerId   cardSK   vehicleSK   xRefNum   preferenceId   stallId }  }}\"}";

        System.out.println("------ List Available Stalls -------------------------------------");

        Request request = new Request();

//      Call this to get request and response logs.
//        request.getLog(query);

        response = request.getResponse(query);
        System.out.println(response.then().log().body());

    }

//    FIXME: Does not exists anymore.
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
}