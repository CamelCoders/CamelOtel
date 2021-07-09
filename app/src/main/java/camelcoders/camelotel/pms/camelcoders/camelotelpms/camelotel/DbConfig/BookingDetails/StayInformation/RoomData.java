package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation;

import java.io.Serializable;

public class RoomData implements Serializable {

    public String roomtype;
    public String roomnumber;
    public String ratetype;
    public String rateplan;
    public String subarateplan;
    public String adult;
    public String child;
    public String amountWOtax;
    public String taxtPer;
    public String tacamount;
    public String amountWtax;

    public RoomData() {

    }

    public RoomData(String roomtype, String roomnumber, String ratetype, String rateplan, String subarateplan, String adult, String child, String amountWOtax, String taxtPer, String tacamount, String amountWtax) {
        this.roomtype = roomtype;
        this.roomnumber = roomnumber;
        this.ratetype = ratetype;
        this.rateplan = rateplan;
        this.subarateplan = subarateplan;
        this.adult = adult;
        this.child = child;
        this.amountWOtax = amountWOtax;
        this.taxtPer = taxtPer;
        this.tacamount = tacamount;
        this.amountWtax = amountWtax;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getRatetype() {
        return ratetype;
    }

    public void setRatetype(String ratetype) {
        this.ratetype = ratetype;
    }

    public String getRateplan() {
        return rateplan;
    }

    public void setRateplan(String rateplan) {
        this.rateplan = rateplan;
    }

    public String getSubarateplan() {
        return subarateplan;
    }

    public void setSubarateplan(String subarateplan) {
        this.subarateplan = subarateplan;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getAmountWOtax() {
        return amountWOtax;
    }

    public void setAmountWOtax(String amountWOtax) {
        this.amountWOtax = amountWOtax;
    }

    public String getTaxtPer() {
        return taxtPer;
    }

    public void setTaxtPer(String taxtPer) {
        this.taxtPer = taxtPer;
    }

    public String getTacamount() {
        return tacamount;
    }

    public void setTacamount(String tacamount) {
        this.tacamount = tacamount;
    }

    public String getAmountWtax() {
        return amountWtax;
    }

    public void setAmountWtax(String amountWtax) {
        this.amountWtax = amountWtax;
    }
}
