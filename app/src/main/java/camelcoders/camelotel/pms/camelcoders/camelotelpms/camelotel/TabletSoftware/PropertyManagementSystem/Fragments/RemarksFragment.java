package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;


public class RemarksFragment extends Fragment {
    public RemarksFragment() {
        // Required empty public constructor
    }

    public static RemarksFragment newInstance() {
        RemarksFragment fragment = new RemarksFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_remarks_fragment, container, false);
    }
}