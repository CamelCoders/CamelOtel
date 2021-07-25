package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.CommonActivities.LoginActivity;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.CheckIn;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
 import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.FrontOffice;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.ActivityLoginBinding;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.ActivityViewReservationBinding;

public class ViewReservationActivity extends AppCompatActivity {
    ActivityViewReservationBinding binding;
    boolean isPortrait;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        isPortrait = AppConfig.setOrientations(ViewReservationActivity.this);
        AppConfig.setStatusBarColor(ViewReservationActivity.this, R.color.dark_color);
        initComponent();
    }
    private void initComponent() {
         binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}