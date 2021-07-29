package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    public boolean expanded = false;
    public boolean parent = false;


    @SerializedName("id")
    private int id;
    @SerializedName("salutation")
    private String salutation;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("midName")
    private String midName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("address")
    private String address;
    @SerializedName("state")
    private String state;

    @SerializedName("city")
    private String city;
    @SerializedName("zipode")
    private String zipode;
    @SerializedName("country")
    private String country;
    @SerializedName("nationality")
    private String nationality;
    @SerializedName("vipstatus")
    private String vipstatus;


    @SerializedName("email")
    private String email;


    @SerializedName("number")
    private String number;


    @SerializedName("fax")
    private String fax;


    @SerializedName("GENDER")
    private String GENDER;


    @SerializedName("idType")
    private String idType;

    @SerializedName("idNumber")
    private String idNumber;


    @SerializedName("date")
    private String date;

    @SerializedName("guestid")
    private String guestid;





    @SerializedName("message")
    private String massage;
    @SerializedName("value")
    private String value;

    List<Guest> guest=new ArrayList<>();

    public Guest() {

    }

    public Guest(int id, String salutation, String firstName, String midName, String lastName, String address, String state, String city, String zipode, String country, String nationality, String vipstatus, String email, String number, String fax, String GENDER, String idType, String idNumber, String date, String guestid) {
        this.id = id;
        this.salutation = salutation;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipode = zipode;
        this.country = country;
        this.nationality = nationality;
        this.vipstatus = vipstatus;
        this.email = email;
        this.number = number;
        this.fax = fax;
        this.GENDER = GENDER;
        this.idType = idType;
        this.idNumber = idNumber;
        this.date = date;
        this.guestid = guestid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipode() {
        return zipode;
    }

    public void setZipode(String zipode) {
        this.zipode = zipode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getVipstatus() {
        return vipstatus;
    }

    public void setVipstatus(String vipstatus) {
        this.vipstatus = vipstatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getGENDER() {
        return GENDER;
    }

    public void setGENDER(String GENDER) {
        this.GENDER = GENDER;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
}