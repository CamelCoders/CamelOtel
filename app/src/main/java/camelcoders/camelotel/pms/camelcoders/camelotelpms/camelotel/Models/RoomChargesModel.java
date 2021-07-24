package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models;

public class RoomChargesModel {
    String date , roomCategory , rateType , paxText , roomCharges , discountText , taxText , adjustmentTax , netAmountText;

    public RoomChargesModel(String date, String roomCategory, String rateType, String paxText, String roomCharges, String discountText, String taxText, String adjustmentTax, String netAmountText) {
        this.date = date;
        this.roomCategory = roomCategory;
        this.rateType = rateType;
        this.paxText = paxText;
        this.roomCharges = roomCharges;
        this.discountText = discountText;
        this.taxText = taxText;
        this.adjustmentTax = adjustmentTax;
        this.netAmountText = netAmountText;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public String getPaxText() {
        return paxText;
    }

    public void setPaxText(String paxText) {
        this.paxText = paxText;
    }

    public String getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(String roomCharges) {
        this.roomCharges = roomCharges;
    }

    public String getDiscountText() {
        return discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

    public String getTaxText() {
        return taxText;
    }

    public void setTaxText(String taxText) {
        this.taxText = taxText;
    }

    public String getAdjustmentTax() {
        return adjustmentTax;
    }

    public void setAdjustmentTax(String adjustmentTax) {
        this.adjustmentTax = adjustmentTax;
    }

    public String getNetAmountText() {
        return netAmountText;
    }

    public void setNetAmountText(String netAmountText) {
        this.netAmountText = netAmountText;
    }
}
