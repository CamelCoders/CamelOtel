package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MisclleneousReservationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan.RatePlanCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.MisclleniousModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.SlabLlistModal;
//import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StayInformationCrud {
     public static List<MisclleniousModel> misclleniousModelList = new ArrayList<>();
    public static List<SlabLlistModal> slabListModal = new ArrayList<>();
    ReservationForm reservationForm=new ReservationForm();
   public static MisclleneousReservationAdapter misclleneousReservationAdapter;


    public void noOfRooms(Activity context, RecyclerView recyclerView, EditText editText) {
        misclleniousModelList.clear();
        for (int i = 1; i < 10; i++) {
            misclleniousModelList.add(new MisclleniousModel(String.valueOf(i)));
        }
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, misclleniousModelList, editText);
        recyclerView.setAdapter(misclleneousReservationAdapter);

    }

    public void getReservationType(Context context, RecyclerView recyclerView, EditText editText) {

        misclleniousModelList.clear();
        misclleniousModelList.add(new MisclleniousModel("Confirmed"));
        misclleniousModelList.add(new MisclleniousModel("Tentative"));
        misclleniousModelList.add(new MisclleniousModel("Hold"));
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, misclleniousModelList, editText);
        recyclerView.setAdapter(misclleneousReservationAdapter);

    }

    public void getPaymentMode(Context context, RecyclerView recyclerView, EditText editText) {
        misclleniousModelList.clear();
        misclleniousModelList.add(new MisclleniousModel("Cash"));
        misclleniousModelList.add(new MisclleniousModel("Credit"));
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        recyclerView.setLayoutManager(layoutManager);
        misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, misclleniousModelList, editText);
        recyclerView.setAdapter(misclleneousReservationAdapter);
    }

    public void getBillTo(Context context, RecyclerView recyclerView, EditText editText) {
        misclleniousModelList.clear();
        misclleniousModelList.add(new MisclleniousModel("Guest"));

        misclleniousModelList.add(new MisclleniousModel("Company"));

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);

        layoutManager.setFlexDirection(FlexDirection.ROW);

        layoutManager.setJustifyContent(JustifyContent.FLEX_START);

        recyclerView.setLayoutManager(layoutManager);

        misclleneousReservationAdapter = new MisclleneousReservationAdapter(context, misclleniousModelList, editText);

        recyclerView.setAdapter(misclleneousReservationAdapter);

    }
//

    public void stayinformationbilling(String roomType,String stayRatePlan,String roomNight,String stayadult, String staychild,
                                       TextView amountWOTax, TextView amountWTax, TextView taxAmount, TextView taxPercentage) {
        float roomrate = (float) 0.0;
        float roomPrice = 0;
        float roomPriceWithTax = 0;
        int stayNight = Integer.parseInt(roomNight);


                float extraadlutrate = 0;
                float extrachildrate = 0;
                int baseadult = 0;
                int basechild = 0;

             for (int i = 0; i < RatePlanCrud.ratePlanslist.size(); i++) {
                    if (String.valueOf(RatePlanCrud.ratePlanslist.get(i).getRoomplanname()).
                               equals(stayRatePlan)) {
                        if (stayadult.equals("1")) {
                            roomPrice =   Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getSingleOccupancy());
                            extraadlutrate = +Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getExtraadultrate());
                            extrachildrate = Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getExtrachildrate());
                            baseadult = Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getBaseadult());
                            basechild = Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getBasechild());
                        } else {
                            roomPrice =  Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getDoubleOccupancy());
                            extraadlutrate = Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getExtraadultrate());
                            extrachildrate = Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getExtrachildrate());
                            baseadult = Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getBaseadult());
                            basechild = Integer.parseInt(RatePlanCrud.ratePlanslist.get(i).getBasechild());
                        }
                    }
             }

                if (Integer.parseInt(stayadult) > 2) {
                    roomPrice = roomPrice + ((Integer.parseInt(stayadult) - 2) * extraadlutrate);
                }

                if (Integer.parseInt(staychild) >= basechild) {
                    roomPrice = roomPrice + ((Integer.parseInt(staychild)) * extrachildrate);
                }
                roomPrice = roomPrice * stayNight;

                ((TextView) amountWOTax).setText(String.valueOf(roomPrice));

            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
            Call<List<SlabLlistModal>> call = apiInterface.getTaxSlab();
            call.enqueue(new Callback<List<SlabLlistModal>>() {
                @Override
                public void onResponse(Call<List<SlabLlistModal>> call, Response<List<SlabLlistModal>> response) {
                    slabListModal = response.body();
                    float priceDay = 00;
                    String taxvalue = "";
                    float staynight = Float.parseFloat(String.valueOf(stayNight));
                    priceDay = Float.parseFloat(amountWOTax.getText().toString()) / Float.parseFloat(String.valueOf(stayNight));
                    for (int i = 0; i < slabListModal.size(); i++) {
                        if (priceDay >= Float.parseFloat(slabListModal.get(i).getFromprice())
                                && priceDay <= Float.parseFloat(slabListModal.get(i).getToprice())) {
                            taxvalue = slabListModal.get(i).getPercentage();
                        }
                    }
                    taxPercentage.setText(taxvalue);
                    float tax = Float.parseFloat(taxvalue);
                    float taxam = priceDay * tax / 100;

                    amountWTax.setText(String.valueOf((priceDay * staynight) + (taxam * staynight)));
                    taxAmount.setText(String.valueOf(taxam * staynight));

                }

                @Override
                public void onFailure(Call<List<SlabLlistModal>> call, Throwable t) {
                    Log.d("error", "" + t.getMessage());

                }
            });

    }
////

}
