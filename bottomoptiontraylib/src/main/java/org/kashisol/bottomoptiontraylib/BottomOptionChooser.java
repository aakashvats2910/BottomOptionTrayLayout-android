package org.kashisol.bottomoptiontraylib;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.kashisol.bottomoptiontraylib.adapters.ClickableOptionAdapter;
import org.kashisol.bottomoptiontraylib.anim.ViewAnimation;
import org.kashisol.bottomoptiontraylib.util.TrayOptionsList;

import java.util.ArrayList;

public class BottomOptionChooser extends Activity implements ClickableOptionAdapter.TrayOptionWatcher {

    private static ArrayList<TrayOptionsList.Option> optionArrayList;

    private RecyclerView choose_option_recycler_view;
    private View background_view;
    private ScrollView scroll_option_chooser;

    private final String SHADY_BG = "#20000000";
    private final String FULL_TRANSPARENT_BG = "#00000000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_bottom_option_chooser);

        choose_option_recycler_view = findViewById(R.id.choose_option_recycler_view);
        background_view = findViewById(R.id.background_view);
        scroll_option_chooser = findViewById(R.id.scroll_option_chooser);

        ViewAnimation.init(scroll_option_chooser);
        ViewAnimation.showIn(scroll_option_chooser);

        background_view.setBackgroundColor(Color.parseColor(SHADY_BG));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        choose_option_recycler_view.setLayoutManager(linearLayoutManager);

        ClickableOptionAdapter adapter = new ClickableOptionAdapter(getApplicationContext(),
                ShowOptions.currentOptionsList.getOptionsList(), this);
        choose_option_recycler_view.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        background_view.setBackgroundColor(Color.parseColor(FULL_TRANSPARENT_BG));
        ViewAnimation.showOut(BottomOptionChooser.this, scroll_option_chooser);
        super.onBackPressed();
    }

    @Override
    public void onTrayOptionSelectedListener(int optionId, String optionText, TrayOptionsList.Option option) {
        ViewAnimation.showOut(BottomOptionChooser.this, scroll_option_chooser);
        if (ShowOptions.onTrayOptionSelectedListener != null)
            ShowOptions.onTrayOptionSelectedListener.onTrayOptionSelected(optionId, optionText, option);
        else // TODO show exception;
        ;
    }

}