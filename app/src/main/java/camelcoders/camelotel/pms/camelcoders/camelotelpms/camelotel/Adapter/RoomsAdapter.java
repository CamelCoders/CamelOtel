package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;

public class RoomsAdapter extends RecyclerView.Adapter<RoomsAdapter.StayInformationView> {

    ArrayList<StayInformation> StayInformationsList = new ArrayList<>();

    public RoomsAdapter(ArrayList<StayInformation> StayInformationsList) {
        this.StayInformationsList = StayInformationsList;
    }

    @NonNull
    @Override
    public StayInformationView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_booking_item,parent,false);

        return new StayInformationView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StayInformationView holder, int position) {

        StayInformation StayInformation = StayInformationsList.get(position);
        holder.roomtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return StayInformationsList.size();
    }

    public class StayInformationView extends RecyclerView.ViewHolder{

        EditText roomtype,roomnumber,adult,child;
        public StayInformationView(@NonNull View itemView) {
            super(itemView);

            roomtype = (EditText) itemView.findViewById(R.id.addRoomType);
            roomnumber = (EditText)itemView.findViewById(R.id.addRoomNumber);
            adult = (EditText)itemView.findViewById(R.id.addAdult);
            child = (EditText)itemView.findViewById(R.id.addChild);


        }
    }

}
