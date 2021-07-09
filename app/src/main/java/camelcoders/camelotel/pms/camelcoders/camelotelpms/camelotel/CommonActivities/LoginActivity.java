package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.CommonActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.Reservation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.TabletDashboard;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {
    boolean isPortrait;
    View viewLines;
    ImageView logo;
    CardView edittext_card;
//    Button button;
    Reservation newReseravation = new Reservation();
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        isPortrait = AppConfig.setOrientations(LoginActivity.this);

        AppConfig.setStatusBarColor(LoginActivity.this, R.color.dark_color);

        if (isPortrait) {
            initViews();
            AppConfig.initAnimation(LoginActivity.this);
            setAnimations();
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    AppConfig.jumpTo(LoginActivity.this, DasboardPhone.class, "slide");
                }
            });
        } else {
            initViews();
            AppConfig.initAnimation(LoginActivity.this);
            setAnimations();
            binding.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppConfig.jumpTo(LoginActivity.this, TabletDashboard.class, "slide");
                    AppConfig.showwCustomToast(LoginActivity.this,"Login Successfully","");
                    //newReseravation.createReservation(LoginActivity.this);

                }
            });
        }
    }

    private void setAnimations() {
        viewLines.setAnimation(AppConfig.topAnimation);
        logo.setAnimation(AppConfig.bottomAnimation);
        edittext_card.setAnimation(AppConfig.middleAnimation);
    }

    private void initViews() {
        viewLines = findViewById(R.id.viewLines);
        logo = findViewById(R.id.logo);
        edittext_card = findViewById(R.id.edittext_card);
//        button = findViewById(R.id.button);

    }
}