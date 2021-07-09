package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by haerul on 15/03/18.
 */

public interface SalutationsApiInterface {

    @POST("getMasters/getSalutation.php")
    Call<List<Salutations>> getSalutations();





}
