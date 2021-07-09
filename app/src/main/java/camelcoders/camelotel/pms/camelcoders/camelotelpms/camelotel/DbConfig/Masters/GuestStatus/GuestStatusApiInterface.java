package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.GuestStatus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GuestStatusApiInterface {


    @POST("getMasters/getGuestStatus.php")
    Call<List<GuestStatus>> getGuestStatus();



}
