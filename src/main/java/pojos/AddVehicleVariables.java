package pojos;

public class AddVehicleVariables {
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    private String make;
    private String model;
    private String carYear;
    private String color;
    private String licensePlate;
    private String vehicleName;
    private String vehicleImage;
    private String state;

    public String getStoredVehicleQR() {
        return storedVehicleQR;
    }

    public void setStoredVehicleQR(String storedVehicleQR) {
        this.storedVehicleQR = storedVehicleQR;
    }

    private String storedVehicleQR;


    public boolean getDefault() {
        return isDefault;
    }

    private boolean isDefault;

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
