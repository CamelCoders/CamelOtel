package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.RoomViewModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

public class RoomViewAdapter extends RecyclerView.Adapter<RoomViewAdapter.RoomViewHolder> {

    // List to store all the contact details
    private final ArrayList<RoomViewModel> roomViewModelArrayList;
    private final Context mContext;

    // Counstructor for the Class
    public RoomViewAdapter(ArrayList<RoomViewModel> roomViewModelArrayList, Context context) {
        this.roomViewModelArrayList = roomViewModelArrayList;
        this.mContext = context;
    }

    // This method creates views for the RecyclerView by inflating the layout
    // Into the viewHolders which helps to display the items in the RecyclerView
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
// Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.room_view_item, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return roomViewModelArrayList == null ? 0 : roomViewModelArrayList.size();
    }

    // This method is called when binding the data to the views being created in RecyclerView

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, final int position) {
        final RoomViewModel contact = roomViewModelArrayList.get(position);

        // Set the data to the views here
        holder.roomCat.setText(contact.getRoomCat());
        holder.roomNumber.setText(contact.getRoomNumber());
        if (contact.getGuestName().equals("")) {
            holder.guestName.setVisibility(View.INVISIBLE);
        } else {
            if (contact.getColor().equals("available")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.dark_color));
            } else if (contact.getColor().equals("checkedout")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.orange_500));
            } else if (contact.getColor().equals("occupied")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.red_800));
            } else if (contact.getColor().equals("confirmed")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.green_500));
            } else if (contact.getColor().equals("maintenance")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.black));
            } else if (contact.getColor().equals("stayover")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.orange_300));
            } else if (contact.getColor().equals("dayuseRes")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.green_800));
            } else if (contact.getColor().equals("dayuse")) {
                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.blue_600));
            }
            holder.guestName.setText(contact.getGuestName());
        }
        if (contact.isDirty()) {
            holder.isDirty.setVisibility(View.VISIBLE);
        } else {
            holder.isDirty.setVisibility(View.GONE);
        }
        if (contact.isMeal()) {
            holder.isMeal.setVisibility(View.VISIBLE);
        } else {
            holder.isMeal.setVisibility(View.GONE);
        }
        if (contact.isSmoking()) {
            holder.isSmoking.setVisibility(View.VISIBLE);
        } else {
            holder.isSmoking.setVisibility(View.GONE);
        }
        if (contact.isVip()) {
            holder.isVip.setVisibility(View.VISIBLE);
        } else {
            holder.isVip.setVisibility(View.GONE);
        }
        // You can set click listners to indvidual items in the viewholder here
        // make sure you pass down the listner or make the Data members of the viewHolder public

    }

    // This is your ViewHolder class that helps to populate data to the view
    public class RoomViewHolder extends RecyclerView.ViewHolder {
        private final TextView roomCat;
        private final TextView roomNumber;
        private final TextView guestName;
        private final ImageView isSmoking;
        private final ImageView isDirty;
        private final ImageView isMeal;
        private final ImageView isVip;

        public RoomViewHolder(View itemView) {
            super(itemView);
            roomCat = itemView.findViewById(R.id.roomCat);
            roomNumber = itemView.findViewById(R.id.roomNo);
            guestName = itemView.findViewById(R.id.guestName);
            isSmoking = itemView.findViewById(R.id.isSmoking);
            isDirty = itemView.findViewById(R.id.isDirty);
            isMeal = itemView.findViewById(R.id.isMeal);
            isVip = itemView.findViewById(R.id.isVip);
        }

    }
}