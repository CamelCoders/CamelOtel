package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models;

public class FolioDetailsItem {
    String chargesCategoryText, refNoText, dateText, roomNo,
            voucherNoText, posUserName, outletText, chargesCategory, folioCharges, adminText;

    public FolioDetailsItem(String chargesCategoryText, String refNoText, String dateText, String roomNo, String voucherNoText, String posUserName, String outletText, String chargesCategory, String folioCharges, String adminText) {
        this.chargesCategoryText = chargesCategoryText;
        this.refNoText = refNoText;
        this.dateText = "dateText";
        this.roomNo = roomNo;
        this.voucherNoText = voucherNoText;
        this.posUserName = posUserName;
        this.outletText = outletText;
        this.chargesCategory = chargesCategory;
        this.folioCharges = folioCharges;
        this.adminText = adminText;
    }

    public String getChargesCategoryText() {
        return chargesCategoryText;
    }

    public void setChargesCategoryText(String chargesCategoryText) {
        this.chargesCategoryText = chargesCategoryText;
    }

    public String getRefNoText() {
        return refNoText;
    }

    public void setRefNoText(String refNoText) {
        this.refNoText = refNoText;
    }

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getVoucherNoText() {
        return voucherNoText;
    }

    public void setVoucherNoText(String voucherNoText) {
        this.voucherNoText = voucherNoText;
    }

    public String getPosUserName() {
        return posUserName;
    }

    public void setPosUserName(String posUserName) {
        this.posUserName = posUserName;
    }

    public String getOutletText() {
        return outletText;
    }

    public void setOutletText(String outletText) {
        this.outletText = outletText;
    }

    public String getChargesCategory() {
        return chargesCategory;
    }

    public void setChargesCategory(String chargesCategory) {
        this.chargesCategory = chargesCategory;
    }

    public String getFolioCharges() {
        return folioCharges;
    }

    public void setFolioCharges(String folioCharges) {
        this.folioCharges = folioCharges;
    }

    public String getAdminText() {
        return adminText;
    }

    public void setAdminText(String adminText) {
        this.adminText = adminText;
    }
}
