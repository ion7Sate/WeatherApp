package com.example.iweather.Activitis;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iweather.Adapters.HourlyAdapter;
import com.example.iweather.Domains.Hourly;
import com.example.iweather.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterHourly ;
private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.dateTime);
        String currentDateTimeString = new SimpleDateFormat("EEE MMM d || hh:mm a").format(new Date());

        textView.setText(currentDateTimeString);


        recyclerView = findViewById(R.id.recyclerView);
        initRecyclerview();

        setVariable();
    }

    private void setVariable() {
        TextView next7dayBtn = findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,FutureActivity2.class)) );
    }

    private void initRecyclerview(){
        ArrayList<Hourly> items = new ArrayList<>();

        items.add(new Hourly("8:00",19,"cloudy"));
        items.add(new Hourly("9:00",25,"sunny"));
        items.add(new Hourly("10:00",23,"wind"));
        items.add(new Hourly("11:00",21,"rainy"));
        items.add(new Hourly("12:00",20,"storm"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this ,LinearLayoutManager.HORIZONTAL,false));

        adapterHourly = new HourlyAdapter(items);

        recyclerView.setAdapter(adapterHourly);
     }
}