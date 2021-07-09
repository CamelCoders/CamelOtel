package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.CommonActivities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import soup.neumorphism.NeumorphTextView;

import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig.bottomAnimation;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig.middleAnimation;
import static camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig.topAnimation;


public class SplashActivity extends AppCompatActivity {
    private static int SPLASH = 4000;
    View first, second, third, fourth, fifth, sixth;
    NeumorphTextView appName, appTitle;
    ImageView logo;
    boolean isPortrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        isPortrait = AppConfig.setOrientations(SplashActivity.this);

        AppConfig.setStatusBarColor(SplashActivity.this, R.color.dark_color);

        if (isPortrait) {
            initViews();
            AppConfig.initAnimation(SplashActivity.this);
            setAnimations();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppConfig.jumpTo(SplashActivity.this, LoginActivity.class, "slide");
                    AppConfig.showwCustomToast(SplashActivity.this,"Welcome",""+AppConfig.getGreetings());
                }
            }, SPLASH);
        } else {
            initViews();
            AppConfig.initAnimation(SplashActivity.this);
            setAnimations();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppConfig.jumpTo(SplashActivity.this, LoginActivity.class, "slide");
                    AppConfig.showwCustomToast(SplashActivity.this,"Welcome",""+AppConfig.getGreetings());
                }
            }, SPLASH);
        }

    }

    private void setAnimations() {
        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        fourth.setAnimation(topAnimation);
        fifth.setAnimation(topAnimation);
        sixth.setAnimation(topAnimation);
        appName.setAnimation(middleAnimation);
        appTitle.setAnimation(bottomAnimation);
        logo.setAnimation(middleAnimation);
    }

    private void initViews() {
        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        sixth = findViewById(R.id.sixth_line);
        appName = findViewById(R.id.appName);
        appTitle = findViewById(R.id.appTitle);
        logo = findViewById(R.id.img_logo);
    }
}