package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.SharereInformationListAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.CheckIn.ChecKInApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations.SalutationsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.SharereInformationListModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.CheckInData;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentSharerInformationBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharerInformationFragment extends Fragment {
    GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);
    String[] guestAdd= new String[1];
    SalutationsCrud salutationsCrud=new SalutationsCrud();
Calendar cal=Calendar.getInstance();
   static String currentString ;
    String[] separated ;
    private final ArrayList<SharereInformationListModel> sharereInformationListModelArrayList = new ArrayList<>();
    FragmentSharerInformationBinding binding;
    private SharereInformationListAdapter listAdapter;
    String stayInformationId,bookingID,guestId,guestIds;
    List<StayInformation> stayInformationList=new ArrayList<>();
    List<Guest> guestList=new ArrayList<>();
    List<Guest> guestList1=new ArrayList<>();
    Guest guest;
    Dialog addGuestDialog;

    public SharerInformationFragment() {
        // Required empty public constructor
    }

    public static SharerInformationFragment newInstance() {
        SharerInformationFragment fragment = new SharerInformationFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSharerInformationBinding.inflate(inflater, container, false);

        stayInformationId=getActivity().getIntent().getStringExtra("stayId");
        bookingID=getActivity().getIntent().getStringExtra("bookingId");
        guestId=getActivity().getIntent().getStringExtra("guestId");
        guestIds=getActivity().getIntent().getStringExtra("guestIds");
        separated = guestIds.split(",");
        binding.addSharer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAddGuestDialog();
            }
        });


//        setStayInfo();
//
      setGuestData();

//        }



        return binding.getRoot();
    }


    public void setStayInfo() {
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();

                for (int i=0;i<stayInformationList.size() ;i++){

                    if (stayInformationList.get(i).getId().equals(stayInformationId)){


                    }

                }

//

            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });
     }

    public  void  setGuestData(){


        Call<List<Guest>> callGuest = apiInterface.getGuest();
        callGuest.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                guestList = response.body();
                for (int k=0;k<guestList.size() ;k++) {

                    for (int j = 0; j < separated.length; j++) {
                            if (guestList.get(k).getGuestid().equals(separated[j])) {
                                guestList1.add(new Guest(guestList.get(k).getId(),
                                        guestList.get(k).getSalutation(),guestList.get(k).getFirstName()
                                ,guestList.get(k).getMidName(),guestList.get(k).getLastName(),
                                        guestList.get(k).getAddress(),guestList.get(k).getState(),
                                        guestList.get(k).getCity(),guestList.get(k).getZipode(),
                                        guestList.get(k).getCountry(),guestList.get(k).getNationality()
                                        ,"",guestList.get(k).getEmail(),guestList.get(k).getNumber(),
                                        "",guestList.get(k).getGENDER(),guestList.get(k).getIdType()
                                        ,guestList.get(k).getIdNumber(),guestList.get(k).getDate(), guestList.get(k).getGuestid()));

                            }

                    }
                }
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
                layoutManager.setFlexDirection(FlexDirection.ROW);
                binding.sharerListRecyclerView.setLayoutManager(layoutManager);
                listAdapter = new SharereInformationListAdapter(getContext(), guestList1);
                binding.sharerListRecyclerView.setAdapter(listAdapter);

                //Load the date from the network or other resources
                //into the array list asynchronously

                listAdapter.notifyDataSetChanged();


            }
            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e(":df",""+t.getMessage());

            }
        });
    }
    public  void setAddGuestDialog(){

        addGuestDialog= AppConfig.showFullScreenCustomDialog(R.layout.guest_layout, getActivity());

        Button addGuest;
        TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
                guestLastName, guestPincode, guestFullAddress,gender,
                guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
        RecyclerView guestRecyler;
        guestRecyler = addGuestDialog.findViewById(R.id.guestList);
        addGuest = addGuestDialog.findViewById(R.id.SaveGuest);
        guestSalutation = addGuestDialog.findViewById(R.id.guestSalutation);
        guestFirstName = addGuestDialog.findViewById(R.id.guestFirstName);
        guestMiddleName = addGuestDialog.findViewById(R.id.guestMiddleName);
        guestLastName = addGuestDialog.findViewById(R.id.guestLastName);
        guestPincode = addGuestDialog.findViewById(R.id.guestPincode);
        guestState = addGuestDialog.findViewById(R.id.guestState);
        gender = addGuestDialog.findViewById(R.id.guestGender);
        guestCity = addGuestDialog.findViewById(R.id.guestCity);
        guestFullAddress = addGuestDialog.findViewById(R.id.guestfullAdrress);
        guestEmail = addGuestDialog.findViewById(R.id.guestEmail);
        guestCountry = addGuestDialog.findViewById(R.id.guestCountry);
        guestPhone = addGuestDialog.findViewById(R.id.guestPhoneNumber);
        guestIdType = addGuestDialog.findViewById(R.id.guestIdType);
        guestIdNumber = addGuestDialog.findViewById(R.id.guestIdNumber);

        guestSalutation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salutationsCrud.getSalutations(getActivity(), guestRecyler, guestSalutation,guestFirstName);

            }
        });

        addGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (guestSalutation.getText().toString().isEmpty()){
                    guestSalutation.requestFocus();
                }else if (guestFirstName.getText().toString().isEmpty()){
                    guestFirstName.requestFocus();
                }else if (guestState.getText().toString().isEmpty()){
                    guestState.requestFocus();
                }else if (guestEmail.getText().toString().isEmpty()){
                    guestEmail.getText();
                }else if (guestIdType.getText().toString().isEmpty()){
                    guestIdType.requestFocus();
                }else if (guestPhone.getText().toString().isEmpty()){
                    guestPhone.requestFocus();
                }else if (guestIdNumber.getText().toString().isEmpty()){
                    guestIdNumber.requestFocus();
                }else if (gender.getText().toString().isEmpty()){
                    gender.requestFocus();
                }else if (guestFullAddress.getText().toString().isEmpty()){
                    guestFullAddress.requestFocus();
                }else {


                    DateFormat date = new SimpleDateFormat("MMddyyyyhhmmss");

                    DateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");


                    String biilid = date.format(cal.getTime());
                    String guestId=guestFirstName.getText().toString()+biilid;
                    guestIds=guestIds+guestId+",";
                    guestAdd[0]=guestId+"!"+guestSalutation.getText().toString()+"!"+guestFirstName.getText().toString()+"!"
                            +guestMiddleName.getText().toString()+"!"+guestLastName.getText().toString()+"!"+ guestFullAddress.getText().toString()
                            +"!"+ guestState.getText().toString()+"!"+guestCity.getText().toString()+"!"+ guestPincode.getText().toString()
                            +"!"+guestCountry.getText().toString()+"!"+guestCountry.getText().toString()+"!"+"VIP"
                            +"!"+guestEmail.getText().toString()+"!"
                            +guestPhone.getText().toString()+"!"+gender.getText().toString()
                            +"!"+guestIdType.getText().toString()+"!"+guestIdNumber.getText().toString()+"!"+date1.format(cal.getTime());

                    ChecKInApiInterface apiInterface = ApiClient.getApiClient().create(ChecKInApiInterface.class);

                    Call<StayInformation> call = apiInterface.checkInGuest(
                            guestAdd,guestIds,stayInformationId
                    );

                    call.enqueue(new Callback<StayInformation>() {
                        @Override
                        public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {

                            String value = response.body().getValue();
                            String message = response.body().getMassage();

                            if (value.equals("1")) {
                                 addGuestDialog.dismiss();
                                setGuestData();
                                AppConfig.showwCustomToast(getActivity(),"Sucess","sucess");

                            } else {

                                Log.e("rr", message);

                            }

                        }

                        @Override
                        public void onFailure(Call<StayInformation> call, Throwable t) {
                            Log.e("rr", "" + t.getMessage());

                            Toast.makeText(getActivity(), t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        addGuestDialog.show();


    }

}