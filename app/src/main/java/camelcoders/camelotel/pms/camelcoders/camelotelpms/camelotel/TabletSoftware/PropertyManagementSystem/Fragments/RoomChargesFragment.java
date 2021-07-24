package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RoomChargesAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.RoomChargesModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.PmsTabDashboard;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentRoomChargesBinding;

public class RoomChargesFragment extends Fragment {

    FragmentRoomChargesBinding binding;
    private RoomChargesAdapter listAdapter;
    private ArrayList<RoomChargesModel> roomChargesModelArrayList = new ArrayList<>();

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

        binding = FragmentRoomChargesBinding.inflate(inflater, container, false);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.roomChargesRecycler.setLayoutManager(layoutManager);
        listAdapter = new RoomChargesAdapter(roomChargesModelArrayList, getContext());
        binding.roomChargesRecycler.setAdapter(listAdapter);

        //Load the date from the network or other resources
        //into the array list asynchronously

        roomChargesModelArrayList.add(new RoomChargesModel("24/07/2021 SAT","Play Deluxe","BAR - CP",
                "2/0","1,544.41","0.00","185.32","0.00","1,729.73"));
        roomChargesModelArrayList.add(new RoomChargesModel("24/07/2021 SAT","Play Deluxe","BAR - CP",
                "2/0","1,544.41","0.00","185.32","0.00","1,729.73"));
        roomChargesModelArrayList.add(new RoomChargesModel("24/07/2021 SAT","Play Deluxe","BAR - CP",
                "2/0","1,544.41","0.00","185.32","0.00","1,729.73"));
        roomChargesModelArrayList.add(new RoomChargesModel("24/07/2021 SAT","Play Deluxe","BAR - CP",
                "2/0","1,544.41","0.00","185.32","0.00","1,729.73"));
        roomChargesModelArrayList.add(new RoomChargesModel("24/07/2021 SAT","Play Deluxe","BAR - CP",
                "2/0","1,544.41","0.00","185.32","0.00","1,729.73"));
        roomChargesModelArrayList.add(new RoomChargesModel("24/07/2021 SAT","Play Deluxe","BAR - CP",
                "2/0","1,544.41","0.00","185.32","0.00","1,729.73"));



        listAdapter.notifyDataSetChanged();
        return binding.getRoot();
    }
}