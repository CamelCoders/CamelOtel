package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules;


import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.GuestAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.PriceListAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RatePlanAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Booking;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.BookingApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.RoomData;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan.RatePlanCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType.RateTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType.RoomsTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations.SalutationsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ListItemClickListener;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Reservation {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    Calendar c = Calendar.getInstance();
    String pricesByDay[];
    public Dialog priceListDialog;
    public static   ArrayList<RoomData> roomData = new ArrayList<>();
    public static   ArrayList<RoomData> priceListByDay = new ArrayList<>();
    PriceListAdapter priceListAdapter;
    Button buttonSubmitList;
    Calendar cal=Calendar.getInstance();
    String[] stayInformation;
    public static ReservationForm reservationForm = new ReservationForm();
    public static SalutationsCrud newSalutation = new SalutationsCrud();
    public static StayInformationCrud stayInformationCrud = new StayInformationCrud();
    public static GuestCrud newGuest = new GuestCrud();
    public static RoomsTypeCrud roomsTypeCrud = new RoomsTypeCrud();
    public static RoomsCrud roomsCrud = new RoomsCrud();
    public static RateTypeCrud rateTypeCrud = new RateTypeCrud();
    public static RatePlanCrud ratePlanCrud = new RatePlanCrud();
    public static SalutationsCrud salutationsCrud = new SalutationsCrud();
    public   LinearLayout priceList;
    public static String guestId;
    public void createReservation(Activity activity) {
        reservationForm.mainDialog(activity);
        salutationsCrud.getSalutations(activity, reservationForm.guestRecyler, reservationForm.guestSalutation,reservationForm.guestFirstName);

        reservationForm.Addrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addView(activity);

            }
        });


        reservationForm.reservationBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTotalPrice();
                stayInformation=new String[roomData.size()];

                DateFormat date = new SimpleDateFormat("MMddyyyyhhmmss");

                DateFormat date1 = new SimpleDateFormat("MM-dd-yyyy");

                String biilid = date.format(cal.getTime());

                String guesFirtnam = reservationForm.guestFirstName.getText().toString();
                String guestMidnam = reservationForm.guestMiddleName.getText().toString();
                String guestLAstnam = reservationForm.guestLastName.getText().toString();
                String idnumber = reservationForm.guestIdNumber.getText().toString();
                String idtype = reservationForm.guestIdType.getText().toString();
                String guestsal = reservationForm.guestSalutation.getText().toString();
                String pincod = reservationForm.guestPincode.getText().toString();
                String guesthouse = reservationForm.guestAddress.getText().toString();
                String guestcity = reservationForm.guestCity.getText().toString();
                String gueststate = reservationForm.guestState.getText().toString();
                String guestcountry = reservationForm.guestCountry.getText().toString();
                String guestemail = reservationForm.guestEmail.getText().toString();
                String guestphone = reservationForm.guestPhone.getText().toString();
                String statusBooking = reservationForm.stayReserType.getText().toString();
                String rateType = reservationForm.RatesSelected.getText().toString();
                String billto = reservationForm.billBookTO.getText().toString();
               // String exeID = reservationForm.bil.getText().toString();
                String guestid = guesFirtnam + biilid;

                if (guesFirtnam.isEmpty()){

                }else if (guestphone.isEmpty()){

                }
                else{
                    for (int i=0;i<roomData.size();i++){
                        stayInformation[i]=roomData.get(i).getRoomtype()+"!"+roomData.get(i).getRoomnumber()+"!"+
                                roomData.get(i).getRatetype()+"!"+roomData.get(i).getRateplan()+"!"+
                                reservationForm.stayArrivalDate.getText().toString()+"!"+
                                reservationForm.stayArrivalTime.getText().toString()
                                +"!"+reservationForm.stayDepartureDate.getText().toString()+"!"+
                                reservationForm.stayDepartureTime.getText().toString()
                                +"!"+roomData.get(i).getAdult()+"!"+roomData.get(i).getChild()+"!"
                                +reservationForm.stayArrivalNight.getText().toString()
                                +"!"+roomData.get(i).getAmountWOtax()+"!"
                                +roomData.get(i).getAmountWtax()+"!"+roomData.get(i).getSubarateplan()+"!";
                    }

                    BookingApiInterface apiInterface = ApiClient.getApiClient().create(BookingApiInterface.class);

                    Call<Booking> call = apiInterface.insertBooking(biilid,biilid,guestid,date1.format(cal.getTime())
                            ,"0",guestsal,guesFirtnam,guestMidnam,guestLAstnam,pincod,guestcity,gueststate,guestcountry
                            ,guesthouse,guestemail,guestphone,guestid,idtype,guestcountry,"","Male",stayInformation,pricesByDay
                            ,statusBooking,String.valueOf(roomData.size()),reservationForm.rate.getText().toString()
                            ,reservationForm.amount.getText().toString(),rateType,
                            billto,"","","","","","","","",
                            "","","","","","","",
                            "","","","");

                    call.enqueue(new Callback<Booking>() {
                        @Override
                        public void onResponse(Call<Booking> call, Response<Booking> response) {

                            String value = response.body().getValue();
                            String message = response.body().getMassage();

                            if (value.equals("1")) {
                                AppConfig.showwCustomToast(activity,"Sucess","Sucess");

                            } else {

                                Log.e("rr", message);

                            }

                        }

                        @Override
                        public void onFailure(Call<Booking> call, Throwable t) {
                            Log.e("rr", "" + t.getMessage());

                            Toast.makeText(activity, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                }

            }
        });



        reservationForm.guestInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservationForm.setActiveForm("guestInformationButton", activity);
            }
        });

        reservationForm.stayArrivalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.MultiDatePicker(activity, reservationForm.stayArrivalDate, reservationForm.stayArrivalNight, reservationForm.stayDepartureDate);
             }
        });


        reservationForm.stayDepartureDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.MultiDatePicker(activity, reservationForm.stayArrivalDate, reservationForm.stayArrivalNight, reservationForm.stayDepartureDate);

            }
        });

        reservationForm.stayArrivalTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.dialogTimePickerDark(activity, reservationForm.stayArrivalTime);
            }
        });

        reservationForm.stayDepartureTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.dialogTimePickerDark(activity, reservationForm.stayDepartureTime);
            }
        });



        reservationForm.stayInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservationForm.setActiveForm("stayInformationButton", activity);
                stayInformationCrud.getReservationType(activity,reservationForm.selectItemLayout,reservationForm.stayReserType);


                AppConfig.MultiDatePicker(activity, reservationForm.stayArrivalDate, reservationForm.stayArrivalNight, reservationForm.stayDepartureDate);


            }
        });

        reservationForm.billingInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stayInformationCrud.getBillTo(activity,reservationForm.billlingList,reservationForm.billBookTO);
                reservationForm.setActiveForm("billingInformationButton", activity);

            }
        });



        reservationForm.otherInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservationForm.setActiveForm("otherInformationButton", activity);

            }
        });


        reservationForm.multipleBookingInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reservationForm.setActiveForm("multipleBookingInformationButton", activity);

            }
        });


        reservationForm.guestFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                newGuest.filter(activity, s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//
//
        reservationForm.stayArrivalNight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
              //billingCheck();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }




    private void addView(Activity activity) {

        final View cricketerView = activity.getLayoutInflater().inflate(R.layout.addroom_layout,null,false);

        TextInputEditText  stayRoomType, stayRateType,
                stayRatePlan, staySubStayPlan,
                stayAdult, stayChild;
          TextView rate,amount,taxper,taxamount;
          RecyclerView roomValueList;
        stayRatePlan = (cricketerView.findViewById(R.id.stayRatePlan));
        roomValueList = (cricketerView.findViewById(R.id.roomValueList));
         stayRoomType = (cricketerView.findViewById(R.id.stayRoomType));
        staySubStayPlan = (cricketerView.findViewById(R.id.subRatePlan));
        stayAdult = (cricketerView.findViewById(R.id.stayAdult));
        stayChild = (cricketerView.findViewById(R.id.stayChild));
        rate=cricketerView.findViewById(R.id.itemamountwithouttax);
        amount=cricketerView.findViewById(R.id.itemamountwithtax);
        taxper=cricketerView.findViewById(R.id.itemtax);
        taxamount=cricketerView.findViewById(R.id.itemtaxamount);

        stayRateType = (cricketerView.findViewById(R.id.stayRateType));
        roomsCrud.getRooms(activity, roomValueList,stayRoomType);

        stayRoomType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomsCrud.getRooms(activity, roomValueList,stayRoomType);
            }
        });
        stayRoomType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                rateTypeCrud.getRateType(activity,roomValueList,stayRateType);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





        reservationForm.stayArrivalNight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                for(int i=0;i<reservationForm.layoutList.getChildCount();i++) {

                    View cricketerView = reservationForm.layoutList.getChildAt(i);

                  EditText  stayRatePlan = (cricketerView.findViewById(R.id.stayRatePlan));
                    EditText   stayRoomType = (cricketerView.findViewById(R.id.stayRoomType));
                    EditText   staySubStayPlan = (cricketerView.findViewById(R.id.subRatePlan));
                    EditText   stayAdult = (cricketerView.findViewById(R.id.stayAdult));
                    EditText   stayChild = (cricketerView.findViewById(R.id.stayChild));
                    TextView     rate=cricketerView.findViewById(R.id.itemamountwithouttax);
                    TextView    amount=cricketerView.findViewById(R.id.itemamountwithtax);
                    TextView     taxper=cricketerView.findViewById(R.id.itemtax);
                    TextView     taxamount=cricketerView.findViewById(R.id.itemtaxamount);

                   EditText stayRateType = (cricketerView.findViewById(R.id.stayRateType));
                    if (!(stayRoomType.getText().toString().isEmpty() ||
                            stayRateType.getText().toString().isEmpty()
                            ||
                            staySubStayPlan.getText().toString().isEmpty()
                            || stayAdult.getText().toString().isEmpty()
                            || stayChild.getText().toString().isEmpty()
                            || reservationForm.stayArrivalNight.getText().toString().isEmpty())) {
                        stayInformationCrud.stayinformationbilling(ReservationForm.stayroomtype, staySubStayPlan.getText().toString()
                                , reservationForm.stayArrivalNight.getText().toString()
                                , stayAdult.getText().toString(), stayChild.getText().toString(),
                                rate, amount, taxamount, taxper);

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        stayRateType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rateTypeCrud.getRateType(activity,roomValueList,stayRateType);

            }
        });

        stayRateType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ratePlanCrud.getRatePlanList(activity,roomValueList,stayRatePlan,stayRateType);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        stayRatePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratePlanCrud.getRatePlanList(activity,roomValueList,stayRatePlan,stayRateType);

            }
        });

        stayRatePlan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ratePlanCrud.getRatePlanSub(activity,roomValueList
                        ,staySubStayPlan,stayRatePlan);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        staySubStayPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratePlanCrud.getRatePlanSub(activity,roomValueList
                        ,staySubStayPlan,stayRatePlan);

            }
        });

        staySubStayPlan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                roomsTypeCrud.getNoofAdult(activity,roomValueList,stayAdult,ReservationForm.stayroomtype);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        stayAdult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                roomsTypeCrud.getNoofAdult(activity,roomValueList,stayAdult,ReservationForm.stayroomtype);


            }
        });


        stayAdult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                roomsTypeCrud.getNoofchild(activity,roomValueList,stayChild, ReservationForm.stayroomtype);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        stayChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomsTypeCrud.getNoofchild(activity,roomValueList,stayChild, ReservationForm.stayroomtype);

            }
        });


       ImageView imageClose = (ImageView)cricketerView.findViewById(R.id.deleteRoom);


        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(cricketerView);
            }
        });







     stayRoomType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (!(stayRoomType.getText().toString().isEmpty() ||
                        stayRateType.getText().toString().isEmpty()
                            ||
                        staySubStayPlan.getText().toString().isEmpty()
                        || stayAdult.getText().toString().isEmpty()
                        || stayChild.getText().toString().isEmpty()
                        || reservationForm.stayArrivalNight.getText().toString().isEmpty())) {
                            stayInformationCrud.stayinformationbilling(ReservationForm.stayroomtype, staySubStayPlan.getText().toString()
                                    , reservationForm.stayArrivalNight.getText().toString()
                                    , stayAdult.getText().toString(), stayChild.getText().toString(),
                                    rate, amount, taxamount, taxper);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


     stayRateType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!(stayRoomType.getText().toString().isEmpty() ||
                        stayRateType.getText().toString().isEmpty()
                        ||
                        staySubStayPlan.getText().toString().isEmpty()
                        || stayAdult.getText().toString().isEmpty()
                        || stayChild.getText().toString().isEmpty()
                        || reservationForm.stayArrivalNight.getText().toString().isEmpty())) {
                    stayInformationCrud.stayinformationbilling(ReservationForm.stayroomtype, staySubStayPlan.getText().toString()
                            , reservationForm.stayArrivalNight.getText().toString()
                            , stayAdult.getText().toString(), stayChild.getText().toString(),
                            rate, amount, taxamount, taxper);

                }            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


      stayRatePlan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!(stayRoomType.getText().toString().isEmpty() ||
                        stayRateType.getText().toString().isEmpty()
                        ||
                        staySubStayPlan.getText().toString().isEmpty()
                        || stayAdult.getText().toString().isEmpty()
                        || stayChild.getText().toString().isEmpty()
                        || reservationForm.stayArrivalNight.getText().toString().isEmpty())) {
                    stayInformationCrud.stayinformationbilling(ReservationForm.stayroomtype, staySubStayPlan.getText().toString()
                            , reservationForm.stayArrivalNight.getText().toString()
                            , stayAdult.getText().toString(), stayChild.getText().toString(),
                            rate, amount, taxamount, taxper);

                }            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


      staySubStayPlan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!(stayRoomType.getText().toString().isEmpty() ||
                        stayRateType.getText().toString().isEmpty()
                        ||
                        staySubStayPlan.getText().toString().isEmpty()
                        || stayAdult.getText().toString().isEmpty()
                        || stayChild.getText().toString().isEmpty()
                        || reservationForm.stayArrivalNight.getText().toString().isEmpty())) {
                    stayInformationCrud.stayinformationbilling(ReservationForm.stayroomtype, staySubStayPlan.getText().toString()
                            , reservationForm.stayArrivalNight.getText().toString()
                            , stayAdult.getText().toString(), stayChild.getText().toString(),
                            rate, amount, taxamount, taxper);

                }            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


       stayAdult.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!(stayRoomType.getText().toString().isEmpty() ||
                        stayRateType.getText().toString().isEmpty()
                        ||
                        staySubStayPlan.getText().toString().isEmpty()
                        || stayAdult.getText().toString().isEmpty()
                        || stayChild.getText().toString().isEmpty()
                        || reservationForm.stayArrivalNight.getText().toString().isEmpty())) {
                    stayInformationCrud.stayinformationbilling(ReservationForm.stayroomtype, staySubStayPlan.getText().toString()
                            , reservationForm.stayArrivalNight.getText().toString()
                            , stayAdult.getText().toString(), stayChild.getText().toString(),
                            rate, amount, taxamount, taxper);

                }            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


       stayChild.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (!(stayRoomType.getText().toString().isEmpty() ||
                        stayRateType.getText().toString().isEmpty()
                        ||
                        staySubStayPlan.getText().toString().isEmpty()
                        || stayAdult.getText().toString().isEmpty()
                        || stayChild.getText().toString().isEmpty()
                        || reservationForm.stayArrivalNight.getText().toString().isEmpty())) {
                    stayInformationCrud.stayinformationbilling(ReservationForm.stayroomtype, staySubStayPlan.getText().toString()
                            , reservationForm.stayArrivalNight.getText().toString()
                            , stayAdult.getText().toString(), stayChild.getText().toString(),
                            rate, amount, taxamount, taxper);

                }
                }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });


       amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                setTotalPrice();

                }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                priceListByDay.clear();
                priceListDialog = AppConfig.showFullScreenCustomDialog(R.layout.price_reservaation, activity);
                priceList=priceListDialog.findViewById(R.id.roomPriceList);
                buttonSubmitList=priceListDialog.findViewById(R.id.calculate);

                Float amountDay=Float.parseFloat(amount.getText().toString())/Float.parseFloat(reservationForm.stayArrivalNight.getText().toString());
                Float rateDay=Float.parseFloat(rate.getText().toString())/Float.parseFloat(reservationForm.stayArrivalNight.getText().toString());
                Float taxAmountDay=Float.parseFloat(taxamount.getText().toString())/Float.parseFloat(reservationForm.stayArrivalNight.getText().toString());
                RoomData priceDay=new RoomData();
                 priceDay.setTaxtPer(taxper.getText().toString());
                priceDay.setAmountWtax(String.valueOf(amountDay));
                priceDay.setAmountWOtax(String.valueOf(rateDay));
                priceDay.setTacamount(String.valueOf(taxAmountDay));
                for (int i=1; i<=Integer.parseInt(reservationForm.stayArrivalNight.getText().toString());i++) {
                    priceListByDay.add(priceDay);


                    final View view = activity.getLayoutInflater().inflate(R.layout.list_price_rresevation,null,false);
                    EditText rateList,amountList,taxperList,taxamountList,roomPriceDate;
                    rateList=view.findViewById(R.id.roomPriceWOtax);
                    roomPriceDate=view.findViewById(R.id.roomPriceDate);
                    amountList=view.findViewById(R.id.roomPriceWtax);
                    taxamountList=view.findViewById(R.id.roomPriceTaxAmount);
                    taxperList=view.findViewById(R.id.taxPercentage);
                    amountList.setEnabled(false);
                    taxamountList.setEnabled(false);
                    try {
                        c.setTime(sdf.parse(reservationForm.stayArrivalDate.getText().toString()));
                        c.add(Calendar.DATE, i);  // number of days to add
                        String date1 = sdf.format(c.getTime());
                        roomPriceDate.setText(date1);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    rateList.setText(String.valueOf(rateDay));
                    amountList.setText(String.valueOf(amountDay));
                    taxamountList.setText(String.valueOf(taxAmountDay));

                    rateList.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            String taxvalue = "0";
                            if (!rateList.getText().toString().isEmpty())
                            {
                                Float priceDay=Float.parseFloat(rateList.getText().toString());

                                for (int i=0;i< StayInformationCrud.slabListModal.size();i++){
                                    if (priceDay >= Float.parseFloat(StayInformationCrud.slabListModal.get(i).getFromprice())
                                            && priceDay <= Float.parseFloat(StayInformationCrud.slabListModal.get(i).getToprice())) {
                                        taxvalue =StayInformationCrud.slabListModal.get(i).getPercentage();
                                    }
                                }
                                taxamountList.setText(String.valueOf(Float.parseFloat(taxvalue)*priceDay/100));

                                priceDay=priceDay+Float.parseFloat(taxvalue)*priceDay/100;
                                amountList.setText(String.valueOf(priceDay));



                            }



                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });



                    priceList.addView(view);


                }

                priceListDialog.show();
                buttonSubmitList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setTotalPriceSaveChange(rate,amount,taxamount,taxper);


                    }
                });

            }
        });


        amount.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            priceListByDay.clear();
            priceListDialog = AppConfig.showFullScreenCustomDialog(R.layout.price_reservaation, activity);
            priceList=priceListDialog.findViewById(R.id.roomPriceList);
            buttonSubmitList=priceListDialog.findViewById(R.id.calculate);

           buttonSubmitList.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   setTotalPriceSaveChange(rate,amount,taxamount,taxper);

               }
           });
            Float amountDay=Float.parseFloat(amount.getText().toString())/Float.parseFloat(reservationForm.stayArrivalNight.getText().toString());
            Float rateDay=Float.parseFloat(rate.getText().toString())/Float.parseFloat(reservationForm.stayArrivalNight.getText().toString());
            Float taxAmountDay=Float.parseFloat(taxamount.getText().toString())/Float.parseFloat(reservationForm.stayArrivalNight.getText().toString());
            RoomData priceDay=new RoomData();
            Log.e("",""+rateDay);
            priceDay.setTaxtPer(taxper.getText().toString());
            priceDay.setAmountWtax(String.valueOf(amountDay));
            priceDay.setAmountWOtax(String.valueOf(rateDay));
            priceDay.setTacamount(String.valueOf(taxAmountDay));
            for (int i=1; i<=Integer.parseInt(reservationForm.stayArrivalNight.getText().toString());i++) {
                priceListByDay.add(priceDay);

                final View view = activity.getLayoutInflater().inflate(R.layout.list_price_rresevation,null,false);
                EditText rateList,amountList,taxperList,taxamountList,roomPriceDate;
                roomPriceDate=view.findViewById(R.id.roomPriceDate);

                rateList=view.findViewById(R.id.roomPriceWOtax);
                amountList=view.findViewById(R.id.roomPriceWtax);
                taxamountList=view.findViewById(R.id.roomPriceTaxAmount);
                taxperList=view.findViewById(R.id.taxPercentage);
                try {
                    c.setTime(sdf.parse(reservationForm.stayArrivalDate.getText().toString()));
                    c.add(Calendar.DATE, i);  // number of days to add
                    String date1 = sdf.format(c.getTime());
                    roomPriceDate.setText(date1);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                rateList.setText(String.valueOf(rateDay));
                amountList.setText(String.valueOf(amountDay));
                taxamountList.setText(String.valueOf(taxAmountDay));
                    rateList.setEnabled(false);
                    taxamountList.setEnabled(false);
                amountList.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        String taxvalue = "0";
                        if (!amountList.getText().toString().isEmpty())
                        {
                             Float amountDay=Float.parseFloat(amountList.getText().toString());
                            Float priceDay=Float.parseFloat(rateList.getText().toString());


                            for (int i=0;i< StayInformationCrud.slabListModal.size();i++){
                                if (priceDay >= Float.parseFloat(StayInformationCrud.slabListModal.get(i).getFromprice())
                                        && priceDay <= Float.parseFloat(StayInformationCrud.slabListModal.get(i).getToprice())) {
                                    taxvalue =StayInformationCrud.slabListModal.get(i).getPercentage();
                                }
                            }

                            rateList.setText(String.valueOf(amountDay/(Float.parseFloat(taxvalue)/100+1)));
                             taxamountList.setText(String.valueOf(amountDay-(amountDay/(Float.parseFloat(taxvalue)/100+1))));


                        }



                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });



                priceList.addView(view);


            }


                priceListDialog.show();

        }
    });

        reservationForm.layoutList.addView(cricketerView);

    }






    private void addView1(Activity activity) {




    }

    private void setTotalPrice() {
        Float roomPriceWOtax=00.00f,roomPriceWtax=00.00f,roomTaxAmount=00.00f;
        roomData.clear();
        boolean result = true;

        for(int i=0;i<reservationForm.layoutList.getChildCount();i++){

            View cricketerView = reservationForm.layoutList.getChildAt(i);
            TextInputEditText  stayRoomType, stayRateType,
                    stayRatePlan, staySubStayPlan,
                    stayAdult, stayChild;

            TextView rate,amount,taxper,taxamount;

            stayRatePlan = (cricketerView.findViewById(R.id.stayRatePlan));
            stayRoomType = (cricketerView.findViewById(R.id.stayRoomType));
            staySubStayPlan = (cricketerView.findViewById(R.id.subRatePlan));
            stayAdult = (cricketerView.findViewById(R.id.stayAdult));
            stayChild = (cricketerView.findViewById(R.id.stayChild));
            rate=cricketerView.findViewById(R.id.itemamountwithouttax);
            amount=cricketerView.findViewById(R.id.itemamountwithtax);
            taxper=cricketerView.findViewById(R.id.itemtax);
            taxamount=cricketerView.findViewById(R.id.itemtaxamount);

            stayRateType = (cricketerView.findViewById(R.id.stayRateType));
            RoomData cricketer = new RoomData();

            String currentString = stayRoomType.getText().toString();
            String[] separated = currentString.split("-");

            cricketer.setRoomtype(separated[1]);
            cricketer.setRoomnumber(separated[0]);
            cricketer.setRatetype(stayRateType.getText().toString());
            cricketer.setRateplan(stayRatePlan.getText().toString());
            cricketer.setSubarateplan(staySubStayPlan.getText().toString());
            cricketer.setAdult(stayAdult.getText().toString());
                cricketer.setChild(stayChild.getText().toString());
                cricketer.setAmountWOtax(rate.getText().toString());
                cricketer.setTaxtPer(taxper.getText().toString());
                cricketer.setTacamount(taxamount.getText().toString());
                cricketer.setAmountWtax(amount.getText().toString());



            if(!amount.getText().toString().equals("00.00")){

                roomPriceWOtax+=Float.parseFloat(rate.getText().toString());
                 roomPriceWtax+=Float.parseFloat(amount.getText().toString());
                 roomTaxAmount+=Float.parseFloat(taxamount.getText().toString());

             }else {
                result = false;
                break;
            }


            roomData.add(cricketer);

        }

        reservationForm.rate.setText(String.valueOf(roomPriceWOtax));
        reservationForm.amount.setText(String.valueOf(roomPriceWtax));
        reservationForm.taxAmount.setText(String.valueOf(roomTaxAmount));



     }


     private void setTotalPriceSaveChange(TextView rate,TextView amount,TextView taxamount,TextView taxper) {
        Float roomPriceWOtax=00.00f,roomPriceWtax=00.00f,roomTaxAmount=00.00f;
        roomData.clear();
        boolean result = true;
         pricesByDay=new String[priceList.getChildCount()];

        for(int i=0;i<priceList.getChildCount();i++){

            View view = priceList.getChildAt(i);

            EditText roomDatePrice,rateList,amountList,taxperList,taxamountList;
            rateList=view.findViewById(R.id.roomPriceWOtax);
            roomDatePrice=view.findViewById(R.id.roomPriceDate);
            amountList=view.findViewById(R.id.roomPriceWtax);
            taxamountList=view.findViewById(R.id.roomPriceTaxAmount);
            taxperList=view.findViewById(R.id.taxPercentage);


            pricesByDay[i]=roomDatePrice.getText().toString()+"!"+rateList.getText().toString()+"!"+amountList.getText().toString()+"!"
                    +taxamountList.getText().toString()+"!"+taxamountList.getText().toString();



                roomPriceWOtax+=Float.parseFloat(rateList.getText().toString());
                 roomPriceWtax+=Float.parseFloat(amountList.getText().toString());
                 roomTaxAmount+=Float.parseFloat(taxamountList.getText().toString());






            //roomData.add(cricketer);

        }
        Log.e("",""+roomPriceWOtax);

         rate.setText(String.valueOf(roomPriceWOtax));
         amount.setText(String.valueOf(roomPriceWtax));
         taxamount.setText(String.valueOf(roomTaxAmount));




     }

    private void removeView(View view){

        reservationForm.layoutList.removeView(view);

    }
}

