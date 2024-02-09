package pojos;


public class UpdateUserVariables {
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdisplayName() {
        return displayName;
    }

    public void setdisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getzipcode() {
        return zipcode;
    }

    public void setzipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

//    public int getChargePreference() {
//        return chargePreference;
//    }
//
//    public void setChargePreference(int chargePreference) {
//        this.chargePreference = chargePreference;
//    }
public int getPreferenceId() {
    return preferenceId;
}

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }



    private String name, displayName, email, address, building, cell, city, state, zipcode, phone, company;

    public String getFirebaseToken() {
        return firebaseToken;
    }

    public void setFirebaseToken(String firebaseToken) {
        this.firebaseToken = firebaseToken;
    }

    private String firebaseToken;

    public String getPaymentCustomerid() {
        return paymentCustomerid;
    }

    public void setPaymentCustomerid(String paymentCustomerid) {
        this.paymentCustomerid = paymentCustomerid;
    }

    private String paymentCustomerid;

    private int preferenceId;
}
