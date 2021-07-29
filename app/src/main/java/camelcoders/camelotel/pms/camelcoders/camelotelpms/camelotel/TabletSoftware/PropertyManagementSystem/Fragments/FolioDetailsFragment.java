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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.FolioPlan.FolioPlanCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations.SalutationsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.FolioDetailsItem;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.ViewReservationActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentFolioDetailsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FolioDetailsFragment extends Fragment {

    FragmentFolioDetailsBinding binding;
    private final ArrayList<FolioDetailsItem> folioDetailsItemArrayList = new ArrayList<>();
    private FolioDetailsItemAdapter listAdapter;


     Calendar cal=Calendar.getInstance();
    public StayInformationAdapter.OnItemClickListener onItemClick;
    public LinearLayout guestInformationButton, stayInformationButton,
            folioInformationButton, billingInformationButton, multipleStayInformationInformationButton;
    public LinearLayout formGuestInformation, formStayInformation,formGuestLayout,formFolioInformation,folioLayout;
    private List<StayInformation> items = new ArrayList<>();
    private List<StayInformation> itemFilter = new ArrayList<>();
    public List<Guest> guestList = new ArrayList<>();
    public List<Folio> folioList = new ArrayList<>();
    FolioCrud folioCrud=new FolioCrud();

    FolioPlanCrud folioPlanCrud=new FolioPlanCrud();
    Dialog addFolioDialog,addGuestDialog;
    String[] guestData ;
    String[] guestAdd= new String[1];
    Button CheckInBook,UpdateRoom,AddFolio,CheckIButton,CheckOutButton;

    public TextView rate, taxPercentage, amount, taxAmount;

    public static String bookingId,totalAmount,folioBookingId,creditdebit;
    TextView folioValue;
    public static GuestAdapter guestAdapter;
    public GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);
    public ReservationForm reservationForm = new ReservationForm();
    String currentString ;
    String[] separated ;
    String[] stayInformation=new String[1];
    Button AddGuest;
    public TextView guestInformationButtonText, stayInformationButtonText,folioInformationButtonText;
    SalutationsCrud salutationsCrud=new SalutationsCrud();
    GuestCrud guestCrud=new GuestCrud();
    private Context ctx;
    String guestIDs;

    Float sum=0.00F;
    public RecyclerView selectItemLayout;
    private StayInformationAdapter.OnItemClickListener mOnItemClickListener;
    public TextInputEditText stayRooms, stayRoomType, stayRoomSelect, stayRateType,
            stayArrivalDate, stayArrivalTime,
            stayRatePlan, staySubStayPlan,
            stayArrivalNight, stayDepartureDate, stayDepartureTime,
            stayAdult, stayReserType, stayChild;
    String stayInformationId,bookingID;


    public FolioDetailsFragment() {

    }

    public static FolioDetailsFragment newInstance() {
        FolioDetailsFragment fragment = new FolioDetailsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        stayInformationId=getActivity().getIntent().getStringExtra("stayId");
        bookingID=getActivity().getIntent().getStringExtra("bookingId");

        binding = FragmentFolioDetailsBinding.inflate(inflater, container, false);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.folioDetailsRecycler.setLayoutManager(layoutManager);
        listAdapter = new FolioDetailsItemAdapter(folioDetailsItemArrayList, getContext());
        binding.folioDetailsRecycler.setAdapter(listAdapter);

        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));

        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));

        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));

        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));

        listAdapter.notifyDataSetChanged();
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
                            ,folioBookingId,
                            bookingId,amountValue.getText().toString(),date1.format(cal.getTime()),stayInformationId
                    );

                    call.enqueue(new Callback<StayInformation>() {
                        @Override
                        public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {

                            String value = response.body().getValue();
                            String message = response.body().getMassage();

                            if (value.equals("1")) {

                                folioLayout.removeAllViews();
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
    public   void getFolio() {
        sum=0.0F;
        FolioApiInterface apiInterface = ApiClient.getApiClient().create(FolioApiInterface.class);

        Call<List<Folio>> call = apiInterface.getFolio();
        call.enqueue(new Callback<List<Folio>>() {
            @Override
            public void onResponse(Call<List<Folio>> call, Response<List<Folio>> response) {
                folioList = response.body();

                for (int i=0;i<folioList.size();i++){
                    Log.e("",""+folioBookingId);

                    if (folioList.get(i).getFoliobillingid().equals(folioBookingId)){

                        final View view = getLayoutInflater().inflate(R.layout.folio_list_item,null,false);

                        TextView t1,t2,t3,t4;


                        t1 = view.findViewById(R.id.txtRank);
                        t2 = view.findViewById(R.id.txtMovieName);
                        t3 = view.findViewById(R.id.txtYear);
                        t4 = view.findViewById(R.id.txtCost);

                        t1.setText(folioList.get(i).getDate());
                        t2.setText(folioList.get(i).getRateplan());
                        t3.setText(folioList.get(i).getCreditdebit());
                        t4.setText("Rs "+folioList.get(i).getAmount());


                        sum=sum+Float.parseFloat(folioList.get(i).getAmount());
                        folioLayout.addView(view);
                        folioValue.setText(String.valueOf(sum));
                    }
                }


            }

            @Override
            public void onFailure(Call<List<Folio>> call, Throwable t) {
            }
        });

    }

}