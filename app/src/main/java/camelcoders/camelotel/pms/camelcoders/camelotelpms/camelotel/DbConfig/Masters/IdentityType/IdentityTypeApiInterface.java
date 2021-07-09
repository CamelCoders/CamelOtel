package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface IdentityTypeApiInterface{

        @POST("getMasters/getIdentityType.php")
        Call<List<IdentityType>> getIdentityType();



}