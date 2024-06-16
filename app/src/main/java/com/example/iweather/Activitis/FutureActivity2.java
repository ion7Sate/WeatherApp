package com.example.iweather.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iweather.Adapters.FutureAdapter;
import com.example.iweather.Adapters.HourlyAdapter;
import com.example.iweather.Domains.FutureDomain;
import com.example.iweather.R;

import java.util.ArrayList;

public class FutureActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapterTomorrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_future2);

        recyclerView = findViewById(R.id.recyclerView2);
        initRecyclerView();
        setVariable();

    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v ->  startActivity(new Intent(FutureActivity2.this,MainActivity.class)));

    }

    private void initRecyclerView() {
        ArrayList<FutureDomain> items = new ArrayList<>();

        items.add(new FutureDomain("Mon", "storm", "Storm", 25, 16));
        items.add(new FutureDomain("Tue", "cloudy", "Partly cloudy", 23, 15));
        items.add(new FutureDomain("Wed", "rainy", "Rainy", 22, 17));
        items.add(new FutureDomain("Thu", "windy", "Windy", 21, 16));
        items.add(new FutureDomain("Fri", "cloudy_sunny", "Cloudy Sunny", 20, 14));
        items.add(new FutureDomain("Sat", "sunny", "Sunny", 19, 13));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapterTomorrow = new FutureAdapter(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}