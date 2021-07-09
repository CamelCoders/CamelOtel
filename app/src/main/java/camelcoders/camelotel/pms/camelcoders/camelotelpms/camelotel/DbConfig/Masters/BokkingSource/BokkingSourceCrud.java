package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MasterCodeViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource.BusinessSource;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource.BokkingSource;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BokkingSourceCrud
{
    //Retrieve BokkingSource Function
    public static List<BokkingSource> BokkingSourceList = new ArrayList<>();
//    public static BokkingSourceAdapter BokkingSourceAdapter;
    public BookingSourceApiInterface apiInterface = ApiClient.getApiClient().create(BookingSourceApiInterface.class);

     public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;
    public void getBookingSource(Context context, RecyclerView recyclerView) {
        BokkingSourceList.clear();
        Call<List<BokkingSource>> call = apiInterface.getBookinSourceList();
        call.enqueue(new Callback<List<BokkingSource>>() {
            @Override
            public void onResponse(Call<List<BokkingSource>> call, Response<List<BokkingSource>> response) {
                BokkingSourceList = response.body();
                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(context);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                layoutManager.setJustifyContent(JustifyContent.FLEX_START);
                recyclerView.setLayoutManager(layoutManager);
//                BokkingSourceAdapter = new BokkingSourceAdapter(context, BokkingSourceList);
//                recyclerView.setAdapter(BokkingSourceAdapter);
            }
            @Override
            public void onFailure(Call<List<BokkingSource>> call, Throwable t) {
            }
        });
    }

    public void getBookingSourceList(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
         Call<List<BokkingSource>> call = apiInterface.getBookinSourceList();
        call.enqueue(new Callback<List<BokkingSource>>() {
            @Override
            public void onResponse(Call<List<BokkingSource>> call, Response<List<BokkingSource>> response) {
                BokkingSourceList = response.body();
                for (int i=0;i<BokkingSourceList.size();i++){
                    masterListModals.add(new MasterListModal(BokkingSourceList.get(i).getShortcode(),
                            BokkingSourceList.get(i).getMa_bookingsource_type(),
                            BokkingSourceList.get(i).getCreateddate(),BokkingSourceList.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);
            }

            @Override
            public void onFailure(Call<List<BokkingSource>> call, Throwable t) {
            }
        });
    }

    //Update BokkingSource Function
//    public void upadteBokkingSource(String BokkingSourceId, String BokkingSourceSalutation, String BokkingSourceFirstName, String BokkingSourceMiddleName,
//                            String BokkingSourceLastName, String BokkingSourcePinCode, String BokkingSourceCity, String BokkingSourceAddress,
//                            String BokkingSourceCountry, String BokkingSourceFullAddress, String BokkingSourceEmail, String BokkingSourcePhoneNumber,
//                            String BokkingSourceIdentityType, String BokkingSourceIdentityNumber, String BokkingSourceNationality, String BokkingSourceStatus,
//                            String BokkingSourceGender) {
//
//        Call<BokkingSource> call = apiInterface.updateBokkingSource(BokkingSourceId, BokkingSourceSalutation, BokkingSourceFirstName, BokkingSourceMiddleName,
//                BokkingSourceLastName, BokkingSourcePinCode, BokkingSourceCity, BokkingSourceAddress,
//                BokkingSourceCountry, BokkingSourceFullAddress, BokkingSourceEmail, BokkingSourcePhoneNumber,
//                BokkingSourceIdentityType, BokkingSourceIdentityNumber, BokkingSourceNationality, BokkingSourceStatus,
//                BokkingSourceGender);
//        call.enqueue(new Callback<BokkingSource>() {
//            @Override
//            public void onResponse(Call<BokkingSource> call, Response<BokkingSource> response) {
//                String value = response.body().getValue();
//                String message = response.body().getMassage();
//                Log.e("e", "uhuhuh");
//            }
//
//            @Override
//            public void onFailure(Call<BokkingSource> call, Throwable t) {
//                Log.e("", "" + t.getMessage());
//            }
//        });
//    }

//    public void filter(Activity context, String text) {
//        List<BokkingSource> filterdNames = new ArrayList<>();
//
//        for (BokkingSource s : BokkingSourceList) {
//
//            if (s.getFirstName().toLowerCase().contains(text.toLowerCase()) ||
//                    s.getFirstName().toLowerCase().contains(text.toLowerCase()) ||
//                    s.getFirstName().toLowerCase().contains(text.toLowerCase())) {
//                filterdNames.add(s);
//            }
//        }
//        BokkingSourceAdapter.filterList(filterdNames);
//    }
}
