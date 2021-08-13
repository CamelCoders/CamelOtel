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

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.OnItemClickFolio;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.FolioDetailsItem;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

public class FolioDetailsItemAdapter extends RecyclerView.Adapter<FolioDetailsItemAdapter.FolioDetailsItemHolder> {

    private final Context mContext;
   public List<FolioDetailsItem> FolioDetailsItemAdapterList = new ArrayList<>();
    public OnItemClickFolio mOnItemClickListener;

    public FolioDetailsItemAdapter(List<FolioDetailsItem> FolioDetailsItemAdapterList, Context context,OnItemClickFolio onItemClickFolio) {
        this.FolioDetailsItemAdapterList = FolioDetailsItemAdapterList;
        this.mOnItemClickListener=onItemClickFolio;
        this.mContext = context;
    }

    @Override
    public FolioDetailsItemAdapter.FolioDetailsItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.folio_details_item, parent, false);
        return new FolioDetailsItemAdapter.FolioDetailsItemHolder(view);
    }

    @Override
    public int getItemCount() {
        return FolioDetailsItemAdapterList == null ? 0 : FolioDetailsItemAdapterList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull FolioDetailsItemAdapter.FolioDetailsItemHolder holder, final int position) {

        FolioDetailsItem adapter = FolioDetailsItemAdapterList.get(position);
        holder.chargesCategoryText.setText(adapter.getChargesCategoryText());
        holder.refNoText.setText(adapter.getRefNoText());
//        holder.dateText.setText(adapter.getDateText());
        holder.roomNo.setText(adapter.getRoomNo());
        holder.voucherNoText.setText(adapter.getVoucherNoText());
        holder.posUserName.setText(adapter.getPosUserName());
        holder.outletText.setText(adapter.getOutletText());
        holder.chargesCategory.setText(adapter.getChargesCategory());
        holder.folioCharges.setText(adapter.getFolioCharges());
        holder.adminText.setText(adapter.getAdminText());
    }

    // This is your ViewHolder class that helps to populate data to the view
    public class FolioDetailsItemHolder extends RecyclerView.ViewHolder {
        private final TextView
                chargesCategoryText, refNoText, dateText, roomNo,
                voucherNoText, posUserName, outletText, chargesCategory, folioCharges, adminText;


        public FolioDetailsItemHolder(View itemView) {
            super(itemView);
            chargesCategoryText = itemView.findViewById(R.id.chargesCategoryText);
            refNoText = itemView.findViewById(R.id.refNoText);
            dateText = itemView.findViewById(R.id.folioDate);
            roomNo = itemView.findViewById(R.id.roomNo);
            voucherNoText = itemView.findViewById(R.id.voucherNoText);
            posUserName = itemView.findViewById(R.id.posUserName);
            outletText = itemView.findViewById(R.id.outletText);
            chargesCategory = itemView.findViewById(R.id.chargesCategory);
            folioCharges = itemView.findViewById(R.id.folioCharges);
            adminText = itemView.findViewById(R.id.adminText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(itemView, FolioDetailsItemAdapterList.get(getAdapterPosition()));
                }
            });
        }

    }
}