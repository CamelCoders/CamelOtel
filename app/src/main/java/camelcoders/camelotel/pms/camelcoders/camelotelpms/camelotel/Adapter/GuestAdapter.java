package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.OnItemClick;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.ViewHolder> {


    public Context ctx;
    String type;
    OnItemClick onItemClick;
    private List<Guest> items = new ArrayList<>();

    public GuestAdapter(Context context, List<Guest> items, OnItemClick onItemClick, String type) {
        this.items = items;
        this.ctx = context;
        this.type = type;
        this.onItemClick = onItemClick;
    }


    @Override
    public GuestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_list, parent, false);

        return new GuestAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Guest p = items.get(position);
        holder.guestName.setText(p.getFirstName() + " " + p.getMidName() + "");
        holder.phonenumber.setText(p.getNumber());
        holder.pincode.setText(p.getZipode());

    }

    @Override
    public int getItemCount() {
        return (null != items ? items.size() : 0);

    }

    public void filterList(List<Guest> filterdNames) {
        this.items = filterdNames;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView guestName, identitynumber, pincode, phonenumber;
        LinearLayout fillGuest;

        public ViewHolder(View v) {
            super(v);
            guestName = v.findViewById(R.id.guestName);
            pincode = v.findViewById(R.id.pincode);
            identitynumber = v.findViewById(R.id.Identitiynumber);
            phonenumber = v.findViewById(R.id.phonenumber);
            fillGuest = v.findViewById(R.id.fillGuest);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onClick(v, items.get(getAdapterPosition()));
                }
            });
        }


    }
}
