package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.FolioDetailsFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.GeneralInformationFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.RoomChargesFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.SharerInformationFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
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
        setupViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(GeneralInformationFragment.newInstance(), "Genral Information");
        adapter.addFragment(RoomChargesFragment.newInstance(), "Room Charges");
        adapter.addFragment(FolioDetailsFragment.newInstance(), "Folio Details");
        adapter.addFragment(SharerInformationFragment.newInstance(), "Sharer Information");
        viewPager.setAdapter(adapter);
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