package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.CheckIn.ChecKInApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.Folio;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.FolioApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.FolioCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.FolioPlan.FolioPlanCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations.SalutationsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.CheckIn;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckInData extends AppCompatActivity {

    List<StayInformation> stayInformationList=new ArrayList<>();
    String stayInformationId;
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

    RecyclerView selectStayREcycler;
    RoomsCrud roomsCrud=new RoomsCrud();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in_data);
        initLayoutVariables();
        stayInformationId=getIntent().getStringExtra("id");


        getStayInformation();
        getFolio();

        stayInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveForm("stayInformationButton", ctx);
                roomsCrud.getRooms(CheckInData.this, selectItemLayout,stayRoomType);

            }
        });
        folioInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setActiveForm("folioInformationButton", ctx);
            }
        });

        guestInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setActiveForm("guestInformationButton", ctx);

            }
        });

        AddGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setAddGuestDialog();
            }
        });


        AddFolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFolioDialog();
            }
        });

        CheckOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        CheckIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");

                ChecKInApiInterface apiInterface = ApiClient.getApiClient().create(ChecKInApiInterface.class);

                Call<StayInformation> call = apiInterface.checkIn(
                        separated[0],folioBookingId,bookingId,totalAmount,date1.format(cal.getTime()),stayInformationId

                );

                call.enqueue(new Callback<StayInformation>() {
                    @Override
                    public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {

                        String value = response.body().getValue();
                        String message = response.body().getMassage();

                        if (value.equals("1")) {

                            AppConfig.showwCustomToast(CheckInData.this,"Sucess","sucess");

                        } else {

                            Log.e("rr", message);

                        }

                    }

                    @Override
                    public void onFailure(Call<StayInformation> call, Throwable t) {
                        Log.e("rr", "" + t.getMessage());

                        Toast.makeText(CheckInData.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        stayArrivalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.MultiDatePicker(CheckInData.this, stayArrivalDate, stayArrivalNight, stayDepartureDate);

            }
        });

        UpdateRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stayArrivalTime.getText().toString().isEmpty()){
                    stayArrivalTime.requestFocus();
                }else if (stayRatePlan.getText().toString().isEmpty()){
                    stayRatePlan.requestFocus();
                }else if (stayRoomType.getText().toString().isEmpty()){
                    stayRoomType.requestFocus();
                }else if (staySubStayPlan.getText().toString().isEmpty()){
                    staySubStayPlan.getText();
                }else if (stayDepartureDate.getText().toString().isEmpty()){
                    stayDepartureDate.requestFocus();
                }else if (stayChild.getText().toString().isEmpty()){
                    stayChild.requestFocus();
                }else if (stayAdult.getText().toString().isEmpty()){
                    stayAdult.requestFocus();
                }else if (stayArrivalDate.getText().toString().isEmpty()){
                    stayArrivalDate.requestFocus();
                }else if (stayRateType.getText().toString().isEmpty()){
                    stayRateType.requestFocus();
                }else {


                    String room =stayRoomType.getText().toString();
                    String[] roomTypeNumber;
                    roomTypeNumber= room.split(",");
                    stayInformation[0]=roomTypeNumber[1]+"!"+roomTypeNumber[0]+"!"+
                            stayRateType.getText().toString()+"!"+stayRatePlan.getText().toString()+"!"+
                            stayArrivalDate.getText().toString()+"!"+
                            stayArrivalTime.getText().toString()
                            +"!"+stayDepartureDate.getText().toString()+"!"+
                            stayDepartureTime.getText().toString()
                            +"!"+stayAdult.getText().toString()+"!"+stayChild.getText().toString()+"!"
                            +stayArrivalTime.getText().toString()
                            +"!"+rate.getText().toString()+"!"
                            +amount.getText().toString()+"!";
                    StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);
                    Call<StayInformation> call = apiInterface.updateStayInfomation(stayInformation,stayInformationId);
                    call.enqueue(new Callback<StayInformation>() {
                        @Override
                        public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {
                            String value = response.body().getValue();
                            String message = response.body().getMassage();
                            if (value.equals("1")) {
                                formGuestLayout.removeAllViews();
                                addGuestDialog.dismiss();
                                getStayInformation();
                                AppConfig.showwCustomToast(CheckInData.this,"Sucess","sucess");
                            } else {
                                Log.e("rr", message);
                            }

                        }

                        @Override
                        public void onFailure(Call<StayInformation> call, Throwable t) {
                            Log.e("rr", "" + t.getMessage());

                            Toast.makeText(CheckInData.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }



    public void addFolioDialog() {

        addFolioDialog= AppConfig.showFullScreenCustomDialog(R.layout.addfolio_layout, this);



        RecyclerView folioList;
        TextInputEditText  taxtype, foliotype,
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

         folioPlanCrud.folioType(CheckInData.this,folioList,foliotype,selectPlan);

         selectPlan.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {

                 folioPlanCrud.setGuestIdsFOlio(CheckInData.this,folioList,separated,guestID,amountValue);

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
                                AppConfig.showwCustomToast(CheckInData.this,"Sucess","sucess");


                            } else {

                                Log.e("rr", message);

                            }

                        }

                        @Override
                        public void onFailure(Call<StayInformation> call, Throwable t) {
                            Log.e("rr", "" + t.getMessage());
                            Toast.makeText(CheckInData.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
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

            folioPlanCrud.getFolioMaster(CheckInData.this,folioList,selectPlan,foliotype.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        addFolioDialog.show();

    }



    public  void setAddGuestDialog(){

        addGuestDialog= AppConfig.showFullScreenCustomDialog(R.layout.guest_layout, this);

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
                salutationsCrud.getSalutations(CheckInData.this, guestRecyler, guestSalutation,guestFirstName);

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
                        guestIDs=guestIDs+guestId+",";
                    guestAdd[0]=guestId+"!"+guestSalutation.getText().toString()+"!"+guestFirstName.getText().toString()+"!"
                            +guestMiddleName.getText().toString()+"!"+guestLastName.getText().toString()+"!"+ guestFullAddress.getText().toString()
                            +"!"+ guestState.getText().toString()+"!"+guestCity.getText().toString()+"!"+ guestPincode.getText().toString()
                            +"!"+guestCountry.getText().toString()+"!"+guestCountry.getText().toString()+"!"+"VIP"
                            +"!"+guestEmail.getText().toString()+"!"
                            +guestPhone.getText().toString()+"!"+gender.getText().toString()
                            +"!"+guestIdType.getText().toString()+"!"+guestIdNumber.getText().toString()+"!"+date1.format(cal.getTime());

                    ChecKInApiInterface apiInterface = ApiClient.getApiClient().create(ChecKInApiInterface.class);

                    Call<StayInformation> call = apiInterface.checkInGuest(
                            guestAdd,guestIDs,stayInformationId
                    );

                    call.enqueue(new Callback<StayInformation>() {
                        @Override
                        public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {

                            String value = response.body().getValue();
                            String message = response.body().getMassage();

                            if (value.equals("1")) {
                                formGuestLayout.removeAllViews();
                                addGuestDialog.dismiss();
                                getStayInformation();
                                AppConfig.showwCustomToast(CheckInData.this,"Sucess","sucess");

                            } else {

                                Log.e("rr", message);

                            }

                        }

                        @Override
                        public void onFailure(Call<StayInformation> call, Throwable t) {
                            Log.e("rr", "" + t.getMessage());

                            Toast.makeText(ctx, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });


        addGuestDialog.show();


    }
    public void setActiveForm(String activeForm, Context context) {
        if (activeForm.equals("guestInformationButton")) {
            formGuestInformation.setVisibility(View.VISIBLE);
            formStayInformation.setVisibility(View.GONE);
            formFolioInformation.setVisibility(View.GONE);
            guestInformationButton.setBackgroundColor(getResources().getColor(R.color.dark_color));
            stayInformationButton.setBackgroundColor(getResources().getColor(R.color.light_color));
            folioInformationButton.setBackgroundColor(getResources().getColor(R.color.light_color));
            guestInformationButtonText.setTextColor(getResources().getColor(R.color.light_color));
            stayInformationButtonText.setTextColor(getResources().getColor(R.color.dark_color));
            folioInformationButtonText.setTextColor(getResources().getColor(R.color.dark_color));

        } else if (activeForm.equals("stayInformationButton")) {
            formGuestInformation.setVisibility(View.GONE);
            formFolioInformation.setVisibility(View.GONE);
            formStayInformation.setVisibility(View.VISIBLE);
            guestInformationButton.setBackgroundColor(getResources().getColor(R.color.light_color));
            folioInformationButton.setBackgroundColor(getResources().getColor(R.color.light_color));
            stayInformationButton.setBackgroundColor(getResources().getColor(R.color.dark_color));
            guestInformationButtonText.setTextColor(getResources().getColor(R.color.dark_color));
            folioInformationButtonText.setTextColor(getResources().getColor(R.color.dark_color));
            stayInformationButtonText.setTextColor(getResources().getColor(R.color.light_color));
        } else if (activeForm.equals("folioInformationButton")) {
            formGuestInformation.setVisibility(View.GONE);
            formStayInformation.setVisibility(View.GONE);
            formFolioInformation.setVisibility(View.VISIBLE);
            guestInformationButton.setBackgroundColor(getResources().getColor(R.color.light_color));
            stayInformationButton.setBackgroundColor(getResources().getColor(R.color.light_color));
            folioInformationButton.setBackgroundColor(getResources().getColor(R.color.dark_color));
            guestInformationButtonText.setTextColor(getResources().getColor(R.color.dark_color));
            stayInformationButtonText.setTextColor(getResources().getColor(R.color.dark_color));
            folioInformationButtonText.setTextColor(getResources().getColor(R.color.light_color));
        }
    }

    public void initLayoutVariables( ) {

        formGuestInformation = findViewById(R.id.formGuestInformation);
        selectItemLayout = findViewById(R.id.selectItemLayout);
        folioValue = findViewById(R.id.folioValue);

        formFolioInformation = findViewById(R.id.formFolioInformation);

        CheckIButton = findViewById(R.id.CheckIButton);
        CheckOutButton = findViewById(R.id.CheckOutButton);

        AddGuest = findViewById(R.id.AddGuest);

        formStayInformation = findViewById(R.id.formStayInformation);

        formGuestLayout = findViewById(R.id.formGuestInformationLayout);

        folioLayout = findViewById(R.id.folioLayout);

        selectStayREcycler = findViewById(R.id.selectItemLayout);


        CheckInBook=findViewById(R.id.CheckIButton);
        UpdateRoom=findViewById(R.id.UpdateRoom);
        AddFolio=findViewById(R.id.AddFolio);

        rate = findViewById(R.id.rate);

        taxPercentage = findViewById(R.id.taxper);
        amount = findViewById(R.id.amount);
        taxAmount = findViewById(R.id.taxAmount);



        stayRatePlan = (findViewById(R.id.stayRatePlan));
        stayRoomType = (findViewById(R.id.stayRoomType));

        staySubStayPlan = (findViewById(R.id.subRatePlan));
        stayAdult = (findViewById(R.id.stayAdult));
        stayChild = (findViewById(R.id.stayChild));

        stayRateType = (findViewById(R.id.stayRateType));
        stayArrivalDate = (findViewById(R.id.stayArrivalDate));
        stayArrivalTime = (findViewById(R.id.stayArrivalTime));
        stayArrivalNight = (findViewById(R.id.stayArrivalNight));
        stayDepartureDate = (findViewById(R.id.stayDepartureDate));
        stayDepartureTime = (findViewById(R.id.stayDepartureTime));
        stayReserType = (findViewById(R.id.stayReserType));
        //  stayGuestStatus = (dialog.findViewById(R.id.stayGuestStatus));

        guestInformationButtonText = findViewById(R.id.guestInformationButtonText);
        folioInformationButtonText = findViewById(R.id.folioInformationButtonText);
        stayInformationButtonText = findViewById(R.id.stayInformationButtonText);
        guestInformationButton = findViewById(R.id.guestInformationButton);
        stayInformationButton = findViewById(R.id.stayInformationButton);
        folioInformationButton = findViewById(R.id.folioInformationButton);
    }
    public   void getStayInformation() {
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();
                for (int i=0;i<stayInformationList.size();i++){
                    if (stayInformationList.get(i).getId().equals(stayInformationId)){

                        stayArrivalDate.setText(stayInformationList.get(i).getCheckin());
                        stayDepartureDate.setText(stayInformationList.get(i).getCheckout());
                        stayArrivalNight.setText(stayInformationList.get(i).getNoofnight());
                        stayRoomType.setText(stayInformationList.get(i).getRoomnumber()+"-"+stayInformationList.get(i).getRoomtype());
                        stayRateType.setText(stayInformationList.get(i).getRoomratetype());
                        stayRatePlan.setText(stayInformationList.get(i).getRatePlan());
                        staySubStayPlan.setText(stayInformationList.get(i).getSubRatePlan());
                        stayAdult.setText(stayInformationList.get(i).getNoofdault());
                        stayChild.setText(stayInformationList.get(i).getNoofchild());
                        rate.setText(stayInformationList.get(i).getAmount());
                        amount.setText(stayInformationList.get(i).getAmountWithTax());
                        bookingId=stayInformationList.get(i).getBookingid();
                        totalAmount=stayInformationList.get(i).getAmountWithTax();
                        folioBookingId=stayInformationList.get(i).getFolioRoomId();
                        guestIDs=stayInformationList.get(i).getGuestid();



                        if (stayInformationList.get(i).getStatus().equals("1")){
                            CheckIButton.setVisibility(View.GONE);
                            CheckOutButton.setVisibility(View.VISIBLE);
                        }

                        currentString =stayInformationList.get(i).getGuestid();

                            separated = currentString.split(",");
                            for (int j=0;j<separated.length;j++){
                                addView(separated[j]);
                            }



                    }
                }


            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

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
    public void addView(String id)
    {

        TextView guestName,identitynumber,pincode,phonenumber;
        LinearLayout fillGuest;





        final View view = getLayoutInflater().inflate(R.layout.guest_list,null,false);

        guestName=view.findViewById(R.id.guestName);
        fillGuest=view.findViewById(R.id.fillGuest);
        pincode=view.findViewById(R.id.pincode);
        identitynumber=view.findViewById(R.id.Identitiynumber);
        phonenumber=view.findViewById(R.id.phonenumber);

        Call<List<Guest>> call = apiInterface.getGuest();
        call.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                guestList = response.body();

                for (int i=0;i<guestList.size();i++){
                    if (guestList.get(i).getGuestid().equals(id)){

                        guestName.setText(guestList.get(i).getFirstName()+" "+guestList.get(i).getMidName()+" "+guestList.get(i).getLastName());
                        phonenumber.setText(guestList.get(i).getNumber());

                    }
                }

            }
            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e(":df",""+t.getMessage());

            }
        });
        fillGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        formGuestLayout.addView(view);


    }


}