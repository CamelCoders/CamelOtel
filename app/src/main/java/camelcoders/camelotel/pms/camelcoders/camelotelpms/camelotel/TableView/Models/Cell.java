package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TableView.Models;

import androidx.annotation.Nullable;

public class Cell {
    @Nullable
    private Object mData;

    public Cell(@Nullable Object data) {
        this.mData = data;
    }

    @Nullable
    public Object getData() {
        return mData;
    }
}