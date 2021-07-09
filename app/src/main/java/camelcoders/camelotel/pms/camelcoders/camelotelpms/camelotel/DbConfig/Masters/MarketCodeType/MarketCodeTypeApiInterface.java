package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.MarketCodeType;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MarketCodeTypeApiInterface {

    @POST("getMasters/getMarketType.php")
    Call<List<MarketCodeType>> getMarketCode();


}
