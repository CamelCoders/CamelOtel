package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentRoomChargesBinding;

public class GeneralInformationFragment extends Fragment {

    FragmentRoomChargesBinding binding;
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
        binding = FragmentRoomChargesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}