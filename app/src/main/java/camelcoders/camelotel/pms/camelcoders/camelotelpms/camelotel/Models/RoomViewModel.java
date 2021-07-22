package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models;

public class RoomViewModel {
    private String roomCat;
    private String roomNumber;
    private String guestName;
    private String color;
    private boolean isSmoking;
    private boolean isDirty;
    private boolean isMeal;
    private boolean isVip;

    public RoomViewModel(String roomCat, String roomNumber, String guestName, String color, boolean isSmoking, boolean isDirty, boolean isMeal, boolean isVip) {
        this.roomCat = roomCat;
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.color = color;
        this.isSmoking = isSmoking;
        this.isDirty = isDirty;
        this.isMeal = isMeal;
        this.isVip = isVip;
    }

    public String getRoomCat() {
        return roomCat;
    }

    public void setRoomCat(String roomCat) {
        this.roomCat = roomCat;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isSmoking() {
        return isSmoking;
    }

    public void setSmoking(boolean smoking) {
        isSmoking = smoking;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    public boolean isMeal() {
        return isMeal;
    }

    public void setMeal(boolean meal) {
        isMeal = meal;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}
