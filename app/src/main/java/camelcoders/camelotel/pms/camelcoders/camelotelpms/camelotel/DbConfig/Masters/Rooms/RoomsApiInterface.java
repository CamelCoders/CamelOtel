package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms;

import java.util.List;

 import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by haerul on 15/03/18.
 */

public interface RoomsApiInterface {


    @POST("room/getRooms.php")
    Call<List<Rooms>> getRoom();

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



}
