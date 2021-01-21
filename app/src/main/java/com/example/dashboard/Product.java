package com.example.dashboard;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

public class Product {
    private final String title;
    private final String info;
    private final String description;
    private final int imageResource;
//
//    static final String TITLE_KEY = "Title";
//    static final String IMAGE_KEY = "Image Resource";
//    static final String PRICE_KEY = "Price";
//    static final String DESCRIPTION_KEY = "Description";

    Product( String title, String info, String description, int imageResource) {
        this.title = title;
        this.info = info;
        this.description = description;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }

    String getDescription() {
        return description;
    }

    int getImageResource() {
        return imageResource;
    }



//    static Intent starter(Context context, String title, String price, String description, @DrawableRes int imageResId) {
//
//
////        Bundle bundle = new Bundle();
////        bundle.putString("KEY_1", title);
////        bundle.putString("KEY_2", price);
////        bundle.putString("KEY_3", description);
////        bundle.putInt("KEY_4", imageResId);
////        Intent detailIntent = new Intent(context, DetailActivity.class);
////        detailIntent.putExtras(bundle);
////        return detailIntent;
//
//        Intent detailIntent = new Intent(context, DetailActivity.class);
//        detailIntent.putExtra(TITLE_KEY, title);
//        detailIntent.putExtra(PRICE_KEY, price);
//        detailIntent.putExtra(DESCRIPTION_KEY, description);
//        detailIntent.putExtra(IMAGE_KEY, imageResId);
//        return detailIntent;
//    }

}
