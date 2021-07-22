package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;


public class StayInformationAdapter extends RecyclerView.Adapter<StayInformationAdapter.ViewHolder> {
    public GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);

    Calendar cal=Calendar.getInstance();
    public OnItemClickListener onItemClick;
    public LinearLayout guestInformationButton, stayInformationButton,
            otherInformationButton, billingInformationButton, multipleStayInformationInformationButton;
    public LinearLayout formGuestInformation, formStayInformation,formGuestLayout;
    private List<StayInformation> items = new ArrayList<>();
    private List<StayInformation> itemFilter = new ArrayList<>();
    public List<Guest> guestList = new ArrayList<>();
    Dialog CheckinInfoDilog,addGuestDialog;

    Button AddGuest;
    public TextView guestInformationButtonText, stayInformationButtonText,
            otherInformationButtonText, billingInformationButtonText, multipleStayInformationInformationButtonText;
        SalutationsCrud salutationsCrud=new SalutationsCrud();
    GuestCrud guestCrud = new GuestCrud();
    private final Context ctx;
    String guestIDs;
    private OnItemClickListener mOnItemClickListener;
    public TextInputEditText stayRooms, stayRoomType, stayRoomSelect, stayRateType,
            stayArrivalDate, stayArrivalTime,
            stayRatePlan, staySubStayPlan,
            stayArrivalNight, stayDepartureDate, stayDepartureTime,
            stayAdult, stayReserType, stayChild, stayGuestStatus;
    RecyclerView selectStayREcycler;
    String[] guestData ;
    String[] guestAdd= new String[1];
    Button CheckInBook;
    public TextView rate, taxPercentage, amount, taxAmount;


    String currentString ;
    String[] separated ;

    public StayInformationAdapter(Context context, List<StayInformation> items) {
        this.items = items;
        this.itemFilter = items;
        ctx = context;
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


//        holder.checkinClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(ctx, CheckInData.class);
//                intent.putExtra("id",p.getId());
//                ctx.startActivity(intent);
//
//              //  AppConfig.jumpTo((Activity) ctx,CheckInData.class,"fade");
//
//
////                CheckinInfoDilog = AppConfig.showFullScreenCustomDialog(R.layout.checkindialog, ctx);
////                initLayoutVariables(CheckinInfoDilog);
////                stayArrivalDate.setText(p.getCheckin());
////                stayDepartureDate.setText(p.getCheckout());
////                stayArrivalNight.setText(p.getNoofnight());
////                stayRoomType.setText(p.getRoomnumber()+"-"+p.getRoomtype());
////                stayRateType.setText(p.getRoomratetype());
////                stayRatePlan.setText(p.getRatePlan());
////                stayAdult.setText(p.getNoofdault());
////                stayChild.setText(p.getNoofchild());
////
////
////
////                  currentString =p.getGuestid();
////                  separated = currentString.split(",");
////
////
////                setValue();
////                setActiveForm("guestInformationButton", ctx);
////                guestData=new String[Integer.parseInt(p.getNoofdault())+Integer.parseInt(p.getNoofchild())];
////
////                for (int i=0;i<separated.length;i++){
////
////                    addView((Activity) ctx);
////
////                }
////                 AddGuest.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////
////                            addGuestDialog=AppConfig.showFullScreenCustomDialog(R.layout.guest_layout,ctx);
////
////                            Button addGuest;
////                        TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
////                                guestLastName, guestPincode, guestFullAddress,gender,
////                                guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
////                        RecyclerView guestRecyler;
////                        guestRecyler = addGuestDialog.findViewById(R.id.guestList);
////                        addGuest = addGuestDialog.findViewById(R.id.SaveGuest);
////                        guestSalutation = addGuestDialog.findViewById(R.id.guestSalutation);
////                        guestFirstName = addGuestDialog.findViewById(R.id.guestFirstName);
////                        guestMiddleName = addGuestDialog.findViewById(R.id.guestMiddleName);
////                        guestLastName = addGuestDialog.findViewById(R.id.guestLastName);
////                        guestPincode = addGuestDialog.findViewById(R.id.guestPincode);
////                        guestState = addGuestDialog.findViewById(R.id.guestState);
////                        gender = addGuestDialog.findViewById(R.id.guestGender);
////                        guestCity = addGuestDialog.findViewById(R.id.guestCity);
////                        guestFullAddress = addGuestDialog.findViewById(R.id.guestfullAdrress);
////                         guestEmail = addGuestDialog.findViewById(R.id.guestEmail);
////                        guestCountry = addGuestDialog.findViewById(R.id.guestCountry);
////                        guestPhone = addGuestDialog.findViewById(R.id.guestPhoneNumber);
////                        guestIdType = addGuestDialog.findViewById(R.id.guestIdType);
////                        guestIdNumber = addGuestDialog.findViewById(R.id.guestIdNumber);
////
////              guestSalutation.setOnClickListener(new View.OnClickListener() {
////                  @Override
////                  public void onClick(View v) {
////                      salutationsCrud.getSalutations(ctx, guestRecyler, guestSalutation,guestFirstName);
////
////                  }
////              });
////              Log.e("0",""+separated.length);
////          if (!(separated.length<Integer.parseInt(p.getNoofdault())+Integer.parseInt(p.getNoofchild()))){
////              addGuest.setVisibility(View.GONE);
////
////                        }
////              addGuest.setOnClickListener(new View.OnClickListener() {
////                  @Override
////                  public void onClick(View v) {
////                      if (guestSalutation.getText().toString().isEmpty()){
////                          guestSalutation.requestFocus();
////                      }else if (guestFirstName.getText().toString().isEmpty()){
////                          guestFirstName.requestFocus();
////                      }else if (guestState.getText().toString().isEmpty()){
////                          guestState.requestFocus();
////                      }else if (guestEmail.getText().toString().isEmpty()){
////                          guestEmail.getText();
////                      }else if (guestIdType.getText().toString().isEmpty()){
////                          guestIdType.requestFocus();
////                      }else if (guestPhone.getText().toString().isEmpty()){
////                          guestPhone.requestFocus();
////                      }else if (guestIdNumber.getText().toString().isEmpty()){
////                          guestIdNumber.requestFocus();
////                      }else if (gender.getText().toString().isEmpty()){
////                          gender.requestFocus();
////                      }else if (guestFullAddress.getText().toString().isEmpty()){
////                          guestFullAddress.requestFocus();
////                      }else {
////
////
////                          DateFormat date = new SimpleDateFormat("MMddyyyyhhmmss");
////
////
////                          String biilid = date.format(cal.getTime());
////                          String guestId=guestFirstName.getText().toString()+biilid;
////                          guestIDs=guestIDs+guestId+",";
////                          guestAdd[0]=guestId+""+guestSalutation.getText().toString()+"!"+guestFirstName.getText().toString()+"!"
////                                  +guestMiddleName.getText().toString()+"!"+guestLastName.getText().toString()+"!"+ guestFullAddress.getText().toString()
////                                  +"!"+ guestState.getText().toString()+"!"+guestCity.getText().toString()+"!"+ guestPincode.getText().toString()
////                                  +"!"+guestCountry.getText().toString()+"!"+guestCountry.getText().toString()+"!"+"VIP"
////                                  +"!"+guestEmail.getText().toString()+"!"
////                                  +guestPhone.getText().toString()+"!"+gender.getText().toString()
////                                  +"!"+guestIdType.getText().toString()+"!"+guestIdNumber.getText().toString();
////
////                          ChecKInApiInterface apiInterface = ApiClient.getApiClient().create(ChecKInApiInterface.class);
////
////                          Call<StayInformation> call = apiInterface.checkIn(
////                                  guestAdd,guestIDs,p.getId()
////
////                          );
////
////                          call.enqueue(new Callback<StayInformation>() {
////                              @Override
////                              public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {
////
////                                  String value = response.body().getValue();
////                                  String message = response.body().getMassage();
////
////                                  if (value.equals("1")) {
////                                      addGuestDialog.dismiss();
////
////                                  } else {
////
////                                      Log.e("rr", message);
////
////                                  }
////
////                              }
////
////                              @Override
////                              public void onFailure(Call<StayInformation> call, Throwable t) {
////                                  Log.e("rr", "" + t.getMessage());
////
////                                  Toast.makeText(ctx, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
////                              }
////                          });
////                      }
////                  }
////              });
////
////
////                        addGuestDialog.show();
////
////
////
////
////                    }
////                });
////
////                CheckInBook.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                     boolean result=   setTotalPrice();
////                     if (result){
////
////                         ChecKInApiInterface apiInterface = ApiClient.getApiClient().create(ChecKInApiInterface.class);
////
////                         Call<StayInformation> call = apiInterface.checkIn(guestData,guestIDs,p.getId());
////
////                         call.enqueue(new Callback<StayInformation>() {
////                             @Override
////                             public void onResponse(Call<StayInformation> call, Response<StayInformation> response) {
////
////                                 String value = response.body().getValue();
////                                 String message = response.body().getMassage();
////
////                                 if (value.equals("1")) {
//////
//////                                     Intent intent=new Intent(ctx, FrontOffice.class);
//////                                     ctx.startActivity(intent);
////                                     addGuestDialog.dismiss();
////
////
////                                 } else {
////
////                                     Log.e("rr", message);
////
////                                 }
////
////                             }
////
////                             @Override
////                             public void onFailure(Call<StayInformation> call, Throwable t) {
////                                 Log.e("rr", "" + t.getMessage());
////
////                                 Toast.makeText(ctx, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
////                             }
////                         });
////
////
////                     }
////                     }
////                });
////
////                stayInformationButton.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        setActiveForm("stayInformationButton", ctx);
////                    }
////                });
////
////                guestInformationButton.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////
////                        setActiveForm("guestInformationButton", ctx);
////
////                    }
////                });
////
////                CheckinInfoDilog.show();
////
//
//            }
//        });
        AppConfig.showStayInformationAdapterItemList(holder.listItemDetails);
        holder.listItemDetails.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {

            }

            @Override
            public void onBackgroundClick() {

            }

            @Override
            public void onBoomWillHide() {

            }

            @Override
            public void onBoomDidHide() {

            }

            @Override
            public void onBoomWillShow() {

            }

            @Override
            public void onBoomDidShow() {

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

    public interface OnItemClickListener {
        void onItemClick(View view, StayInformation obj, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView roomnumber, title_time_label, title_date_label, phonenumber;
        LinearLayout checkinClick;
        OnItemClick onItemClick;
        BoomMenuButton listItemDetails;
        public ViewHolder(View v, int viewType, OnItemClick onItemClick) {
            super(v);

            this.onItemClick = onItemClick;
            roomnumber = v.findViewById(R.id.roomnumber);
            title_time_label = v.findViewById(R.id.title_time_label);
            listItemDetails = v.findViewById(R.id.listItemDetails);
            title_date_label = v.findViewById(R.id.title_date_label);
            checkinClick = v.findViewById(R.id.checkinClick);

        }

        @Override
        public void onClick(View view) {
            if (onItemClick != null) {
                onItemClick.onItemClick(getLayoutPosition(), view);
            }
        }
    }

    public void initLayoutVariables(Dialog view) {

        formGuestInformation = view.findViewById(R.id.formGuestInformation);
        AddGuest = view.findViewById(R.id.AddGuest);
        formStayInformation = view.findViewById(R.id.formStayInformation);
        formGuestLayout = view.findViewById(R.id.formGuestInformationLayout);
        selectStayREcycler = view.findViewById(R.id.selectItemLayout);


        CheckInBook=view.findViewById(R.id.CheckIButton);

        rate = view.findViewById(R.id.rate);

        taxPercentage = view.findViewById(R.id.taxper);
        amount = view.findViewById(R.id.amount);
        taxAmount = view.findViewById(R.id.taxAmount);



        stayRatePlan = (view.findViewById(R.id.stayRatePlan));
         stayRoomType = (view.findViewById(R.id.stayRoomType));

        staySubStayPlan = (view.findViewById(R.id.subRatePlan));
        stayAdult = (view.findViewById(R.id.stayAdult));
        stayChild = (view.findViewById(R.id.stayChild));

        stayRateType = (view.findViewById(R.id.stayRateType));
        stayArrivalDate = (view.findViewById(R.id.stayArrivalDate));
        stayArrivalTime = (view.findViewById(R.id.stayArrivalTime));
        stayArrivalNight = (view.findViewById(R.id.stayArrivalNight));
        stayDepartureDate = (view.findViewById(R.id.stayDepartureDate));
        stayDepartureTime = (view.findViewById(R.id.stayDepartureTime));
        stayReserType = (view.findViewById(R.id.stayReserType));
        //  stayGuestStatus = (dialog.findViewById(R.id.stayGuestStatus));

        guestInformationButtonText = view.findViewById(R.id.guestInformationButtonText);
        stayInformationButtonText = view.findViewById(R.id.stayInformationButtonText);
        guestInformationButton = view.findViewById(R.id.guestInformationButton);
        stayInformationButton = view.findViewById(R.id.stayInformationButton);
          }

//          public void addView(Activity activity,String guestID){
//              final View view = activity.getLayoutInflater().inflate(R.layout.guest_layout,null,false);
//                TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
//                      guestLastName, guestPincode, guestFullAddress,
//                      guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
//              Button saveGuest;
//              RecyclerView guestRecyler;
//              guestRecyler = view.findViewById(R.id.guestList);
//              guestSalutation = view.findViewById(R.id.guestSalutation);
//              guestFirstName = view.findViewById(R.id.guestFirstName);
//              guestMiddleName = view.findViewById(R.id.guestMiddleName);
//              guestLastName = view.findViewById(R.id.guestLastName);
//              guestPincode = view.findViewById(R.id.guestPincode);
//              guestState = view.findViewById(R.id.guestState);
//              guestCity = view.findViewById(R.id.guestCity);
//              guestFullAddress = view.findViewById(R.id.guestfullAdrress);
//              guestEmail = view.findViewById(R.id.guestEmail);
//              guestCountry = view.findViewById(R.id.guestCountry);
//              guestPhone = view.findViewById(R.id.guestPhoneNumber);
//              guestIdType = view.findViewById(R.id.guestIdType);
//              guestIdNumber = view.findViewById(R.id.guestIdNumber);
//              saveGuest=view.findViewById(R.id.SaveGuest);
//              Call<List<Guest>> call = apiInterface.getGuest();
//              call.enqueue(new Callback<List<Guest>>() {
//                  @Override
//                  public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
//                      guestList = response.body();
//                      for (int i=0;i<guestList.size();i++){
//
//                          Log.e("",""+guestList.size());
//                          if (guestList.get(i).getGuestid().equals(guestID)){
//
//                              guestFullAddress.setText(guestList.get(i).getAddress());
//                              guestFirstName.setText(guestList.get(i).getFirstName());
//                              guestMiddleName.setText(guestList.get(i).getMidName());
//                              guestPincode.setText(guestList.get(i).getZipode());
//                              guestState.setText(guestList.get(i).getState());
//                              guestCity.setText(guestList.get(i).getCity());
//                              guestEmail.setText(guestList.get(i).getEmail());
//                              guestCountry.setText(guestList.get(i).getCountry());
//                              guestLastName.setText(guestList.get(i).getLastName());
//                              guestLastName.setText(guestList.get(i).getLastName());
//                              guestPhone.setText(guestList.get(i).getNumber());
//                              guestIdType.setText(guestList.get(i).getIdType());
//                              guestIdNumber.setText(guestList.get(i).getIdNumber());
//                          }
//
//                      }
//
//                  }
//                  @Override
//                  public void onFailure(Call<List<Guest>> call, Throwable t) {
//                      Log.e(":df",""+t.getMessage());
//
//                  }
//              });
//
//
//
//
//
//
//
//              saveGuest.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View v) {
//
//                  }
//              });
//
//
//              guestSalutation.setOnClickListener(new View.OnClickListener() {
//                  @Override
//                  public void onClick(View v) {
//                      salutationsCrud.getSalutations(activity, guestRecyler, guestSalutation,guestFirstName);
//
//                  }
//              });
//
//              guestFirstName.addTextChangedListener(new TextWatcher() {
//                  @Override
//                  public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                  }
//
//                  @Override
//                  public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    //  guestCrud.filter(activity, s.toString());
//
//
//                  }
//
//                  @Override
//                  public void afterTextChanged(Editable s) {
//
//                  }
//              });
//
//              formGuestLayout.addView(view);
//
//
//          }
//

    public void addView(Activity activity){


        final View view = activity.getLayoutInflater().inflate(R.layout.guest_list,null,false);


          TextView guestName,identitynumber,pincode,phonenumber;


        guestName=view.findViewById(R.id.guestName);
        pincode=view.findViewById(R.id.pincode);
        identitynumber=view.findViewById(R.id.Identitiynumber);
        phonenumber=view.findViewById(R.id.phonenumber);


        formGuestLayout.addView(view);


    }

    public void setActiveForm(String activeForm, Context context) {
        if (activeForm.equals("guestInformationButton")) {
            formGuestInformation.setVisibility(View.VISIBLE);
            formStayInformation.setVisibility(View.GONE);
            guestInformationButton.setBackgroundColor(context.getResources().getColor(R.color.dark_color));
            stayInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            guestInformationButtonText.setTextColor(context.getResources().getColor(R.color.light_color));
            stayInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));

        } else if (activeForm.equals("stayInformationButton")) {
            formGuestInformation.setVisibility(View.GONE);
            formStayInformation.setVisibility(View.VISIBLE);
            guestInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            stayInformationButton.setBackgroundColor(context.getResources().getColor(R.color.dark_color));
            guestInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            stayInformationButtonText.setTextColor(context.getResources().getColor(R.color.light_color));
        }
    }

    private boolean setTotalPrice() {
        Float roomPriceWOtax=00.00f,roomPriceWtax=00.00f,roomTaxAmount=00.00f;
         boolean result = true;

        for(int i=0;i<formGuestInformation.getChildCount();i++){
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

            if(guestSalutation.getText().toString().isEmpty() || guestFirstName.getText().toString().isEmpty() ||
            guestPhone.getText().toString().isEmpty() ||
            guestCountry.getText().toString().isEmpty() || guestEmail.getText().toString().isEmpty() ||
            guestPincode.getText().toString().isEmpty() || guestState.getText().toString().isEmpty() ||
            guestFullAddress.getText().toString().isEmpty() || guestCity.getText().toString().isEmpty() ||
            guestIdType.getText().toString().isEmpty() || guestIdNumber.getText().toString().isEmpty()){


                result = false;
                break;

            }else {

                DateFormat date = new SimpleDateFormat("MMddyyyyhhmmss");


                String biilid = date.format(cal.getTime());
                String guestId=guestFirstName.getText().toString()+biilid;
                guestIDs=guestIDs+guestId+",";


              guestData[i]=guestId+""+guestSalutation.getText().toString()+"!"+guestFirstName.getText().toString()+"!"
                      +guestMiddleName.getText().toString()+"!"+guestLastName.getText().toString()+"!"+ guestFullAddress.getText().toString()
                    +"!"+ guestAddress.getText().toString()+"!"+guestCity.getText().toString()+"!"+ guestPincode.getText().toString()
                      +"!"+guestCountry.getText().toString()+"!"+guestCountry.getText().toString()+"!"+"VIP"
                      +"!"+guestEmail.getText().toString()+"!"
                      +guestPhone.getText().toString()+"!"+"GENDER"+"!"+guestIdType.getText().toString()+"!"+guestIdNumber.getText().toString();

                result = true;

            }



        }



        return result;

    }

    private void setValue() {
        Float roomPriceWOtax=00.00f,roomPriceWtax=00.00f,roomTaxAmount=00.00f;
        boolean result = true;





        for(int i=0;i<separated.length;i++){

           for (int j=0;j<guestList.size();j++){
               if (guestList.get(i).getGuestid().equals(separated[i])){

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

}
