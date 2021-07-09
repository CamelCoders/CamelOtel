package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
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

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.RoomData;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.SlabLlistModal;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation.reservationForm;


public class PriceListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

GuestCrud newGuest=new GuestCrud();


        TextView rateT,amountT,taxamountT,taxperT;
    private List<RoomData> items = new ArrayList<>();
    private List< RoomData> itemFilter = new ArrayList<>();

    private Context ctx;


    public PriceListAdapter(Context context, List< RoomData> items,TextView rate,TextView amount,TextView taxamouont,TextView taxper) {
        this.items = items;
        this.itemFilter = items;
        this.rateT = rate;
        this.amountT = amount;
        this.taxamountT = taxamouont;
        this.taxperT = taxper;
         ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder  {
         public TextView name;
         EditText rate,amount,taxper,taxamount;


        public OriginalViewHolder(View v) {
            super(v);

            rate=v.findViewById(R.id.roomPriceWOtax);
            amount=v.findViewById(R.id.roomPriceWtax);
            taxamount=v.findViewById(R.id.roomPriceTaxAmount);
            taxper=v.findViewById(R.id.taxPercentage);








        }



    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_price_rresevation, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            final OriginalViewHolder view = (OriginalViewHolder) holder;

            final  RoomData p = items.get(position);
            view.rate.setText(p.getAmountWOtax());
            view.amount.setText(p.getAmountWtax());
            view.taxamount.setText(p.getTacamount());
             view.taxper.setText(p.getTaxtPer());
             view.rate.addTextChangedListener(new TextWatcher() {
                 @Override
                 public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                 }

                 @Override
                 public void onTextChanged(CharSequence s, int start, int before, int count) {
                     String taxvalue;
                     Float priceDay=Float.parseFloat(view.rate.getText().toString());

                     for (int i=0;i< StayInformationCrud.slabListModal.size();i++){
                         if (priceDay >= Float.parseFloat(StayInformationCrud.slabListModal.get(i).getFromprice())
                                 && priceDay <= Float.parseFloat(StayInformationCrud.slabListModal.get(i).getToprice())) {
                             taxvalue =StayInformationCrud.slabListModal.get(i).getPercentage();
                         }
                     }

                 }

                 @Override
                 public void afterTextChanged(Editable s) {

                 }
             });

        }
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filterList(List< RoomData> filterdNames) {
         this.items = filterdNames;
        notifyDataSetChanged();
    }

 }