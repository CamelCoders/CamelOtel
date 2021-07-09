package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models;

import com.google.gson.annotations.SerializedName;

public class SlabLlistModal {
    @SerializedName("id")
    private String id;
    @SerializedName("fromprice")
    private String fromprice;
    @SerializedName("toprice")
    private String toprice;
    @SerializedName("percentage")
    private String percentage;
    @SerializedName("taxid")
    private String taxid;

    @SerializedName("value")
    private String value;

    @SerializedName("message")
    private String message;

    public void Rooms() {


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromprice() {
        return fromprice;
    }

    public void setFromprice(String fromprice) {
        this.fromprice = fromprice;
    }

    public String getToprice() {
        return toprice;
    }

    public void setToprice(String toprice) {
        this.toprice = toprice;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}