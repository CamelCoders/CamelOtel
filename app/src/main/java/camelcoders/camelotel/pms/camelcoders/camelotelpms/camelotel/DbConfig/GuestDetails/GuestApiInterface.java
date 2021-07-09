package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface GuestApiInterface {

    @POST("GuestCrud/GetGuestList.php")
    Call<List<Guest>> getGuest();
    @POST("GuestCrud/GetGuestList.php")
    Call<List<Guest>> getGuest(

            @Field("guestid") String guestid

    );


    @POST("GuestCrud/DeleteGuest.php")
    Call<List<Guest>> deleteGuest(
            @Field("guestid") String guestid
    );

    @FormUrlEncoded
    @POST("GuestCrud/UpdateGuest.php")
    Call<Guest> updateGuest(
            @Field("guestid") String guestid,
            @Field("salutation") String salutation,
            @Field("firstName") String firstName,
            @Field("middleName") String middleName,
            @Field("lastName") String lastName,
            @Field("zipode") String zipode,
            @Field("city") String city,
            @Field("state") String state,
            @Field("country") String country,
            @Field("address") String address,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("idType") String idType,
            @Field("idNumber") String idNumber,
            @Field("nationality") String nationality,
            @Field("vipstatus") String vipstatus,
            @Field("GENDER") String GENDER);


    @FormUrlEncoded
    @POST("GuestCrud/InsertGuest.php")
    Call<Guest> insertGuest(
            @Field("guestid") String guestid,
            @Field("salutation") String salutation,
            @Field("firstName") String firstName,
            @Field("middleName") String middleName,
            @Field("lastName") String lastName,
            @Field("zipode") String zipode,
            @Field("city") String city,
            @Field("state") String state,
            @Field("country") String country,
            @Field("address") String address,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("idType") String idType,
            @Field("idNumber") String idNumber,
            @Field("nationality") String nationality,
            @Field("date") String date,
            @Field("vipstatus") String vipstatus,
            @Field("GENDER") String GENDER);
}