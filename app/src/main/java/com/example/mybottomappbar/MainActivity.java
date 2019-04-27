package com.example.mybottomappbar;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static CoordinatorLayout coordinator_layout;
    public static BottomAppBar bar;
    public static FloatingActionButton fab;
    private RecyclerView rv;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        setUpRecyclerView();


    }

    private void tanimla() {
        coordinator_layout = findViewById(R.id.coordinator_layout);
        bar = findViewById(R.id.bottom_app_bar);
        fab = findViewById(R.id.fab);
        rv = findViewById(R.id.rv);

        setSupportActionBar(bar);

        clickProccess();
    }

    private void clickProccess() {
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

    private void setUpRecyclerView() {
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ArrayList<String> countries = new ArrayList<>();

        countries.add("TURKEY");
        countries.add("USA");
        countries.add("CANADA");
        countries.add("JAPAN");
        countries.add("ITALY");
        countries.add("FRANCE");
        countries.add("GERMANY");
        countries.add("FINLAND");
        countries.add("RUSSIA");
        countries.add("GREECE");
        countries.add("ARGENTINA");
        countries.add("BRAZIL");
        countries.add("INDIA");
        countries.add("CHINA");

        adapter = new MyAdapter(countries, MainActivity.this, coordinator_layout);
        rv.setAdapter(adapter);
    }

    public static void showSnackbar(CharSequence text) {
        Snackbar.make(coordinator_layout, text, Snackbar.LENGTH_SHORT)
                .setAnchorView(fab.getVisibility() == View.VISIBLE ? fab : bar)
                .show(); // floating action button'un üstünde gösteriyor.
    }

}
