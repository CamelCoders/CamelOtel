package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.PaymentType;

import com.google.gson.annotations.SerializedName;

public class PaymentType {

    @SerializedName("id")
    private int id;
    @SerializedName("paytypename")
    private String paytypename;
    @SerializedName("shortcode")
    private String shortcode;
    @SerializedName("createdbyuid")
    private String createdbyuid;
    @SerializedName("createddate")
    private String createddate;
    @SerializedName("modifiedbyuid")
    private String modifiedbyuid;
    @SerializedName("modfieddate")
    private String modfieddate;

    @SerializedName("status")
    private String status;
    @SerializedName("type")
    private String type;
    @SerializedName("consideras")
    private String consideras;

    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;

    public PaymentType() {

    }

    public PaymentType(int id, String paytypename, String shortcode, String createdbyuid, String createddate, String modifiedbyuid, String modfieddate, String status, String type, String consideras, String massage, String value) {
        this.id = id;
        this.paytypename = paytypename;
        this.shortcode = shortcode;
        this.createdbyuid = createdbyuid;
        this.createddate = createddate;
        this.modifiedbyuid = modifiedbyuid;
        this.modfieddate = modfieddate;
        this.status = status;
        this.type = type;
        this.consideras = consideras;
        this.massage = massage;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getPaytypename()
    {
        return paytypename;
    }

    public void setPaytypename(String paytypename) {
        this.paytypename = paytypename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConsideras() {
        return consideras;
    }

    public void setConsideras(String consideras) {
        this.consideras = consideras;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortname) {
        this.shortcode = shortname;
    }

    public String getCreatedbyuid() {
        return createdbyuid;
    }

    public void setCreatedbyuid(String createdbyuid) {
        this.createdbyuid = createdbyuid;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getModifiedbyuid() {
        return modifiedbyuid;
    }

    public void setModifiedbyuid(String modifiedbyuid) {
        this.modifiedbyuid = modifiedbyuid;
    }

    public String getModfieddate() {
        return modfieddate;
    }

    public void setModfieddate(String modfieddate) {
        this.modfieddate = modfieddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
