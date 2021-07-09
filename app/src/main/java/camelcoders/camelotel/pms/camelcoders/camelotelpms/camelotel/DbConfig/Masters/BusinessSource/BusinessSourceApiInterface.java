package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource;

import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource.BusinessSource;
import retrofit2.Call;
import retrofit2.http.POST;

public interface BusinessSourceApiInterface {

    @POST("getMasters/getBusinessSource.php")
    Call<List<BusinessSource>> getBusinessSource();



}