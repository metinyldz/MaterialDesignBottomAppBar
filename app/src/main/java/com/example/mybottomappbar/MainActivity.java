package com.example.mybottomappbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private CoordinatorLayout coordinator_layout;
    private BottomAppBar bar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Clicked Navigation Menu", Toast.LENGTH_SHORT).show();
                showSnackbar("Clicked menu");
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Clicked Fab", Toast.LENGTH_SHORT).show();
                showSnackbar("Clicked fab");
            }
        });


    }

    private void tanimla() {
        coordinator_layout = findViewById(R.id.coordinator_layout);
        bar = findViewById(R.id.bottom_app_bar);
        fab = findViewById(R.id.fab);

        setSupportActionBar(bar);


    }

    private void showSnackbar(CharSequence text) {
        Snackbar.make(coordinator_layout, text, Snackbar.LENGTH_SHORT)
                .setAnchorView(fab.getVisibility() == View.VISIBLE ? fab : bar)
                .show();
    }
}
