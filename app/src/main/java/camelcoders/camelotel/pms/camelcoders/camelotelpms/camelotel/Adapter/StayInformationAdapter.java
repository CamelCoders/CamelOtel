package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.OnItemClick;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Salutations.SalutationsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.AmendStayActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.ViewReservationActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.DialogArrivalListBinding;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.DialogDepartureListBinding;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.DialogInhouseListBinding;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.DialogReservationListBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StayInformationAdapter extends RecyclerView.Adapter<StayInformationAdapter.ViewHolder> {
    private final Context ctx;
    public GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);
    public OnItemClickListener onItemClick;
    public LinearLayout guestInformationButton, stayInformationButton,
            otherInformationButton, billingInformationButton, multipleStayInformationInformationButton;
    public LinearLayout formGuestInformation, formStayInformation, formGuestLayout;
    public List<Guest> guestList = new ArrayList<>();
    public TextView guestInformationButtonText, stayInformationButtonText,
            otherInformationButtonText, billingInformationButtonText, multipleStayInformationInformationButtonText;
    public TextInputEditText stayRooms, stayRoomType, stayRoomSelect, stayRateType,
            stayArrivalDate, stayArrivalTime,
            stayRatePlan, staySubStayPlan,
            stayArrivalNight, stayDepartureDate, stayDepartureTime,
            stayAdult, stayReserType, stayChild, stayGuestStatus;
    public TextView rate, taxPercentage, amount, taxAmount;
    Calendar cal = Calendar.getInstance();
    Dialog CheckinInfoDilog, addGuestDialog;
    Button AddGuest;
    SalutationsCrud salutationsCrud = new SalutationsCrud();
    GuestCrud guestCrud = new GuestCrud();
    String function;
    String guestIDs;
    RecyclerView selectStayREcycler;
    String[] guestData;
    String[] guestAdd = new String[1];
    Button CheckInBook;
    String currentString;
    String[] separated;
    private List<StayInformation> items = new ArrayList<>();
    private List<StayInformation> itemFilter = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener;

    public StayInformationAdapter(Context context, List<StayInformation> items, String function) {
        this.items = items;
        this.itemFilter = items;
        ctx = context;
        this.function = function;
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @Override
    public StayInformationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_content_layout, parent, false);
        return new StayInformationAdapter.ViewHolder(view, viewType, (OnItemClick) onItemClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final StayInformation p = items.get(position);
        holder.roomnumber.setText(p.getRoomnumber());

        // TODO: 7/22/2021 uncomment this intent
        //      holder.pincode.setText(p.getZipode());


        Call<List<Guest>> callGuest = apiInterface.getGuest();
        callGuest.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                guestList = response.body();
                for (int i = 0; i < guestList.size(); i++) {

                    if (guestList.get(i).getGuestid().equals(p.getParentGuestId())) {
                        holder.guestName.setText(guestList.get(i).getSalutation()
                                + " " + guestList.get(i).getFirstName() + " " + guestList.get(i).getMidName()
                                + " " + guestList.get(i).getLastName());
                    }

                }


            }

            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e(":df", "" + t.getMessage());

            }
        });
        holder.listItemDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (function.equals("Reservation")) {
                    DialogReservationListBinding binding = AppConfig.showReservationOperations((Activity) ctx);
                    binding.viewReservationReservation.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ctx, ViewReservationActivity.class);
                            intent.putExtra("stayId", p.getId());
                            intent.putExtra("bookingId", p.getBookingid());
                            intent.putExtra("guestId", p.getParentGuestId());
                            intent.putExtra("guestIds", p.getGuestid());
                            ctx.startActivity(intent);
                            ((Activity) ctx).finish();
                        }
                    });
                    binding.ReservationAuditTrail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(ctx, ViewReservationActivity.class);
                            intent.putExtra("auditTrail", "true");
                            intent.putExtra("stayId", p.getId());
                            intent.putExtra("bookingId", p.getBookingid());
                            intent.putExtra("guestId", p.getParentGuestId());
                            intent.putExtra("guestIds", p.getGuestid());
                            ctx.startActivity(intent);
                            ((Activity) ctx).finish();
                        }
                    });
                    binding.ReservationUnassignRoom.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (true) {
                                Dialog dialog = AppConfig.showFullScreenCustomDialog(R.layout.unassign_room_alert_item, ctx);
                                dialog.show();
                            } else {

                            }
                        }
                    });
                    binding.ReservationAmendStay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AmendStayActivity obj = new AmendStayActivity(R.layout.activity_amend_stay, ctx);
                        }
                    });
                } else if (function.equals("Arrival")) {
                    DialogArrivalListBinding binding = AppConfig.showArrivalOperations((Activity) ctx);
                    binding.viewArrivalReservation.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppConfig.jumpTo((Activity) ctx, ViewReservationActivity.class, "fade");
                            ((Activity) ctx).finish();
                        }
                    });
                } else if (function.equals("Departure")) {
                    DialogDepartureListBinding binding = AppConfig.showDepartureOperations((Activity) ctx);
                    binding.viewDepartureReservation.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppConfig.jumpTo((Activity) ctx, ViewReservationActivity.class, "fade");
                            ((Activity) ctx).finish();
                        }
                    });
                } else if (function.equals("InHouse")) {
                    DialogInhouseListBinding binding = AppConfig.showInHouseOperations((Activity) ctx);
                    binding.viewInHouseReservaton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AppConfig.jumpTo((Activity) ctx, ViewReservationActivity.class, "fade");
                            ((Activity) ctx).finish();
                        }
                    });
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != items ? items.size() : 0);

    }

    public void filterList(List<StayInformation> filterdNames) {
        this.items = filterdNames;
        notifyDataSetChanged();
    }


    private boolean setTotalPrice() {
        Float roomPriceWOtax = 00.00f, roomPriceWtax = 00.00f, roomTaxAmount = 00.00f;
        boolean result = true;

        for (int i = 0; i < formGuestInformation.getChildCount(); i++) {
            View view = formGuestInformation.getChildAt(i);
            TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
                    guestLastName, guestPincode, guestAddress, guestFullAddress,
                    guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
            RecyclerView guestRecyler;
            guestRecyler = view.findViewById(R.id.guestList);
            guestSalutation = view.findViewById(R.id.guestSalutation);
            guestFirstName = view.findViewById(R.id.guestFirstName);
            guestMiddleName = view.findViewById(R.id.guestMiddleName);
            guestLastName = view.findViewById(R.id.guestLastName);
            guestPincode = view.findViewById(R.id.guestPincode);
            guestState = view.findViewById(R.id.guestState);
            guestCity = view.findViewById(R.id.guestCity);
            guestFullAddress = view.findViewById(R.id.guestfullAdrress);
            guestAddress = view.findViewById(R.id.guestState);
            guestEmail = view.findViewById(R.id.guestEmail);
            guestCountry = view.findViewById(R.id.guestCountry);
            guestPhone = view.findViewById(R.id.guestPhoneNumber);
            guestIdType = view.findViewById(R.id.guestIdType);
            guestIdNumber = view.findViewById(R.id.guestIdNumber);

            if (guestSalutation.getText().toString().isEmpty() || guestFirstName.getText().toString().isEmpty() ||
                    guestPhone.getText().toString().isEmpty() ||
                    guestCountry.getText().toString().isEmpty() || guestEmail.getText().toString().isEmpty() ||
                    guestPincode.getText().toString().isEmpty() || guestState.getText().toString().isEmpty() ||
                    guestFullAddress.getText().toString().isEmpty() || guestCity.getText().toString().isEmpty() ||
                    guestIdType.getText().toString().isEmpty() || guestIdNumber.getText().toString().isEmpty()) {


                result = false;
                break;

            } else {

                DateFormat date = new SimpleDateFormat("MMddyyyyhhmmss");


                String biilid = date.format(cal.getTime());
                String guestId = guestFirstName.getText().toString() + biilid;
                guestIDs = guestIDs + guestId + ",";


                guestData[i] = guestId + "" + guestSalutation.getText().toString() + "!" + guestFirstName.getText().toString() + "!"
                        + guestMiddleName.getText().toString() + "!" + guestLastName.getText().toString() + "!" + guestFullAddress.getText().toString()
                        + "!" + guestAddress.getText().toString() + "!" + guestCity.getText().toString() + "!" + guestPincode.getText().toString()
                        + "!" + guestCountry.getText().toString() + "!" + guestCountry.getText().toString() + "!" + "VIP"
                        + "!" + guestEmail.getText().toString() + "!"
                        + guestPhone.getText().toString() + "!" + "GENDER" + "!" + guestIdType.getText().toString() + "!" + guestIdNumber.getText().toString();

                result = true;

            }


        }


        return result;

    }

    private void setValue() {
        Float roomPriceWOtax = 00.00f, roomPriceWtax = 00.00f, roomTaxAmount = 00.00f;
        boolean result = true;


        for (int i = 0; i < separated.length; i++) {

            for (int j = 0; j < guestList.size(); j++) {
                if (guestList.get(i).getGuestid().equals(separated[i])) {

                    View view = formGuestInformation.getChildAt(i);
                    TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
                            guestLastName, guestPincode, guestAddress, guestFullAddress,
                            guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
                    RecyclerView guestRecyler;
                    guestRecyler = view.findViewById(R.id.guestList);
                    guestSalutation = view.findViewById(R.id.guestSalutation);
                    guestFirstName = view.findViewById(R.id.guestFirstName);
                    guestMiddleName = view.findViewById(R.id.guestMiddleName);
                    guestLastName = view.findViewById(R.id.guestLastName);
                    guestPincode = view.findViewById(R.id.guestPincode);
                    guestState = view.findViewById(R.id.guestState);
                    guestCity = view.findViewById(R.id.guestCity);
                    guestFullAddress = view.findViewById(R.id.guestfullAdrress);
                    guestEmail = view.findViewById(R.id.guestEmail);
                    guestCountry = view.findViewById(R.id.guestCountry);
                    guestPhone = view.findViewById(R.id.guestPhoneNumber);
                    guestIdType = view.findViewById(R.id.guestIdType);
                    guestIdNumber = view.findViewById(R.id.guestIdNumber);

                    guestFullAddress.setText(guestList.get(i).getAddress());
                    guestFirstName.setText(guestList.get(i).getFirstName());
                    guestMiddleName.setText(guestList.get(i).getMidName());
                    guestPincode.setText(guestList.get(i).getZipode());
                    guestState.setText(guestList.get(i).getState());
                    guestCity.setText(guestList.get(i).getCity());
                    guestEmail.setText(guestList.get(i).getEmail());
                    guestCountry.setText(guestList.get(i).getCountry());
                    guestLastName.setText(guestList.get(i).getLastName());
                    guestLastName.setText(guestList.get(i).getLastName());
                    guestPhone.setText(guestList.get(i).getNumber());
                    guestIdType.setText(guestList.get(i).getIdType());
                    guestIdNumber.setText(guestList.get(i).getIdNumber());

                }

            }


        }


    }

    public interface OnItemClickListener {
        void onItemClick(View view, StayInformation obj, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView guestName, roomnumber, title_time_label, title_date_label, phonenumber;
        LinearLayout checkinClick;
        OnItemClick onItemClick;
        LinearLayout listItemDetails;

        public ViewHolder(View v, int viewType, OnItemClick onItemClick) {
            super(v);

            this.onItemClick = onItemClick;
            roomnumber = v.findViewById(R.id.roomnumber);
            guestName = v.findViewById(R.id.guestName);
            listItemDetails = v.findViewById(R.id.listItemDetails);
            title_date_label = v.findViewById(R.id.title_date_label);
            checkinClick = v.findViewById(R.id.checkinClick);

        }


    }

}
