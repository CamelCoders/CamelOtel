package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by haerul on 15/03/18.
 */

public interface RoomsTypeApiInterface {

    @POST("room/getRoomType.php")
    Call<List<RoomsType>> getRoomType();



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
}