package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.GuestAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GuestCrud {
    //Retrieve Guest Function
    public static List<Guest> guestList = new ArrayList<>();
    public static   GuestAdapter guestAdapter;
    public GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);
    public   ReservationForm reservationForm = new ReservationForm();

    public void getGuest(Context context, RecyclerView recyclerView) {
        guestList.clear();
        Call<List<Guest>> call = apiInterface.getGuest();
        call.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                guestList = response.body();
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
                 guestAdapter = new GuestAdapter(context, guestList,"reservationGuest");
                recyclerView.setAdapter(guestAdapter);

            }
            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e(":df",""+t.getMessage());

            }
        });
    }


    //Update Guest Function
    public void upadteGuest(String guestId, String guestSalutation, String guestFirstName, String guestMiddleName,
                            String guestLastName, String guestPinCode, String guestCity, String guestAddress,
                            String guestCountry, String guestFullAddress, String guestEmail, String guestPhoneNumber,
                            String guestIdentityType, String guestIdentityNumber, String guestNationality, String guestStatus,
                            String guestGender) {

        Call<Guest> call = apiInterface.updateGuest(guestId, guestSalutation, guestFirstName, guestMiddleName,
                guestLastName, guestPinCode, guestCity, guestAddress,
                guestCountry, guestFullAddress, guestEmail, guestPhoneNumber,
                guestIdentityType, guestIdentityNumber, guestNationality, guestStatus,
                guestGender);
        call.enqueue(new Callback<Guest>() {
            @Override
            public void onResponse(Call<Guest> call, Response<Guest> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                Log.e("e", "uhuhuh");
            }

            @Override
            public void onFailure(Call<Guest> call, Throwable t) {
                Log.e("", "" + t.getMessage());
            }
        });
    }

    public void filter(Activity context, String text) {
        List<Guest> filterdNames = new ArrayList<>();

        for (Guest s : guestList) {

            if (s.getFirstName().toLowerCase().contains(text.toLowerCase()) ||
                    s.getFirstName().toLowerCase().contains(text.toLowerCase()) ||
                    s.getFirstName().toLowerCase().contains(text.toLowerCase())) {
                filterdNames.add(s);
            }
        }

  ///      guestAdapter.filterList(filterdNames);
    }
}
