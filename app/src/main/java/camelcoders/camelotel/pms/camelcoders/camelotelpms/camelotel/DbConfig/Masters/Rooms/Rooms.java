package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms;

import com.google.gson.annotations.SerializedName;

public class Rooms {
    @SerializedName("room_short_code")
    private String room_short_code;
    @SerializedName("room_short_key")
    private String room_short_key;
    @SerializedName("room_name")
    private String room_name;
    @SerializedName("room_type_id")
    private String room_type_id;
    @SerializedName("room_bed_type_id")
    private String room_bed_type_id;
    @SerializedName("room_phone_number")
    private String room_phone_number;
    @SerializedName("room_key_card_alias")
    private String room_key_card_alias;
    @SerializedName("room_is_smoking")
    private String room_is_smoking;
    @SerializedName("room_is_pay_master")
    private String room_is_pay_master;
    @SerializedName("room_paymaster_inventory")
    private String room_paymaster_inventory;
    @SerializedName("room_is_voucher")
    private String room_is_voucher;
    @SerializedName("room_template_id")
    private String room_template_id;
    @SerializedName("room_as")
    private String room_as;
    @SerializedName("room_suite_name")
    private String room_suite_name;
    @SerializedName("room_description")
    private String room_description;
    @SerializedName("room_image_link")
    private String room_image_link;
    @SerializedName("is_dirty")
    private String is_dirty;
    @SerializedName("status")
    private String status;
    @SerializedName("value")
    private String value;

    @SerializedName("message")
    private String message;

    public void Rooms(){



    }

    public Rooms(String room_short_code, String room_short_key, String room_name, String room_type_id, String room_bed_type_id, String room_phone_number, String room_key_card_alias, String room_is_smoking, String room_is_pay_master, String room_paymaster_inventory, String room_is_voucher, String room_template_id, String room_as, String room_suite_name, String room_description, String room_image_link, String is_dirty, String status) {
        this.room_short_code = room_short_code;
        this.room_short_key = room_short_key;
        this.room_name = room_name;
        this.room_type_id = room_type_id;
        this.room_bed_type_id = room_bed_type_id;
        this.room_phone_number = room_phone_number;
        this.room_key_card_alias = room_key_card_alias;
        this.room_is_smoking = room_is_smoking;
        this.room_is_pay_master = room_is_pay_master;
        this.room_paymaster_inventory = room_paymaster_inventory;
        this.room_is_voucher = room_is_voucher;
        this.room_template_id = room_template_id;
        this.room_as = room_as;
        this.room_suite_name = room_suite_name;
        this.room_description = room_description;
        this.room_image_link = room_image_link;
        this.is_dirty = is_dirty;
        this.status = status;
    }

    public String getRoom_short_code() {
        return room_short_code;
    }

    public void setRoom_short_code(String room_short_code) {
        this.room_short_code = room_short_code;
    }

    public String getRoom_short_key() {
        return room_short_key;
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

    public void setRoom_short_key(String room_short_key) {
        this.room_short_key = room_short_key;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(String room_type_id) {
        this.room_type_id = room_type_id;
    }

    public String getRoom_bed_type_id() {
        return room_bed_type_id;
    }

    public void setRoom_bed_type_id(String room_bed_type_id) {
        this.room_bed_type_id = room_bed_type_id;
    }

    public String getRoom_phone_number() {
        return room_phone_number;
    }

    public void setRoom_phone_number(String room_phone_number) {
        this.room_phone_number = room_phone_number;
    }

    public String getRoom_key_card_alias() {
        return room_key_card_alias;
    }

    public void setRoom_key_card_alias(String room_key_card_alias) {
        this.room_key_card_alias = room_key_card_alias;
    }

    public String getRoom_is_smoking() {
        return room_is_smoking;
    }

    public void setRoom_is_smoking(String room_is_smoking) {
        this.room_is_smoking = room_is_smoking;
    }

    public String getRoom_is_pay_master() {
        return room_is_pay_master;
    }

    public void setRoom_is_pay_master(String room_is_pay_master) {
        this.room_is_pay_master = room_is_pay_master;
    }

    public String getRoom_paymaster_inventory() {
        return room_paymaster_inventory;
    }

    public void setRoom_paymaster_inventory(String room_paymaster_inventory) {
        this.room_paymaster_inventory = room_paymaster_inventory;
    }

    public String getRoom_is_voucher() {
        return room_is_voucher;
    }

    public void setRoom_is_voucher(String room_is_voucher) {
        this.room_is_voucher = room_is_voucher;
    }

    public String getRoom_template_id() {
        return room_template_id;
    }

    public void setRoom_template_id(String room_template_id) {
        this.room_template_id = room_template_id;
    }

    public String getRoom_as() {
        return room_as;
    }

    public void setRoom_as(String room_as) {
        this.room_as = room_as;
    }

    public String getRoom_suite_name() {
        return room_suite_name;
    }

    public void setRoom_suite_name(String room_suite_name) {
        this.room_suite_name = room_suite_name;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    public String getRoom_image_link() {
        return room_image_link;
    }

    public void setRoom_image_link(String room_image_link) {
        this.room_image_link = room_image_link;
    }

    public String getIs_dirty() {
        return is_dirty;
    }

    public void setIs_dirty(String is_dirty) {
        this.is_dirty = is_dirty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
