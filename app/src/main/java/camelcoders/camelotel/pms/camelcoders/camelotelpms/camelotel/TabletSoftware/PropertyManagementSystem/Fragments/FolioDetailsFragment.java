package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.FolioDetailsItemAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.GuestAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.Folio;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.FolioApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.FolioCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.OnItemClickFolio;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.OnItemClick;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.FolioPlan.FolioPlanCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations.SalutationsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.FolioDetailsItem;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.CheckInData;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.ViewReservationActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentFolioDetailsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FolioDetailsFragment extends Fragment implements OnItemClickFolio {
    public OnItemClickFolio onItemClick= new OnItemClickFolio() {
        @Override
        public void onClick(View view, FolioDetailsItem position) {
            addFolioDialog= AppConfig.showFullScreenCustomDialog(R.layout.addfolio_layout, getActivity());
            RecyclerView folioList;
            TextInputEditText taxtype, foliotype,
                    selectPlan,guestID,
                    comment, amountValue;
            TextView rate,amount,taxper,taxamount;
            Button addbillfolio;

            foliotype = (addFolioDialog.findViewById(R.id.foliotype));
            folioList = (addFolioDialog.findViewById(R.id.folioList));
            addbillfolio = (addFolioDialog.findViewById(R.id.addbillfolio));
            guestID = (addFolioDialog.findViewById(R.id.guestID));
            selectPlan = (addFolioDialog.findViewById(R.id.selectPlan));
            taxtype = (addFolioDialog.findViewById(R.id.taxtype));
            comment = (addFolioDialog.findViewById(R.id.comment));
            amountValue = (addFolioDialog.findViewById(R.id.amountValue));
            rate=addFolioDialog.findViewById(R.id.itemamountwithouttax);
            amount=addFolioDialog.findViewById(R.id.itemamountwithtax);
            taxper=addFolioDialog.findViewById(R.id.itemtax);
            taxamount=addFolioDialog.findViewById(R.id.itemtaxamount);

            foliotype.setText(position.getChargesCategoryText());
            selectPlan.setText(position.getChargesCategoryText());
            amountValue.setText(position.getFolioCharges());

        }


    };
    FragmentFolioDetailsBinding binding;
    private final ArrayList<FolioDetailsItem> folioDetailsItemArrayList = new ArrayList<>();
    private FolioDetailsItemAdapter listAdapter;


     Calendar cal=Calendar.getInstance();
     public LinearLayout guestInformationButton;
    public LinearLayout formGuestInformation,formGuestLayout,formFolioInformation,folioLayout;
    public List<Guest> guestList = new ArrayList<>();
    public List<Folio> folioList = new ArrayList<>();
    FolioCrud folioCrud=new FolioCrud();

    FolioPlanCrud folioPlanCrud=new FolioPlanCrud();
    Dialog addFolioDialog;
    public TextView rate, taxPercentage, amount, taxAmount;

    public   String bookingId,totalAmount,folioBookingId;
    public  static String creditdebit;
    TextView folioValue;
    public static GuestAdapter guestAdapter;
    public GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);
    public ReservationForm reservationForm = new ReservationForm();
    String guestIds,folioId ;
    String[] separated ;
    String[] stayInformation=new String[1];
    Button AddGuest;
    public TextView guestInformationButtonText, stayInformationButtonText,folioInformationButtonText;


    Float sum=0.00F;
    public RecyclerView selectItemLayout;

     public TextInputEditText stayRooms, stayRoomType, stayRoomSelect, stayRateType,
            stayArrivalDate, stayArrivalTime,
            stayRatePlan, staySubStayPlan,
            stayArrivalNight, stayDepartureDate, stayDepartureTime,
            stayAdult, stayReserType, stayChild;
    String stayInformationId,bookingID;


    public FolioDetailsFragment() {

    }
    List<StayInformation> stayInformationList=new ArrayList<>();


    public static FolioDetailsFragment newInstance() {
        FolioDetailsFragment fragment = new FolioDetailsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        stayInformationId=getActivity().getIntent().getStringExtra("stayId");
        folioId=getActivity().getIntent().getStringExtra("folioId");
        bookingID=getActivity().getIntent().getStringExtra("bookingId");

        binding = FragmentFolioDetailsBinding.inflate(inflater, container, false);

setStayInfo();

            getFolio();

        binding.addFolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFolioDialog();
            }
        });

        return binding.getRoot();
    }


    public void addFolioDialog() {

        addFolioDialog= AppConfig.showFullScreenCustomDialog(R.layout.addfolio_layout, getActivity());
        RecyclerView folioList;
        TextInputEditText taxtype, foliotype,
                selectPlan,guestID,
                comment, amountValue;
        TextView rate,amount,taxper,taxamount;
        Button addbillfolio;

        foliotype = (addFolioDialog.findViewById(R.id.foliotype));
        folioList = (addFolioDialog.findViewById(R.id.folioList));
        addbillfolio = (addFolioDialog.findViewById(R.id.addbillfolio));
        guestID = (addFolioDialog.findViewById(R.id.guestID));
        selectPlan = (addFolioDialog.findViewById(R.id.selectPlan));
        taxtype = (addFolioDialog.findViewById(R.id.taxtype));
        comment = (addFolioDialog.findViewById(R.id.comment));
        amountValue = (addFolioDialog.findViewById(R.id.amountValue));
        rate=addFolioDialog.findViewById(R.id.itemamountwithouttax);
        amount=addFolioDialog.findViewById(R.id.itemamountwithtax);
        taxper=addFolioDialog.findViewById(R.id.itemtax);
        taxamount=addFolioDialog.findViewById(R.id.itemtaxamount);
        folioPlanCrud.folioType(getContext(),folioList,foliotype,selectPlan);

        selectPlan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                folioPlanCrud.setGuestIdsFOlio(getActivity(),folioList,separated,guestID,amountValue);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        addbillfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (foliotype.getText().toString().isEmpty()){
                    foliotype.requestFocus();
                }else if (selectPlan.getText().toString().isEmpty()){
                    selectPlan.requestFocus();
                }
                else if (amountValue.getText().toString().isEmpty()){
                    amountValue.requestFocus();

                }
                else{
                    if (creditdebit.equals("Credit")){
                        amountValue.setText("-"+Float.parseFloat(amountValue.getText().toString()));
                    }
                    DateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
                    FolioApiInterface apiInterface = ApiClient.getApiClient().create(FolioApiInterface.class);
                    Call<StayInformation> call = apiInterface.addFolio(
                            guestID.getText().toString(),comment.getText().toString(),creditdebit,selectPlan.getText().toString()
                            ,folioId,
                            bookingID,amountValue.getText().toString(),date1.format(cal.getTime()),stayInformationId
                    );

                    call.enqueue(new Callback<StayInformation>() {
                        @Override
                        public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {

                            String value = response.body().getValue();
                            String message = response.body().getMassage();

                            if (value.equals("1")) {

                                 addFolioDialog.dismiss();
                                getFolio();
                                AppConfig.showwCustomToast(getActivity(),"Sucess","sucess");


                            } else {

                                Log.e("rr", message);

                            }

                        }

                        @Override
                        public void onFailure(Call<StayInformation> call, Throwable t) {
                            Log.e("rr", "" + t.getMessage());
                            Toast.makeText(getContext() ,t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

        foliotype.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                folioPlanCrud.getFolioMaster(getActivity(),folioList,selectPlan,foliotype.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        addFolioDialog.show();

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

                    }

                }

//

            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }

    public void getFolio() {
        sum=0.00F;
        FolioApiInterface apiInterface = ApiClient.getApiClient().create(FolioApiInterface.class);

        Call<List<Folio>> call = apiInterface.getFolio();
        call.enqueue(new Callback<List<Folio>>() {
            @Override
            public void onResponse(Call<List<Folio>> call, Response<List<Folio>> response) {
                folioList = response.body();

                for (int i=0;i<folioList.size();i++){

                    Toast.makeText(getContext(), "sdftyu"+folioId, Toast.LENGTH_SHORT).show();

                    if (folioList.get(i).getFoliobillingid().equals(folioId)){

                        folioDetailsItemArrayList.add(new FolioDetailsItem
                                (folioList.get(i).getRateplan(), folioList.get(i).getId(),
                                        folioList.get(i).getDate(),
                                folioList.get(i).getRoomId(), "REC-873",
                                        "shristi", "Camelotel", folioList.get(i).getRateplan(), folioList.get(i).getAmount(), "Shristi"));


                    }
                }

                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
                layoutManager.setFlexDirection(FlexDirection.ROW);
                binding.folioDetailsRecycler.setLayoutManager(layoutManager);
                listAdapter = new FolioDetailsItemAdapter(folioDetailsItemArrayList, getContext(),onItemClick);
                binding.folioDetailsRecycler.setAdapter(listAdapter);
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Folio>> call, Throwable t) {

                Log.e("hj",""+t.getMessage());
            }
        });

    }

    @Override
    public void onClick(View view, FolioDetailsItem position) {

    }
}