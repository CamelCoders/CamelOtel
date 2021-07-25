package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.FolioDetailsItemAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.FolioDetailsItem;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentFolioDetailsBinding;

public class FolioDetailsFragment extends Fragment {

    FragmentFolioDetailsBinding binding;
    private final ArrayList<FolioDetailsItem> folioDetailsItemArrayList = new ArrayList<>();
    private FolioDetailsItemAdapter listAdapter;

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
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.folioDetailsRecycler.setLayoutManager(layoutManager);
        listAdapter = new FolioDetailsItemAdapter(folioDetailsItemArrayList, getContext());
        binding.folioDetailsRecycler.setAdapter(listAdapter);

        //Load the date from the network or other resources
        //into the array list asynchronously

        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));
        folioDetailsItemArrayList.add(new FolioDetailsItem("FandB Charges", "522", "2021-07-03",
                "206", "REC-873", "shristi", "Camelotel", "Restaurant", "Rs 38.00", "Shristi"));

        listAdapter.notifyDataSetChanged();
        return binding.getRoot();
    }
}