package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan;

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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RatePlanAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType.RateType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatePlanCrud {
    public RatePlanApiInterface apiInterface = ApiClient.getApiClient().create(RatePlanApiInterface.class);
    public static RatePlanAdapter ratePlanAdapter;
    public static List<RatePlan> ratePlanslist = new ArrayList<>();
    public static List<RatePlan> ratePlanslist1 = new ArrayList<>();

    public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;
    public void getRatePlanList(Context context, RecyclerView recyclerView, EditText editText, EditText editText2) {
            ratePlanslist1.clear();
        Call<List<RatePlan>> call = apiInterface.getRatePlan();
        call.enqueue(new Callback<List<RatePlan>>() {
            @Override
            public void onResponse(Call<List<RatePlan>> call, Response<List<RatePlan>> response) {
                ratePlanslist = response.body();
                ratePlanslist1=ratePlanslist;

                for (int i = 0; i < ratePlanslist.size(); i++) {
                    if (!(ratePlanslist.get(i).getRatetypeid().equals(editText2
                            .getText().toString()))) {
                        ratePlanslist1.remove(i);
                    }
                    if (!( ratePlanslist.get(i).getCreterateplanas().equals("Independent"))) {
                        ratePlanslist1.remove(i);
                    }

                }

                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
                ratePlanAdapter = new RatePlanAdapter(context, ratePlanslist1, editText);
                recyclerView.setAdapter(ratePlanAdapter);
            }

            @Override
            public void onFailure(Call<List<RatePlan>> call, Throwable t) {
            }
        });


    }



    public void getRatePlanSub(Context context, RecyclerView recyclerView, EditText editText, EditText editText2) {
        ratePlanslist1.clear();
        Call<List<RatePlan>> call = apiInterface.getRatePlan();
        call.enqueue(new Callback<List<RatePlan>>() {
            @Override
            public void onResponse(Call<List<RatePlan>> call, Response<List<RatePlan>> response) {
                ratePlanslist = response.body();

                    for (int i = 0; i < ratePlanslist.size(); i++) {

                        if (!(ratePlanslist.get(i).getCreterateplanas().equals(editText2.getText().toString())
                                || ratePlanslist.get(i).getRoomplanname().equals(editText2
                                .getText().toString()))) {


                            ratePlanslist.remove(i);


                        }
                        ratePlanslist1 = ratePlanslist;

                }

                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
                ratePlanAdapter = new RatePlanAdapter(context, ratePlanslist1, editText);
                recyclerView.setAdapter(ratePlanAdapter);
            }

            @Override
            public void onFailure(Call<List<RatePlan>> call, Throwable t) {

            }
        });


    }
    public void getRatePlanList(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        Call<List<RatePlan>> call = apiInterface.getRatePlan();
        call.enqueue(new Callback<List<RatePlan>>() {
            @Override
            public void onResponse(Call<List<RatePlan>> call, Response<List<RatePlan>> response) {
                ratePlanslist = response.body();
                for (int i=0;i<ratePlanslist.size();i++){
                    masterListModals.add(new MasterListModal(ratePlanslist.get(i).getShortcode(),
                            ratePlanslist.get(i).getRoomplanname(),
                            ratePlanslist.get(i).getStatus(),ratePlanslist.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<RatePlan>> call, Throwable t) {
            }
        });
    }

}