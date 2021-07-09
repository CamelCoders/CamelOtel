package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.PaymentType;

import android.content.Context;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.MasterCodeViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType.IdentityType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.MisclleniousModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.MasterListModal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentTypeCrud {
    public PaymentTypeApiInterface apiInterface = ApiClient.getApiClient().create(PaymentTypeApiInterface.class);

    //Retrieve PaymentType Function
    public static List<PaymentType> paymentList = new ArrayList<>();
    public static List<MisclleniousModel> misclleniousModelList = new ArrayList<>();

     public List<MasterListModal> masterListModals = new ArrayList<>();

    MasterCodeViewAdapter marketTypeAdapter;

    public   void getBillPaymentList(Context context, RecyclerView recyclerView, EditText editText, EditText editText2) {
        misclleniousModelList.clear();
        Call<List<PaymentType>> call = apiInterface.getPaymentType();
        call.enqueue(new Callback<List<PaymentType>>() {
            @Override
            public void onResponse(Call<List<PaymentType>> call, Response<List<PaymentType>> response) {

                paymentList = response.body();
                for (int i=0;i<paymentList.size();i++){
                    masterListModals.add(new MasterListModal(paymentList.get(i).getShortcode(),
                            paymentList.get(i).getPaytypename(),
                            paymentList.get(i).getCreateddate(),paymentList.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);

            }

            @Override
            public void onFailure(Call<List<PaymentType>> call, Throwable t) {

            }
        });


    }
    public   void getPaymentList(Context context, RecyclerView recyclerView) {
        masterListModals.clear();
        Call<List<PaymentType>> call = apiInterface.getPaymentType();
        call.enqueue(new Callback<List<PaymentType>>() {
            @Override
            public void onResponse(Call<List<PaymentType>> call, Response<List<PaymentType>> response) {

                paymentList = response.body();
                for (int i=0;i<paymentList.size();i++){
                    masterListModals.add(new MasterListModal(paymentList.get(i).getShortcode(),
                            paymentList.get(i).getPaytypename(),
                            paymentList.get(i).getCreateddate(),paymentList.get(i).getStatus()));

                }

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);

                recyclerView.setLayoutManager(layoutManager);
                marketTypeAdapter = new MasterCodeViewAdapter(context, masterListModals);
                recyclerView.setAdapter(marketTypeAdapter);

            }

            @Override
            public void onFailure(Call<List<PaymentType>> call, Throwable t) {

            }
        });


    }


}



