package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource.BokkingSource;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource.BokkingSourceCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource.BusinessSource;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BusinessSource.BusinessSourceCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.CompanyDetails.CompanyDetails;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType.IdentityType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.IdentityType.IdentityTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.MarketCodeType.MarketCodeType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.MarketCodeType.MarketCodeTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.PaymentType.PaymentType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.PaymentType.PaymentTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan.RatePlan;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RatePlan.RatePlanCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType.RateType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RateType.RateTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.Rooms;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.Rooms.RoomsCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType.RoomsType;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.RoomsType.RoomsTypeCrud;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Models.SlabLlistModal;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.Fragments.MastersFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.ActivityGeneralBinding;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.FormFolioTypeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralActivity extends AppCompatActivity {
    public static String[] slabArr;
    final Fragment fragment1 = new MastersFragment();
    final FragmentManager fm = getSupportFragmentManager();
    public ApiInterface apiInterface;
    public List<RoomsType> roomlist = new ArrayList<>();
    public List<RateType> ratelist = new ArrayList<>();
    public List<RatePlan> ratePlanslist = new ArrayList<>();
    public List<CompanyDetails> companyList = new ArrayList<>();
    public List<BusinessSource> businessSources = new ArrayList<>();
    public RecyclerView recyclerViewMovieList;
    ActivityGeneralBinding binding;
    String racratevalue = "0";
    List<SlabLlistModal> SlabListViewValuesArr;
    LinearLayout generalSettings, generalSettingsLayout,
            marketCodeType, discountType, businessSourceType, identityType, paymentType, transportationMode, BokkingSource, currency,
            addRoom, amenities, RoomsType, rateType, ratePlan, ratePlanConfig, roomImages,
            tax, travelAgent, guestDatabase;
    String considera;
    RadioButton afterbefore;
    LinearLayout roomsManagement, roomsManagementLayout;
    LinearLayout propertySetting, propertySettingLayout;
    LinearLayout companySetting, companySettingLayout, addCompany;
    Fragment active = fragment1;
    boolean isPortrait;
    ProgressDialog progressDialog;
    RadioButton roomas;
    int slabLength;
    long singleRate, doubleRate, extraadultrateprice, extrachildrateprice;


    //
    MarketCodeTypeCrud marketCodeTypeCrud = new MarketCodeTypeCrud();
    BusinessSourceCrud businessSourceCrud = new BusinessSourceCrud();
    IdentityTypeCrud identityTypeCrud = new IdentityTypeCrud();
    PaymentTypeCrud paymentTypeCrud = new PaymentTypeCrud();
    BokkingSourceCrud bokkingSourceCrud = new BokkingSourceCrud();
    RoomsTypeCrud roomsTypeCrud = new RoomsTypeCrud();
    RateTypeCrud rateTypeCrud = new RateTypeCrud();
    RatePlanCrud ratePlanCrud = new RatePlanCrud();

    RoomsCrud roomsCrud = new RoomsCrud();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGeneralBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_general);

        progressDialog = new ProgressDialog(this);

        AppConfig.setOrientations(GeneralActivity.this);

        getRatePlan();

        initViews();


        generalSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (generalSettingsLayout.getVisibility() == View.GONE) {
                    openSubNav(generalSettingsLayout);
                } else {
                    closeSubNav(generalSettingsLayout);
                }
            }
        });

        binding.folioMasters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.folioMastersLayout.getVisibility() == View.GONE) {
                    openSubNav(binding.folioMastersLayout);
                } else {
                    closeSubNav(binding.folioMastersLayout);
                }
            }
        });


        roomsManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roomsManagementLayout.getVisibility() == View.GONE) {
                    openSubNav(roomsManagementLayout);
                } else {
                    closeSubNav(roomsManagementLayout);
                }
            }
        });

        propertySetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (propertySettingLayout.getVisibility() == View.GONE) {
                    openSubNav(propertySettingLayout);
                } else {
                    closeSubNav(propertySettingLayout);
                }
            }
        });

        companySetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (companySettingLayout.getVisibility() == View.GONE) {
                    openSubNav(companySettingLayout);
                } else {
                    closeSubNav(companySettingLayout);
                }
            }
        });
        //General Seetings

        binding.addFolioType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFolioDialog();
            }
        });

        marketCodeType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                marketCodeTypeCrud.getMarketCodeType(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Market Code");
                // showCustomDialog(R.layout.form_market_type, marketCodeType);
            }
        });

        discountType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //showCustomDialog(R.layout.form_res_type, discountType);
                binding.mastersType.setText("Discount Type");
            }
        });

        businessSourceType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessSourceCrud.getBusinessSource(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Business Source");
                //   showCustomDialog(R.layout.form_business_source, businessSourceType);
            }
        });

        binding.bookingSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bokkingSourceCrud.getBookingSourceList(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Booking Source");
                //   showCustomDialog(R.layout.form_business_source, businessSourceType);
            }
        });

        identityType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                identityTypeCrud.getIdentityType(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Identity Type");
                //  showCustomDialog(R.layout.form_identity_type, identityType);

            }
        });

        paymentType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentTypeCrud.getPaymentList(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Payment Type");
                //    showCustomDialog(R.layout.form_payment_type, paymentType);
            }
        });

        transportationMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mastersType.setText("Transport Mode");
            }
        });

        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mastersType.setText("Currency");
            }
        });
        ///room Management
        addRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomsCrud.getRoomList(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Add Rooms");
                // showCustomDialog(R.layout.form_add_room, addRoom);
            }
        });

        amenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mastersType.setText("Add Rooms Amenities");
            }
        });

        RoomsType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomsTypeCrud.getRoomTypeList(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Rooms Type");
                //  showCustomDialog(R.layout.form_room_type, RoomsType);
            }
        });

        rateType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rateTypeCrud.getRateTypeList(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Rate Type");
                //showCustomDialog(R.layout.form_rate_type, rateType);
            }
        });

        ratePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratePlanCrud.getRatePlanList(GeneralActivity.this, binding.recyclerViewMovieList);
                binding.mastersType.setText("Rate Plan");
                //  showCustomDialog(R.layout.form_rate_plan, ratePlan);
            }
        });

        roomImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mastersType.setText("Room Images");
            }
        });
        //// Rest of the Settings
        tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showCustomDialog(R.layout.form_add_tax, tax);
                binding.mastersType.setText("Taxes");
            }
        });

        travelAgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mastersType.setText("Travel Agent");
            }
        });

        guestDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mastersType.setText("All Guest ");
            }
        });
        ///company Management
        addCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.mastersType.setText("Add Company");
                //  showCustomDialog(R.layout.form_company_form, addCompany);
            }
        });
        getRoomsType();
        getRateType();

        binding.addMasters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.mastersType.getText().toString().equals("Market Code")) {
                    showCustomDialog(R.layout.form_market_type, marketCodeType);
                } else if (binding.mastersType.getText().toString().equals("Discount Type")) {
                    //  showCustomDialog(R.layout.form_res_type, discountType);
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("Booking Source")) {
                    showCustomDialog(R.layout.form_business_source, BokkingSource);
                } else if (binding.mastersType.getText().toString().equals("Business Source")) {
                    showCustomDialog(R.layout.form_business_source, businessSourceType);
                } else if (binding.mastersType.getText().toString().equals("Identity Type")) {
                    showCustomDialog(R.layout.form_identity_type, identityType);
                } else if (binding.mastersType.getText().toString().equals("Payment Type")) {
                    showCustomDialog(R.layout.form_payment_type, paymentType);
                } else if (binding.mastersType.getText().toString().equals("Transport Mode")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("Currency")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("Add Rooms")) {
                    showCustomDialog(R.layout.form_add_room, addRoom);
                } else if (binding.mastersType.getText().toString().equals("Add Rooms Amenities")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("Rooms Type")) {
                    showCustomDialog(R.layout.form_room_type, RoomsType);
                } else if (binding.mastersType.getText().toString().equals("Rate Type")) {
                    showCustomDialog(R.layout.form_rate_type, rateType);
                } else if (binding.mastersType.getText().toString().equals("Rate Plan")) {
                    showCustomDialog(R.layout.form_rate_plan, ratePlan);
                } else if (binding.mastersType.getText().toString().equals("Room Images")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("Taxes")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("Travel Agent")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("All Guest")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                } else if (binding.mastersType.getText().toString().equals("Add Company")) {
                    AppConfig.showwCustomToast(GeneralActivity.this, "Todo", "Work in Progress");
                }
            }
        });
    }


    private void showCustomDialog(int layout, LinearLayout layoutType) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(layout);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();
        if (layoutType == RoomsType) {
            EditText shortcode = dialog.findViewById(R.id.shortcode);
            EditText RoomsTypename = dialog.findViewById(R.id.roomtypename);
            EditText baseadult = dialog.findViewById(R.id.baseadult);
            EditText basechild = dialog.findViewById(R.id.basechild);
            EditText maxadult = dialog.findViewById(R.id.maxadult);
            EditText maxchild = dialog.findViewById(R.id.maxchild);
            EditText defaultwebinventory = dialog.findViewById(R.id.defaultwebinventory);
            EditText inventorytobedisplayed = dialog.findViewById(R.id.inventorytobedisplayed);
            EditText minrate = dialog.findViewById(R.id.minrate);
            EditText maxrate = dialog.findViewById(R.id.maxrate);
            Button bt_submit = dialog.findViewById(R.id.bt_submit);

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortco = shortcode.getText().toString();
                    String roomname = RoomsTypename.getText().toString();
                    String basadult = baseadult.getText().toString();
                    String basechil = basechild.getText().toString();
                    String maxad = maxadult.getText().toString();
                    String maxch = maxchild.getText().toString();
                    String webinventory = defaultwebinventory.getText().toString();
                    String inventorydisplayed = inventorytobedisplayed.getText().toString();
                    String minrat = minrate.getText().toString();
                    String maxrat = maxrate.getText().toString();
                    String img_path = "";
                    String status = "1";
                    if (shortco.isEmpty()) {
                        shortcode.requestFocus();
                        shortcode.setError("Enter Short Code");

                    } else if (roomname.isEmpty()) {
                        RoomsTypename.requestFocus();
                        RoomsTypename.setError("Enter Room Name");
                    } else if (basechil.isEmpty()) {
                        basechild.requestFocus();
                    } else if (basadult.isEmpty()) {
                        baseadult.requestFocus();
                    } else if (maxad.isEmpty()) {
                        maxadult.requestFocus();
                    } else if (maxch.isEmpty()) {
                        maxchild.requestFocus();
                    } else if (webinventory.isEmpty()) {
                        defaultwebinventory.requestFocus();
                    } else if (minrat.isEmpty()) {
                        minrate.requestFocus();
                    } else if (maxrat.isEmpty()) {
                        maxrate.requestFocus();
                    } else {


                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                        Log.e("rr", "hudhuhu");

                        Call<RoomsType> call = apiInterface.insertRoomtype(shortco, roomname,
                                basadult, basechil, maxch, maxad, webinventory, inventorydisplayed,
                                maxrat, minrat, img_path, status);

                        call.enqueue(new Callback<RoomsType>() {
                            @Override
                            public void onResponse(Call<RoomsType> call, Response<RoomsType> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Room Type Added Successfully");
                                    roomsTypeCrud.getRoomTypeList(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<RoomsType> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });


                    }

                }
            });

        } else if (layoutType == rateType) {

            EditText shortcode = dialog.findViewById(R.id.slectratetype);
            EditText ratetypename = dialog.findViewById(R.id.ratetypename);
            Button bt_submit = dialog.findViewById(R.id.bt_submit);
            String status = "1";
            shortcode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] planArr = {"Normal", "Contract"};
                    AppConfig.showChoiceDialog(v, planArr, GeneralActivity.this, "Select Plan As");
                }
            });

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortco = shortcode.getText().toString();
                    String roomname = ratetypename.getText().toString();
                    if (shortco.isEmpty()) {
                        shortcode.requestFocus();

                    } else if (roomname.isEmpty()) {
                        ratetypename.requestFocus();
                    } else {
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                        Call<RateType> call = apiInterface.insertRatetype(shortco, roomname, "", "", "", ""
                                , status);

                        call.enqueue(new Callback<RateType>() {
                            @Override
                            public void onResponse(Call<RateType> call, Response<RateType> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Rate Type Added Successfully");
                                    rateTypeCrud.getRateTypeList(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<RateType> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });
                    }
                }
            });


        } else if (layoutType == ratePlan) {

            int minprice = 0;
            int maxprice = 0;
            EditText selectRoomsType = dialog.findViewById(R.id.selectRoomType);
            EditText ratetype = dialog.findViewById(R.id.ratetype);
            EditText rateplanname = dialog.findViewById(R.id.rateplanname);
            EditText plandesc = dialog.findViewById(R.id.plandesc);
            EditText baseadultrate = dialog.findViewById(R.id.baseadultrate);
            EditText basechild = dialog.findViewById(R.id.basechild);
            EditText maxadult = dialog.findViewById(R.id.maxadult);
            EditText maxchild = dialog.findViewById(R.id.maxchild);
            EditText maxOccupanc = dialog.findViewById(R.id.maxOccupanc);
            EditText minnight = dialog.findViewById(R.id.minnight);
            EditText maxnight = dialog.findViewById(R.id.maxnight);
            EditText inclusion = dialog.findViewById(R.id.inclusion);
            EditText planas = dialog.findViewById(R.id.planas);
            EditText derivedMaster = dialog.findViewById(R.id.derivedMaster);
            EditText singleoccupancy = dialog.findViewById(R.id.singleoccupancy);
            EditText singleoccupancyFunc = dialog.findViewById(R.id.singleoccupancyFunc);
            EditText singleoccupancyRate = dialog.findViewById(R.id.singleoccupancyRate);
            EditText doubleoccupancy = dialog.findViewById(R.id.doubleoccupancy);
            EditText doubleoccupancyFunc = dialog.findViewById(R.id.doubleoccupancyFunc);
            EditText doubleoccupancyRate = dialog.findViewById(R.id.doubleoccupancyRate);
            EditText extraadultrate = dialog.findViewById(R.id.extraadultrate);
            EditText extraadultrateFunc = dialog.findViewById(R.id.extraadultrateFunc);
            EditText extraadultrateRate = dialog.findViewById(R.id.extraadultrateRate);
            EditText extrachildrate = dialog.findViewById(R.id.extrachildrate);
            EditText extrachildrateFunc = dialog.findViewById(R.id.extrachildrateFunc);
            EditText extrachildrateRate = dialog.findViewById(R.id.extrachildrateRate);
            EditText singleoccupancyIn = dialog.findViewById(R.id.singleoccupancyIn);
            EditText doubleoccupancyIn = dialog.findViewById(R.id.doubleoccupancyIn);
            EditText extraadultrateIn = dialog.findViewById(R.id.extraadultrateIn);
            EditText extrachildrateIn = dialog.findViewById(R.id.extraChildRateIn);
            LinearLayout derivedLayout = dialog.findViewById(R.id.derivedLayout);
            LinearLayout independentLayout = dialog.findViewById(R.id.independentLayout);
            EditText associatedCompany = dialog.findViewById(R.id.associatedCompany);
            EditText associatedBusiness = dialog.findViewById(R.id.associatedBusinessSource);

            Button bt_submit = dialog.findViewById(R.id.bt_submit);

            AppCompatCheckBox appCompatCheckBox = dialog.findViewById(R.id.checkMaxOccupancy);
            LinearLayout maxOccupancy = dialog.findViewById(R.id.maxOccupancy);
            appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (maxOccupancy.getVisibility() == View.GONE) {
                        maxOccupancy.setVisibility(View.VISIBLE);
                    } else {
                        maxOccupancy.setVisibility(View.GONE);
                    }
                }
            });
            planas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] planArr = {"Independent", "Derived"};
                    AppConfig.showChoiceDialog(planas, planArr, GeneralActivity.this, "Select Plan As");
                }
            });
            planas.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (planas.getText().toString().trim().equals("Derived")) {
                        derivedMaster.setVisibility(View.VISIBLE);
                        derivedLayout.setVisibility(View.VISIBLE);
                        independentLayout.setVisibility(View.GONE);
                        fillDerivedLayout();
                    } else if (planas.getText().toString().trim().equals("Independent")) {
                        derivedMaster.setVisibility(View.GONE);
                        independentLayout.setVisibility(View.VISIBLE);
                        derivedLayout.setVisibility(View.GONE);
                        fillIndependentLayout();
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            selectRoomsType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[roomlist.size()];
//
                    for (int i = 0; i < roomlist.size(); i++)
                        array[i] = roomlist.get(i).getRoomtypename();
                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });
            ratetype.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[ratelist.size()];
//
                    for (int i = 0; i < ratelist.size(); i++)
                        array[i] = ratelist.get(i).getRatetypename();
                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });

            baseadultrate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = 0;
                    int k = 1;
                    for (int i = 0; i < roomlist.size(); i++)
                        if (roomlist.get(i).getRoomtypename().equals(selectRoomsType.getText().toString()))
                            count = Integer.parseInt(roomlist.get(i).getBaseadult());

                    String[] array = new String[count];
                    for (int i = 0; i < count; i++) {
                        array[i] = String.valueOf(i + 1);

                    }
                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });


            basechild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = 0;
                    int k = 1;
                    for (int i = 0; i < roomlist.size(); i++)
                        if (roomlist.get(i).getRoomtypename().equals(selectRoomsType.getText().toString()))
                            count = Integer.parseInt(roomlist.get(i).getBasechild());
                    if (count == 0) {
                        String[] array = new String[1];
                        for (int i = 0; i <= count; i++) {
                            array[i] = String.valueOf(i);

                        }
                        AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                    } else {
                        String[] array = new String[count];
                        for (int i = 0; i <= count; i++) {
                            array[i] = String.valueOf(i);

                        }
                        AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                    }

                }
            });

            maxadult.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = 0;
                    int k = 1;
                    for (int i = 0; i < roomlist.size(); i++)
                        if (roomlist.get(i).getRoomtypename().equals(selectRoomsType.getText().toString()))
                            count = Integer.parseInt(roomlist.get(i).getMaxadult());

                    String[] array = new String[count];
                    for (int i = 0; i < count; i++) {
                        array[i] = String.valueOf(i + 1);

                    }
                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });

            maxchild.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = 0;
                    int k = 1;
                    for (int i = 0; i < roomlist.size(); i++)
                        if (roomlist.get(i).getRoomtypename().equals(selectRoomsType.getText().toString()))
                            count = Integer.parseInt(roomlist.get(i).getMaxchild());

                    if (count == 0) {
                        String[] array = new String[1];
                        for (int i = 0; i <= count; i++) {
                            array[i] = String.valueOf(i);

                        }
                        AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                    } else {
                        String[] array = new String[count];
                        for (int i = 0; i < count; i++) {
                            array[i] = String.valueOf(i);

                        }
                        AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                    }
                }
            });

            derivedMaster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[ratePlanslist.size()];
                    for (int i = 0; i < ratePlanslist.size(); i++) {
                        array[i] = ratePlanslist.get(i).getRoomplanname();
                        singleRate = Integer.parseInt(ratePlanslist.get(i).getSingleOccupancy().trim());
                        doubleRate = Integer.parseInt(ratePlanslist.get(i).getDoubleOccupancy());
                        extraadultrateprice = Integer.parseInt(ratePlanslist.get(i).getExtraadultrate());
                        extrachildrateprice = Integer.parseInt(ratePlanslist.get(i).getExtrachildrate());

                    }
                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Payment Type");
                }
            });


            //Derived Functionalities

            singleoccupancy.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    long sum = 0;
                    if (singleoccupancyFunc.getText().toString().equals("FLAT") && !singleoccupancy.getText().toString().trim().isEmpty()) {
                        sum = singleRate + Integer.parseInt(singleoccupancy.getText().toString());
                    } else if (singleoccupancyFunc.getText().toString().equals("Percentage") && !singleoccupancy.getText().toString().trim().isEmpty()) {
                        sum = singleRate + (singleRate * Long.parseLong(singleoccupancy.getText().toString())) / 100;
                    }
                    singleoccupancyRate.setText(String.valueOf(sum));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            doubleoccupancy.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    long sum = 0;

                    if (doubleoccupancyFunc.getText().toString().equals("FLAT") && !doubleoccupancy.getText().toString().trim().isEmpty()) {
                        sum = doubleRate + Integer.parseInt(doubleoccupancy.getText().toString());
                    } else if (doubleoccupancyFunc.getText().toString().equals("Percentage") && !doubleoccupancy.getText().toString().trim().isEmpty()) {
                        sum = doubleRate + (doubleRate * Long.parseLong(doubleoccupancy.getText().toString())) / 100;

                    }
                    doubleoccupancyRate.setText(String.valueOf(sum));
                }


                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            extraadultrate.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    long sum = 0;

                    if (extraadultrateFunc.getText().toString().equals("FLAT") && !extraadultrate.getText().toString().trim().isEmpty()) {
                        sum = extraadultrateprice + Integer.parseInt(extraadultrate.getText().toString());
                    } else if (extraadultrateFunc.getText().toString().equals("Percentage") && !extraadultrate.getText().toString().trim().isEmpty()) {
                        sum = extraadultrateprice + (extraadultrateprice * Long.parseLong(extraadultrate.getText().toString())) / 100;

                    }
                    extraadultrateRate.setText(String.valueOf(sum));
                }


                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            extrachildrate.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    long sum = 0;

                    if (extrachildrateFunc.getText().toString().equals("FLAT") && !extrachildrate.getText().toString().trim().isEmpty()) {
                        sum = extrachildrateprice + Integer.parseInt(extrachildrate.getText().toString());
                    } else if (extrachildrateFunc.getText().toString().equals("Percentage") && !extrachildrate.getText().toString().trim().isEmpty()) {
                        sum = extrachildrateprice + (extrachildrateprice * Long.parseLong(extrachildrate.getText().toString())) / 100;

                    }
                    extrachildrateRate.setText(String.valueOf(sum));
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            doubleoccupancyFunc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[]{

                            "FLAT", "Percentage"

                    };
//

                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });
            doubleoccupancyFunc.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!doubleoccupancyFunc.getText().toString().trim().isEmpty()) {
                        doubleoccupancy.setFocusable(true);
                        doubleoccupancy.setFocusableInTouchMode(true);
                        doubleoccupancy.setClickable(true);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            singleoccupancyFunc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[]{

                            "FLAT", "Percentage"

                    };
//
                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");

                }
            });

            singleoccupancyFunc.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!singleoccupancyFunc.getText().toString().trim().isEmpty()) {
                        singleoccupancy.setFocusable(true);
                        singleoccupancy.setFocusableInTouchMode(true);
                        singleoccupancy.setClickable(true);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            extraadultrateFunc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[]{

                            "FLAT", "Percentage"

                    };
//

                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });
            extraadultrateFunc.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!extraadultrateFunc.getText().toString().trim().isEmpty()) {
                        extraadultrate.setFocusable(true);
                        extraadultrate.setFocusableInTouchMode(true);
                        extraadultrate.setClickable(true);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            extrachildrateFunc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[]{

                            "FLAT", "Percentage"

                    };
//

                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });
            extrachildrateFunc.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (!extrachildrateFunc.getText().toString().trim().isEmpty()) {
                        extrachildrate.setFocusable(true);
                        extrachildrate.setFocusableInTouchMode(true);
                        extrachildrate.setClickable(true);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            //Independent Functionalities

            singleoccupancyIn.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {


                    String[] array = new String[roomlist.size()];
                    long minprice = 0;
                    long maxprice = 0;

                    if (selectRoomsType.getText().toString().isEmpty()) {
                        selectRoomsType.setError("");
                    } else {

                        for (int i = 0; i < roomlist.size(); i++)
                            if (roomlist.get(i).getRoomtypename().equals(selectRoomsType.getText().toString())) {
                                minprice = Integer.parseInt(roomlist.get(i).getMinrate());
                                maxprice = Integer.parseInt(roomlist.get(i).getMaxrate());
                            }
                        long rate = 0;
                        if (!singleoccupancyIn.getText().toString().trim().isEmpty() ||
                                !singleoccupancyIn.getText().toString().trim().equals("")) {
                            rate = Long.parseLong(singleoccupancyIn.getText().toString().trim());

                        }
                        if (!(rate > maxprice && rate < minprice)) {
                            singleoccupancyIn.setError("Amount should be between " + minprice + " and " + maxprice);

                        }


                    }


                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            associatedBusiness.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[businessSources.size()];
//
                    Log.e("s", businessSources.size() + "");

                    for (int i = 0; i < businessSources.size(); i++) {
                        array[i] = businessSources.get(i).getBusinesstypename();
                    }

                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Business Source");

                }
            });

            associatedCompany.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[companyList.size()];
//
                    Log.e("s", companyList.size() + "");

                    for (int i = 0; i < companyList.size(); i++) {
                        array[i] = companyList.get(i).getCompanyName();
                    }

                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Business Source");

                }
            });

            doubleoccupancyIn.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {


                    String[] array = new String[roomlist.size()];
                    long minprice = 0;
                    long maxprice = 0;

                    if (selectRoomsType.getText().toString().isEmpty()) {
                        selectRoomsType.setError("");
                    } else {

                        for (int i = 0; i < roomlist.size(); i++)
                            if (roomlist.get(i).getRoomtypename().equals(selectRoomsType.getText().toString())) {
                                minprice = Integer.parseInt(roomlist.get(i).getMinrate());
                                maxprice = Integer.parseInt(roomlist.get(i).getMaxrate());
                            }
                        long rate = 0;
                        if (!doubleoccupancyIn.getText().toString().trim().isEmpty() ||
                                !doubleoccupancyIn.getText().toString().trim().equals("")) {
                            rate = Long.parseLong(doubleoccupancyIn.getText().toString().trim());

                        }
                        if (!(rate > maxprice && rate < minprice)) {
                            doubleoccupancyIn.setError("Amount should be between " + minprice + " and " + maxprice);

                        }


                    }


//
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

            //Independent Funcitonalities

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String RoomsType = selectRoomsType.getText().toString().trim();
                    String ratety = ratetype.getText().toString().trim();
                    String rateplan = rateplanname.getText().toString().trim();
                    String plandes = plandesc.getText().toString().trim();
                    String baseadult = baseadultrate.getText().toString();
                    String basechil = basechild.getText().toString();
                    String maxadul = maxadult.getText().toString();
                    String maxchil = maxchild.getText().toString();
                    String maxOccupancy = maxOccupanc.getText().toString();
                    String minnigh = minnight.getText().toString();
                    String maxnigh = maxnight.getText().toString();
                    String inclusio = inclusion.getText().toString();
                    String creterateplanas = planas.getText().toString();
                    String singleoccup = singleoccupancyRate.getText().toString().trim();
                    String doubleoccup = doubleoccupancyRate.getText().toString().trim();
                    String extraadultrat = extraadultrateRate.getText().toString().trim();
                    String extrachildrat = extrachildrateRate.getText().toString().trim();
                    String singleoccupin = singleoccupancyIn.getText().toString().trim();
                    String doubleoccupin = doubleoccupancyIn.getText().toString().trim();
                    String extraadultratin = extraadultrateIn.getText().toString().trim();
                    String extrachildratin = extrachildrateIn.getText().toString().trim();
                    String assoicatedCm = associatedCompany.getText().toString().trim();
                    String associatedBus = associatedBusiness.getText().toString().trim();


                    String status = "1";
                    if (planas.getText().toString().trim().equals("Derived")) {

                        if (RoomsType.isEmpty()) {

                        } else {
                            progressDialog.show();
                            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                            Call<RatePlan> call = apiInterface.insertRatePlan(" ", rateplan, plandes, inclusio, RoomsType, ratety
                                    , baseadult, basechil, maxchil, minnigh, maxadul, maxnigh, "", "", "", "",
                                    derivedMaster.getText().toString(), singleoccup, doubleoccup, extraadultrat, extrachildrat, associatedBus, assoicatedCm, maxOccupancy, status);

                            call.enqueue(new Callback<RatePlan>() {
                                @Override
                                public void onResponse(Call<RatePlan> call, Response<RatePlan> response) {

                                    String value = response.body().getValue();
                                    Log.e("rr", value);

                                    if (value.equals("1")) {
                                        Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Rate Plan Added Successfully");
                                        ratePlanCrud.getRatePlanList(GeneralActivity.this, binding.recyclerViewMovieList);
                                        ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog1.dismiss();
                                            }
                                        });
                                        progressDialog.dismiss();
                                        dialog.dismiss();
                                    } else {
                                        progressDialog.dismiss();
                                        Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                        ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog1.dismiss();
                                            }
                                        });
                                        progressDialog.dismiss();
                                        dialog.dismiss();
                                    }

                                }

                                @Override
                                public void onFailure(Call<RatePlan> call, Throwable t) {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }
                            });

                        }


                    } else {


                        if (RoomsType.isEmpty()) {

                        } else {
                            progressDialog.show();
                            apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                            Call<RatePlan> call = apiInterface.insertRatePlan(" ", rateplan, plandes, inclusio, RoomsType, ratety
                                    , baseadult, basechil, maxchil, minnigh, maxadul, maxnigh, "", "", "", "",
                                    creterateplanas, singleoccupin, doubleoccupin, extraadultratin, extrachildratin, associatedBus, assoicatedCm, maxOccupancy, status);

                            call.enqueue(new Callback<RatePlan>() {
                                @Override
                                public void onResponse(Call<RatePlan> call, Response<RatePlan> response) {

                                    String value = response.body().getValue();
                                    Log.e("rr", value);

                                    if (value.equals("1")) {
                                        Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Rate Plan Added Successfully");
                                        ratePlanCrud.getRatePlanList(GeneralActivity.this, binding.recyclerViewMovieList);
                                        ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog1.dismiss();
                                            }
                                        });
                                        progressDialog.dismiss();
                                        dialog.dismiss();
                                    } else {
                                        progressDialog.dismiss();
                                        Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                        ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                dialog1.dismiss();
                                            }
                                        });
                                        progressDialog.dismiss();
                                        dialog.dismiss();
                                    }

                                }

                                @Override
                                public void onFailure(Call<RatePlan> call, Throwable t) {
                                    progressDialog.dismiss();
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }
                            });

                        }


                    }


                }
            });


        } else if (layoutType == businessSourceType) {

            EditText shortcode = dialog.findViewById(R.id.shortcodebusinessource);
            EditText businesssourcename = dialog.findViewById(R.id.businesssourcename);
            Button bt_submit = dialog.findViewById(R.id.bt_submit);
            String status = "1";

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortco = shortcode.getText().toString();
                    String roomname = businesssourcename.getText().toString();
                    if (shortco.isEmpty()) {
                        shortcode.requestFocus();

                    } else if (roomname.isEmpty()) {
                        businesssourcename.requestFocus();
                    } else {
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                        Call<BusinessSource> call = apiInterface.insertbusinesssource(shortco, roomname, "", "", "", ""
                                , status);

                        call.enqueue(new Callback<BusinessSource>() {
                            @Override
                            public void onResponse(Call<BusinessSource> call, Response<BusinessSource> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Business Source Added Successfully");
                                    businessSourceCrud.getBusinessSource(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }


                            }

                            @Override
                            public void onFailure(Call<BusinessSource> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });
                    }
                }
            });


        } else if (layoutType == BokkingSource) {

            EditText shortcode = dialog.findViewById(R.id.shortcodebusinessource);
            EditText BokkingSourcename = dialog.findViewById(R.id.businesssourcename);
            Button bt_submit = dialog.findViewById(R.id.bt_submit);
            String status = "1";

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortco = shortcode.getText().toString();
                    String roomname = BokkingSourcename.getText().toString();
                    if (shortco.isEmpty()) {
                        shortcode.requestFocus();

                    } else if (roomname.isEmpty()) {
                        BokkingSourcename.requestFocus();
                    } else {
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                        Call<BokkingSource> call = apiInterface.insertbookingsource(shortco, roomname, "", "", "", ""
                                , status);

                        call.enqueue(new Callback<BokkingSource>() {
                            @Override
                            public void onResponse(Call<BokkingSource> call, Response<BokkingSource> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Booking Source Added Successfully");
                                    bokkingSourceCrud.getBookingSourceList(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Masters.BokkingSource.BokkingSource> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });
                    }
                }
            });


        } else if (layoutType == paymentType) {

            RadioGroup cashBank = dialog.findViewById(R.id.cashBank);
            AppCompatRadioButton cashRadio = dialog.findViewById(R.id.cashRadio);
            AppCompatRadioButton bankRadio = dialog.findViewById(R.id.bankRadio);
//            int cashBankId = cashBank.getCheckedRadioButtonId();
//            AppCompatRadioButton finalRadio;
//            finalRadio = (AppCompatRadioButton)dialog.findViewById(cashBankId);
//            String type;
//            if (finalRadio.getText().toString()!=null)
//                type = finalRadio.getText().toString();
//             else
//                type = "";
            String type;
            if (cashBank.getCheckedRadioButtonId() == R.id.cashRadio)
                type = "Cash";
            else
                type = "Bank";

            AppCompatCheckBox consideras = dialog.findViewById(R.id.consideras);
            consideras.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        considera = "1";
                    } else {

                    }
                }
            });
            EditText shortcode = dialog.findViewById(R.id.shortcodebusinessource);
            EditText BokkingSourcename = dialog.findViewById(R.id.businesssourcename);
            Button bt_submit = dialog.findViewById(R.id.bt_submit);
            String status = "1";

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortco = shortcode.getText().toString();
                    String roomname = BokkingSourcename.getText().toString();
                    if (shortco.isEmpty()) {
                        shortcode.requestFocus();

                    } else if (roomname.isEmpty()) {
                        BokkingSourcename.requestFocus();
                    } else {
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                        Call<PaymentType> call = apiInterface.insertPaymentType(shortco, type, considera, roomname, "", "", "", ""
                                , status);

                        call.enqueue(new Callback<PaymentType>() {
                            @Override
                            public void onResponse(Call<PaymentType> call, Response<PaymentType> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Payment Type Added Successfully");
                                    paymentTypeCrud.getPaymentList(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<PaymentType> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });
                    }
                }
            });

        }
//         else if (layoutType == reservationType) {
//
//            RadioGroup cashBank = dialog.findViewById(R.id.cashBank);
//            AppCompatRadioButton cashRadio = dialog.findViewById(R.id.cashRadio);
//            AppCompatRadioButton bankRadio = dialog.findViewById(R.id.bankRadio);
//
//            String type;
//            if (cashBank.getCheckedRadioButtonId() == R.id.cashRadio)
//                type = "Confirmed";
//            else
//                type = "Unconfirmed";
//
//
//            EditText shortcode = dialog.findViewById(R.id.shortcodebusinessource);
//            EditText reservationtype = dialog.findViewById(R.id.businesssourcename);
//            Button bt_submit = dialog.findViewById(R.id.bt_submit);
//            String status = "1";
//
//            bt_submit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String shortco = shortcode.getText().toString();
//                    String roomname = reservationtype.getText().toString();
//                    if (shortco.isEmpty()) {
//                        shortcode.requestFocus();
//
//                    } else if (roomname.isEmpty()) {
//                        reservationtype.requestFocus();
//                    } else {
//                        progressDialog.show();
//                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//
//                        Call<ReservationType> call = apiInterface.insertResType(shortco, type, roomname, "", "", "", ""
//                                , status);
//
//                        call.enqueue(new Callback<ReservationType>() {
//                            @Override
//                            public void onResponse(Call<ReservationType> call, Response<ReservationType> response) {
//
//                                String value = response.body().getValue();
//                                String message = response.body().getMassage();
//                                Log.e("rr", value);
//
//                                if (value.equals("1")) {
//                                    Log.e("rr", "qwerty");
//                                    progressDialog.dismiss();
//
//                                } else {
//                                    progressDialog.dismiss();
//
//                                    Log.e("rr", message);
//                                }
//
//                            }
//
//                            @Override
//                            public void onFailure(Call<ReservationType> call, Throwable t) {
//                                progressDialog.dismiss();
//                                Log.e("rr", "" + t.getMessage());
//
//                                Toast.makeText(GeneralActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                }
//            });
//
//
        else if (layoutType == identityType) {

            EditText shortcode = dialog.findViewById(R.id.shortcodeidentity);
            EditText ratetypename = dialog.findViewById(R.id.identityname);
            Button bt_submit = dialog.findViewById(R.id.bt_submit);
            String status = "1";

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortco = shortcode.getText().toString();
                    String roomname = ratetypename.getText().toString();
                    if (shortco.isEmpty()) {
                        shortcode.requestFocus();

                    } else if (roomname.isEmpty()) {
                        ratetypename.requestFocus();
                    } else {
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
                        Call<IdentityType> call = apiInterface.insertidentitytype(shortco, roomname, "", "", "", ""
                                , status);

                        call.enqueue(new Callback<IdentityType>() {
                            @Override
                            public void onResponse(Call<IdentityType> call, Response<IdentityType> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Identity Type Added Successfully");
                                    identityTypeCrud.getIdentityType(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<IdentityType> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });
                    }
                }
            });


        } else if (layoutType == marketCodeType) {

            EditText shortcode = dialog.findViewById(R.id.shortcodeidentity);
            EditText ratetypename = dialog.findViewById(R.id.identityname);
            Button bt_submit = dialog.findViewById(R.id.bt_submit);
            String status = "1";

            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortco = shortcode.getText().toString();
                    if (shortco.isEmpty()) {
                        shortcode.requestFocus();
                    } else {
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                        Call<MarketCodeType> call = apiInterface.insertMarketCode(shortco, "", "", "", ""
                                , status);

                        call.enqueue(new Callback<MarketCodeType>() {
                            @Override
                            public void onResponse(Call<MarketCodeType> call, Response<MarketCodeType> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Market Code Added Successfully");
                                    marketCodeTypeCrud.getMarketCodeType(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<MarketCodeType> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });
                    }
                }
            });


        } else if (layoutType == addCompany) {


            EditText shortcode = dialog.findViewById(R.id.shortcodecompany);
            EditText companyContactSal = dialog.findViewById(R.id.companyContactSal);
            EditText contactPersonName = dialog.findViewById(R.id.contactPersonName);
            EditText companyName = dialog.findViewById(R.id.companyName);
            EditText pinCode = dialog.findViewById(R.id.pinCode);
            EditText companyCity = dialog.findViewById(R.id.companyCity);
            EditText fullAdd = dialog.findViewById(R.id.fullAdd);
            EditText companystate = dialog.findViewById(R.id.companystate);
            EditText companyCountry = dialog.findViewById(R.id.companyCountry);
            EditText customerEmail = dialog.findViewById(R.id.customerEmail);
            EditText companyPhone = dialog.findViewById(R.id.companyPhone);
            EditText companyMobile = dialog.findViewById(R.id.companyMobile);
            EditText companyTaxid = dialog.findViewById(R.id.companyTaxid);
            EditText gstIdType = dialog.findViewById(R.id.gstIdType);
            EditText companyOpeningBalance = dialog.findViewById(R.id.companyOpeningBalance);
            EditText companyCreditBalance = dialog.findViewById(R.id.companyCreditBalance);

            Button bt_submit = dialog.findViewById(R.id.bt_submit);
            bt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String code = shortcode.getText().toString();
                    String companyConSal = companyContactSal.getText().toString();
                    String companyPerson = contactPersonName.getText().toString();
                    String conpanynam = companyName.getText().toString();
                    String pinco = pinCode.getText().toString();
                    String companycit = companyCity.getText().toString();
                    String ADDRESS = fullAdd.getText().toString();
                    String companysta = companystate.getText().toString();
                    String companycountry = companyCountry.getText().toString();
                    String companyemail = customerEmail.getText().toString();
                    String copmanyphone = companyPhone.getText().toString();
                    String companymob = companyMobile.getText().toString();
                    String companytax = companyTaxid.getText().toString();
                    String gstid = gstIdType.getText().toString();
                    String comopeningBal = companyOpeningBalance.getText().toString();
                    String companycreditbal = companyCreditBalance.getText().toString();

                    if (code.isEmpty()) {
                        shortcode.setError("");
                    } else if (companyConSal.isEmpty()) {
                        companyContactSal.setError("");
                    } else if (companyPerson.isEmpty()) {
                        contactPersonName.setError("");
                    } else if (conpanynam.isEmpty()) {
                        companyName.setError("");
                    } else if (pinco.isEmpty()) {
                        pinCode.setError("");
                    } else if (companycit.isEmpty()) {
                        companyCity.setError("");
                    } else if (ADDRESS.isEmpty()) {
                        fullAdd.setError("");
                    } else if (companysta.isEmpty()) {
                        companystate.setError("");
                    } else if (companycountry.isEmpty()) {
                        companyCountry.setError("");
                    } else if (companyemail.isEmpty()) {
                        customerEmail.setError("");
                    } else if (companyemail.isEmpty()) {
                        customerEmail.setError("");
                    } else if (copmanyphone.isEmpty()) {
                        companyPhone.setError("");
                    } else if (companymob.isEmpty()) {
                        companyMobile.setError("");
                    } else if (companytax.isEmpty()) {
                        companyTaxid.setError("");
                    } else if (gstid.isEmpty()) {
                        gstIdType.setError("");
                    } else if (comopeningBal.isEmpty()) {
                        companyOpeningBalance.setError("");
                    } else if (companycreditbal.isEmpty()) {
                        companyCreditBalance.setError("");
                    } else {
                        String status = "1";
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                        Call<CompanyDetails> call = apiInterface.insertCompany(
                                conpanynam, companyPerson, code, pinco, companycit, ADDRESS
                                , companysta, companycountry, companyemail, copmanyphone
                                , companymob, companytax, gstid, comopeningBal, companycreditbal, status);

                        call.enqueue(new Callback<CompanyDetails>() {
                            @Override
                            public void onResponse(Call<CompanyDetails> call, Response<CompanyDetails> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMassage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Company Details Added Successfully");
                                    //identityTypeCrud.getIdentityType(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<CompanyDetails> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });

                    }


                }
            });


        } else if (layoutType == addRoom) {
            EditText addRoomShortCode, addRoomShortKey, addRoomName, addRoomsType, addRoomBedType, addRoomNumber, addRoomDescription, addRoomTemplate, addRoomSuiteName;
            AppCompatCheckBox isNonSmoking, isPaymasterRoom, isPaymasterInventory, isSendVoucher;
            LinearLayout paymasterLayout;
            RadioGroup addRoomAs;
            RadioButton normalRoom, suiteRoom;

            addRoomShortCode = dialog.findViewById(R.id.addRoomShortCode);
            addRoomShortKey = dialog.findViewById(R.id.addRoomShortKey);
            addRoomName = dialog.findViewById(R.id.addRoomName);
            addRoomsType = dialog.findViewById(R.id.addRoomType);
            addRoomBedType = dialog.findViewById(R.id.addRoomBedType);
            addRoomNumber = dialog.findViewById(R.id.addRoomNumber);
            addRoomDescription = dialog.findViewById(R.id.addRoomDescription);
            addRoomTemplate = dialog.findViewById(R.id.addRoomTemplate);
            addRoomSuiteName = dialog.findViewById(R.id.addRoomSuiteName);

            isNonSmoking = dialog.findViewById(R.id.isNonSmoking);
            isPaymasterRoom = dialog.findViewById(R.id.isPaymasterRoom);
            isPaymasterInventory = dialog.findViewById(R.id.isPaymasterInventory);
            isSendVoucher = dialog.findViewById(R.id.isSendVoucher);
            Button bbt_submit = dialog.findViewById(R.id.bt_submit);
            paymasterLayout = dialog.findViewById(R.id.paymasterLayout);

            addRoomAs = dialog.findViewById(R.id.addRoomAs);

            addRoomAs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    roomas = group.findViewById(checkedId);

                    if (null != roomas && checkedId > -1) {

                    }

                }
            });
            addRoomsType.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] array = new String[roomlist.size()];
//
                    for (int i = 0; i < roomlist.size(); i++)
                        array[i] = roomlist.get(i).getRoomtypename();

                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Room Type");
                }
            });
            isPaymasterRoom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        openSubNav(paymasterLayout);
                    } else {
                        closeSubNav(paymasterLayout);
                    }
                }
            });
            bbt_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String shortcode = addRoomShortCode.getText().toString();
                    String addRoomshortkey = addRoomShortKey.getText().toString();
                    String addroomname = addRoomName.getText().toString();
                    String addRoomType = addRoomsType.getText().toString();
                    String addroombedtype = addRoomBedType.getText().toString();
                    String addroomnumber = addRoomNumber.getText().toString();
                    String addroomdescription = addRoomDescription.getText().toString();
                    String addroomtemplate = addRoomTemplate.getText().toString();
                    String addroomsuitename = addRoomSuiteName.getText().toString();

                    if (addRoomType.isEmpty()) {
                        addRoomsType.setError("");
                    } else if (addroomname.isEmpty()) {
                        addRoomName.setError("");
                    } else {

                        String status = "1";
                        progressDialog.show();
                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                        Call<Rooms> call = apiInterface.insertRoom(
                                shortcode, addRoomshortkey, addroomname, addRoomType, addroombedtype,
                                addroomnumber, "", "", "", ""
                                , "", "", roomas.getText().toString(),
                                "", addroomdescription, "", "", status);

                        call.enqueue(new Callback<Rooms>() {
                            @Override
                            public void onResponse(Call<Rooms> call, Response<Rooms> response) {

                                String value = response.body().getValue();
                                String message = response.body().getMessage();
                                Log.e("rr", value);

                                if (value.equals("1")) {
                                    Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Rooms Details Added Successfully");
                                    roomsCrud.getRoomList(GeneralActivity.this, binding.recyclerViewMovieList);
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                } else {
                                    progressDialog.dismiss();
                                    Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                    ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            dialog1.dismiss();
                                        }
                                    });
                                    progressDialog.dismiss();
                                    dialog.dismiss();
                                }

                            }

                            @Override
                            public void onFailure(Call<Rooms> call, Throwable t) {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }
                        });
                    }


                }
            });
        }

//         else if (layoutType == tax) {
//            EditText shortcodeTax = dialog.findViewById(R.id.shortcodeTax);
//            EditText taxName = dialog.findViewById(R.id.taxName);
//            EditText taxDate = dialog.findViewById(R.id.taxDate);
//            EditText taxExempt = dialog.findViewById(R.id.taxExempt);
//            EditText taxPostingType = dialog.findViewById(R.id.taxPostingType);
//            EditText postingAmount = dialog.findViewById(R.id.postingAmount);
//            EditText taxandslab = dialog.findViewById(R.id.taxandslab);
//            LinearLayout postingTypeLayout = dialog.findViewById(R.id.postingTypeLayout);
//            Button slabButton = dialog.findViewById(R.id.slabButton);
//            Button add_tax_btn = dialog.findViewById(R.id.add_tax_btn);
//            RecyclerView generatedSlabListView = dialog.findViewById(R.id.generatedSlabList);
//            AppCompatCheckBox sgst1 = dialog.findViewById(R.id.sgst1);
//            AppCompatCheckBox sc1 = dialog.findViewById(R.id.sc1);
//            AppCompatCheckBox sgst2 = dialog.findViewById(R.id.sgst1);
//            AppCompatCheckBox cgst1 = dialog.findViewById(R.id.cgst1);
//            AppCompatCheckBox cgst2 = dialog.findViewById(R.id.cgst2);
//            AppCompatCheckBox sgst3 = dialog.findViewById(R.id.sgst3);
//            AppCompatCheckBox cgst3 = dialog.findViewById(R.id.cgst3);
//            AppCompatCheckBox rackRateCheck = dialog.findViewById(R.id.rackRateCheck);
//            RadioGroup applyTaxGroup = dialog.findViewById(R.id.applyTaxGroup);
//            RadioButton afterdis = dialog.findViewById(R.id.afterDisButton);
//
//            applyTaxGroup.clearCheck();
//
//            applyTaxGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @SuppressLint("ResourceType")
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                    afterbefore = group.findViewById(checkedId);
//
//                    if (null != afterbefore && checkedId > -1) {
//
//                        Toast.makeText(GeneralActivity.this, afterbefore.getText(), Toast.LENGTH_SHORT).show();
//                    }
//
//                }
//            });
//
//
//            taxDate.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    AppConfig.datepick(GeneralActivity.this, taxDate);
//
//                }
//            });
//
//
//            taxPostingType.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String[] array = new String[]{"Flat Amount", "Flat Percentage", "Slab"};
//                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Tax Posting Type");
//                }
//            });
//
//            SlabListViewValuesArr = new ArrayList<>();
//
//            taxPostingType.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    if (!taxPostingType.getText().toString().trim().isEmpty()) {
//                        if (taxPostingType.getText().toString().trim().equals("Flat Amount")) {
//                            postingTypeLayout.setVisibility(View.VISIBLE);
//                            postingAmount.setVisibility(View.VISIBLE);
//                            taxandslab.setVisibility(View.VISIBLE);
//                            taxandslab.setHint("On Pax");
//                            taxandslab.setKeyListener(null);
//                            generatedSlabListView.setVisibility(View.GONE);
//                            taxandslab.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    String[] array = new String[]{"Per Night", "Per Adult", "Per Child", "Per Pax"};
//                                    AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Apply On PAX");
//                                }
//                            });
//                            slabButton.setVisibility(View.GONE);
//                        } else if (taxPostingType.getText().toString().trim().equals("Flat Percentage")) {
//                            postingTypeLayout.setVisibility(View.VISIBLE);
//                            postingAmount.setVisibility(View.VISIBLE);
//                            taxandslab.setVisibility(View.GONE);
//                            postingAmount.setHint("Tax %");
//                            postingAmount.setText("");
//                            slabButton.setVisibility(View.GONE);
//                            generatedSlabListView.setVisibility(View.GONE);
//                        } else if (taxPostingType.getText().toString().trim().equals("Slab")) {
//                            postingTypeLayout.setVisibility(View.VISIBLE);
//                            postingAmount.setVisibility(View.VISIBLE);
//                            taxandslab.setVisibility(View.GONE);
//                            postingAmount.setHint("Slab Num");
//                            postingAmount.setText("");
//                            slabButton.setVisibility(View.VISIBLE);
//                            slabButton.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    slabArr = new String[Integer.parseInt(postingAmount.getText().toString())];
//
//                                    SlabListViewValuesArr.clear();
//                                    for (int i = 0; i < Integer.parseInt(postingAmount.getText().toString()); i++) {
//                                        SlabListViewValuesArr.add(new SlabLlistModal());
//                                    }
//                                    generatedSlabListView.setVisibility(View.VISIBLE);
//                                    generatedSlabListView.setLayoutManager(new LinearLayoutManager(GeneralActivity.this));
//
//                                    generatedSlabListView.setHasFixedSize(true);
//                                    SlabAdapter adapter = new SlabAdapter(GeneralActivity.this, SlabListViewValuesArr);
//                                    generatedSlabListView.setAdapter(adapter);
//                                }
//                            });
//                        } else {
//                            postingTypeLayout.setVisibility(View.GONE);
//                        }
//                    }
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//
//                }
//            });
//
//            rackRateCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    if (isChecked) {
//                        applyTaxGroup.check(R.id.beforeDisButton);
//                        racratevalue = "1";
//                    } else {
//                        racratevalue = "0";
//
//                        afterdis.setVisibility(View.GONE);
//                    }
//                }
//            });
//
//            add_tax_btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    Calendar cal = Calendar.getInstance();
//
//                    DateFormat date = new SimpleDateFormat("MMddyyyyhhmmss");
//                    String taxid = date.format(cal.getTime());
//
//                    if (taxPostingType.getText().toString().equals("Slab")) {
//
//
//                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//
//                        Call<Tax> call = apiInterface.insertTax(
//                                shortcodeTax.getText().toString(), taxName.getText().toString(),
//                                taxid
//                                , taxDate.getText().toString(), taxExempt.getText().toString()
//                                , taxPostingType.getText().toString()
//                                , postingAmount.getText().toString(), afterbefore.getText().toString(),
//                                "", taxandslab.getText().toString(), slabArr, racratevalue);
//
//                        call.enqueue(new Callback<Tax>() {
//                            @Override
//                            public void onResponse(Call<Tax> call, Response<Tax> response) {
//
//                                String value = response.body().getValue();
//                                String message = response.body().getMassage();
//                                Log.e("rr", value);
//
//                                if (value.equals("1")) {
//                                    Log.e("rr", "qwerty");
//                                    progressDialog.dismiss();
//                                    slabArr = new String[0];
//
//                                } else {
//                                    progressDialog.dismiss();
//
//                                    Log.e("rr", message);
//                                }
//
//                            }
//
//                            @Override
//                            public void onFailure(Call<Tax> call, Throwable t) {
//                                progressDialog.dismiss();
//                                Log.e("rr", "" + t.getMessage());
//
//                                Toast.makeText(GeneralActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//
//                    } else {
//
//                        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//                        Call<Tax> call = apiInterface.insertTax(
//                                shortcodeTax.getText().toString(), taxName.getText().toString(),
//                                taxid,
//                                taxDate.getText().toString(), taxExempt.getText().toString()
//                                , taxPostingType.getText().toString()
//                                , postingAmount.getText().toString(), afterbefore.getText().toString(),
//                                "", taxandslab.getText().toString(), slabArr, racratevalue);
//
//                        call.enqueue(new Callback<Tax>() {
//                            @Override
//                            public void onResponse(Call<Tax> call, Response<Tax> response) {
//
//                                String value = response.body().getValue();
//                                String message = response.body().getMassage();
//
//                                Log.e("rr", value);
//
//                                if (value.equals("1")) {
//
//                                    Log.e("rr", "qwerty");
//
//                                    progressDialog.dismiss();
//
//                                } else {
//
//                                    progressDialog.dismiss();
//
//                                    Log.e("rr", message);
//                                }
//
//                            }
//
//                            @Override
//                            public void onFailure(Call<Tax> call, Throwable t) {
//                                progressDialog.dismiss();
//                                Log.e("rr", "" + t.getMessage());
//
//                                Toast.makeText(GeneralActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                            }
//                        });
//                    }
//
//
//                }
//            });
//
//        }

        dialog.show();

    }

    private void showFolioDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        FormFolioTypeBinding binding2 = FormFolioTypeBinding.inflate(LayoutInflater.from(GeneralActivity.this));
        dialog.setContentView(binding2.getRoot());
        dialog.setCancelable(true);
        binding2.masterType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] array = new String[]{

                        "Adustment",
                        "Room Charges", "Bank", "Cash", "City Ledger", "Discount", "Extra Charges", "Transfer"

                };
//

                AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Master Type");
            }
        });
        binding2.slectratetype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] array = new String[]{

                        "Credit", "Debit", "Transfer"

                };
//

                AppConfig.showChoiceDialog(v, array, GeneralActivity.this, "Master Type");
            }
        });
        binding2.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding2.slectratetype.getText().toString().isEmpty()) {

                } else if (binding2.ratetypename.getText().toString().isEmpty()) {

                } else if (binding2.masterType.getText().toString().isEmpty()) {

                } else {
                    progressDialog.show();
                    apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

                    Call<RateType> call = apiInterface.insertFoliotype(binding2.slectratetype.getText().toString(),
                            binding2.ratetypename.getText().toString(), binding2.masterType.getText().toString(), "", "", "", ""
                            , "1");

                    call.enqueue(new Callback<RateType>() {
                        @Override
                        public void onResponse(Call<RateType> call, Response<RateType> response) {

                            String value = response.body().getValue();
                            String message = response.body().getMassage();
                            Log.e("rr", value);

                            if (value.equals("1")) {
                                Dialog dialog1 = AppConfig.showSuccessDialog(GeneralActivity.this, "Rate Type Added Successfully");
                                rateTypeCrud.getRateTypeList(GeneralActivity.this, binding.recyclerViewMovieList);
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            } else {
                                progressDialog.dismiss();
                                Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                                ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        dialog1.dismiss();
                                    }
                                });
                                progressDialog.dismiss();
                                dialog.dismiss();
                            }

                        }

                        @Override
                        public void onFailure(Call<RateType> call, Throwable t) {
                            progressDialog.dismiss();
                            Dialog dialog1 = AppConfig.showWarningDialog(GeneralActivity.this, "Oops Error Occured");
                            ((AppCompatButton) dialog1.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog1.dismiss();
                                }
                            });
                            progressDialog.dismiss();
                            dialog.dismiss();
                        }
                    });
                }

            }
        });
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.show();

    }

    private void fillIndependentLayout() {

    }

    private void fillDerivedLayout() {
    }

    private void initViews() {
        marketCodeType = findViewById(R.id.marketCodeType);
        discountType = findViewById(R.id.discountType);
        businessSourceType = findViewById(R.id.businessSourceType);
        generalSettings = findViewById(R.id.generatlSetting);
        generalSettingsLayout = findViewById(R.id.generatlSettingLayout);
        roomsManagement = findViewById(R.id.roomsManagement);
        roomsManagementLayout = findViewById(R.id.roomsManagementLayout);
        propertySetting = findViewById(R.id.propertySetting);
        propertySettingLayout = findViewById(R.id.propertySettingLayout);
        companySetting = findViewById(R.id.companySettings);
        companySettingLayout = findViewById(R.id.companySettingLayout);
        addCompany = findViewById(R.id.addCompany);
        //
        addRoom = findViewById(R.id.addRoom);
        identityType = findViewById(R.id.identityType);
        paymentType = findViewById(R.id.paymentType);
        transportationMode = findViewById(R.id.transportationMode);
        BokkingSource = findViewById(R.id.bookingSource);
        currency = findViewById(R.id.currency);
        //
        amenities = findViewById(R.id.amenties);
        RoomsType = findViewById(R.id.roomType);
        rateType = findViewById(R.id.rateType);
        ratePlan = findViewById(R.id.ratePlan);
        roomImages = findViewById(R.id.roomImages);
        //
        tax = findViewById(R.id.tax);
        travelAgent = findViewById(R.id.travelAgent);
        guestDatabase = findViewById(R.id.guestDatabase);
    }

    private void openSubNav(LinearLayout layout) {
        layout.setVisibility(View.VISIBLE);
    }

    private void closeSubNav(LinearLayout layout) {
        layout.setVisibility(View.GONE);
    }

    public void getRoomsType() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<RoomsType>> call = apiInterface.getRoomType();
        call.enqueue(new Callback<List<RoomsType>>() {
            @Override
            public void onResponse(Call<List<RoomsType>> call, Response<List<RoomsType>> response) {
                roomlist = response.body();

            }

            @Override
            public void onFailure(Call<List<RoomsType>> call, Throwable t) {
                Log.d("error", "" + t.getMessage());

            }
        });
    }

    public void getRateType() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<RateType>> call = apiInterface.getRateType();
        call.enqueue(new Callback<List<RateType>>() {
            @Override
            public void onResponse(Call<List<RateType>> call, Response<List<RateType>> response) {
                ratelist = response.body();
                Log.e("df", "sdfvb");

            }

            @Override
            public void onFailure(Call<List<RateType>> call, Throwable t) {
                Log.d("error", "" + t.getMessage());

            }
        });
    }


    public void getRatePlan() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<RatePlan>> call = apiInterface.getRatePlan();
        call.enqueue(new Callback<List<RatePlan>>() {
            @Override
            public void onResponse(Call<List<RatePlan>> call, Response<List<RatePlan>> response) {
                ratePlanslist = response.body();
                Log.e("df", "Rate plan");

            }

            @Override
            public void onFailure(Call<List<RatePlan>> call, Throwable t) {
                Log.d("error", "" + t.getMessage());

            }
        });
    }

    public void getCompany() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<CompanyDetails>> call = apiInterface.getCompany();
        call.enqueue(new Callback<List<CompanyDetails>>() {
            @Override
            public void onResponse(Call<List<CompanyDetails>> call, Response<List<CompanyDetails>> response) {
                companyList = response.body();

                Log.e("df", "sdfvb");

            }

            @Override
            public void onFailure(Call<List<CompanyDetails>> call, Throwable t) {
                Log.d("error", "" + t.getMessage());

            }
        });
    }

    public void getBusinessSource() {
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<BusinessSource>> call = apiInterface.getBusinesSource();
        call.enqueue(new Callback<List<BusinessSource>>() {
            @Override
            public void onResponse(Call<List<BusinessSource>> call, Response<List<BusinessSource>> response) {
                businessSources = response.body();


            }

            @Override
            public void onFailure(Call<List<BusinessSource>> call, Throwable t) {
                Log.d("error", "" + t.getMessage());

            }
        });
    }

}