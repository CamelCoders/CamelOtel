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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ListItemClickListener;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.guestId;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.reservationForm;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.ViewHolder> {


    public ListItemClickListener listItemClickListener;


    private List<Guest> items = new ArrayList<>();
    private List<Guest> itemFilter = new ArrayList<>();

    public Context ctx;
    String type;


    public GuestAdapter(Context context, List<Guest> items,String type) {
        this.items = items;
        this.itemFilter = items;
        this.ctx = context;
        this.type = type;
    }

    public void setItemClickListener(ListItemClickListener listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
    }

    @Override
    public GuestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guest_list, parent, false);
            return new GuestAdapter.ViewHolder(view, viewType, listItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Guest p = items.get(position);
        holder.guestName.setText(p.getFirstName()+" "+p.getMidName()+"");
        holder.phonenumber.setText(p.getNumber());
        holder.pincode.setText(p.getZipode());
        holder.fillGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type.equals("reservationGuest")){
                    guestId=p.getGuestid();

                   reservationForm.guestFirstName.setText(p.getFirstName());
                   reservationForm.guestMiddleName.setText(p.getMidName());
                   reservationForm.guestLastName.setText(p.getLastName());
                   reservationForm.guestSalutation.setText(p.getSalutation());
                   reservationForm.guestPincode.setText(p.getZipode());
                   reservationForm.guestState.setText(p.getState());
                   reservationForm.guestCity.setText(p.getCity());
                   reservationForm.guestFullAddress.setText(p.getAddress());
                   reservationForm.guestEmail.setText(p.getEmail());
                   reservationForm.guestPhone.setText(p.getNumber());
                   reservationForm.guestCountry.setText(p.getCountry());
                   reservationForm.guestIdType.setText(p.getIdType());
                   reservationForm.guestIdNumber.setText(p.getIdNumber());



                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return (null != items ? items.size() : 0);

    }

    public void filterList(List<Guest> filterdNames) {
        this.items = filterdNames;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView guestName, identitynumber, pincode, phonenumber;
        LinearLayout fillGuest;
        ListItemClickListener listItemClickListener;


        public ViewHolder(View v, int viewType, ListItemClickListener listItemClickListene) {
            super(v);

            this.listItemClickListener = listItemClickListene;
            guestName = v.findViewById(R.id.guestName);
            pincode = v.findViewById(R.id.pincode);
            identitynumber = v.findViewById(R.id.Identitiynumber);
            phonenumber = v.findViewById(R.id.phonenumber);
            fillGuest = v.findViewById(R.id.fillGuest);
            fillGuest.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listItemClickListener != null) {
                listItemClickListener.onItemClick(getLayoutPosition(), view);
            }
        }
    }
}
