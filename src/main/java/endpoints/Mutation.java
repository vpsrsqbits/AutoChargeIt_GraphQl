package endpoints;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.datafaker.Faker;
import pojos.*;


public class Mutation {
    Faker faker = new Faker();
    JsonPath json;
    String vehicleSK, cardSK, lastFour, chargeRateSK, licensePlate, state, scanNodeQRPK, scanNodeQRSK, updateStatusPK, updateStatusSK, resetNodeValuesPK, resetNodeValuesSK;

    public void addVehicle(){
        GraphQLQuery query = new GraphQLQuery();
        Response response;
        licensePlate = faker.vehicle().licensePlate();
        state = faker.address().stateAbbr();

        query.setQuery("mutation AddVehicle($make:String!, $model:String!, $carYear:String!, " +
                "        $color:String!, $licensePlate:String!, $vehicleName:String!," +
                "        $vehicleImage:String!, $default:Boolean!, $storedVehicleQR:String, $state:String!) " +
                "        {" +
                "                addVehicle(" +
                "                                input: {" +
                "                                                make: $make" +
                "                                                model: $model" +
                "                                                carYear: $carYear" +
                "                                                color: $color" +
                "                                                licensePlate: $licensePlate" +
                "                                                vehicleName: $vehicleName" +
                "                                                vehicleImage: $vehicleImage" +
                "                                                isDefault: $default" +
                "                                                storedVehicleQR: $storedVehicleQR" +
                "                                                state: $state" +
                "                                }" +
                "                ) {" +
                "                                pk" +
                "                                sk" +
                "                                make" +
                "                                model" +
                "                                carYear" +
                "                                color" +
                "                                licensePlate" +
                "                                vehicleName" +
                "                                storedVehicleQR" +
                "                                isDefault" +
                "                                vehicleImage" +
                "                                state" +
                "                }" +
                "}");
        AddVehicleVariables variables = new AddVehicleVariables();
        variables.setMake(faker.vehicle().make());
        variables.setModel(faker.vehicle().model());
        variables.setCarYear("2013");
        variables.setColor(faker.color().name());
        variables.setLicensePlate(licensePlate);
        variables.setVehicleName(faker.vehicle().makeAndModel());
        variables.setVehicleImage("lksdjfohafouwouhfiwfolkigjrei");
        variables.setDefault(false);
        variables.setState(state);
        variables.setStoredVehicleQR("zxcvbnmkjiuytrdfghj");

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
//        System.out.println((String)json.get("data.addVehicle.sk"));
        json = response.jsonPath();
        vehicleSK = json.get("data.addVehicle.sk");

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");


    }

    public void setDefaultVehicle(){
        Response response;
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation SetDefaultVehicle ($sk:String!){\n" +
                "    setDefaultVehicle(input: { sk: $sk }) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        make\n" +
                "        model\n" +
                "        carYear\n" +
                "        color\n" +
                "        licensePlate\n" +
                "        vehicleName\n" +
                "        storedVehicleQR\n" +
                "        isDefault\n" +
                "        vehicleImage\n" +
                "        state\n" +
                "    }\n" +
                "}\n");

        SetDefaultVehicleVariables variables = new SetDefaultVehicleVariables();
        variables.setSk(vehicleSK);

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
        json = response.jsonPath();

        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");


    }

    public void deleteVehicle(){
        Response response;
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation DeleteVehicle($sk:String!){\n" +
                "    deleteVehicle(input: { sk: $sk }) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        make\n" +
                "        model\n" +
                "        carYear\n" +
                "        color\n" +
                "        licensePlate\n" +
                "        vehicleName\n" +
                "        storedVehicleQR\n" +
                "        isDefault\n" +
                "        vehicleImage\n" +
                "        state\n" +
                "    }\n" +
                "}");

        DeleteVehicleVariables variables = new DeleteVehicleVariables();

//      Here, put sk of the vehicle to be deleted
        variables.setsk(vehicleSK);
        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
        json = response.jsonPath();

        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");



    }

    public void addCard(){
        Response response;
        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation AddCard($lastFour:String!, $cardName:String!, $expiration:String!, \n" +
                "                 $ccToken:String!, $isDefault:Boolean!) {\n" +
                "    addCard(\n" +
                "        input: {\n" +
                "            lastFour: $lastFour\n" +
                "            cardName: $cardName\n" +
                "            expiration: $expiration\n" +
                "            ccToken: $ccToken\n" +
                "            isDefault: $isDefault\n" +
                "        }\n" +
                "    ) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        ccToken\n" +
                "        lastFour\n" +
                "        cardName\n" +
                "        expiration\n" +
                "        isDefault\n" +
                "    }\n" +
                "}");
        AddCardVariables variables = new AddCardVariables();
        variables.setlastFour(faker.number().digits(4));
        variables.setcardName(faker.name().firstName());
        variables.setexpiration("02/25");
        variables.setccToken(faker.number().digits(11));
        variables.setisDefault(false);
        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
        json = response.jsonPath();
        cardSK = json.get("data.addCard.sk");
        lastFour = json.get("data.addCard.lastFour");

        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public void setDefaultCard(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation SetDefaultCard($lastFour:String!,$isDefault:Boolean!) {\n" +
                "    setDefaultCard(input: { lastFour: $lastFour, isDefault: $isDefault }) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        ccToken\n" +
                "        lastFour\n" +
                "        cardName\n" +
                "        expiration\n" +
                "        isDefault\n" +
                "    }\n" +
                "}\n");
        SetDefaultCardVariables variables = new SetDefaultCardVariables();
        variables.setSk(cardSK);
        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
        json = response.jsonPath();

        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    public void deleteCard(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation DeleteCard ($sk:String!){\n" +
                "    deleteCard(input: { sk: $sk }) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        ccToken\n" +
                "        lastFour\n" +
                "        cardName\n" +
                "        expiration\n" +
                "        isDefault\n" +
                "    }\n" +
                "}\n");

        DeleteCardVariables variables = new DeleteCardVariables();

//      Here, enter your sk for card to delete.
        variables.setsk(cardSK);
        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
        json = response.jsonPath();

        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    public void updateUser(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation UpdateUser ($address:String!, $displayName:String!, $name:String!, $email:String!, $building:String!, $cell:String!, $city:String!, $state:String!, $zipcode:String!, $phone:String!, $company:String!, $preferenceId:Int!){\n" +
                "    updateUser(\n" +
                "        input: {\n" +
                "            address: $address,\n" +
                "            displayName: $displayName,\n" +
                "            name: $name,\n" +
                "            email: $email,\n" +
                "            building: $building,\n" +
                "            cell: $cell,\n" +
                "            city: $city,\n" +
                "            state: $state,\n" +
                "            zipcode: $zipcode,\n" +
                "            phone: $phone,\n" +
                "            company: $company,\n" +
                "            preferenceId: $preferenceId\n" +
                "        }\n" +
                "    ) {\n" +
                "        address\n" +
                "        displayName\n" +
                "        name\n" +
                "        email\n" +
                "        building\n" +
                "        city\n" +
                "        state\n" +
                "        zipcode\n" +
                "        phone\n" +
                "        company\n" +
                "        pk\n" +
                "        sk\n" +
                "        preferenceId\n" +
                "    }\n" +
                "}\n");

        UpdateUserVariables variables = new UpdateUserVariables();

        variables.setAddress(faker.address().fullAddress());
        variables.setdisplayName(faker.gameOfThrones().character());
        variables.setname(faker.funnyName().name());
        variables.setemail(faker.internet().emailAddress());
        variables.setBuilding(faker.address().buildingNumber());
        variables.setCell(faker.address().postcode());
        variables.setCity(faker.gameOfThrones().city());
        variables.setState(faker.gameOfThrones().house());
        variables.setzipcode(faker.address().zipCode());
        variables.setPhone(faker.phoneNumber().phoneNumber());
        variables.setCompany(faker.company().name());
        variables.setPreferenceId(faker.number().numberBetween(1,4));

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
        json = response.jsonPath();

        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");

    }

    public void updateChargePreference(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation UpdateChargePreference($preferenceId:Int!) {\n" +
                "    updateChargePreference(\n" +
                "        input: {chargePreference: $preferenceId }\n" +
                "    ) {\n" +
                       " address\n"+
                        "displayName\n"+
                        "name\n"+
                        "email\n"+
                        "building\n"+
                        "city\n"+
                        "state\n"+
                        "zipcode\n"+
                        "phone\n"+
                        "company\n"+
                        "preferenceId\n"+
                        "pk\n"+
                        "sk\n"+
                "    }\n" +
                "}\n");
        UpdateChargePreferenceVariables variables = new UpdateChargePreferenceVariables();
        variables.setPreferenceId(faker.number().numberBetween(1,4));

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
        json = response.jsonPath();

        System.out.println(response.then().log().body());
        System.out.println("-----------------------------------------------------------------------------------------");

    }





//  FIXME:  This test is facing some problems due to incompatibility between schema and mutation query.
    public void updateVehicle(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation UpdateVehicle($make:String!, $model:String!, $carYear:String!, $color:String!, $licensePlate:String!, $vehicleName:String!, $vehicleImage:String!, $isDefault:Boolean!, $storedVehicleQR:String!, $state:String!) {\n" +
                "    updateVehicle(\n" +
                "        input: {\n" +
                "            make: $make\n" +
                "            model: $model\n" +
                "            carYear: $carYear\n" +
                "            color: $color\n" +
                "            licensePlate: $licensePlate\n" +
                "            vehicleName: $vehicleName\n" +
                "            vehicleImage: $vehicleImage\n" +
                "            isDefault: $isDefault\n" +
                "            storedVehicleQR: $storedVehicleQR\n" +
                "            state: $state\n" +
                "        }\n" +
                "    ) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        make\n" +
                "        model\n" +
                "        carYear\n" +
                "        color\n" +
                "        licensePlate\n" +
                "        vehicleName\n" +
                "        storedVehicleQR\n" +
                "        isDefault\n" +
                "        vehicleImage\n" +
                "        state\n" +
                "    }\n" +
                "}\n");

        UpdateVehicleVariables variables = new UpdateVehicleVariables();
        variables.setMake(faker.vehicle().make());
        variables.setModel(faker.vehicle().model());
        variables.setCarYear("2006");
        variables.setColor(faker.color().name());
//      Check if existing car's license plate is required.
        variables.setlicensePlate(faker.vehicle().licensePlate());
        variables.setvehicleName(faker.gameOfThrones().dragon());
        variables.setVehicleImage(faker.gameOfThrones().quote());
        variables.setisDefault(false);
        variables.setStoredVehicleQR(faker.random().hex(18));
        variables.setstate(faker.address().stateAbbr());

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);

    }
//    TODO: Figure out, how this should be tested. What "sk" should we use.
    public void updateChargeRate(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation UpdateChargeRate($sk:String!, $normalRate:String!, $normalSurcharge:String!, $offPeakRate:String!, $offPeakSurcharge:String!, $priorityRate:String!, $prioritySurcharge:String!, $address:String!) {\n" +
                "    updateChargeRate(\n" +
                "        input: {\n" +
                "            sk: $sk\n" +
                "            normalRate: $normalRate\n" +
                "            normalSurcharge: $normalSurcharge\n" +
                "            offPeakRate: $offPeakRate\n" +
                "            offPeakSurcharge: $offPeakSurcharge\n" +
                "            priorityRate: $priorityRate\n" +
                "            prioritySurcharge: $prioritySurcharge\n" +
                "            address: $address\n" +
                "        }\n" +
                "    ) {\n" +
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
                "}\n");

        UpdateChargeRateVariables variables = new UpdateChargeRateVariables();
        variables.setSk(chargeRateSK);
        variables.setNormalRate(String.valueOf(faker.random().nextDouble(21.33,31.33)));
        variables.setNormalSurcharge(String.valueOf(faker.random().nextDouble(1.33,7.47)));
        variables.setOffPeakRate(String.valueOf(faker.random().nextDouble(31.33,41.36)));
        variables.setOffPeakSurcharge(String.valueOf(faker.random().nextDouble(1.33,7.47)));
        variables.setPriorityRate(String.valueOf(faker.random().nextDouble(41.33,51.36)));
        variables.setPrioritySurcharge(String.valueOf(faker.random().nextDouble(1.33,7.47)));
        variables.setAddress(faker.address().fullAddress());

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);

    }

//    TODO: Figure out, how this too should be tested. Here also "sk" and "pk".
    public void scanNodeQR() {
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation ScanNodeQR($pk:String!,$sk:String!,$cardSK:String!,$vehicleSK:String!,$xRefNum:String!,$cardnoxCustomerId:String!,$preferenceId:Int!,$stallId:Int!){\n" +
                "    scanNodeQR(\n" +
                "        input: {\n" +
                "            pk: $pk\n" +
                "            sk: $sk\n" +
                "            cardSK: $cardSK\n" +
                "            vehicleSK: $vehicleSK\n" +
                "            xRefNum: $xRefNum\n" +
                "            cardnoxCustomerId: $cardnoxCustomerId\n" +
                "            preferenceId: $preferenceId\n" +
                "            stallId: $stallId\n" +
                "        }\n" +
                "    ) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        data\n" +
                "        activeCharge\n" +
                "        activeParked\n" +
                "        status\n" +
                "        scanTime\n" +
                "        cardnoxCustomerId\n" +
                "        cardSK\n" +
                "        vehicleSK\n" +
                "        xRefNum\n" +
                "        preferenceId\n" +
                "        stallId\n" +
                "    }\n" +
                "}\n");
        ScanNodeQRVariables variables = new ScanNodeQRVariables();
        variables.setPk("");
        variables.setSk("");
        variables.setCardSK("");
        variables.setVehicleSK("");
        variables.setCardnoxCustomerId("");
        variables.setxRefNumber("");
        variables.setStallId(0);
        variables.setPreferenceId(0);

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
    }

//    TODO: Figure out, how this three should be tested. Here we need pk and sk
    public void updateStatus(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation UpdateStatus($pk:String!, $sk:String!, $status:Int!) {\n" +
                "    updateStatus(input: { pk: $pk, sk: $sk, status: $status }) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        data\n" +
                "        activeCharge\n" +
                "        activeParked\n" +
                "        status\n" +
                "        scanTime\n" +
                "        cardnoxCustomerId\n" +
                "        cardSK\n" +
                "        vehicleSK\n" +
                "        xRefNum\n" +
                "        preferenceId\n" +
                "        stallId\n" +
                "    }\n" +
                "}\n");

        UpdateStatusVariables variables = new UpdateStatusVariables();
        variables.setSk(updateStatusSK);
        variables.setPk(updateStatusPK);
        variables.setStatus(faker.number().numberBetween(0, 10));

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
    }

//    TODO: Figure out, how this four should be tested.pk ,sk.
    public void resetNodeValues(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation ResetNodeValues($pk:String!,$sk:String!) {\n" +
                "    resetNodeValues(\n" +
                "        input: {\n" +
                "            pk: $pk\n" +
                "            sk: $sk\n" +
                "        }\n" +
                "    ) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        data\n" +
                "        activeCharge\n" +
                "        activeParked\n" +
                "        status\n" +
                "        scanTime\n" +
                "        cardnoxCustomerId\n" +
                "        cardSK\n" +
                "        vehicleSK\n" +
                "        xRefNum\n" +
                "        preferenceId\n" +
                "        stallId\n" +
                "    }\n" +
                "}");

        ResetNodeValuesVariables variables = new ResetNodeValuesVariables();
        variables.setPk(resetNodeValuesPK);
        variables.setSk(resetNodeValuesSK);

        Request request = new Request();
        response = request.getResponse(query);
    }

//    TODO: Figure out, how this five should be tested. We need pk, sk, cardSk, vehicleSk, xref, cardnoxId, preferenceId, stallId.
    public void updateVehicleCharging(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation UpdateVehicleCharging($pk:String!, $sk:String!, $cardSK:String!, $vehicleSK:String!, $xRefNum:String!, $cardnoxCustomerId:String!, $preferenceId:Int!, $stallId:Int!) {\n" +
                "    updateVehicleCharging(\n" +
                "        input: {\n" +
                "            pk: $pk\n" +
                "            sk: $sk\n" +
                "            cardSK: $cardSK\n" +
                "            vehicleSK: $vehicleSK\n" +
                "            xRefNum: $xRefNum\n" +
                "            cardnoxCustomerId: $cardnoxCustomerId\n" +
                "            preferenceId: $preferenceId\n" +
                "            stallId: $stallId\n" +
                "        }\n" +
                "    ) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        data\n" +
                "        activeCharge\n" +
                "        activeParked\n" +
                "        status\n" +
                "        scanTime\n" +
                "        cardnoxCustomerId\n" +
                "        cardSK\n" +
                "        vehicleSK\n" +
                "        xRefNum\n" +
                "        preferenceId\n" +
                "        stallId\n" +
                "    }\n" +
                "}\n");

        UpdateVehicleChargingVariables variables = new UpdateVehicleChargingVariables();
        variables.setSk("");
        variables.setPk("");
        variables.setVehicleSK("");
        variables.setCardSK("");
        variables.setPreferenceId(0);
        variables.setxRefNumber("");
        variables.setCardnoxCustomerId("");
        variables.setStallId(0);

        Request request = new Request();
        response = request.getResponse(query);
    }

//    TODO: Figure out, how this six should be tested. We need pk, sk, normalQueue, priorityQueue, offpeakQueue.
    public void setQueueLengths(){
        Response response;

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("mutation SetQueueLengths($pk:String!, $sk:String!, $normalQueue:Int!, $priorityQueue:Int!, $offpeakQueue:Int!) {\n" +
                "    setQueueLengths(\n" +
                "        input: {\n" +
                "            pk: $pk\n" +
                "            sk: $sk\n" +
                "            normalQueue: $normalQueue\n" +
                "            priorityQueue: $priorityQueue\n" +
                "            offpeakQueue: $offpeakQueue\n" +
                "        }\n" +
                "    ) {\n" +
                "        pk\n" +
                "        sk\n" +
                "        priorityQueue\n" +
                "        normalQueue\n" +
                "        offpeakQueue\n" +
                "    }\n" +
                "}\n");

        SetQueueLengths variables = new SetQueueLengths();
        variables.setPk("");
        variables.setSk("");
        variables.setNormalQueue(0);
        variables.setOffpeakQueue(0);
        variables.setPriorityQueue(0);

        query.setVariables(variables);

        Request request = new Request();
        response = request.getResponse(query);
    }

// FIXME: Confirm if this mutation is removed.
    public void getQueueLengths(){}

}