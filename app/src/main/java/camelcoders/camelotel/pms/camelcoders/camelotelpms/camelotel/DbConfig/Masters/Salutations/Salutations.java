package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations;

import com.google.gson.annotations.SerializedName;

public  class Salutations{
    @SerializedName("id")
    private int id;
    @SerializedName("salutationName")
    private String salutationName;
   public Salutations(){

   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalutationName() {
        return salutationName;
    }

    public void setSalutationName(String salutationName) {
        this.salutationName = salutationName;
    }
}