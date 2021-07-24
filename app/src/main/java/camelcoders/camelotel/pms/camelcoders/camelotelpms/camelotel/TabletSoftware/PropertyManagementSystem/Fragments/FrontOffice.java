package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.BookingAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RoomNumberAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RoomViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Booking;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.BookingApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.Rooms;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.RoomViewModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentFrontOfficeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FrontOffice extends Fragment {
    private final ArrayList<RoomViewModel> roomViewModelArrayList = new ArrayList<>();
    private RoomViewAdapter roomViewAdapter;
    private FragmentFrontOfficeBinding binding;
    public RoomsApiInterface roomsApiInterface = ApiClient.getApiClient().create(RoomsApiInterface.class);
     public static List<Rooms> Roomss=new ArrayList<>();
    public BookingApiInterface apiInterface = ApiClient.getApiClient().create(BookingApiInterface.class);
    Calendar calendar=Calendar.getInstance();
    SimpleDateFormat simpleDateFormat;
    List<Booking> bookingList=new ArrayList<>();
    List<StayInformation> stayInformationList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_front_office, container, false);
//        return view;
        binding = FragmentFrontOfficeBinding.inflate(inflater, container, false);
        simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        getRooms();
        //Load the date from the network or other resources
//        //into the array list asynchronously
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, true));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "102", "Mr. Camelotel", "occupied", true, false, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "103", "Mr. Camelotel", "available", true, true, false, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "104", "Mr. Camelotel", "occupied", true, false, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "105", "Mr. Camelotel", "available", true, true, false, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "106", "Mr. Camelotel", "available", true, false, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "", "maintenance", true, true, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, false, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "occupied", true, false, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, false, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "occupied", true, false, true, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
//        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, false, true, false));
//        roomViewAdapter.notifyDataSetChanged();
        return binding.getRoot();
    }

    public void getStayInformation() {
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();


                for (int i=0;i<stayInformationList.size();i++){
                    if (!(stayInformationList.get(i).getCheckout().equals(simpleDateFormat.format(calendar.getTime()))
                            || stayInformationList.get(i).getCheckin().equals(simpleDateFormat.format(calendar.getTime())))
                    ){
                        stayInformationList.remove(i);
                    }
                }


                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
                layoutManager.setFlexDirection(FlexDirection.ROW);
                binding.roomViewRecycler.setLayoutManager(layoutManager);
//                roomViewAdapter = new RoomViewAdapter(stayInformationList,getContext());
//                 binding.roomViewRecycler.setAdapter(roomViewAdapter);
//

            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }
    public   void getRooms() {

        Call<List<Rooms>> call = roomsApiInterface.getRoom();
        call.enqueue(new Callback<List<Rooms>>() {
            @Override
            public void onResponse(Call<List<Rooms>> call, Response<List<Rooms>> response) {
                Roomss = response.body();
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
                layoutManager.setFlexDirection(FlexDirection.ROW);
                binding.roomViewRecycler.setLayoutManager(layoutManager);
                roomViewAdapter = new RoomViewAdapter(Roomss,getContext());
                binding.roomViewRecycler.setAdapter(roomViewAdapter);
//
}

            @Override
            public void onFailure(Call<List<Rooms>> call, Throwable t) {
            }
        });

    }

}