package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.Rooms;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomViewAdapter extends RecyclerView.Adapter<RoomViewAdapter.RoomViewHolder> {
    public GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);
    String currentString ;
    String[] separated ;
    // List to store all the contact details
    List<Rooms> RoomsArrayList=new ArrayList<>();
    List<Guest> guestList=new ArrayList<>();

    List<StayInformation> stayInformationList=new ArrayList<>();
    SimpleDateFormat simpleDateFormat;
    Calendar calendar=Calendar.getInstance();

    private final Context mContext;

     public RoomViewAdapter(List<Rooms> RoomsArrayList, Context context) {
        this.RoomsArrayList = RoomsArrayList;
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
        return RoomsArrayList == null ? 0 : RoomsArrayList.size();
    }

    // This method is called when binding the data to the views being created in RecyclerView

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, final int position) {
        final Rooms contact = RoomsArrayList.get(position);
        simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");

        // Set the data to the views here
        holder.roomCat.setText(contact.getRoom_type_id());
        holder.roomNumber.setText(contact.getRoom_name());




        StayInformationApiInterface stayInformationApiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = stayInformationApiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();


                for (int i=0;i<stayInformationList.size();i++){

                    if (stayInformationList.get(i).getRoomnumber().equals(contact.getRoom_name()) &&
                            stayInformationList.get(i).getCheckin().equals(simpleDateFormat.format(calendar.getTime()))){
                        currentString =stayInformationList.get(i).getGuestid();
                        separated = currentString.split(",");


                        if (stayInformationList.get(i).getStatus().equals("0")){
                            holder.roomCat.setTextColor(ContextCompat.getColor(mContext, R.color.green_800));

                        }

                    }



                    }


            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });












//        Call<List<Guest>> callGuest = apiInterface.getGuest();
//        callGuest.enqueue(new Callback<List<Guest>>() {
//            @Override
//            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
//                guestList = response.body();
//                for (int i=0;i<guestList.size() ;i++){
//
//                    if (guestList.get(i).getGuestid().equals(separated[0])){
//                        holder.guestName.setText(guestList.get(i).getFirstName()+" "+guestList.get(i).getMidName()
//                        +" "+guestList.get(i).getLastName());
//                    }
//
//                }
//
//
//            }
//            @Override
//            public void onFailure(Call<List<Guest>> call, Throwable t) {
//                Log.e(":df",""+t.getMessage());
//
//            }
//        });
////
        holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.blue_800));

        if (contact.getStatus().equals("1")){
               holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.red_800));

        }else  if (contact.getStatus().equals("2")){
              holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.orange_500));
        }




//        if (contact.getGuestName().equals("")) {
//            holder.guestName.setVisibility(View.INVISIBLE);
//        } else {
//            if (contact.getColor().equals("available")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.dark_color));
//            } else if (contact.getColor().equals("checkedout")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.orange_500));
//            } else if (contact.getColor().equals("occupied")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.red_800));
//            } else if (contact.getColor().equals("confirmed")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.green_500));
//            } else if (contact.getColor().equals("maintenance")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.black));
//            } else if (contact.getColor().equals("stayover")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.orange_300));
//            } else if (contact.getColor().equals("dayuseRes")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.green_800));
//            } else if (contact.getColor().equals("dayuse")) {
//                holder.guestName.setTextColor(ContextCompat.getColor(mContext, R.color.blue_600));
//            }
//            holder.guestName.setText(contact.getGuestName());
//        }
//        if (contact.isDirty()) {
//            holder.isDirty.setVisibility(View.VISIBLE);
//        } else {
//            holder.isDirty.setVisibility(View.GONE);
//        }
//        if (contact.isMeal()) {
//            holder.isMeal.setVisibility(View.VISIBLE);
//        } else {
//            holder.isMeal.setVisibility(View.GONE);
//        }
//        if (contact.isSmoking()) {
//            holder.isSmoking.setVisibility(View.VISIBLE);
//        } else {
//            holder.isSmoking.setVisibility(View.GONE);
//        }
//        if (contact.isVip()) {
//            holder.isVip.setVisibility(View.VISIBLE);
//        } else {
//            holder.isVip.setVisibility(View.GONE);
//        }
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