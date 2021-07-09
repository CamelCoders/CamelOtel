package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio;

import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FolioApiInterface {

    @POST("booking/getFolio.php")
    Call<List<Folio>> getFolio();

    @FormUrlEncoded
    @POST("booking/addFolio.php")
    Call<StayInformation> addFolio(
            @Field("guestId") String guestId,
            @Field("comment") String comment,
            @Field("creditdebit") String creditdebit,
            @Field("rateplan") String rateplan,
            @Field("foliobillingid") String foliobillingid,
            @Field("bookingid") String bookingid,
            @Field("amount") String amount,
            @Field("date") String date,
            @Field("id") String id
    );






}
