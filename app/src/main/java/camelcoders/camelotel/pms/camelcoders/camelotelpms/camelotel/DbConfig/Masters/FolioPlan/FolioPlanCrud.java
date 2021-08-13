package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.FolioPlan;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.FolioPlanAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.FolioPlanAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MisclleneousReservationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.MisclleniousModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FolioPlanCrud {

    List<MisclleniousModel> misclleniousModels=new ArrayList<>();
    MisclleneousReservationAdapter misclleneousReservationAdapter;
List<FolioPlan> folioPlanList=new ArrayList<>();
    public FolioAPiInterFace folioAPiInterFace = ApiClient.getApiClient().create(FolioAPiInterFace.class);

 public void getFolioMaster(Context context, RecyclerView recyclerView, EditText editText,String masterFolio) {

        Call<List<FolioPlan>> call = folioAPiInterFace.getFolioPlan();
        call.enqueue(new Callback<List<FolioPlan>>() {
            @Override
            public void onResponse(Call<List<FolioPlan>> call, Response<List<FolioPlan>> response) {
                folioPlanList = response.body();

                for (int i=0;i<folioPlanList.size();i++){

                    if (!folioPlanList.get(i).getMasterType().equals(masterFolio)){
                        folioPlanList.remove(i);
                    }
                }
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
                FolioPlanAdapter  folioPlanAdapter= new FolioPlanAdapter(context, folioPlanList,editText,recyclerView);
                recyclerView.setAdapter(folioPlanAdapter);

            }
            @Override
            public void onFailure(Call<List<FolioPlan>> call, Throwable t) {
                Log.e(":df",""+t.getMessage());

            }
        });
}
 public void folioType(Context context, RecyclerView recyclerView, EditText editText, EditText editText1) {

        misclleniousModels.clear();

        misclleniousModels.add(new MisclleniousModel("Adustment"));
        misclleniousModels.add(new MisclleniousModel("Room Charges"));
        misclleniousModels.add(new MisclleniousModel("Bank"));
        misclleniousModels.add(new MisclleniousModel("Cash"));
        misclleniousModels.add(new MisclleniousModel("City Ledger"));
        misclleniousModels.add(new MisclleniousModel("Discount"));
        misclleniousModels.add(new MisclleniousModel("Extra Charges"));
        misclleniousModels.add(new MisclleniousModel("Transfer"));
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, misclleniousModels, editText,editText1);
        recyclerView.setAdapter(misclleneousReservationAdapter);

    }


    public void setGuestIdsFOlio(Context context, RecyclerView recyclerView, String[] guestList,EditText editText, EditText editText1) {

        misclleniousModels.clear();
        for (int i=0;i<guestList.length;i++){
            misclleniousModels.add(new MisclleniousModel(guestList[i]));

        }


        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, misclleniousModels, editText,editText1);
        recyclerView.setAdapter(misclleneousReservationAdapter);

    }

}
