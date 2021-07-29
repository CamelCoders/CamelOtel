package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.ViewReservationActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentGeneralInformationBinding;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentRoomChargesBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralInformationFragment extends Fragment {

    FragmentGeneralInformationBinding binding;
    public   List<StayInformation> stayInformations = new ArrayList<>();
    String stayInformationId;
    float averageRate;
    public GeneralInformationFragment() {
        // Required empty public constructor
    }
    public static GeneralInformationFragment newInstance() {
        GeneralInformationFragment fragment = new GeneralInformationFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGeneralInformationBinding.inflate(inflater, container, false);
        stayInformationId = getActivity().getIntent().getStringExtra("stayId");

   setStayInfo();
        return binding.getRoot();
    }



    public void setStayInfo() {
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
                         @Override
                         public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                             stayInformations = response.body();

                             for (int i = 0; i < stayInformations.size(); i++) {
                                 if (stayInformationId.
                                         equals(stayInformations.get(i).getId())) {
                                     binding.ratePlan.setText(stayInformations.get(i).getSubRatePlan());
                                     averageRate = Float.parseFloat(stayInformations.get(i).getAmountWithTax()) /
                                             Float.parseFloat(stayInformations.get(i).getNoofnight());
                                     binding.averagerate.setText(String.valueOf(averageRate+"/night"));
                                 }
                             }

                         
                     
//

            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }

}