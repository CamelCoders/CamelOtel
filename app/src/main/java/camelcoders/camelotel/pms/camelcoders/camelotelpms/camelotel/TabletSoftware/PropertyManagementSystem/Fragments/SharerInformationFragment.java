package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.GuestAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.SharereInformationListAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.CheckIn.ChecKInApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.OnItemClick;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations.SalutationsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.SharereInformationListModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.CheckInData;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.ViewReservationActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentSharerInformationBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SharerInformationFragment extends Fragment implements OnItemClick {
    public OnItemClick onItemClick=new OnItemClick() {
        @Override
        public void onClick(View view, Guest position) {

            getGuestId=position.getGuestid();
            guestSalutation.setText(position.getSalutation());
            guestFirstName.setText(position.getFirstName());
            guestLastName.setText(position.getLastName());
            guestMiddleName.setText(position.getMidName());
            guestPhone.setText(position.getNumber());
            guestPincode.setText(position.getZipode());
            guestFullAddress.setText(position.getAddress());
            guestCity.setText(position.getCity());
            guestEmail.setText(position.getEmail());
            guestState.setText(position.getState());
            guestIdType.setText(position.getIdType());
            guestIdNumber.setText(position.getIdNumber());
            guestCountry.setText(position.getCountry());
            gender.setText(position.getGENDER());


        }
    };

    public OnItemClick onGuestClcik=new OnItemClick() {
        @Override
        public void onClick(View view, Guest position) {
            addGuestDialog= AppConfig.showFullScreenCustomDialog(R.layout.guestupdate_layout, getActivity());

             addGuest = addGuestDialog.findViewById(R.id.SaveGuest);
            guestRecyler = addGuestDialog.findViewById(R.id.guestList);
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



             guestSalutation.setText(position.getSalutation());
            guestFirstName.setText(position.getFirstName());
            guestLastName.setText(position.getLastName());
            guestMiddleName.setText(position.getMidName());
            guestPhone.setText(position.getNumber());
            guestPincode.setText(position.getZipode());
            guestFullAddress.setText(position.getAddress());
            guestCity.setText(position.getCity());
            guestEmail.setText(position.getEmail());
            guestState.setText(position.getState());
            guestIdType.setText(position.getIdType());
            guestIdNumber.setText(position.getIdNumber());
            guestCountry.setText(position.getCountry());
            gender.setText(position.getGENDER());

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




                        GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);

                        Call<Guest> call = apiInterface.updateGuest(position.getGuestid()
                                ,guestSalutation.getText().toString()
                                ,guestFirstName.getText().toString(),
                                guestMiddleName.getText().toString(),
                                guestLastName.getText().toString(),
                                guestPincode.getText().toString(),
                                guestCity.getText().toString()
                                ,guestState.getText().toString(),guestCountry.getText().toString()
                                ,guestFullAddress.getText().toString(),guestEmail.getText().toString(),
                                guestPhone.getText().toString(),guestIdType.getText().toString(),
                                guestIdNumber.getText().toString(),guestCountry.getText().toString()
                                ,"VIP",gender.getText().toString()
                        );

                        call.enqueue(new Callback<Guest>() {
                            @Override
                            public void onResponse(Call<Guest> call, Response<Guest> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();

                                if (value.equals("1")) {
                                    addGuestDialog.dismiss();
                                    setGuestData();
                                    setGuestData();
                                    AppConfig.showwCustomToast(getActivity(),"Sucess","sucess");

                                } else {

                                    Log.e("rr", message);

                                }

                            }

                            @Override
                            public void onFailure(Call<Guest> call, Throwable t) {
                                Log.e("rr", "" + t.getMessage());

                                Toast.makeText(getActivity(), t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            });

            addGuestDialog.show();
        }
    };
    GuestAdapter guestAdapter;

    Button addGuest;
    TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
            guestLastName, guestPincode, guestFullAddress,gender,
            guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
    RecyclerView guestRecyler;
    GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);
    String[] guestAdd= new String[1];
    SalutationsCrud salutationsCrud=new SalutationsCrud();
Calendar cal=Calendar.getInstance();
   static String currentString ;
    String[] separated ;
    String getGuestId="null";
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

        setStayInfo();
        binding.addSharer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAddGuestDialog();
            }
        });


//


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

                for (int i = 0; i < stayInformationList.size(); i++) {

                    if (stayInformationList.get(i).getId().equals(stayInformationId)) {
                        guestIds=stayInformationList.get(i).getGuestid();
                        separated = guestIds.split(",");
                        setGuestData();

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

    guestList1.clear();
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
                listAdapter = new SharereInformationListAdapter(getContext(), guestList1,onGuestClcik);
                binding.sharerListRecyclerView.setAdapter(listAdapter);

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
        salutationsCrud.getSalutations(getActivity(), guestRecyler, guestSalutation,guestFirstName);

        guestSalutation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salutationsCrud.getSalutations(getActivity(), guestRecyler, guestSalutation,guestFirstName);

            }
        });

guestSalutation.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        guestList.clear();
        Call<List<Guest>> call = apiInterface.getGuest();
        call.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                guestList = response.body();


                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getActivity());
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                guestRecyler.setLayoutManager(layoutManager);
                 guestAdapter = new GuestAdapter(getActivity(), guestList,onItemClick,"reservationGuest");
                guestRecyler.setAdapter(guestAdapter);

            }
            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e(":df",""+t.getMessage());

            }
        });
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
});
guestFirstName.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence text, int start, int before, int count) {
        List<Guest> filterdNames = new ArrayList<>();

        for (Guest s : guestList) {

            if (s.getFirstName().toLowerCase().contains(text.toString().toLowerCase()) ||
                    s.getFirstName().toLowerCase().contains(text.toString().toLowerCase()) ||
                    s.getFirstName().toLowerCase().contains(text.toString().toLowerCase())) {
                filterdNames.add(s);
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

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

                    String biilid;
                    if (getGuestId.equals("null")){

                          biilid = date.format(cal.getTime());

                    }
                    else {
                        biilid=getGuestId;
                    }


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

    @Override
    public void onClick(View view, Guest position) {
        Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
    }
}