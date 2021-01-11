package org.kashisol.bottomoptiontraylib;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import org.kashisol.bottomoptiontraylib.util.TrayOptionsList;


public class ShowOptions {

    protected static ShowOptions currentInstance;
    protected static TrayOptionsList currentOptionsList;
    protected static OnTrayOptionSelectedListener onTrayOptionSelectedListener;

    public static Drawable getCurrentDrawable() {
        return currentDrawable;
    }

    protected static Drawable currentDrawable;

    private int rowsToShow = 4;

    private ShowOptions() {}

    public static ShowOptions getNewInstance(TrayOptionsList options) {
        ShowOptions.currentInstance = new ShowOptions();
        ShowOptions.currentOptionsList = options;
        ShowOptions.currentInstance.rowsToShow = 4;
        ShowOptions.currentDrawable = null;
        return ShowOptions.currentInstance;
    }

    public void setRowsToShow(int rowsToShow) {
        ShowOptions.currentInstance.rowsToShow = rowsToShow;
    }

    public void setDrawableForSelectableOption(Drawable drawable) {
        ShowOptions.currentDrawable = drawable;
    }

    public void setDrawableForButton(Context context, int drawable) {
        ShowOptions.currentDrawable = ContextCompat.getDrawable(context, drawable);
    }



    public void setOnTrayOptionSelectedListener(OnTrayOptionSelectedListener onTrayOptionSelectedListener) {
        ShowOptions.onTrayOptionSelectedListener = onTrayOptionSelectedListener;
    }

    public void openTray(Context context) {
        context.startActivity(new Intent(context, BottomOptionChooser.class)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    public static abstract class OnTrayOptionSelectedListener {
        protected abstract void onTrayOptionSelected(
                int optionId, String optionText, TrayOptionsList.Option option
        );
    }
}
