package graphql;

import endpoints.Mutation;
import endpoints.Query;
import org.testng.annotations.Test;

public class GraphQLTest {
    Mutation mutation = new Mutation();
    Query query = new Query();
    @Test(testName = "Update user -> Get user -> UpdateCharge Preference -> Get user")
    public void user(){
//      update user
        mutation.updateUser();
//      get user
        query.getUser();
//      update charge preference
        mutation.updateChargePreference();
//      get user
        query.getUser();
    }
    @Test(testName = "Add vehicle -> List vehicle -> Update vehicle -> List vehicle -> Set default vehicle -> Get default vehicle -> Delete vehicle -> List vehicle")
    public void vehicle(){
//      add vehicle
        mutation.addVehicle();
//      list vehicles
        query.listVehicles();
//      update vehicle
        mutation.updateVehicle();
//      list vehicles
        query.listVehicles();
//      set default vehicle
        mutation.setDefaultVehicle();
//      get default vehicle
        query.getDefaultVehicle();
//      delete vehicle
        mutation.deleteVehicle();
//      list vehicles
        query.listVehicles();
    }
    @Test(testName= "Add card -> List credit card -> Set default card -> Get default credit card -> Delete Card -> List credit card")
    public void card(){
//      add card
        mutation.addCard();
//      list credit cards
        query.listCreditCards();
//      set default card
        mutation.setDefaultCard();
//      get default card
        query.getDefaultCreditCard();
//      delete card
        mutation.deleteCard();
//      list credit cards
        query.listCreditCards();
    }
    @Test
    public void stall(){

    }
}
