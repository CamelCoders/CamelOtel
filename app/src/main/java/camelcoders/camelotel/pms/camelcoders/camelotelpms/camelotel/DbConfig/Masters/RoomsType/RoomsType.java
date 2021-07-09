package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType;

import com.google.gson.annotations.SerializedName;

public class RoomsType {
    @SerializedName("id")
    private int id;
    @SerializedName("shortcode")
    private String shortcode;
    @SerializedName("roomtypename")
    private String roomtypename;
    @SerializedName("baseadult")
    private String baseadult;
    @SerializedName("basechild")
    private String basechild;
    @SerializedName("maxchild")
    private String maxchild;
    @SerializedName("maxadult")
    private String maxadult;
    @SerializedName("img_path")
    private String img_path;
    @SerializedName("status")
    private String status;
    @SerializedName("defaultwebinventory")
    private String defaultwebinventory;
    @SerializedName("inventorytobedisplayed")
    private String inventorytobedisplayed;
    @SerializedName("maxrate")
    private String maxrate;
    @SerializedName("minrate")
    private String minrate;
    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;


    public RoomsType() {

    }

    public String getMaxrate() {
        return maxrate;
    }

    public void setMaxrate(String maxrate) {
        this.maxrate = maxrate;
    }

    public String getMinrate() {
        return minrate;
    }

    public void setMinrate(String minrate) {
        this.minrate = minrate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getRoomtypename() {
        return roomtypename;
    }

    public void setRoomtypename(String roomtypename) {
        this.roomtypename = roomtypename;
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

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDefaultwebinventory() {
        return defaultwebinventory;
    }

    public void setDefaultwebinventory(String defaultwebinventory) {
        this.defaultwebinventory = defaultwebinventory;
    }

    public String getInventorytobedisplayed() {
        return inventorytobedisplayed;
    }

    public void setInventorytobedisplayed(String inventorytobedisplayed) {
        this.inventorytobedisplayed = inventorytobedisplayed;
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