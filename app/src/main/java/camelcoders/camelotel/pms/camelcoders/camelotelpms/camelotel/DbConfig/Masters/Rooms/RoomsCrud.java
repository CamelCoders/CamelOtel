package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms;

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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RoomNumberAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.Rooms;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomsCrud{
    public RoomsApiInterface apiInterface = ApiClient.getApiClient().create(RoomsApiInterface.class);
    public  static RoomNumberAdapter roomTypeAdapter;
    public static List<Rooms> Roomss=new ArrayList<>();

    public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;
    public   void getRooms(Context context, RecyclerView recyclerView, EditText editText) {

        Call<List<Rooms>> call = apiInterface.getRoom();
        call.enqueue(new Callback<List<Rooms>>() {
            @Override
            public void onResponse(Call<List<Rooms>> call, Response<List<Rooms>> response) {
                Roomss = response.body();
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
                roomTypeAdapter = new RoomNumberAdapter(context, Roomss, editText);
                recyclerView.setAdapter(roomTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<Rooms>> call, Throwable t) {
            }
        });

    }
    public void getRoomList(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        Call<List<Rooms>> call = apiInterface.getRoom();
        call.enqueue(new Callback<List<Rooms>>() {
            @Override
            public void onResponse(Call<List<Rooms>> call, Response<List<Rooms>> response) {
                Roomss = response.body();
                for (int i=0;i<Roomss.size();i++){
                    masterListModals.add(new MasterListModal(Roomss.get(i).getRoom_short_code(),
                            Roomss.get(i).getRoom_name(),
                            Roomss.get(i).getRoom_as(),Roomss.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<Rooms>> call, Throwable t) {
            }
        });
    }


}