package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;
import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.OnBoomListener;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.CheckInOffice;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.FrontOffice;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.BuilderManager;
import soup.neumorphism.NeumorphTextView;

public class PmsTabDashboard extends AppCompatActivity  {


    Reservation newReseravation = new Reservation();

    final Fragment fragment1 = new FrontOffice();
    final Fragment fragment2 = new CheckInOffice();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;
    NeumorphTextView greetings;
    BoomMenuButton selectHotel;
    ImageView navImg;
    String frgVlaue="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pms_tab_dashboard);
        AppConfig.setOrientations(PmsTabDashboard.this);
        AppConfig.setStatusBarColor(PmsTabDashboard.this, R.color.dark_color);
        initView();
        frgVlaue=getIntent().getStringExtra("frag");
        if (frgVlaue==null){
            setFragment();
        }
       else if (frgVlaue.equals("1")){
            setFragment2();
        }
        greetings.setText(AppConfig.getGreetings());

        for (int i = 0; i < selectHotel.getPiecePlaceEnum().pieceNumber(); i++) {
            selectHotel.addBuilder(BuilderManager.getHamButtonBuilder());
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