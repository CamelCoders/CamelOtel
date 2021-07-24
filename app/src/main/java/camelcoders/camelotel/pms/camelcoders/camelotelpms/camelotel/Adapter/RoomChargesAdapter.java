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

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.RoomChargesModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

public class RoomChargesAdapter extends RecyclerView.Adapter<RoomChargesAdapter.RoomChargesHolder> {

    private final Context mContext;
    List<RoomChargesModel> roomChargesAdapterList = new ArrayList<>();

    public RoomChargesAdapter(List<RoomChargesModel> roomChargesAdapterList, Context context) {
        this.roomChargesAdapterList = roomChargesAdapterList;
        this.mContext = context;
    }

    @Override
    public RoomChargesAdapter.RoomChargesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.room_charges_item, parent, false);
        return new RoomChargesAdapter.RoomChargesHolder(view);
    }

    @Override
    public int getItemCount() {
        return roomChargesAdapterList == null ? 0 : roomChargesAdapterList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RoomChargesAdapter.RoomChargesHolder holder, final int position) {

        RoomChargesModel adapter = roomChargesAdapterList.get(position);
        holder.date.setText(adapter.getDate());
        holder.roomCategory.setText(adapter.getRoomCategory());
        holder.rateType.setText(adapter.getRateType());
        holder.paxText.setText(adapter.getPaxText());
        holder.roomCharges.setText(adapter.getRoomCharges());
        holder.discountText.setText(adapter.getDiscountText());
        holder.taxText.setText(adapter.getTaxText());
        holder.adjustmentTax.setText(adapter.getAdjustmentTax());
        holder.netAmountText.setText(adapter.getNetAmountText());


    }

    // This is your ViewHolder class that helps to populate data to the view
    public class RoomChargesHolder extends RecyclerView.ViewHolder {
        private final TextView date, roomCategory, rateType, paxText, roomCharges, discountText, taxText, adjustmentTax, netAmountText;


        public RoomChargesHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.reservationDate);
            roomCategory = itemView.findViewById(R.id.roomCategory);
            rateType = itemView.findViewById(R.id.rateType);
            paxText = itemView.findViewById(R.id.paxText);
            roomCharges = itemView.findViewById(R.id.roomCharges);
            discountText = itemView.findViewById(R.id.discountText);
            taxText = itemView.findViewById(R.id.taxText);
            adjustmentTax = itemView.findViewById(R.id.adjustmentText);
            netAmountText = itemView.findViewById(R.id.netAmountText);
        }

    }
}