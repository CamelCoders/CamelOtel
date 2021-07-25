package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;


public class CheckInOffice extends Fragment {
    public static CheckInOffice newInstance() {
        CheckInOffice fragment = new CheckInOffice();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkin, container, false);

        return view;
    }

}