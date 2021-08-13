package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio;

import com.google.gson.annotations.SerializedName;

public class Folio {

    @SerializedName("bookingid")
    private String bookingid;
    @SerializedName("foliobillingid")
    private String foliobillingid;

    @SerializedName("guestId")
    private String guestId;

    @SerializedName("comment")
    private String comment;
    @SerializedName("creditdebit")
    private String creditdebit;

    @SerializedName("tax")
    private String tax;
    @SerializedName("rateplan")
    private String rateplan;

    @SerializedName("amount")
    private String amount;
    @SerializedName("id")
    private String id;
    @SerializedName("roomId")
    private String roomId;

    @SerializedName("date")
    private String date;


    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;


    public void Folio(){

    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getFoliobillingid() {
        return foliobillingid;
    }

    public void setFoliobillingid(String foliobillingid) {
        this.foliobillingid = foliobillingid;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreditdebit() {
        return creditdebit;
    }

    public void setCreditdebit(String creditdebit) {
        this.creditdebit = creditdebit;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getRateplan() {
        return rateplan;
    }

    public void setRateplan(String rateplan) {
        this.rateplan = rateplan;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
