package pojos;


public class UpdateChargeRateVariables {
    private String sk, normalRate, normalSurcharge, priorityRate, prioritySurcharge, address, offPeakRate, offPeakSurcharge;

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getNormalRate() {
        return normalRate;
    }

    public void setNormalRate(String normalRate) {
        this.normalRate = normalRate;
    }

    public String getNormalSurcharge() {
        return normalSurcharge;
    }

    public void setNormalSurcharge(String normalSurcharge) {
        this.normalSurcharge = normalSurcharge;
    }

    public String getPriorityRate() {
        return priorityRate;
    }

    public void setPriorityRate(String priorityRate) {
        this.priorityRate = priorityRate;
    }

    public String getPrioritySurcharge() {
        return prioritySurcharge;
    }

    public void setPrioritySurcharge(String prioritySurcharge) {
        this.prioritySurcharge = prioritySurcharge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOffPeakRate() {
        return offPeakRate;
    }

    public void setOffPeakRate(String offPeakRate) {
        this.offPeakRate = offPeakRate;
    }

    public String getOffPeakSurcharge() {
        return offPeakSurcharge;
    }

    public void setOffPeakSurcharge(String offPeakSurcharge) {
        this.offPeakSurcharge = offPeakSurcharge;
    }
}