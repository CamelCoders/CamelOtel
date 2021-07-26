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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FragmentAuditTrailBinding;


public class AuditTrailFragment extends Fragment {
    private final ArrayList<AuditTrailModel> auditTrailModelArrayList = new ArrayList<>();
    FragmentAuditTrailBinding binding;
    private AuditTrailAdapter listAdapter;

    public AuditTrailFragment() {
        // Required empty public constructor
    }

    public static AuditTrailFragment newInstance() {
        AuditTrailFragment fragment = new AuditTrailFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAuditTrailBinding.inflate(inflater, container, false);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
        layoutManager.setFlexDirection(FlexDirection.ROW);
        binding.audirTrailRecycler.setLayoutManager(layoutManager);
        listAdapter = new AuditTrailAdapter(auditTrailModelArrayList, getContext());
        binding.audirTrailRecycler.setAdapter(listAdapter);

        //Load the date from the network or other resources
        //into the array list asynchronously

        auditTrailModelArrayList.add(new AuditTrailModel("Add Payment", "Particular : Gp-MMT Ledger , Amount: Rs -21068.72, Payment Date: 2021-07-25", "OTA", "25/07/2021 11:4:50AM", "10.0.4.2.11"));
        auditTrailModelArrayList.add(new AuditTrailModel("Channel Booking", "Channel Booking : - Booking Ref No : - NH7520577107460, Channel: - Go-MMT, Channel Account: 1000234860", "OTA", "25/07/2021 11:4:50AM", "10.0.4.2.11"));
        auditTrailModelArrayList.add(new AuditTrailModel("New Booking Channel Room Assign", "Room Type : Play Deluxe Rate Plan name : Play Deluxe , Booking Ref No - NH7520577107460", "OTA", "25/07/2021 11:4:50AM", "10.0.4.2.11"));
        listAdapter.notifyDataSetChanged();
        return binding.getRoot();
    }
}