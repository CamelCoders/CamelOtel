package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.MarketCodeType;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MasterCodeViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketCodeTypeCrud {

    public MarketCodeTypeApiInterface apiInterface = ApiClient.getApiClient().create(MarketCodeTypeApiInterface.class);

     public List<MarketCodeType> MarketCodeTypeList = new ArrayList<>();
     public List<MasterListModal> masterListModals = new ArrayList<>();

    public static MasterCodeViewAdapter marketTypeAdapter;
    public void getMarketCodeType(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        MarketCodeTypeList.clear();
        Call<List<MarketCodeType>> call = apiInterface.getMarketCode();
        call.enqueue(new Callback<List<MarketCodeType>>() {
            @Override
            public void onResponse(Call<List<MarketCodeType>> call, Response<List<MarketCodeType>> response) {
                MarketCodeTypeList = response.body();
                for (int i=0;i<MarketCodeTypeList.size();i++){
                    masterListModals.add(new MasterListModal(MarketCodeTypeList.get(i).getShortcode(),
                            MarketCodeTypeList.get(i).getMarketcode(),
                            MarketCodeTypeList.get(i).getCreateddate(),MarketCodeTypeList.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<MarketCodeType>> call, Throwable t) {
            }
        });
    }

}