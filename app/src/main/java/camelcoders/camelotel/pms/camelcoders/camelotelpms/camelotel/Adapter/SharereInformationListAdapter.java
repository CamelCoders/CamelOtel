package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.OnItemClick;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;

public class SharereInformationListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context ctx;
    private List<Guest> items = new ArrayList<>();
    public OnItemClick mOnItemClickListener;

    public SharereInformationListAdapter(Context context, List<Guest> items,OnItemClick onItemClick) {
        this.items = items;
        ctx = context;
        this.mOnItemClickListener=onItemClick;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sharer_information_list_item, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final OriginalViewHolder view = (OriginalViewHolder) holder;

            final Guest p = items.get(position);

            view.sharerName.setText(p.getSalutation()+" "+p.getFirstName()+" "+p.getMidName()
                    +" "+p.getLastName());
            view.sharerCountry.setText(p.getNationality());
            view.registrationCardNoText.setText(p.getIdNumber());


             view.guestEmailId.setText(p.getEmail());
            view.guestPhone.setText(p.getNumber());
            view.identityCategory.setText(p.getIdType());
            view.identityNumber.setText(p.getIdNumber());
//            view.arrivalText.setText(p.getArrivalText());
//            view.nightText.setText(p.getNightText());
//            view.departuteText.setText(p.getDepartuteText());
//            view.adultText.setText(p.getAdultText());
//            view.roomCatText.setText(p.getRoomCatText());
//            view.ratetypeText.setText(p.getRatetypeText());
//            view.tarrifText.setText(p.getTarrifText());
//            view.taxText.setText(p.getTaxText());
//            view.discountText.setText(p.getDiscountText());
//            view.adjustmentText.setText(p.getAdjustmentText());
//            view.netAmountText.setText(p.getNetAmountText());


            view.bt_expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean show = toggleLayoutExpand(!p.expanded, v, view.lyt_expand);
                    items.get(position).expanded = show;
                }
            });


            // void recycling view
            if (p.expanded) {
                view.lyt_expand.setVisibility(View.VISIBLE);
            } else {
                view.lyt_expand.setVisibility(View.GONE);
            }
            AppConfig.toggleArrow(p.expanded, view.bt_expand, false);

        }
    }

    private boolean toggleLayoutExpand(boolean show, View view, View lyt_expand) {
        AppConfig.toggleArrow(show, view);
        if (show) {
            AppConfig.expand(lyt_expand);
        } else {
            AppConfig.collapse(lyt_expand);
        }
        return show;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Guest obj, int position);
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageButton bt_expand;
        public View lyt_expand;
        public View lyt_parent;
        TextView sharerName, sharerCountry, registrationCardNoText,
                guestName, guestEmailId, guestPhone, identityCategory, identityNumber,
                arrivalText, nightText, departuteText, adultText, roomCatText, ratetypeText,
                tarrifText, taxText, discountText, adjustmentText, netAmountText;

        public OriginalViewHolder(View v) {
            super(v);
            bt_expand = (ImageButton) v.findViewById(R.id.bt_expand);
            lyt_expand = (View) v.findViewById(R.id.lyt_expand);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);
            sharerName = (TextView) v.findViewById(R.id.sharerName);
            sharerCountry = (TextView) v.findViewById(R.id.sharerCountry);
            registrationCardNoText = (TextView) v.findViewById(R.id.registrationCardNoText);

            guestName = (TextView) v.findViewById(R.id.guestName);
            guestEmailId = (TextView) v.findViewById(R.id.guestEmailId);
            guestPhone = (TextView) v.findViewById(R.id.guestPhone);
            identityCategory = (TextView) v.findViewById(R.id.identityCategory);
            identityNumber = (TextView) v.findViewById(R.id.identityNumber);


            arrivalText = (TextView) v.findViewById(R.id.arrivalText);
            nightText = (TextView) v.findViewById(R.id.nightText);
            departuteText = (TextView) v.findViewById(R.id.departuteText);
            adultText = (TextView) v.findViewById(R.id.adultText);
            roomCatText = (TextView) v.findViewById(R.id.roomCatText);
            ratetypeText = (TextView) v.findViewById(R.id.ratetypeText);
            tarrifText = (TextView) v.findViewById(R.id.tarrifText);
            taxText = (TextView) v.findViewById(R.id.taxText);
            discountText = (TextView) v.findViewById(R.id.discountText);
            adjustmentText = (TextView) v.findViewById(R.id.adjustmentText);
            netAmountText = (TextView) v.findViewById(R.id.netAmountText);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(v, items.get(getAdapterPosition()));
                }
            });
        }
    }

}