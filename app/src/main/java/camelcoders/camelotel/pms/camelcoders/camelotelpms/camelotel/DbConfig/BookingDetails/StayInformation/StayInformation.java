package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation;

import com.google.gson.annotations.SerializedName;

public class StayInformation {
    @SerializedName("id")
    private String id;
    @SerializedName("bookingid")
    private String bookingid;
    @SerializedName("noofrooms")
    private String noofrooms;
    @SerializedName("roomtype")
    private String roomtype;

    @SerializedName("checkin")
    private String checkin;

    @SerializedName("roomnumber")
    private String roomnumber;

    @SerializedName("roomratetype")
    private String roomratetype;

    @SerializedName("ratePlan")
    private String ratePlan;
    @SerializedName("subRatePlan")
    private String subRatePlan;


    @SerializedName("checkintime")
    private String checkintime;


    @SerializedName("noofnight")
    private String noofnight;
    @SerializedName("checkout")
    private String checkout;
    @SerializedName("checkouttime")
    private String checkouttime;
    @SerializedName("noofdault")
    private String noofdault;
    @SerializedName("noofchild")
    private String noofchild;



    @SerializedName("guestid")
    private String guestid;

    @SerializedName("amount")
    private String amount;

    @SerializedName("status")
    private String status;

    @SerializedName("amountWithTax")
    private String amountWithTax;

    @SerializedName("folioRoomId")
    private String folioRoomId;

    @SerializedName("parentFolioId")
    private String parentFolioId;


    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;

    public void  StayInformation() {


    }

    public String getSubRatePlan() {
        return subRatePlan;
    }

    public void setSubRatePlan(String subRatePlan) {
        this.subRatePlan = subRatePlan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getNoofrooms() {
        return noofrooms;
    }

    public void setNoofrooms(String noofrooms) {
        this.noofrooms = noofrooms;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getRoomratetype() {
        return roomratetype;
    }

    public void setRoomratetype(String roomratetype) {
        this.roomratetype = roomratetype;
    }

    public String getCheckintime() {
        return checkintime;
    }

    public void setCheckintime(String checkintime) {
        this.checkintime = checkintime;
    }

    public String getNoofnight() {
        return noofnight;
    }

    public void setNoofnight(String noofnight) {
        this.noofnight = noofnight;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckouttime() {
        return checkouttime;
    }

    public void setCheckouttime(String checkouttime) {
        this.checkouttime = checkouttime;
    }

    public String getNoofdault() {
        return noofdault;
    }

    public void setNoofdault(String noofdault) {
        this.noofdault = noofdault;
    }

    public String getNoofchild() {
        return noofchild;
    }

    public void setNoofchild(String noofchild) {
        this.noofchild = noofchild;
    }

    public String getGuestid() {
        return guestid;
    }

    public void setGuestid(String guestid) {
        this.guestid = guestid;
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

    public String getRatePlan() {
        return ratePlan;
    }

    public void setRatePlan(String ratePlan) {
        this.ratePlan = ratePlan;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountWithTax() {
        return amountWithTax;
    }

    public void setAmountWithTax(String amountWithTax) {
        this.amountWithTax = amountWithTax;
    }

    public String getFolioRoomId() {
        return folioRoomId;
    }

    public void setFolioRoomId(String folioRoomId) {
        this.folioRoomId = folioRoomId;
    }

    public String getParentFolioId() {
        return parentFolioId;
    }

    public void setParentFolioId(String parentFolioId) {
        this.parentFolioId = parentFolioId;
    }
}
