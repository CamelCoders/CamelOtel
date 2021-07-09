package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MasterCodeViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType.IdentityType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType.IdentityTypeApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IdentityTypeCrud{

    public IdentityTypeApiInterface apiInterface = ApiClient.getApiClient().create(IdentityTypeApiInterface.class);

    public List<IdentityType> IdentityTypeList = new ArrayList<>();
    public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;

    public void getIdentityType(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        IdentityTypeList.clear();
        Call<List<IdentityType>> call = apiInterface.getIdentityType();
        call.enqueue(new Callback<List<IdentityType>>() {
            @Override
            public void onResponse(Call<List<IdentityType>> call, Response<List<IdentityType>> response) {
                IdentityTypeList = response.body();
                for (int i=0;i<IdentityTypeList.size();i++){
                    masterListModals.add(new MasterListModal(IdentityTypeList.get(i).getShortcode(),
                            IdentityTypeList.get(i).getIdentitytypename(),
                            IdentityTypeList.get(i).getCreateddate(),IdentityTypeList.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<IdentityType>> call, Throwable t) {
            }
        });
    }

}