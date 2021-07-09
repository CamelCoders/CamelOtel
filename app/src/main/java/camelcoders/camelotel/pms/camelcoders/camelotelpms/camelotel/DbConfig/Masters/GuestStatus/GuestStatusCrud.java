package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.GuestStatus;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestStatusCrud {

//    public GuestStatusApiInterface apiInterface = ApiClient.getApiClient().create(GuestStatusApiInterface.class);
//
//    //Retrieve GuestStatus Function
//    public List<GuestStatus> GuestStatusList = new ArrayList<>();
//
//    public static GuestStausAdapter guestStausAdapter;
//    public void getGuestStatus(Context context, RecyclerView recyclerView) {
//        GuestStatusList.clear();
//        Call<List<GuestStatus>> call = apiInterface.getGuestStatus();
//        call.enqueue(new Callback<List<GuestStatus>>() {
//            @Override
//            public void onResponse(Call<List<GuestStatus>> call, Response<List<GuestStatus>> response) {
//                GuestStatusList = response.body();
//                 FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
//                layoutManager.setFlexDirection(FlexDirection.ROW);
//                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
//                recyclerView.setLayoutManager(layoutManager);
//                  guestStausAdapter = new GuestStausAdapter(context, GuestStatusList);
//                recyclerView.setAdapter(guestStausAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<GuestStatus>> call, Throwable t) {
//            }
//        });
//    }

}