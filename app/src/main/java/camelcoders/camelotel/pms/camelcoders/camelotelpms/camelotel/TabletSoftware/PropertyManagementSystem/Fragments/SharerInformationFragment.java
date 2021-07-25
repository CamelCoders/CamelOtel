package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.SharereInformationListAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.SharereInformationListModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentSharerInformationBinding;

public class SharerInformationFragment extends Fragment {


    private final ArrayList<SharereInformationListModel> sharereInformationListModelArrayList = new ArrayList<>();
    FragmentSharerInformationBinding binding;
    private SharereInformationListAdapter listAdapter;

    public SharerInformationFragment() {
        // Required empty public constructor
    }

    public static SharerInformationFragment newInstance() {
        SharerInformationFragment fragment = new SharerInformationFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSharerInformationBinding.inflate(inflater, container, false);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.sharerListRecyclerView.setLayoutManager(layoutManager);
        listAdapter = new SharereInformationListAdapter(getContext(), sharereInformationListModelArrayList);
        binding.sharerListRecyclerView.setAdapter(listAdapter);

        //Load the date from the network or other resources
        //into the array list asynchronously

        sharereInformationListModelArrayList.add(new SharereInformationListModel("Mr Camelotel", "India", "667",
                "Mr. Camelotel", "abc@gmail.com", "9452059368", "Aadhar Card", "3341XXXX6700",
                "24/07/2021 01:49:41PM", "02", "24/07/2021 01:49:41PM", "2/0", "Play Deluxe", "BAR-CP",
                "Rs 1,667.24", "Rs 200.08", "Rs 0.00", "Rs 0.00", "Rs 1867.32"));

        sharereInformationListModelArrayList.add(new SharereInformationListModel("Mr Camelotel", "India", "667",
                "Mr. Camelotel", "abc@gmail.com", "9452059368", "Aadhar Card", "3341XXXX6700",
                "24/07/2021 01:49:41PM", "02", "24/07/2021 01:49:41PM", "2/0", "Play Deluxe", "BAR-CP",
                "Rs 1,667.24", "Rs 200.08", "Rs 0.00", "Rs 0.00", "Rs 1867.32"));

        sharereInformationListModelArrayList.add(new SharereInformationListModel("Mr Camelotel", "India", "667",
                "Mr. Camelotel", "abc@gmail.com", "9452059368", "Aadhar Card", "3341XXXX6700",
                "24/07/2021 01:49:41PM", "02", "24/07/2021 01:49:41PM", "2/0", "Play Deluxe", "BAR-CP",
                "Rs 1,667.24", "Rs 200.08", "Rs 0.00", "Rs 0.00", "Rs 1867.32"));

        sharereInformationListModelArrayList.add(new SharereInformationListModel("Mr Camelotel", "India", "667",
                "Mr. Camelotel", "abc@gmail.com", "9452059368", "Aadhar Card", "3341XXXX6700",
                "24/07/2021 01:49:41PM", "02", "24/07/2021 01:49:41PM", "2/0", "Play Deluxe", "BAR-CP",
                "Rs 1,667.24", "Rs 200.08", "Rs 0.00", "Rs 0.00", "Rs 1867.32"));


        listAdapter.notifyDataSetChanged();
        return binding.getRoot();
    }
}