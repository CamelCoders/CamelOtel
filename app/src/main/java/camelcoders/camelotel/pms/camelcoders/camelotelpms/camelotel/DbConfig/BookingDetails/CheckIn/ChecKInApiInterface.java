package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.CheckIn;

import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Booking;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ChecKInApiInterface {


    @FormUrlEncoded
    @POST("booking/GuestCheckIn.php")
    Call<StayInformation> checkInGuest(
            @Field("guestList[]") String[] guestList,
            @Field("guestIds") String guestIds,
            @Field("id") String ids
    );

    @FormUrlEncoded
    @POST("booking/CheckIn.php")
    Call<StayInformation> checkIn(
            @Field("guestId") String guestId,
            @Field("foliobillingid") String foliobillingid,
            @Field("bookingid") String bookingid,
            @Field("amount") String amount,
            @Field("date") String date,
            @Field("id") String id
    );


}