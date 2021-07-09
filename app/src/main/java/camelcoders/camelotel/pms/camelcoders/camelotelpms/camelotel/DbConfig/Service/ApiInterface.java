package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service;

import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Booking;
 import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource.BokkingSource;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource.BusinessSource;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.CompanyDetails.CompanyDetails;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.GuestStatus.GuestStatus;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType.IdentityType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.MarketCodeType.MarketCodeType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.PaymentType.PaymentType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan.RatePlan;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType.RateType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.Rooms;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType.RoomsType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.SlabLlistModal;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("getMasters/getTaxSlab.php")
    Call<List<SlabLlistModal>> getTaxSlab();


    @FormUrlEncoded
    @POST("booking/CheckIn.php")
    Call<Booking> checkIn(
            @Field("guestList[]") String[] staylist,
            @Field("guestIds") String[] guestIds
  );

    @POST("room/getRoomType.php")
    Call<List<RoomsType>> getRoomType();

    @POST("getMasters/getTaxSlab.php")
    Call<List<SlabLlistModal >> getTaxSLb();


    @POST("room/getRooms.php")
    Call<List<Rooms>> getRoom();

    @POST("room/getRateType.php")
    Call<List<RateType>> getRateType();


    @POST("room/getRommPlan.php")
    Call<List<RatePlan>> getRatePlan();

    @POST("getMasters/getIdentityType.php")
    Call<List<IdentityType>> getIdentityType();


    @POST("getMasters/getBusinessSource.php")
    Call<List<BusinessSource>> getBusinesSource();


    @POST("getMasters/getMarketType.php")
    Call<List<MarketCodeType>> getMarketCode();

    @POST("getMasters/getPaymentType.php")
    Call<List<PaymentType>> getPaymentType();


    @POST("getMasters/getCompany.php")
    Call<List<CompanyDetails>> getCompany();



    @POST("booking/getBooking.php")
    Call<List<Booking>> getBookings();

    @POST("booking/getStayInformation.php")
    Call<List<StayInformation>> getStayInformation();

    @FormUrlEncoded
    @POST("room/ma_room_type.php")
    Call<RoomsType> insertRoomtype(
            @Field("shortcode") String shortcode,
            @Field("roomtypename") String roomtypename,
            @Field("baseadult") String baseadult,
            @Field("basechild") String basechild,
            @Field("maxchild") String maxchild,
            @Field("maxadult") String maxadult,
            @Field("defaultwebinventory") String defaultwebinventory,
            @Field("invenotrytobedisplayed") String invenotrytobedisplayed,
            @Field("maxrate") String maxrate,
            @Field("minrate") String minrate,
            @Field("img_path") String img_path,
            @Field("status") String status);






    @FormUrlEncoded
    @POST("ma_company.php")
    Call<CompanyDetails> insertCompany(
            @Field("companyName") String companyName,
            @Field("companyContactPerson") String companyContactPerson,
            @Field("comanycode") String comanycode,
            @Field("pincode") String pincode,
            @Field("city") String city,
            @Field("fulladdress") String fulladdress,
            @Field("state") String state,
            @Field("country") String country,
            @Field("email") String email,
            @Field("phone") String phone,
            @Field("mobile") String mobile,
            @Field("taxid") String taxid,
            @Field("gstno") String gstno,
            @Field("openingbalance") String openingbalance,
            @Field("status") String status,
            @Field("creditbalance") String creditbalance);





    @FormUrlEncoded
    @POST("ma_addroom.php")
    Call<Rooms> insertRoom(
            @Field("room_short_code") String room_short_code,
            @Field("room_short_key") String room_short_key,
            @Field("room_name") String room_name,
            @Field("room_type_id") String room_type_id,
            @Field("room_bed_type_id") String room_bed_type_id,
            @Field("room_phone_number") String room_phone_number,
            @Field("room_key_card_alias") String room_key_card_alias,
            @Field("room_is_smoking") String room_is_smoking,
            @Field("room_is_pay_master") String room_is_pay_master,
            @Field("room_paymaster_inventory") String room_paymaster_inventory,
            @Field("room_is_voucher") String room_is_voucher,
            @Field("room_template_id") String room_template_id,
            @Field("room_as") String room_as,
            @Field("room_suite_name") String room_suite_name,
            @Field("room_description") String room_description,
            @Field("room_image_link") String room_image_link,
            @Field("is_dirty") String is_dirty,
            @Field("status") String status);



    @FormUrlEncoded
    @POST("room/ma_rate_type.php")
    Call<RateType> insertRatetype(
            @Field("shortcode") String shortcode,
            @Field("ratetypename") String ratetypename,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modfieddate") String modfieddate,

            @Field("status") String status);




    @FormUrlEncoded
    @POST("Folio/insertFolioPlan.php")
    Call<RateType> insertFoliotype(
            @Field("type") String type,
            @Field("ratetypename") String ratetypename,
            @Field("masterType") String masterType,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modfieddate") String modfieddate,

            @Field("status") String status);


    @FormUrlEncoded
    @POST("ma_market_type.php")
    Call<MarketCodeType> insertMarketCode(
            @Field("marketcode") String marketcode,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modfieddate") String modfieddate,
            @Field("status") String status);





    @FormUrlEncoded
    @POST("ma_business_type.php")
    Call<BusinessSource> insertbusinesssource(
            @Field("shortcode") String shortcode,
            @Field("businesstypename") String businesstypename,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modfieddate") String modfieddate,
            @Field("status") String status);



    @FormUrlEncoded
    @POST("ma_identity_type.php")
    Call<IdentityType> insertidentitytype(
            @Field("shortcode") String shortcode,
            @Field("identitytypename") String identitytypename,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modfieddate") String modfieddate,
            @Field("status") String status);


    @FormUrlEncoded
    @POST("BookingSourceCrud/InsertBookingSource.php")
    Call<BokkingSource> insertbookingsource(
            @Field("shortcode") String shortcode,
            @Field("bookingtypename") String bookingtypename,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modfieddate") String modfieddate,
            @Field("status") String status);



    @FormUrlEncoded
    @POST("ma_pay_type.php")
    Call<PaymentType> insertPaymentType(
            @Field("shortcode") String shortcode,
            @Field("type") String type,
            @Field("consideras") String consideras,
            @Field("paytypename") String paytypename,
            @Field("createdbyuid") String createdbyuid,
            @Field("createddate") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modfieddate") String modfieddate,
            @Field("status") String status);
//
//
//
//
//
//    @FormUrlEncoded
//    @POST("ma_res_type.php")
//    Call<ReservationType> insertResType(
//            @Field("shortcode") String shortcode,
//            @Field("confirmedun") String confirmedun,
//            @Field("restypename") String restypename,
//            @Field("createdbyuid") String createdbyuid,
//            @Field("createddate") String createddate,
//            @Field("modifiedbyuid") String modifiedbyuid,
//            @Field("modfieddate") String modfieddate,
//            @Field("status") String status);






//    @FormUrlEncoded
//    @POST("ma_tax_type.php")
//    Call<Tax> insertTax(
//            @Field("shortname") String shortcode,
//            @Field("taxname") String taxname,
//            @Field("taxid") String taxid,
//            @Field("appliesfrom") String appliesfrom,
//            @Field("exemptafter") String exemptafter,
//            @Field("postingtype") String postingtype,
//            @Field("taxpercent") String taxpercent,
//            @Field("applytax") String applytax,
//            @Field("note") String note,
//            @Field("paxtype") String paxtype,
//            @Field("slablist[]") String[] sablist,
//            @Field("rackrate") String rackrate);
//
//


    @FormUrlEncoded
    @POST("room/ma_rate_plan.php")
    Call<RatePlan> insertRatePlan(

            @Field("shortcode") String shortcode,
            @Field("roomplanname") String roomplanname,
            @Field("roomplandesc") String roomplandesc,
            @Field("inclusion") String inclusion,
            @Field("roomtypeid") String roomtypeid,
            @Field("ratetypeid") String ratetypeid,
            @Field("baseadult") String baseadult,
            @Field("basechild") String basechild,
            @Field("maxchild") String maxchild,
            @Field("minnight") String minnight,
            @Field("maxadult") String maxadult,
            @Field("maxnight") String maxnight,
            @Field("maxnight") String createdbyuid,
            @Field("maxnight") String createddate,
            @Field("modifiedbyuid") String modifiedbyuid,
            @Field("modifydate") String modifydate,
            @Field("creterateplanas") String creterateplanas,
            @Field("singleOcc") String singleOcc,
            @Field("doubleOcc") String doubleOcc,
            @Field("extraadultrate") String extraadultrate,
            @Field("extrachildrate") String extrachildrate,
            @Field("associatedBusinessSource") String associatedBusinessSource,
            @Field("associatedCompany") String associatedCompany,
            @Field("maxoccup") String maxoccup,
            @Field("status") String status);


    @FormUrlEncoded
    @POST("booking/booking.php")
    Call<Booking> insertBooking(
            @Field("billingid") String billingid,
            @Field("pholio") String pholio,
            @Field("guestid") String guestid,
            @Field("date") String date,
            @Field("statusBooking") String statusBooking,


            @Field("salutation") String salutation,
            @Field("name") String name,
            @Field("address") String address,
            @Field("state") String state,
            @Field("city") String city,
            @Field("zipode") String zipode,
            @Field("country") String country,
            @Field("nationality") String 	nationality,
            @Field("vipstatus") String vipstatus,
            @Field("email") String 	email	,
            @Field("number") String 	number,
            @Field("phone") String phone,
            @Field("GENDER") String GENDER,
//stay

            @Field("rates") String rates,
            @Field("billto") String billto,
            @Field("istaxexemption") String istaxexemption,
            @Field("billtaxexeid") String billtaxexeid,
            @Field("paymode") String paymode,
            @Field("paymode2") String paymode2,
            @Field("releasedate") String 	releasedate,
            @Field("term") String term,

            //others

            @Field("rescompanyname") String 	rescompanyname,
            @Field("resbusinesssource") String 	resbusinesssource,
            @Field("resmarket") String 	resmarket,
            @Field("restravelagentname") String 	restravelagentname,
            @Field("ressalesperson") String 	ressalesperson,
            @Field("rescomplan") String 	rescomplan,
            @Field("resvalue") String 	resvalue,
            @Field("resvocno") String 	resvocno,
            @Field("resdiscounttype") String 	resdiscounttype,
            @Field("resdiscountrule") String 	resdiscountrule,
            @Field("respaymenttype") String 	respaymenttype,
            @Field("cuurencyT") String 	cuurencyT,
            @Field("priceDeposit") String 	priceDeposit,
            @Field("resvouchernumber") String 	resvouchernumber,




            //stay

            @Field("noofrooms") String 	noofrooms,
            @Field("roomtype") String 	roomtype,
            @Field("roomnumber") String 	roomnumber,
            @Field("roomratetype") String 	roomratetype,
            @Field("checkin") String 	checkin,
            @Field("checkintime") String 	checkintime,
            @Field("noofnight") String 	noofnight,
            @Field("checkout") String 		checkout,
            @Field("checkouttime") String 		checkouttime,
            @Field("noofdault") String 		noofdault	,
            @Field("noofchild") String 		noofchild,
            @Field("reservationtype") String 		reservationtype


    )


            ;


}
