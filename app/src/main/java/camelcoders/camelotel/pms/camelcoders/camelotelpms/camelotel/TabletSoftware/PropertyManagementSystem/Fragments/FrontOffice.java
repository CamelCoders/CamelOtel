package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.RoomViewAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.RoomViewModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentFrontOfficeBinding;


public class FrontOffice extends Fragment {
    private final ArrayList<RoomViewModel> roomViewModelArrayList = new ArrayList<>();
    private RoomViewAdapter roomViewAdapter;
    private FragmentFrontOfficeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_front_office, container, false);
//        return view;
        binding = FragmentFrontOfficeBinding.inflate(inflater, container, false);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.roomViewRecycler.setLayoutManager(layoutManager);
        roomViewAdapter = new RoomViewAdapter(roomViewModelArrayList, getContext());
        binding.roomViewRecycler.setAdapter(roomViewAdapter);

        //Load the date from the network or other resources
        //into the array list asynchronously
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, true));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "102", "Mr. Camelotel", "occupied", true, false, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "103", "Mr. Camelotel", "available", true, true, false, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "104", "Mr. Camelotel", "occupied", true, false, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "105", "Mr. Camelotel", "available", true, true, false, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "106", "Mr. Camelotel", "available", true, false, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "", "maintenance", true, true, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, false, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "occupied", true, false, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, false, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "occupied", true, false, true, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, true, false, false));
        roomViewModelArrayList.add(new RoomViewModel("Play Deluxe", "101", "Mr. Camelotel", "available", true, false, true, false));
        roomViewAdapter.notifyDataSetChanged();
        return binding.getRoot();
    }


}