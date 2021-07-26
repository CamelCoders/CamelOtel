package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.AuditTrailModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

public class AuditTrailAdapter extends RecyclerView.Adapter<AuditTrailAdapter.AuditTrailModelHolder> {

    private final Context mContext;
    List<AuditTrailModel> AuditTrailModelAdapterList = new ArrayList<>();

    public AuditTrailAdapter(List<AuditTrailModel> AuditTrailModelAdapterList, Context context) {
        this.AuditTrailModelAdapterList = AuditTrailModelAdapterList;
        this.mContext = context;
    }

    @Override
    public AuditTrailAdapter.AuditTrailModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.audit_trail_items, parent, false);
        return new AuditTrailAdapter.AuditTrailModelHolder(view);
    }

    @Override
    public int getItemCount() {
        return AuditTrailModelAdapterList == null ? 0 : AuditTrailModelAdapterList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull AuditTrailAdapter.AuditTrailModelHolder holder, final int position) {

        AuditTrailModel adapter = AuditTrailModelAdapterList.get(position);
        holder.trailCategory.setText(adapter.getTrailCategory());
        holder.auditTrailDescription.setText(adapter.getAuditTrailDescription());
        holder.auditTrailSource.setText(adapter.getAuditTrailSource());
        holder.auditTrailTime.setText(adapter.getAuditTrailTime());
        holder.auditTrailIPAddress.setText(adapter.getAuditTrailTime());
    }

    // This is your ViewHolder class that helps to populate data to the view
    public class AuditTrailModelHolder extends RecyclerView.ViewHolder {
        private final TextView trailCategory, auditTrailDescription, auditTrailSource, auditTrailTime,
                auditTrailIPAddress;


        public AuditTrailModelHolder(View itemView) {
            super(itemView);
            trailCategory = itemView.findViewById(R.id.trailCategory);
            auditTrailDescription = itemView.findViewById(R.id.auditTrailDescription);
            auditTrailSource = itemView.findViewById(R.id.auditTrailSource);
            auditTrailTime = itemView.findViewById(R.id.auditTrailTime);
            auditTrailIPAddress = itemView.findViewById(R.id.auditTrailIPAddress);

        }

    }
}