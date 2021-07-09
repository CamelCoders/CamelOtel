package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.PaymentType;

import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.PaymentType.PaymentType;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface PaymentTypeApiInterface {

    @POST("getMasters/getPaymentType.php")
    Call<List<PaymentType>> getPaymentType();



}