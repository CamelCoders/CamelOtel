package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RatePlanApiInterface {



    @POST("RoomOperations/getRooms.php")
    Call<List<RatePlan>> getRatePlan();


}
