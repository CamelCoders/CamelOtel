package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Booking;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.BookingApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FrontOffice extends Fragment {
RecyclerView mainRecyclerView;
RecyclerView mainRecyclerView1;
BookingAdapter bookingAdapter;
StayInformationAdapter stayInformationAdapter;
    public BookingApiInterface apiInterface = ApiClient.getApiClient().create(BookingApiInterface.class);
Calendar calendar=Calendar.getInstance();
SimpleDateFormat simpleDateFormat;
List<Booking> bookingList=new ArrayList<>();
List<StayInformation> stayInformationList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_front_office, container, false);
        simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        mainRecyclerView=view.findViewById(R.id.mainRecyclerView);
    //    mainRecyclerView1=view.findViewById(R.id.mainRecyclerView1);

        getStayInformation();


        return view;
    }
    public   void getBooking() {

        Call<List<Booking>> call = apiInterface.getBookings();
        call.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
                bookingList = response.body();
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
                layoutManager.setFlexDirection(FlexDirection.ROW_REVERSE);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                mainRecyclerView.setLayoutManager(layoutManager);
                bookingAdapter = new BookingAdapter(getContext(),bookingList);
                mainRecyclerView.setAdapter(bookingAdapter);


            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {
            }
        });

    }
    public   void getStayInformation() {
          StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();


                for (int i=0;i<stayInformationList.size();i++){
                    if (!stayInformationList.get(i).getCheckin().equals(simpleDateFormat.format(calendar.getTime()))){
                        stayInformationList.remove(i);
                    }
                }

                Log.e("",""+stayInformationList.size());

                GridLayoutManager layoutManager = new GridLayoutManager(getContext(),6);

                mainRecyclerView.setLayoutManager(layoutManager);
                stayInformationAdapter = new StayInformationAdapter(getContext(),stayInformationList);
                mainRecyclerView.setAdapter(stayInformationAdapter);


            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }

}