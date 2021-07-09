package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities;

import com.nightonke.boommenu.BoomButtons.HamButton;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.R;


public class BuilderManager {

    private static int[] imageResources = new int[]{
            R.drawable.logo_round,
            R.drawable.logo_round,
            R.drawable.logo_round,
            R.drawable.logo_round,
            R.drawable.logo_round,
            R.drawable.logo_round

    };

    private static int imageResourceIndex = 0;

    static int getImageResource() {
        if (imageResourceIndex >= imageResources.length) imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }


    public static HamButton.Builder getHamButtonBuilder() {
        return new HamButton.Builder()
                .normalImageRes(getImageResource())
                .normalTextRes(R.string.app_name)
                .subNormalTextRes(R.string.app_name);
    }



    private static BuilderManager ourInstance = new BuilderManager();

    public static BuilderManager getInstance() {
        return ourInstance;
    }

    private BuilderManager() {
    }
}
