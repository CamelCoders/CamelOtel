package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface StayInformationApiInterface {

    @POST("booking/getStayInformation.php")
    Call<List<StayInformation>> getStayInfomation();

    @POST("booking/stayInfomationUpdate.php")
    Call<StayInformation> updateStayInfomation(
            @Field("staylist[]") String[] staylist,
            @Field("id") String id
            );



}