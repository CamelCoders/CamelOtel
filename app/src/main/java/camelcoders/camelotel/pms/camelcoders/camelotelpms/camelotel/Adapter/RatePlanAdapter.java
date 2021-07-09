package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan.RatePlan;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.ratePlanCrud;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.reservationForm;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.roomsCrud;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.roomsTypeCrud;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.stayInformationCrud;


public class RatePlanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

GuestCrud newGuest=new GuestCrud();



    private List<RatePlan> items = new ArrayList<>();
    private List<RatePlan> itemFilter = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    EditText editText;

    public interface OnItemClickListener {
        void onItemClick(View view, RatePlan obj, int position);
    }


    public RatePlanAdapter(Context context, List<RatePlan> items, EditText editText) {
        this.items = items;
        this.itemFilter = items;
        this.editText = editText;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder  {
         public TextView name;
         LinearLayout fillRatePlan;


        public OriginalViewHolder(View v) {
            super(v);
            name=v.findViewById(R.id.optionType);


        }



    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_stay_informationlist, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final OriginalViewHolder view = (OriginalViewHolder) holder;

            final RatePlan p = items.get(position);
            view.name.setText(p.getRoomplanname());

    view.name.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setText(p.getRoomplanname());

            if (editText.equals(reservationForm.staySubStayPlan)){
                Log.e("",""+ ReservationForm.stayroomtype);
            }
        }
    });

        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filterList(List<RatePlan> filterdNames) {
         this.items = filterdNames;
        notifyDataSetChanged();
    }
}