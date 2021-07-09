package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.nightonke.boommenu.BoomMenuButton;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters.GeneralActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.PmsTabDashboard;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.BuilderManager;
import soup.neumorphism.NeumorphTextView;

public class TabletDashboard extends AppCompatActivity {
    NeumorphTextView greetings;
    TextView userName;
    View viewLines;
    BoomMenuButton selectHotel;
    BarChart barChart;
    PieChart pieChart;
    LineChart lineChart;
    RadarChart radarChart;
    Button jumptoPMSDash , jumpToSettings;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablet_dashboard);
        AppConfig.setOrientations(TabletDashboard.this);
        AppConfig.setStatusBarColor(TabletDashboard.this, R.color.light_color);
        initView();
        AppConfig.initAnimation(TabletDashboard.this);
        setAnimations();
        greetings.setText(AppConfig.getGreetings());
        for (int i = 0; i < selectHotel.getPiecePlaceEnum().pieceNumber(); i++)
            selectHotel.addBuilder(BuilderManager.getHamButtonBuilder());
        AppConfig.showBarChart(barChart, TabletDashboard.this);
        AppConfig.showPieChart(pieChart);
        AppConfig.showLineChart(lineChart);
        AppConfig.showRadarChart(radarChart, TabletDashboard.this);
        jumptoPMSDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(TabletDashboard.this, PmsTabDashboard.class, "fade");
            }
        });
        jumpToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConfig.jumpTo(TabletDashboard.this, GeneralActivity.class, "fade");
            }
        });
    }

    private void initView() {
        greetings = (NeumorphTextView) findViewById(R.id.greetings);
        userName = (TextView) findViewById(R.id.userName);
        viewLines = (View) findViewById(R.id.viewLines);
        selectHotel = (BoomMenuButton) findViewById(R.id.selecthotel);
        barChart = (BarChart) findViewById(R.id.barChart);
        pieChart = (PieChart) findViewById(R.id.pieChart);
        lineChart = (LineChart) findViewById(R.id.lineChart);
        radarChart = (RadarChart) findViewById(R.id.radarChart);
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        jumptoPMSDash = (Button) findViewById(R.id.jumptoPMSDash);
        jumpToSettings = (Button) findViewById(R.id.jumpToSettings);
    }

    private void setAnimations() {
        viewLines.setAnimation(AppConfig.topAnimation);
        greetings.setAnimation(AppConfig.middleAnimation);
        userName.setAnimation(AppConfig.middleAnimation);
        mainLayout.setAnimation(AppConfig.bottomAnimation);
    }
}