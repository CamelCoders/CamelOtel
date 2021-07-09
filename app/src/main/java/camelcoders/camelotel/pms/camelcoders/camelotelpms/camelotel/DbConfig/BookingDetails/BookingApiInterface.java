package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails;

import java.util.List;

 import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface BookingApiInterface {


    @POST("booking/getBooking.php")
    Call<List<Booking>> getBookings();

    @FormUrlEncoded
    @POST("booking/booking.php")
    Call<Booking> insertBooking(
            @Field("billingid") String billingid,
            @Field("pholio") String pholio,
            @Field("guestid") String guestid,
            @Field("date") String date,
            @Field("statusBooking") String statusBooking,
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
            @Field("GENDER") String GENDER,
            //stay

            @Field("staylist[]") String[] staylist,

            @Field("reservationtype") String reservationtype,
            @Field("noofrooms") String noofrooms,
            @Field("rate") String rate,
            @Field("amount") String amount,


            @Field("rates") String rates,
            @Field("billto") String billto,
            @Field("billtaxexeid") String billtaxexeid,
            @Field("paymode") String paymode,
            @Field("paymode2") String paymode2,
            @Field("releasedate") String releasedate,
            @Field("term") String term,

            //others

            @Field("rescompanyname") String rescompanyname,
            @Field("resbusinesssource") String resbusinesssource,
            @Field("resmarket") String resmarket,
            @Field("restravelagentname") String restravelagentname,
            @Field("ressalesperson") String ressalesperson,
            @Field("rescomplan") String rescomplan,
            @Field("resvalue") String resvalue,
            @Field("resvocno") String resvocno,
            @Field("resdiscounttype") String resdiscounttype,
            @Field("resdiscountrule") String resdiscountrule,
            @Field("respaymenttype") String respaymenttype,
            @Field("cuurencyT") String cuurencyT,
            @Field("priceDeposit") String priceDeposit,
            @Field("resvouchernumber") String resvouchernumber);

}