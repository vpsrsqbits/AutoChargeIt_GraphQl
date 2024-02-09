package pojos;


public class UpdateVehicleVariables {

    public String getlicensePlate() {
        return licensePlate;
    }

    public void setlicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getvehicleName() {
        return vehicleName;
    }

    public void setvehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public String getStoredVehicleQR() {
        return storedVehicleQR;
    }

    public void setStoredVehicleQR(String storedVehicleQR) {
        this.storedVehicleQR = storedVehicleQR;
    }

    public boolean getisDefault() {
        return isDefault;
    }

    public void setisDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    private String  licensePlate, vehicleName, state, make, model, carYear, color, vehicleImage, storedVehicleQR;
    private boolean isDefault;
}
