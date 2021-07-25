package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models;

public class SharereInformationListModel {
    public boolean expanded = false;
    public boolean parent = false;

    String sharerName, sharerCountry, registrationCardNoText,
            guestName, guestEmailId, guestPhone, identityCategory, identityNumber,
            arrivalText, nightText, departuteText, adultText, roomCatText, ratetypeText,
            tarrifText, taxText, discountText, adjustmentText, netAmountText;


    public SharereInformationListModel(String sharerName, String sharerCountry, String registrationCardNoText, String guestName, String guestEmailId, String guestPhone, String identityCategory, String identityNumber, String arrivalText, String nightText, String departuteText, String adultText, String roomCatText, String ratetypeText, String tarrifText, String taxText, String discountText, String adjustmentText, String netAmountText) {
        this.sharerName = sharerName;
        this.sharerCountry = sharerCountry;
        this.registrationCardNoText = registrationCardNoText;
        this.guestName = guestName;
        this.guestEmailId = guestEmailId;
        this.guestPhone = guestPhone;
        this.identityCategory = identityCategory;
        this.identityNumber = identityNumber;
        this.arrivalText = arrivalText;
        this.nightText = nightText;
        this.departuteText = departuteText;
        this.adultText = adultText;
        this.roomCatText = roomCatText;
        this.ratetypeText = ratetypeText;
        this.tarrifText = tarrifText;
        this.taxText = taxText;
        this.discountText = discountText;
        this.adjustmentText = adjustmentText;
        this.netAmountText = netAmountText;
    }

    public String getSharerName() {
        return sharerName;
    }

    public void setSharerName(String sharerName) {
        this.sharerName = sharerName;
    }

    public String getIdentityCategory() {
        return identityCategory;
    }

    public void setIdentityCategory(String identityCategory) {
        this.identityCategory = identityCategory;
    }

    public String getSharerCountry() {
        return sharerCountry;
    }

    public void setSharerCountry(String sharerCountry) {
        this.sharerCountry = sharerCountry;
    }

    public String getRegistrationCardNoText() {
        return registrationCardNoText;
    }

    public void setRegistrationCardNoText(String registrationCardNoText) {
        this.registrationCardNoText = registrationCardNoText;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmailId() {
        return guestEmailId;
    }

    public void setGuestEmailId(String guestEmailId) {
        this.guestEmailId = guestEmailId;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getArrivalText() {
        return arrivalText;
    }

    public void setArrivalText(String arrivalText) {
        this.arrivalText = arrivalText;
    }

    public String getNightText() {
        return nightText;
    }

    public void setNightText(String nightText) {
        this.nightText = nightText;
    }

    public String getDepartuteText() {
        return departuteText;
    }

    public void setDepartuteText(String departuteText) {
        this.departuteText = departuteText;
    }

    public String getAdultText() {
        return adultText;
    }

    public void setAdultText(String adultText) {
        this.adultText = adultText;
    }

    public String getRoomCatText() {
        return roomCatText;
    }

    public void setRoomCatText(String roomCatText) {
        this.roomCatText = roomCatText;
    }

    public String getRatetypeText() {
        return ratetypeText;
    }

    public void setRatetypeText(String ratetypeText) {
        this.ratetypeText = ratetypeText;
    }

    public String getTarrifText() {
        return tarrifText;
    }

    public void setTarrifText(String tarrifText) {
        this.tarrifText = tarrifText;
    }

    public String getTaxText() {
        return taxText;
    }

    public void setTaxText(String taxText) {
        this.taxText = taxText;
    }

    public String getDiscountText() {
        return discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

    public String getAdjustmentText() {
        return adjustmentText;
    }

    public void setAdjustmentText(String adjustmentText) {
        this.adjustmentText = adjustmentText;
    }

    public String getNetAmountText() {
        return netAmountText;
    }

    public void setNetAmountText(String netAmountText) {
        this.netAmountText = netAmountText;
    }
}
