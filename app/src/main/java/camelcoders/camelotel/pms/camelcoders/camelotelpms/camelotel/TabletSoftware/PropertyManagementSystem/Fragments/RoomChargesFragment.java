package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RoomChargesAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.RoomChargesModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.PmsTabDashboard;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.ViewReservationActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentRoomChargesBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomChargesFragment extends Fragment {
    public   List<StayInformation> stayInformationList = new ArrayList<>();

    FragmentRoomChargesBinding binding;
    private RoomChargesAdapter listAdapter;
    private ArrayList<RoomChargesModel> roomChargesModelArrayList = new ArrayList<>();
String stayInformationId;
    public RoomChargesFragment() {
        // Required empty public constructor
    }

    public static RoomChargesFragment newInstance() {
        RoomChargesFragment fragment = new RoomChargesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        stayInformationId=getActivity().getIntent().getStringExtra("stayId");

        binding = FragmentRoomChargesBinding.inflate(inflater, container, false);
        setStayInfo();

        return binding.getRoot();
    }


    public void setStayInfo() {
        stayInformationList.clear();
        roomChargesModelArrayList.clear();
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();

                for (int i = 0; i < stayInformationList.size(); i++) {

                    if (stayInformationList.get(i).getId().equals(stayInformationId)) {
                        String date=stayInformationList.get(i).getCheckin();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        Calendar c = Calendar.getInstance();
                        // dt is now the new date
                        int noofNight=Integer.parseInt(stayInformationList.get(i).getNoofnight());
                       float amountWOtax=Float.parseFloat(stayInformationList.get(i).getAmount())/noofNight;
                       float discount=Float.parseFloat(stayInformationList.get(i).getDiscountAmount())/noofNight;
                       float amountWtax=Float.parseFloat(stayInformationList.get(i).getAmountWithTax())/noofNight;
                        float taxValue=amountWtax-  amountWOtax;
                        float totalAmount=amountWtax-
                               discount;
                        for (int j=0; j<Integer.parseInt(stayInformationList.get(i).getNoofnight()); j++)
                        {
                            try {
                                c.setTime(sdf.parse(date));
                                c.add(Calendar.DATE, j);  // number of days to add
                                String date1 = sdf.format(c.getTime());
                                roomChargesModelArrayList.add(new RoomChargesModel(date1,stayInformationList
                                        .get(i).getRoomtype(),stayInformationList.get(i).getSubRatePlan(),
                                        "2/0",String.valueOf(amountWOtax),String.valueOf(discount),
                                        String.valueOf(taxValue),"0.00",String.valueOf(totalAmount)));

                            } catch (ParseException e) {
                                e.printStackTrace();
                            }


                        }



                    }

                }
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
                layoutManager.setFlexDirection(FlexDirection.ROW);
                binding.roomChargesRecycler.setLayoutManager(layoutManager);
                listAdapter = new RoomChargesAdapter(roomChargesModelArrayList, getContext());
                binding.roomChargesRecycler.setAdapter(listAdapter);

                //Load the date from the network or other resources
                //into the array list asynchronously


                listAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }

}