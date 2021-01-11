package org.kashisol.bottomoptiontraylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.kashisol.bottomoptiontraylib.ShowOptions;
import org.kashisol.bottomoptiontraylib.util.TrayOptionsList;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        TrayOptionsList trayOptionsList = new TrayOptionsList();

        trayOptionsList.add(new TrayOptionsList.Option("aaa", null, 1));
        trayOptionsList.add(new TrayOptionsList.Option("bbb", null, 2));
        trayOptionsList.add(new TrayOptionsList.Option("ccc", null, 1));

        final ShowOptions s = ShowOptions.getNewInstance(trayOptionsList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s.openTray(getApplicationContext());
            }
        });

        s.setOnTrayOptionSelectedListener(new ShowOptions.OnTrayOptionSelectedListener() {
            @Override
            protected void onTrayOptionSelected(int optionId, String optionText, TrayOptionsList.Option option) {
                System.out.println("()()()() " + optionId + " :: " + optionText + " :: " + optionId);
            }
        });
    }
}