package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.GuestStatus;

import com.google.gson.annotations.SerializedName;

public class GuestStatus {

    @SerializedName("id")
    private int id;
    @SerializedName("statusName")
    private String statusName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
