package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.SalutationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalutationsCrud{

    public SalutationsApiInterface apiInterface = ApiClient.getApiClient().create(SalutationsApiInterface.class);
  public List<Salutations> SalutationsList = new ArrayList<>();


    public void getSalutations(Context context, RecyclerView recyclerView, EditText editText,EditText guestNAme) {
        SalutationsList.clear();
        Call<List<Salutations>> call = apiInterface.getSalutations();
        call.enqueue(new Callback<List<Salutations>>() {
            @Override
            public void onResponse(Call<List<Salutations>> call, Response<List<Salutations>> response) {
                SalutationsList = response.body();
                Log.e("",""+SalutationsList.size());
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);

                SalutationAdapter SalutationsAdapter = new SalutationAdapter(context, SalutationsList,editText,guestNAme,recyclerView);
                recyclerView.setAdapter(SalutationsAdapter);
            }

            @Override
            public void onFailure(Call<List<Salutations>> call, Throwable t) {
            }
        });
    }
//
}