package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.FolioPlan;

import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.Folio;
import retrofit2.Call;
import retrofit2.http.POST;

public interface FolioAPiInterFace {


    @POST("Folio/getFolioPlanType.php")
    Call<List<FolioPlan>> getFolioPlan();
}
