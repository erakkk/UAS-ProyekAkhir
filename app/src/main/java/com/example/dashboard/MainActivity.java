package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void daftarmobil(View view) {
        Intent daftarmobil = new Intent(MainActivity.this, DaftarMobil.class);
        startActivity(daftarmobil);
    }

    public void syaratdanketentuan(View view) {
        Intent daftarmobil = new Intent(MainActivity.this, SyaratDanKetentuan.class);
        startActivity(daftarmobil);
    }
}