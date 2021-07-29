package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Adapter.StayInformationAdapter;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Booking;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.BookingApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.Folio.Folio;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformation;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.BookingDetails.StayInformation.StayInformationApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.Guest;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.GuestDetails.GuestApiInterface;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.DbConfig.Service.ApiClient;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules.ReservationForm;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.AuditTrailFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.FolioDetailsFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.GeneralInformationFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.RemarksFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.RoomChargesFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem.Fragments.SharerInformationFragment;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.databinding.ActivityViewReservationBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewReservationActivity extends AppCompatActivity {
    public static String guestId, bookingId, totalAmount, folioBookingId, creditdebit;
    public StayInformationAdapter.OnItemClickListener onItemClick;
    public LinearLayout guestInformationButton, stayInformationButton,
            folioInformationButton, billingInformationButton, multipleStayInformationInformationButton;
    public LinearLayout formGuestInformation, formGuestLayout, formFolioInformation, folioLayout;
    public static  List<Guest> guestList = new ArrayList<>();
    public static List<Booking> bookingList = new ArrayList<>();
    public static List<Folio> folioList = new ArrayList<>();
    public TextView rate, taxPercentage, amount, taxAmount;
    public ReservationForm reservationForm = new ReservationForm();
    public TextView guestInformationButtonText, stayInformationButtonText, folioInformationButtonText;
    public RecyclerView selectItemLayout;
    public TextInputEditText stayRooms, stayRoomType, stayRoomSelect, stayRateType,
            stayArrivalDate, stayArrivalTime,
            stayRatePlan, staySubStayPlan,
            stayArrivalNight, stayDepartureDate, stayDepartureTime,
            stayAdult, stayReserType, stayChild;
    ActivityViewReservationBinding binding;
    boolean isPortrait;
    static String stayInformationId, bookingID;
    Calendar cal = Calendar.getInstance();
   public static List<StayInformation> stayInformationList = new ArrayList<>();
  public static List<StayInformation> itemFilter = new ArrayList<>();
      StayInformationAdapter.OnItemClickListener mOnItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stayInformationId = getIntent().getStringExtra("stayId");
        bookingID = getIntent().getStringExtra("bookingId");
        guestId = getIntent().getStringExtra("guestId");

        binding = ActivityViewReservationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getIntent().getStringExtra("auditTrail")!=null) {
            focusOnView();
        }

        setGuestData();
        setStayInfo();
        isPortrait = AppConfig.setOrientations(ViewReservationActivity.this);
        binding.nestedContent.setFillViewport(true);
        AppConfig.setStatusBarColor(ViewReservationActivity.this, R.color.dark_color);
        initComponent();
    }

    private void initComponent() {
        setupViewPager(binding.viewPager);
        setupViewPager2(binding.viewPager2);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        binding.tabLayout2.setupWithViewPager(binding.viewPager2);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(GeneralInformationFragment.newInstance(), "General Information");
        adapter.addFragment(RoomChargesFragment.newInstance(), "Room Charges");
        adapter.addFragment(FolioDetailsFragment.newInstance(), "Folio Details");
        adapter.addFragment(SharerInformationFragment.newInstance(), "Sharer Information");
        viewPager.setAdapter(adapter);
    }

    private void setupViewPager2(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(AuditTrailFragment.newInstance(), "Audit Trail");
        adapter.addFragment(RemarksFragment.newInstance(), "Remarks");
        viewPager.setAdapter(adapter);
    }

    private void focusOnView() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                AppConfig.showwCustomToast(ViewReservationActivity.this,"","");
                binding.nestedContent.scrollTo(0, binding.viewPager2.getTop());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AppConfig.jumpTo(ViewReservationActivity.this, PmsTabDashboard.class, "fade");
    }

    public void setStayInfo() {
        StayInformationApiInterface apiInterface = ApiClient.getApiClient().create(StayInformationApiInterface.class);

        Call<List<StayInformation>> call = apiInterface.getStayInfomation();
        call.enqueue(new Callback<List<StayInformation>>() {
            @Override
            public void onResponse(Call<List<StayInformation>> call, Response<List<StayInformation>> response) {
                stayInformationList = response.body();

                for (int i = 0; i < stayInformationList.size(); i++) {

                    if (stayInformationList.get(i).getId().equals(stayInformationId)) {
                        binding.resDateValue.setText(stayInformationList.get(i).getDate());
                        binding.resArrivalValue.setText(stayInformationList.get(i).getCheckin() + " " + stayInformationList.get(i)
                                .getCheckintime());
                        binding.resDepartureValue.setText(stayInformationList.get(i).getCheckout() + " " + stayInformationList.get(i)
                                .getCheckouttime());
                        binding.resNightsValue.setText(stayInformationList.get(i).getNoofnight());
                        binding.resRateTypeValue.setText(stayInformationList.get(i).getRatePlan());

                    }

                }

//

            }

            @Override
            public void onFailure(Call<List<StayInformation>> call, Throwable t) {
            }
        });

    }

    public void setGuestData() {

        GuestApiInterface apiInterface = ApiClient.getApiClient().create(GuestApiInterface.class);

        Call<List<Guest>> callGuest = apiInterface.getGuest();
        callGuest.enqueue(new Callback<List<Guest>>() {
            @Override
            public void onResponse(Call<List<Guest>> call, Response<List<Guest>> response) {
                guestList = response.body();
                for (int i = 0; i < guestList.size(); i++) {

                    if (guestList.get(i).getGuestid().equals(guestId)) {
                        binding.viewReservationGuestName.setText(guestList.get(i).getSalutation() + " " + guestList.get(i).getFirstName() + " " + guestList.get(i).getMidName()
                                + " " + guestList.get(i).getLastName());
                        binding.guestNameText.setText(guestList.get(i).getSalutation() + " " + guestList.get(i).getFirstName() + " " + guestList.get(i).getMidName()
                                + " " + guestList.get(i).getLastName());
                        binding.guestAddress.setText(guestList.get(i).getAddress());
                        binding.guestPhone.setText("Phone - " + guestList.get(i).getNumber());
                        binding.guestEmail.setText(guestList.get(i).getEmail());
                        binding.guestIdentityTypeText.setText(guestList.get(i).getIdType());
                        binding.guestIdentityNumberText.setText(guestList.get(i).getIdNumber());


                    }

                }


            }

            @Override
            public void onFailure(Call<List<Guest>> call, Throwable t) {
                Log.e(":df", "" + t.getMessage());

            }
        });
    }

    public void setBookingInfo() {

        BookingApiInterface bookingApiInterface = ApiClient.getApiClient().create(BookingApiInterface.class);

        Call<List<Booking>> callGuest = bookingApiInterface.getBookings();
        callGuest.enqueue(new Callback<List<Booking>>() {
            @Override
            public void onResponse(Call<List<Booking>> call, Response<List<Booking>> response) {
                bookingList = response.body();
                for (int i = 0; i < guestList.size(); i++) {

                    if (bookingList.get(i).getGuestid().equals(bookingID)) {


                    }

                }


            }

            @Override
            public void onFailure(Call<List<Booking>> call, Throwable t) {
                Log.e(":df", "" + t.getMessage());

            }
        });
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