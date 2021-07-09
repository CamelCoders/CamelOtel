package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType;

import com.google.gson.annotations.SerializedName;

public class IdentityType {


    @SerializedName("idid")
    private int idid;
    @SerializedName("identitytypename")
    private String identitytypename;
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

    public IdentityType() {

    }

    public IdentityType(int id, String identitytypename, String shortcode, String createdbyuid, String createddate, String modifiedbyuid, String modfieddate, String status, String massage, String value) {
        this.idid = id;
        this.identitytypename = identitytypename;
        this.shortcode = shortcode;
        this.createdbyuid = createdbyuid;
        this.createddate = createddate;
        this.modifiedbyuid = modifiedbyuid;
        this.modfieddate = modfieddate;
        this.status = status;
        this.massage = massage;
        this.value = value;
    }

    public int getIdid() {
        return idid;
    }

    public void setIdid(int idid) {
        this.idid = idid;
    }

    public String getIdentitytypename() {
        return identitytypename;
    }

    public void setIdentitytypename(String identitytypename) {
        this.identitytypename = identitytypename;
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