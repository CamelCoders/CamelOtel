package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails;

import com.google.gson.annotations.SerializedName;

public class Booking {
    @SerializedName("id")
    private String id;
    @SerializedName("pholio")
    private String pholio;
    @SerializedName("guestid")
    private String guestid;
    @SerializedName("reservationtype")
    private String bookireservationtypengid;
    @SerializedName("bookingid")
    private String bookingid;

    @SerializedName("date")
    private String date;

    @SerializedName("statusBooking")
    private String statusBooking;

    @SerializedName("amountDeposit")
    private String amountDeposit;
    @SerializedName("noofrooms")
    private String noofrooms;


    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;

    public void Booking() {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPholio() {
        return pholio;
    }

    public void setPholio(String pholio) {
        this.pholio = pholio;
    }

    public String getGuestid() {
        return guestid;
    }

    public void setGuestid(String guestid) {
        this.guestid = guestid;
    }

    public String getBookireservationtypengid() {
        return bookireservationtypengid;
    }

    public void setBookireservationtypengid(String bookireservationtypengid) {
        this.bookireservationtypengid = bookireservationtypengid;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(String statusBooking) {
        this.statusBooking = statusBooking;
    }

    public String getAmountDeposit() {
        return amountDeposit;
    }

    public void setAmountDeposit(String amountDeposit) {
        this.amountDeposit = amountDeposit;
    }

    public String getNoofrooms() {
        return noofrooms;
    }

    public void setNoofrooms(String noofrooms) {
        this.noofrooms = noofrooms;
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
