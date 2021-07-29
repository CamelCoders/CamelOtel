package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.AuditTrailAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.AuditTrailModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentRemarksFragmentBinding;


public class RemarksFragment extends Fragment {
    private final ArrayList<AuditTrailModel> auditTrailModelArrayList = new ArrayList<>();
    FragmentRemarksFragmentBinding binding;
    private AuditTrailAdapter listAdapter;

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

        binding = FragmentRemarksFragmentBinding.inflate(inflater, container, false);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.remarksListRecyclerView.setLayoutManager(layoutManager);
        listAdapter = new AuditTrailAdapter(auditTrailModelArrayList, getContext());
        binding.remarksListRecyclerView.setAdapter(listAdapter);


        auditTrailModelArrayList.add(new AuditTrailModel("Important Info", "CC Details not Provided , The Guest can cancel free of charge anytime - non-smoking", "OTA", "25/07/2021 11:4:50AM", "10.0.4.2.11"));
        auditTrailModelArrayList.add(new AuditTrailModel("Reservation", "Breakfast is included in the room rate", "OTA", "25/07/2021 11:4:50AM", "10.0.4.2.11"));

        listAdapter.notifyDataSetChanged();

        return binding.getRoot();
    }
}