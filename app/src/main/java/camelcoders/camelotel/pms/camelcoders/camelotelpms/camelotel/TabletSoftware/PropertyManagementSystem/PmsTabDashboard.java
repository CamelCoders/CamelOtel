package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
 import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.FrontOffice;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import soup.neumorphism.NeumorphTextView;

public class PmsTabDashboard extends AppCompatActivity {

    final Fragment fragment1 = new FrontOffice();
     final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
    String activeAudit = "Pending";
    CardView pendingReservationAudit, releaseReservationAudit, roomStatusAudit, unsetelledFolios, nightlyCharges,
            newDayAudit;
    TextView pendingReservationAuditText, releaseReservationAuditText, roomStatusAuditText, unsetelledFoliosText, nightlyChargesText, newDayAuditText;
    Reservation newReseravation = new Reservation();
    NeumorphTextView greetings;
    BoomMenuButton selectHotel;
    ImageView navImg;
    String frgVlaue = "";
    RecyclerView mainRecyclerView;
    StayInformationAdapter stayInformationAdapter;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat;
    List<StayInformation> stayInformationList = new ArrayList<>();
    LinearLayout nightAudit, guestView, dashboardMain, roomView, listLayout;
    DrawerLayout drawer;
    FrameLayout main_container;
    EditText SelectDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pms_tab_dashboard);
        AppConfig.setOrientations(PmsTabDashboard.this);
        AppConfig.setStatusBarColor(PmsTabDashboard.this, R.color.dark_color);
        initView();

        SelectDate=findViewById(R.id.SelectDate);

        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        SelectDate.setText(simpleDateFormat.format(calendar.getTime()));

        SelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.datepick(


                        PmsTabDashboard.this,SelectDate);
            }
        });




         fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();
        getStayInformation();
        greetings.setText(AppConfig.getGreetings());
        for (int i = 0; i < selectHotel.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder();
            if (i == 0) {
                builder.normalText("New Reservation");
                builder.normalImageRes(R.drawable.ic_reservation);
            } else if (i == 1) {
                builder.normalText("Walk-In");
                builder.normalImageRes(R.drawable.ic_arrival);
            } else if (i == 2) {
                builder.normalText("Reservation / Booking List");
                builder.normalImageRes(R.drawable.ic_list);
            } else if (i == 3) {
                builder.normalText("Arrival List");
                builder.normalImageRes(R.drawable.ic_arrival);
            } else if (i == 4) {
                builder.normalText("Departure List");
                builder.normalImageRes(R.drawable.ic_departure);
            } else if (i == 5) {
                builder.normalText("In-House View");
                builder.normalImageRes(R.drawable.ic_inhouse);
            }
            selectHotel.addBuilder(builder);
        }
        selectHotel.setOnBoomListener(new OnBoomListener() {
            @Override
            public void onClicked(int index, BoomButton boomButton) {
                if (index == 0) {
                    newReseravation.createReservation(PmsTabDashboard.this);
                }
                if (index == 2){
                    stayInformationList.clear();

                    StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

                    Call<List<StayInformation>> call = apiInterface.getStayInfomation();
                    call.enqueue(new Callback<List<StayInformation>>() {
                        @Override
                        public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                            stayInformationList = response.body();

                            List<StayInformation> stayInformationList2 = new ArrayList<>();
                            for (int i = 0; i < stayInformationList.size(); i++) {
                                if (stayInformationList.get(i).getCheckin().equals(SelectDate.getText().toString())||stayInformationList.get(i).getCheckout().equals(SelectDate.getText().toString())){
                                    stayInformationList2.add(stayInformationList.get(i));
                                }
                            }


                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(PmsTabDashboard.this);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            mainRecyclerView.setLayoutManager(layoutManager);
                            stayInformationAdapter = new StayInformationAdapter(PmsTabDashboard.this, stayInformationList2,"Reservation");
                            mainRecyclerView.setAdapter(stayInformationAdapter);
//

                        }

                        @Override
                        public void onFailure(Call<List<StayInformation>> call, Throwable t) {
                        }
                    });
                }
                if (index == 3) {
                     stayInformationList.clear();
                    StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

                    Call<List<StayInformation>> call = apiInterface.getStayInfomation();
                    call.enqueue(new Callback<List<StayInformation>>() {
                        @Override
                        public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                            stayInformationList = response.body();

                            for (int i = 0; i < stayInformationList.size(); i++) {

                                if (!stayInformationList.get(i).getCheckin().equals(SelectDate.getText().toString())){
                                        stayInformationList.remove(i);
                                }
                            }
                            for (int i = 0; i < stayInformationList.size(); i++) {

                                if (!stayInformationList.get(i).getStatus().equals("0")){
                                        stayInformationList.remove(i);
                                }
                            }


                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(PmsTabDashboard.this);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            mainRecyclerView.setLayoutManager(layoutManager);
                            stayInformationAdapter = new StayInformationAdapter(PmsTabDashboard.this, stayInformationList,"Arrival");
                            mainRecyclerView.setAdapter(stayInformationAdapter);
//

                        }

                        @Override
                        public void onFailure(Call<List<StayInformation>> call, Throwable t) {
                        }
                    });
                }
                if (index == 4) {
                    stayInformationList.clear();
                    StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

                    Call<List<StayInformation>> call = apiInterface.getStayInfomation();
                    call.enqueue(new Callback<List<StayInformation>>() {
                        @Override
                        public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                            stayInformationList = response.body();


                            for (int i = 0; i < stayInformationList.size(); i++) {
                                if (!(stayInformationList.get(i).getCheckout().equals(SelectDate.getText().toString()))
                                ) {
                                    stayInformationList.remove(i);
                                }
                            }
                            for (int i = 0; i < stayInformationList.size(); i++) {

                                if (!stayInformationList.get(i).getStatus().equals("1")){
                                    stayInformationList.remove(i);
                                }
                            }


                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(PmsTabDashboard.this);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            mainRecyclerView.setLayoutManager(layoutManager);
                            stayInformationAdapter = new StayInformationAdapter(PmsTabDashboard.this, stayInformationList,"Departure");
                            mainRecyclerView.setAdapter(stayInformationAdapter);
//

                        }

                        @Override
                        public void onFailure(Call<List<StayInformation>> call, Throwable t) {
                        }
                    });
                }
                if (index == 5) {
                    stayInformationList.clear();
                    StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

                    Call<List<StayInformation>> call = apiInterface.getStayInfomation();
                    call.enqueue(new Callback<List<StayInformation>>() {
                        @Override
                        public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                            stayInformationList = response.body();




                            for (int i = 0; i < stayInformationList.size(); i++) {

                                if (!stayInformationList.get(i).getCheckout().equals(SelectDate.getText().toString())){
                                    stayInformationList.remove(i);
                                }
                            }
                            for (int i = 0; i < stayInformationList.size(); i++) {

                                if (!stayInformationList.get(i).getStatus().equals("1")){
                                    stayInformationList.remove(i);
                                }
                            }



                            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(PmsTabDashboard.this);
                            layoutManager.setFlexDirection(FlexDirection.ROW);
                            mainRecyclerView.setLayoutManager(layoutManager);
                            stayInformationAdapter = new StayInformationAdapter(PmsTabDashboard.this, stayInformationList,"InHouse");
                            mainRecyclerView.setAdapter(stayInformationAdapter);
//

                        }

                        @Override
                        public void onFailure(Call<List<StayInformation>> call, Throwable t) {
                        }
                    });
                }

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

        navImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initNavigationMenu();
            }
        });
        mainRecyclerView = findViewById(R.id.listRecyclerView);
        dashboardMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                listLayout.setVisibility(View.VISIBLE);
//                fm.beginTransaction().show(fragment1).commit();
//                active = fragment1;
//                main_container.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//                drawer.closeDrawer(GravityCompat.END);
            }
        });

        nightAudit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performNightAudit();
                drawer.closeDrawer(GravityCompat.END);
            }
        });

        guestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fm.beginTransaction().hide(active).show(fragment2).commit();
//                active = fragment2;
//                listLayout.setVisibility(View.GONE);
//                drawer.closeDrawer(GravityCompat.END);
            }
        });

        roomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fm.beginTransaction().hide(active).show(fragment1).commit();
//                main_container.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//                active = fragment1;
//                listLayout.setVisibility(View.GONE);
//                drawer.closeDrawer(GravityCompat.END);
            }
        });
    }


    private void performNightAudit() {
        Dialog dialog = AppConfig.showFullScreenCustomDialog(R.layout.dialog_night_audit, PmsTabDashboard.this);
        pendingReservationAudit = dialog.findViewById(R.id.pendingReservationAudit);
        releaseReservationAudit = dialog.findViewById(R.id.releaseReservationAudit);
    }

    private void initView() {
        greetings = findViewById(R.id.greetings);
        selectHotel = findViewById(R.id.selecthotel);
        navImg = findViewById(R.id.navImg);
        nightAudit = findViewById(R.id.nightAudit);
        guestView = findViewById(R.id.guestView);
        dashboardMain = findViewById(R.id.dashboardMain);
        roomView = findViewById(R.id.roomView);
        listLayout = findViewById(R.id.listLayout);
        main_container = findViewById(R.id.main_container);
    }

    private void initNavigationMenu() {
        NavigationView nav_view = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        drawer.openDrawer(GravityCompat.END);
    }

    public void getStayInformation() {
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();

                List<StayInformation> stayInformationList2 = new ArrayList<>();
                for (int i = 0; i < stayInformationList.size(); i++) {
                    if (stayInformationList.get(i).getCheckin().equals(SelectDate.getText().toString())||stayInformationList.get(i).getCheckout().equals(SelectDate.getText().toString())){
                        stayInformationList2.add(stayInformationList.get(i));
                    }
                }


                FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(PmsTabDashboard.this);
                layoutManager.setFlexDirection(FlexDirection.ROW);
                mainRecyclerView.setLayoutManager(layoutManager);
                stayInformationAdapter = new StayInformationAdapter(PmsTabDashboard.this, stayInformationList2,"Reservation");
                mainRecyclerView.setAdapter(stayInformationAdapter);
//

            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }

}