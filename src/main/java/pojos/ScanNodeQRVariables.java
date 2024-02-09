package pojos;


public class ScanNodeQRVariables {
    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getCardSK() {
        return cardSK;
    }

    public void setCardSK(String cardSK) {
        this.cardSK = cardSK;
    }

    public String getVehicleSK() {
        return vehicleSK;
    }

    public void setVehicleSK(String vehicleSK) {
        this.vehicleSK = vehicleSK;
    }

    public String getxRefNumber() {
        return xRefNumber;
    }

    public void setxRefNumber(String xRefNumber) {
        this.xRefNumber = xRefNumber;
    }

    public String getCardnoxCustomerId() {
        return cardnoxCustomerId;
    }

    public void setCardnoxCustomerId(String cardnoxCustomerId) {
        this.cardnoxCustomerId = cardnoxCustomerId;
    }

    public int getPreferenceId() {
        return preferenceId;
    }

    public void setPreferenceId(int preferenceId) {
        this.preferenceId = preferenceId;
    }

    public int getStallId() {
        return stallId;
    }

    public void setStallId(int stallId) {
        this.stallId = stallId;
    }
    private String pk, sk, cardSK, vehicleSK, xRefNumber, cardnoxCustomerId;
    private int preferenceId, stallId;
}