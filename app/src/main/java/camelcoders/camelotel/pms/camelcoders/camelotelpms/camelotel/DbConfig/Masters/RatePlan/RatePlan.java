package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan;

import com.google.gson.annotations.SerializedName;

public class RatePlan {

    @SerializedName("id")
    private String id;
    @SerializedName("shortcode")
    private String shortcode;
    @SerializedName("roomplanname")
    private String roomplanname;
    @SerializedName("roomplandesc")
    private String roomplandesc;
    @SerializedName("inclusion")
    private String inclusion;
    @SerializedName("roomtypeid")
    private String roomtypeid;
    @SerializedName("ratetypeid")
    private String ratetypeid;
    @SerializedName("baseadult")
    private String baseadult;
    @SerializedName("basechild")
    private String basechild;
    @SerializedName("maxchild")
    private String maxchild;
    @SerializedName("maxadult")
    private String maxadult;
    @SerializedName("minnight")
    private String minnight;
    @SerializedName("maxnight")
    private String maxnight;
    @SerializedName("createdbyuid")
    private String createdbyuid;
    @SerializedName("createddate")
    private String createddate;
    @SerializedName("modifiedbyuid")
    private String modifiedbyuid;
    @SerializedName("modifydate")
    private String modifydate;
    @SerializedName("creterateplanas")
    private String creterateplanas;
    @SerializedName("rackrate")
    private String rackrate;

    @SerializedName("extraadultrate")
    private String extraadultrate;
    @SerializedName("extrachildrate")
    private String extrachildrate;
    @SerializedName("maxoccup")
    private String maxoccup;
    @SerializedName("status")
    private String status;

    @SerializedName("associatedBusinessSource")
    private String associatedBusinessSource;

    @SerializedName("associatedCompany")
    private String associatedCompany;

    @SerializedName("doubleOccupancy")
    private String doubleOccupancy	;

    @SerializedName("singleOccupancy")
    private String singleOccupancy;


    @SerializedName("value")
    private String value;

    @SerializedName("message")
    private String message;


    public void RateType(){

    }

    public String getAssociatedBusinessSource() {
        return associatedBusinessSource;
    }

    public void setAssociatedBusinessSource(String associatedBusinessSource) {
        this.associatedBusinessSource = associatedBusinessSource;
    }

    public String getAssociatedCompany() {
        return associatedCompany;
    }

    public void setAssociatedCompany(String associatedCompany) {
        this.associatedCompany = associatedCompany;
    }

    public String getDoubleOccupancy() {
        return doubleOccupancy;
    }

    public void setDoubleOccupancy(String doubleOccupancy) {
        this.doubleOccupancy = doubleOccupancy;
    }

    public String getSingleOccupancy() {
        return singleOccupancy;
    }

    public void setSingleOccupancy(String singleOccupancy) {
        this.singleOccupancy = singleOccupancy;
    }

    public String getRackrate() {
        return rackrate;
    }

    public void setRackrate(String rackrate) {
        this.rackrate = rackrate;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getRoomplanname() {
        return roomplanname;
    }

    public void setRoomplanname(String roomplanname) {
        this.roomplanname = roomplanname;
    }

    public String getRoomplandesc() {
        return roomplandesc;
    }

    public void setRoomplandesc(String roomplandesc) {
        this.roomplandesc = roomplandesc;
    }

    public String getInclusion() {
        return inclusion;
    }

    public void setInclusion(String inclusion) {
        this.inclusion = inclusion;
    }

    public String getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(String roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getRatetypeid() {
        return ratetypeid;
    }

    public void setRatetypeid(String ratetypeid) {
        this.ratetypeid = ratetypeid;
    }

    public String getBaseadult() {
        return baseadult;
    }

    public void setBaseadult(String baseadult) {
        this.baseadult = baseadult;
    }

    public String getBasechild() {
        return basechild;
    }

    public void setBasechild(String basechild) {
        this.basechild = basechild;
    }

    public String getMaxchild() {
        return maxchild;
    }

    public void setMaxchild(String maxchild) {
        this.maxchild = maxchild;
    }

    public String getMaxadult() {
        return maxadult;
    }

    public void setMaxadult(String maxadult) {
        this.maxadult = maxadult;
    }

    public String getMinnight() {
        return minnight;
    }

    public void setMinnight(String minnight) {
        this.minnight = minnight;
    }

    public String getMaxnight() {
        return maxnight;
    }

    public void setMaxnight(String maxnight) {
        this.maxnight = maxnight;
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

    public String getModifydate() {
        return modifydate;
    }

    public void setModifydate(String modifydate) {
        this.modifydate = modifydate;
    }

    public String getCreterateplanas() {
        return creterateplanas;
    }

    public void setCreterateplanas(String creterateplanas) {
        this.creterateplanas = creterateplanas;
    }

    public String getExtraadultrate() {
        return extraadultrate;
    }

    public void setExtraadultrate(String extraadultrate) {
        this.extraadultrate = extraadultrate;
    }

    public String getExtrachildrate() {
        return extrachildrate;
    }

    public void setExtrachildrate(String extrachildrate) {
        this.extrachildrate = extrachildrate;
    }

    public String getMaxoccup() {
        return maxoccup;
    }

    public void setMaxoccup(String maxoccup) {
        this.maxoccup = maxoccup;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
