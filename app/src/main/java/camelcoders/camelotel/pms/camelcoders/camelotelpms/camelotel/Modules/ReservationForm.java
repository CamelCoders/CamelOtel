package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Modules;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;
import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;

public class ReservationForm {
    //Billing Dialog Variables
    public TextInputEditText billBookTO, RatesSelected, billPaymentMode,
            paymentMode, billReleaseDate, billTerm, taxExtmotionIdNumber;
    //Multiple Booking Form

    LinearLayout layoutList;

    Button Addrooms;
    public RecyclerView multipleBookingList, multipleBoooking;
    public Dialog reservationFormDilaog;
    //Hiding Unhiding Variables
    public TextView rate, taxPercentage, amount, taxAmount;
    public LinearLayout guestInformationButton, stayInformationButton,
            otherInformationButton, billingInformationButton, multipleBookingInformationButton;
    public TextView guestInformationButtonText, stayInformationButtonText,
            otherInformationButtonText, billingInformationButtonText, multipleBookingInformationButtonText;
    //Hiding Unhiding Variables
    public LinearLayout formGuestInformation, formStayInformation,
            formOtherInformation, formBillingInformation, formGroupBookingInformation;
    //Guest Information Form
    public RecyclerView guestRecyler;
    public TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
            guestLastName, guestPincode, guestAddress, guestFullAddress,
            guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
    //Stay Information Form
    public TextInputEditText stayRooms, stayRoomType, stayRoomSelect, stayRateType,
            stayArrivalDate, stayArrivalTime,
            stayRatePlan, staySubStayPlan,
            stayArrivalNight, stayDepartureDate, stayDepartureTime,
            stayAdult, stayReserType, stayChild, stayGuestStatus;
    public static String stayroomtype;
    public ProgressBar progressBar;
    public RecyclerView selectItemLayout;
    //Other Information Form
    public Button checkIn, reservationBook;
    public RecyclerView otherItemList;
    //Stay Information Form
    public TextInputEditText resCompanyName, resBusinessSource, resMarket;
    //Travel Agent Info
    public TextInputEditText resTravelAgentName, resSalesPerson, resComPlan, resValue, resVocNo;
    //Discount Info
    public TextInputEditText resDiscountType, resDiscountRule;
    //Payment Info
    public TextInputEditText resPaymentType, currencytype, resDiscountSpinner, resVoucherNumber;
    public Button otherButton, travelAgentButton, discountButton, paymentButton;
    //Other Information Form
    public LinearLayout otherLayout, travelAgentLayout, discountLayout, paymentLayout;
    //Billing Dialog Variables
    public AppCompatCheckBox billTaxExeID, taxinclusive, billReleaseCheck;
    public RecyclerView billlingList;
    //Multiple Booking

    /***
     //Multiple Booking Form
     public static RecyclerView multipleBookingList, multipleBoooking;
     public static Dialog reservationFormDilaog;
     public static TextView rate, taxPercentage, amount, taxAmount;
     //Hiding Unhiding Variables
     public static LinearLayout guestInformationButton, stayInformationButton,
     otherInformationButton, billingInformationButton, multipleBookingInformationButton;
     public static TextView guestInformationButtonText, stayInformationButtonText,
     otherInformationButtonText, billingInformationButtonText, multipleBookingInformationButtonText;
     //Hiding Unhiding Variables
     public static LinearLayout formGuestInformation, formStayInformation,
     formOtherInformation, formBillingInformation, formGroupBookingInformation;
     //Guest Information Form
     public static RecyclerView guestRecyler;
     public static TextInputEditText guestSalutation, guestFirstName, guestMiddleName,
     guestLastName, guestPincode, guestAddress, guestFullAddress,
     guestCity, guestCountry, guestPhone, guestEmail, guestIdType, guestIdNumber, guestState;
     //Stay Information Form
     public static TextInputEditText stayRooms, stayRoomType, stayRoomSelect, stayRateType,
     stayArrivalDate, stayArrivalTime,
     stayRatePlan, staySubStayPlan,
     stayArrivalNight, stayDepartureDate, stayDepartureTime,
     stayAdult, stayReserType, stayChild, stayGuestStatus;
     public static ProgressBar progressBar;
     public static RecyclerView selectItemLayout;
     //Other Information Form
     public static Button checkIn, reservationBook;
     public static RecyclerView otherItemList;
     //Stay Information Form
     public static TextInputEditText resCompanyName, resBusinessSource, resMarket;
     //Travel Agent Info
     public static TextInputEditText resTravelAgentName, resSalesPerson, resComPlan, resValue, resVocNo;
     //Discount Info
     public static TextInputEditText resDiscountType, resDiscountRule;
     //Payment Info
     public static TextInputEditText resPaymentType, currencytype, resDiscountSpinner, resVoucherNumber;
     public static Button otherButton, travelAgentButton, discountButton, paymentButton;
     //Other Information Form
     public static LinearLayout otherLayout, travelAgentLayout, discountLayout, paymentLayout;
     //Billing Dialog Variables
     public static AppCompatCheckBox billTaxExeID, taxinclusive, billReleaseCheck;
     public static RecyclerView billlingList;
     //Billing Dialog Variables
     public static TextInputEditText billBookTO, RatesSelected, billPaymentMode,
     paymentMode, billReleaseDate, billTerm, taxExtmotionIdNumber;
     //Multiple Booking

     */

    public void mainDialog(Activity activity) {
        reservationFormDilaog = AppConfig.showFullScreenCustomDialog(R.layout.form_reservation_dialog, activity);
        iniGuestFormVariables(reservationFormDilaog);
        initLayoutVariables(reservationFormDilaog);
        initStayInformation(reservationFormDilaog);
        initOtherInformation(reservationFormDilaog);
        initBillingInformationForm(reservationFormDilaog);
        initMultipleBookingForm(reservationFormDilaog);

        setActiveForm("guestInformationButton", activity);

        reservationFormDilaog.show();
    }

    private void initLayoutVariables(Dialog dialog) {
        rate = dialog.findViewById(R.id.rate);

        taxPercentage = dialog.findViewById(R.id.taxper);
        amount = dialog.findViewById(R.id.amount);
        taxAmount = dialog.findViewById(R.id.taxAmount);


        progressBar = dialog.findViewById(R.id.lyt_progress);
        guestInformationButton = dialog.findViewById(R.id.guestInformationButton);
        stayInformationButton = dialog.findViewById(R.id.stayInformationButton);
        otherInformationButton = dialog.findViewById(R.id.otherInformationButton);
        billingInformationButton = dialog.findViewById(R.id.billingInformationButton);
        multipleBookingInformationButton = dialog.findViewById(R.id.multipleBookingInformationButton);

        guestInformationButtonText = dialog.findViewById(R.id.guestInformationButtonText);
        stayInformationButtonText = dialog.findViewById(R.id.stayInformationButtonText);
        otherInformationButtonText = dialog.findViewById(R.id.otherInformationButtonText);
        billingInformationButtonText = dialog.findViewById(R.id.billingInformationButtonText);
        multipleBookingInformationButtonText = dialog.findViewById(R.id.multipleBookingInformationButtonText);

        formGuestInformation = dialog.findViewById(R.id.formGuestInformation);
        formStayInformation = dialog.findViewById(R.id.formStayInformation);
        formOtherInformation = dialog.findViewById(R.id.formOtherInformation);
        formBillingInformation = dialog.findViewById(R.id.formBillingInformation);
        formGroupBookingInformation = dialog.findViewById(R.id.formGroupBookingInformation);
    }

    public void setActiveForm(String activeForm, Context context) {
        if (activeForm.equals("guestInformationButton")) {
            formGuestInformation.setVisibility(View.VISIBLE);
            formStayInformation.setVisibility(View.GONE);
            formOtherInformation.setVisibility(View.GONE);
            formBillingInformation.setVisibility(View.GONE);
            formGroupBookingInformation.setVisibility(View.GONE);
            guestInformationButton.setBackgroundColor(context.getResources().getColor(R.color.dark_color));
            stayInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            otherInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            billingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            multipleBookingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            guestInformationButtonText.setTextColor(context.getResources().getColor(R.color.light_color));
            stayInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            otherInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            billingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            multipleBookingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
        } else if (activeForm.equals("stayInformationButton")) {
            formGuestInformation.setVisibility(View.GONE);
            formStayInformation.setVisibility(View.VISIBLE);
            formOtherInformation.setVisibility(View.GONE);
            formBillingInformation.setVisibility(View.GONE);
            formGroupBookingInformation.setVisibility(View.GONE);
            guestInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            stayInformationButton.setBackgroundColor(context.getResources().getColor(R.color.dark_color));
            otherInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            billingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            multipleBookingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            guestInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            stayInformationButtonText.setTextColor(context.getResources().getColor(R.color.light_color));
            otherInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            billingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            multipleBookingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
        } else if (activeForm.equals("otherInformationButton")) {
            formGuestInformation.setVisibility(View.GONE);
            formStayInformation.setVisibility(View.GONE);
            formOtherInformation.setVisibility(View.VISIBLE);
            formBillingInformation.setVisibility(View.GONE);
            formGroupBookingInformation.setVisibility(View.GONE);
            guestInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            stayInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            otherInformationButton.setBackgroundColor(context.getResources().getColor(R.color.dark_color));
            billingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            multipleBookingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            guestInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            stayInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            otherInformationButtonText.setTextColor(context.getResources().getColor(R.color.light_color));
            billingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            multipleBookingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
        } else if (activeForm.equals("billingInformationButton")) {
            formGuestInformation.setVisibility(View.GONE);
            formStayInformation.setVisibility(View.GONE);
            formOtherInformation.setVisibility(View.GONE);
            formBillingInformation.setVisibility(View.VISIBLE);
            formGroupBookingInformation.setVisibility(View.GONE);
            guestInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            stayInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            otherInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            billingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.dark_color));
            multipleBookingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            guestInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            stayInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            otherInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            billingInformationButtonText.setTextColor(context.getResources().getColor(R.color.light_color));
            multipleBookingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
        } else if (activeForm.equals("multipleBookingInformationButton")) {
            formGuestInformation.setVisibility(View.GONE);
            formStayInformation.setVisibility(View.GONE);
            formOtherInformation.setVisibility(View.GONE);
            formBillingInformation.setVisibility(View.GONE);
            formGroupBookingInformation.setVisibility(View.VISIBLE);
            guestInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            stayInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            otherInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            billingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.light_color));
            multipleBookingInformationButton.setBackgroundColor(context.getResources().getColor(R.color.dark_color));
            guestInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            stayInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            otherInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            billingInformationButtonText.setTextColor(context.getResources().getColor(R.color.dark_color));
            multipleBookingInformationButtonText.setTextColor(context.getResources().getColor(R.color.light_color));
        }
    }

    private void iniGuestFormVariables(Dialog dialog) {

        guestRecyler = dialog.findViewById(R.id.guestList);
        guestSalutation = dialog.findViewById(R.id.guestSalutation);
        guestFirstName = dialog.findViewById(R.id.guestFirstName);
        guestMiddleName = dialog.findViewById(R.id.guestMiddleName);
        guestLastName = dialog.findViewById(R.id.guestLastName);
        guestPincode = dialog.findViewById(R.id.guestPincode);
        guestState = dialog.findViewById(R.id.guestState);
        guestCity = dialog.findViewById(R.id.guestCity);
        guestFullAddress = dialog.findViewById(R.id.guestfullAdrress);
        guestAddress = dialog.findViewById(R.id.guestState);
        guestEmail = dialog.findViewById(R.id.guestEmail);
        guestCountry = dialog.findViewById(R.id.guestCountry);
        guestPhone = dialog.findViewById(R.id.guestPhoneNumber);
        guestIdType = dialog.findViewById(R.id.guestIdType);
        guestIdNumber = dialog.findViewById(R.id.guestIdNumber);


    }

    private void initStayInformation(Dialog dialog) {
        Addrooms=dialog.findViewById(R.id.button_add);
        layoutList=dialog.findViewById(R.id.layout_list);


        selectItemLayout = dialog.findViewById(R.id.selectItemLayout);

         stayRatePlan = (dialog.findViewById(R.id.stayRatePlan));
        // stayRooms = (dialog.findViewById(R.id.stayRooms));
         stayRoomType = (dialog.findViewById(R.id.stayRoomType));
         //stayRoomSelect = (dialog.findViewById(R.id.stayRoomSelect));

        staySubStayPlan = (dialog.findViewById(R.id.subRatePlan));
        stayAdult = (dialog.findViewById(R.id.stayAdult));
        stayChild = (dialog.findViewById(R.id.stayChild));

        stayRateType = (dialog.findViewById(R.id.stayRateType));
        stayArrivalDate = (dialog.findViewById(R.id.stayArrivalDate));
        stayArrivalTime = (dialog.findViewById(R.id.stayArrivalTime));
        stayArrivalNight = (dialog.findViewById(R.id.stayArrivalNight));
        stayDepartureDate = (dialog.findViewById(R.id.stayDepartureDate));
        stayDepartureTime = (dialog.findViewById(R.id.stayDepartureTime));
         stayReserType = (dialog.findViewById(R.id.stayReserType));
       //  stayGuestStatus = (dialog.findViewById(R.id.stayGuestStatus));

    }

    private void initOtherInformation(Dialog dialog) {
        otherButton = dialog.findViewById(R.id.otherButton);

        travelAgentButton = dialog.findViewById(R.id.travelAgentButton);

        discountButton = dialog.findViewById(R.id.discountButton);

        paymentButton = dialog.findViewById(R.id.paymentButton);


        otherLayout = dialog.findViewById(R.id.otherLayout);

        travelAgentLayout = dialog.findViewById(R.id.travelAgentLayout);

        discountLayout = dialog.findViewById(R.id.discountLayout);

        paymentLayout = dialog.findViewById(R.id.paymentLayout);


        otherItemList = dialog.findViewById(R.id.otherItemList);

        resCompanyName = (dialog.findViewById(R.id.resCompanyName));
        resBusinessSource = (dialog.findViewById(R.id.resBusinessSource));
        resMarket = (dialog.findViewById(R.id.resMarket));
        resTravelAgentName = (dialog.findViewById(R.id.resTravelAgentName));
        resSalesPerson = (dialog.findViewById(R.id.resSalesPerson));
        resComPlan = (dialog.findViewById(R.id.resComPlan));
        resValue = (dialog.findViewById(R.id.resValue));
        resVocNo = (dialog.findViewById(R.id.resVocNo));
        resDiscountType = (dialog.findViewById(R.id.resDiscountType));
        resDiscountRule = (dialog.findViewById(R.id.resDiscountRule));
        resPaymentType = (dialog.findViewById(R.id.resPaymentType));
        currencytype = (dialog.findViewById(R.id.currencyOther));
        resDiscountSpinner = (dialog.findViewById(R.id.resDiscountSpinner));
        resVoucherNumber = (dialog.findViewById(R.id.resVoucherNumber));


        checkIn = dialog.findViewById(R.id.checkIn);
        reservationBook = dialog.findViewById(R.id.reservationBook);
    }

    private void initBillingInformationForm(Dialog dialog) {
        billlingList = dialog.findViewById(R.id.billlingList);
        RatesSelected = dialog.findViewById(R.id.RatesSelected);
        billBookTO = dialog.findViewById(R.id.billBookTO);
//
        billPaymentMode = dialog.findViewById(R.id.billPaymentMode);
        paymentMode = dialog.findViewById(R.id.paymentMode);
        billReleaseCheck = dialog.findViewById(R.id.billReleaseCheck);
        billReleaseDate = dialog.findViewById(R.id.billReleaseDate);
        billTerm = dialog.findViewById(R.id.billTerm);
    }

    private void initMultipleBookingForm(Dialog dialog) {
        multipleBoooking = dialog.findViewById(R.id.multipleBooking);
        multipleBookingList = dialog.findViewById(R.id.multipleBookingList);
    }


}


