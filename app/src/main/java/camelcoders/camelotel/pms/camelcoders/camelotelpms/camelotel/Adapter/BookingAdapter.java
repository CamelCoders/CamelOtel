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

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Booking;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.OnItemClick;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;


public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {


    public OnItemClickListener onItemClick;


    private List<Booking> items = new ArrayList<>();
    private List<Booking> itemFilter = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public BookingAdapter(Context context, List<Booking> items) {
        this.items = items;
        this.itemFilter = items;
        ctx = context;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @Override
    public BookingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_title_layout, parent, false);
        return new BookingAdapter.ViewHolder(view, viewType, (OnItemClick) onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Booking p = items.get(position);
//        holder.phonenumber.setText(p.getNumber());
//        holder.pincode.setText(p.getZipode());

    }

    @Override
    public int getItemCount() {
        return (null != items ? items.size() : 0);

    }

    public void filterList(List<Booking> filterdNames) {
        this.items = filterdNames;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Booking obj, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title_price, title_time_label, title_date_label, phonenumber;
        LinearLayout fillBooking;
        OnItemClick onItemClick;


        public ViewHolder(View v, int viewType, OnItemClick onItemClick) {
            super(v);

            this.onItemClick = onItemClick;
            title_price = v.findViewById(R.id.title_price);
            title_time_label = v.findViewById(R.id.title_time_label);
            title_date_label = v.findViewById(R.id.title_date_label);
            //    fillBooking.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (onItemClick != null) {
                onItemClick.onItemClick(getLayoutPosition(), view);
            }
        }
    }
}
