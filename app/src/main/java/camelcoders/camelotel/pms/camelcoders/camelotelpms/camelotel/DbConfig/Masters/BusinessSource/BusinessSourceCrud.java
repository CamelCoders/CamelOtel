package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MasterCodeViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource.BusinessSource;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource.BusinessSourceApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BusinessSourceCrud{

    public BusinessSourceApiInterface apiInterface = ApiClient.getApiClient().create(BusinessSourceApiInterface.class);

    public List<BusinessSource> BusinessSourceList = new ArrayList<>();
    public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;

    public void getBusinessSource(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        BusinessSourceList.clear();
        Call<List<BusinessSource>> call = apiInterface.getBusinessSource();
        call.enqueue(new Callback<List<BusinessSource>>() {
            @Override
            public void onResponse(Call<List<BusinessSource>> call, Response<List<BusinessSource>> response) {
                BusinessSourceList = response.body();
                for (int i=0;i<BusinessSourceList.size();i++){
                    masterListModals.add(new MasterListModal(BusinessSourceList.get(i).getShortcode(),
                            BusinessSourceList.get(i).getBusinesstypename(),
                            BusinessSourceList.get(i).getCreateddate(),BusinessSourceList.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<BusinessSource>> call, Throwable t) {
            }
        });
    }



}