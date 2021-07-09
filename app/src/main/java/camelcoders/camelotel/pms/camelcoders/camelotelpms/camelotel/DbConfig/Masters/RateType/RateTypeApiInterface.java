package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;



public interface RateTypeApiInterface {


    @POST("room/getRateType.php")
    Call<List<RateType>> getRateType();

    @FormUrlEncoded
    @POST("room/ma_rate_plan.php")
    Call<RateType> insertRatePlan(

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

}