package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

public class RoomChargesFragment extends Fragment {


    public RoomChargesFragment() {
        // Required empty public constructor
    }

    public static RoomChargesFragment newInstance() {
        RoomChargesFragment fragment = new RoomChargesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_room_charges, container, false);
    }
}