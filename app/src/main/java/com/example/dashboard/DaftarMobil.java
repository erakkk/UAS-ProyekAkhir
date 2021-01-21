package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class DaftarMobil extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ArrayList<Product> mProductsData;
    private ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_mobil);
        getSupportActionBar().hide();


        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));

//

        //Initialize the ArrayList that will contain the data
        mProductsData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new ProductAdapter(this, mProductsData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] productList = getResources().getStringArray(R.array.nama_produk);
        String[] productInfo = getResources().getStringArray(R.array.harga_produk);
        String[] productDesk = getResources().getStringArray(R.array.deskripsi_produk);
        TypedArray productImageResources = getResources().obtainTypedArray(R.array.gambar_produk);

        //Clear the existing data (to avoid duplication)
        mProductsData.clear();


        //Create the ArrayList of Sports objects with the titles, images
        // and information about each sport
        for(int i=0; i<productList.length; i++){
            mProductsData.add(new Product(productList[i],productInfo[i],productDesk[i], productImageResources.getResourceId(i, 0)));
        }

        //Recycle the typed array
        productImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

    public void sewa(View view) {
        Intent daftarmobil = new Intent(DaftarMobil.this, MainActivity.class);
        startActivity(daftarmobil);
        Toast.makeText(DaftarMobil.this, "Terimakasih telah memesan mobil", Toast.LENGTH_SHORT).show();
    }
}