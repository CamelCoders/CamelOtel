package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MasterCodeViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MisclleneousReservationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RoomTypeAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType.RoomsType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.MisclleniousModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomsTypeCrud {
    public static List<MisclleniousModel> noofroomslist = new ArrayList<>();
    public static int roomOccupancy = 0;
    public static RoomTypeAdapter roomTypeAdapter;
    public static List<RoomsType> roomsTypes = new ArrayList<>();
    public static MisclleneousReservationAdapter misclleneousReservationAdapter;
    public RoomsTypeApiInterface apiInterface = ApiClient.getApiClient().create(RoomsTypeApiInterface.class);

    public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;
    public   void getNoofAdult(Context context, RecyclerView recyclerView, EditText editText, String roomtype) {
        noofroomslist.clear();


        Call<List<RoomsType>> call = apiInterface.getRoomType();
        call.enqueue(new Callback<List<RoomsType>>() {
            @Override
            public void onResponse(Call<List<RoomsType>> call, Response<List<RoomsType>> response) {
                roomsTypes = response.body();
                int count = 0;
                int k = 1;
                for (int i = 0; i < roomsTypes.size(); i++)
                    if (roomsTypes.get(i).getRoomtypename().equals(roomtype))
                        count = Integer.parseInt(roomsTypes.get(i).getMaxadult());

                for (int i = 1; i <= count; i++) {
                    noofroomslist.add(new MisclleniousModel(String.valueOf(i)));

                }
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
                misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, noofroomslist, editText);
                recyclerView.setAdapter(misclleneousReservationAdapter);

            }

            @Override
            public void onFailure(Call<List<RoomsType>> call, Throwable t) {
            }
        });


    }

    public void getRoomsType( ) {


    }

    public void getNoofchild(Context context, RecyclerView recyclerView, EditText editText, String roomtype) {
        noofroomslist.clear();

        int count = 0;
        int k = 1;


        for (int i = 0; i < roomsTypes.size(); i++)
            if (roomsTypes.get(i).getRoomtypename().equals(roomtype))
                count = Integer.parseInt(roomsTypes.get(i).getMaxchild());

        for (int i = 0; i < count; i++) {
            noofroomslist.add(new MisclleniousModel(String.valueOf(i)));

        }

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, noofroomslist, editText);
        recyclerView.setAdapter(misclleneousReservationAdapter);

    }
    public void getRoomTypeList(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        Call<List<RoomsType>> call = apiInterface.getRoomType();
        call.enqueue(new Callback<List<RoomsType>>() {
            @Override
            public void onResponse(Call<List<RoomsType>> call, Response<List<RoomsType>> response) {
                roomsTypes = response.body();
                for (int i=0;i<roomsTypes.size();i++){
                    masterListModals.add(new MasterListModal(roomsTypes.get(i).getShortcode(),
                            roomsTypes.get(i).getRoomtypename(),
                            roomsTypes.get(i).getStatus(),roomsTypes.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<RoomsType>> call, Throwable t) {
            }
        });
    }


}