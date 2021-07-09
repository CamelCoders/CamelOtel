package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.FolioPlan.FolioPlan;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.CheckInData;


public class FolioPlanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

GuestCrud newGuest=new GuestCrud();



    private List<FolioPlan> items = new ArrayList<>();
    private List<FolioPlan> itemFilter = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;
    EditText editText;
    EditText edittext;
    RecyclerView newRecycler;

    public interface OnItemClickListener {
        void onItemClick(View view, FolioPlan obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public FolioPlanAdapter(Context context, List<FolioPlan> items, EditText editText, RecyclerView newRecycler) {
        this.items = items;
        this.itemFilter = items;
        this.editText = editText;
         this.newRecycler = newRecycler;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder  {
         public TextView name;
         LinearLayout fillFolioPlan;


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

            final FolioPlan p = items.get(position);
            view.name.setText(p.getTypename());

    view.name.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckInData.creditdebit=p.getType();

                        editText.setText(p.getTypename());

        }
    });

        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filterList(List<FolioPlan> filterdNames) {
         this.items = filterdNames;
        notifyDataSetChanged();
    }
}