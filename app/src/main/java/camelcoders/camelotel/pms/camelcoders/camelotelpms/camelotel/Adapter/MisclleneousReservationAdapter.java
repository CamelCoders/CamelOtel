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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType.RoomsTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.MisclleniousModel;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.reservationForm;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.roomsTypeCrud;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.stayInformationCrud;


public class MisclleneousReservationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

GuestCrud newGuest=new GuestCrud();



    private List<MisclleniousModel> items = new ArrayList<>();
    private List<MisclleniousModel> itemFilter = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    EditText editText,editText1;

    public interface OnItemClickListener {
        void onItemClick(View view, MisclleniousModel obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public MisclleneousReservationAdapter(Context context, List<MisclleniousModel> items, EditText editText) {
        this.items = items;
        this.itemFilter = items;
        this.editText = editText;
        ctx = context;
    }
    public MisclleneousReservationAdapter(Context context, List<MisclleniousModel> items, EditText editText,EditText editText1) {
        this.items = items;
        this.itemFilter = items;
        this.editText = editText;
        this.editText1 = editText1;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder  {
         public TextView name;
         LinearLayout fillMisclleniousModel;


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

            final MisclleniousModel p = items.get(position);
            view.name.setText(p.getName());
      view.name.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            editText.setText(p.getName());
            if (editText.equals(reservationForm.stayRooms)){
             //   roomsTypeCrud.getRoomsType(ctx,reservationForm.selectItemLayout,reservationForm.stayRoomType);

            }

            if (editText.equals(reservationForm.stayRoomSelect)){
               // roomsTypeCrud.getRoomsType(ctx,reservationForm.selectItemLayout,reservationForm.stayRoomType);

            }

            if (editText.equals(reservationForm.stayAdult)){
                roomsTypeCrud.getNoofchild(ctx,reservationForm.selectItemLayout,reservationForm.stayChild,reservationForm.stayroomtype);

            }
            if (editText.equals(reservationForm.stayChild)){
            }
            if (editText.equals(reservationForm.billBookTO)){

                stayInformationCrud.getPaymentMode(ctx,reservationForm.billlingList,reservationForm.billPaymentMode);

            }




        }
    });

        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filterList(List<MisclleniousModel> filterdNames) {
         this.items = filterdNames;
        notifyDataSetChanged();
    }
}