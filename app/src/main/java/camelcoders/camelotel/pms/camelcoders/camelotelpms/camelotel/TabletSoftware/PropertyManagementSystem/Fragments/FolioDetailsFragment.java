package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentFolioDetailsBinding;

public class FolioDetailsFragment extends Fragment {

    FragmentFolioDetailsBinding binding;
    public FolioDetailsFragment() {
        // Required empty public constructor
    }
    public static FolioDetailsFragment newInstance() {
        FolioDetailsFragment fragment = new FolioDetailsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFolioDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}