package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource;

import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface BookingSourceApiInterface {

    @POST("BookingSourceCrud/getBookingSource.php")
    Call<List<BokkingSource>> getBookinSourceList();


    @FormUrlEncoded
    @POST("BookingSourceCrud/InsertBusinessSource.php")
    Call<BokkingSource> insertBookingSource(
            @Field("shortcode") String shortcode,
            @Field("bookingtypename") String bookingtypename,
            @Field("status") String status,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modifydate") String modifydate);
}