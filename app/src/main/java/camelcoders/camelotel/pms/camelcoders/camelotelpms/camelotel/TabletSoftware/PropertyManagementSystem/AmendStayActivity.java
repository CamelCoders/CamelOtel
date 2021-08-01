package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.PropertyManagementSystem;

import android.app.Dialog;
import android.content.Context;

import camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.Utilities.AppConfig;

public class AmendStayActivity {
    Dialog dialog;
    private Context ctx;

    public AmendStayActivity(int layout, Context ctx) {
        ctx = ctx;
        dialog = AppConfig.showFullScreenCustomDialog(layout, ctx);
        showDialog(dialog);
    }

    public void showDialog(Dialog dialog) {
        dialog.show();
    }

}