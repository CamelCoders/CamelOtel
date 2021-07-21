package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.CheckInOffice;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.FrontOffice;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import soup.neumorphism.NeumorphTextView;

public class PmsTabDashboard extends AppCompatActivity {


    final Fragment fragment1 = new FrontOffice();
    final Fragment fragment2 = new CheckInOffice();
    final FragmentManager fm = getSupportFragmentManager();
    Reservation newReseravation = new Reservation();
    Fragment active = fragment1;
    NeumorphTextView greetings;
    BoomMenuButton selectHotel;
    ImageView navImg;
    String frgVlaue = "";
    RecyclerView mainRecyclerView;
    StayInformationAdapter stayInformationAdapter;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat;
    List<StayInformation> stayInformationList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pms_tab_dashboard);
        AppConfig.setOrientations(PmsTabDashboard.this);
        AppConfig.setStatusBarColor(PmsTabDashboard.this, R.color.dark_color);
        initView();
        frgVlaue = getIntent().getStringExtra("frag");
        if (frgVlaue == null) {
            setFragment();
        } else if (frgVlaue.equals("1")) {
            setFragment2();
        }
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
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        mainRecyclerView = findViewById(R.id.listRecyclerView);
        getStayInformation();

    }

    public void getStayInformation() {
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();


                for (int i = 0; i < stayInformationList.size(); i++) {
                    if (!stayInformationList.get(i).getCheckin().equals(simpleDateFormat.format(calendar.getTime()))) {
                        stayInformationList.remove(i);
                    }
                }

                Log.e("", "" + stayInformationList.size());

                LinearLayoutManager layoutManager = new LinearLayoutManager(PmsTabDashboard.this);

                mainRecyclerView.setLayoutManager(layoutManager);
                stayInformationAdapter = new StayInformationAdapter(PmsTabDashboard.this, stayInformationList);
                mainRecyclerView.setAdapter(stayInformationAdapter);


            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }


    private void setFragment2() {
        fm.beginTransaction().hide(active).show(fragment2).commit();
        active = fragment2;
    }

    private void setFragment() {
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();
    }

    private void initView() {
        greetings = (NeumorphTextView) findViewById(R.id.greetings);
        selectHotel = (BoomMenuButton) findViewById(R.id.selecthotel);
        navImg = (ImageView) findViewById(R.id.navImg);
    }

    private void initNavigationMenu() {
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        drawer.openDrawer(GravityCompat.END);
    }

}