package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType;

import android.content.Context;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MasterCodeViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RateTypeAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType.RateType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RateTypeCrud{
    public RateTypeApiInterface apiInterface = ApiClient.getApiClient().create(RateTypeApiInterface.class);
    public  static RateTypeAdapter roomTypeAdapter;
    public static List<RateType> RateTypes=new ArrayList<>();

    public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;
    public   void getRateType(Context context, RecyclerView recyclerView, EditText editText) {

        Call<List<RateType>> call = apiInterface.getRateType();
        call.enqueue(new Callback<List<RateType>>() {
            @Override
            public void onResponse(Call<List<RateType>> call, Response<List<RateType>> response) {
                RateTypes = response.body();
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
                roomTypeAdapter = new RateTypeAdapter(context, RateTypes, editText);
                recyclerView.setAdapter(roomTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<RateType>> call, Throwable t) {
            }
        });

    }

    public void getRateTypeList(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        Call<List<RateType>> call = apiInterface.getRateType();
        call.enqueue(new Callback<List<RateType>>() {
            @Override
            public void onResponse(Call<List<RateType>> call, Response<List<RateType>> response) {
                RateTypes = response.body();
                for (int i=0;i<RateTypes.size();i++){
                    masterListModals.add(new MasterListModal(RateTypes.get(i).getShortcode(),
                            RateTypes.get(i).getRatetypename(),
                            RateTypes.get(i).getStatus(),RateTypes.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<RateType>> call, Throwable t) {
            }
        });
    }

}