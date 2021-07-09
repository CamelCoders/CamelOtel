package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource;

import com.google.gson.annotations.SerializedName;

public class BokkingSource {


    @SerializedName("id")
    private int id;
    @SerializedName("bookingtypename")
    private String ma_bookingsource_type;
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

    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;

    public BokkingSource() {

    }

    public BokkingSource(int id, String ma_bookingsource_type, String shortcode, String createdbyuid, String createddate, String modifiedbyuid, String modfieddate, String status, String massage, String value) {
        this.id = id;
        this.ma_bookingsource_type = ma_bookingsource_type;
        this.shortcode = shortcode;
        this.createdbyuid = createdbyuid;
        this.createddate = createddate;
        this.modifiedbyuid = modifiedbyuid;
        this.modfieddate = modfieddate;
        this.status = status;
        this.massage = massage;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa_bookingsource_type() {
        return ma_bookingsource_type;
    }

    public void setMa_bookingsource_type(String ma_bookingsource_type) {
        this.ma_bookingsource_type = ma_bookingsource_type;
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
