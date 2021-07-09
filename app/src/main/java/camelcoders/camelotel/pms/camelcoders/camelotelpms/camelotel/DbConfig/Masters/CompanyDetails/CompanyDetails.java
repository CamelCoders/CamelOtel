package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.CompanyDetails;

import com.google.gson.annotations.SerializedName;

public class CompanyDetails {

    @SerializedName("id")
    private int id;
    @SerializedName("companyName")
    private String companyName;
    @SerializedName("companyContactPerson")
    private String companyContactPerson;
    @SerializedName("comanycode")
    private String comanycode;
    @SerializedName("pincode")
    private String pincode;
    @SerializedName("city")
    private String city;
    @SerializedName("fulladdress")
    private String fulladdress;

    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
    @SerializedName("mobile")
    private String mobile;


    @SerializedName("taxid")
    private String taxid;


    @SerializedName("gstno")
    private String gstno;


    @SerializedName("openingbalance")
    private String openingbalance;


    @SerializedName("creditbalance")
    private String creditbalance;


    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;

    public CompanyDetails() {

    }


    public int getId() {
        return id;
    }

    public CompanyDetails(int id, String companyName, String companyContactPerson, String comanycode, String pincode, String city, String fulladdress, String state, String country, String email, String phone, String mobile, String taxid, String gstno, String openingbalance, String creditbalance, String status, String massage, String value) {
        this.id = id;
        this.companyName = companyName;
        this.companyContactPerson = companyContactPerson;
        this.comanycode = comanycode;
        this.pincode = pincode;
        this.city = city;
        this.fulladdress = fulladdress;
        this.state = state;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.taxid = taxid;
        this.gstno = gstno;
        this.openingbalance = openingbalance;
        this.creditbalance = creditbalance;
        this.status = status;
        this.massage = massage;
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyContactPerson() {
        return companyContactPerson;
    }

    public void setCompanyContactPerson(String companyContactPerson) {
        this.companyContactPerson = companyContactPerson;
    }

    public String getComanycode() {
        return comanycode;
    }

    public void setComanycode(String comanycode) {
        this.comanycode = comanycode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFulladdress() {
        return fulladdress;
    }

    public void setFulladdress(String fulladdress) {
        this.fulladdress = fulladdress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTaxid() {
        return taxid;
    }

    public void setTaxid(String taxid) {
        this.taxid = taxid;
    }

    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
    }

    public String getOpeningbalance() {
        return openingbalance;
    }

    public void setOpeningbalance(String openingbalance) {
        this.openingbalance = openingbalance;
    }

    public String getCreditbalance() {
        return creditbalance;
    }

    public void setCreditbalance(String creditbalance) {
        this.creditbalance = creditbalance;
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
