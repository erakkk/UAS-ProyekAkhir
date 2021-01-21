package com.example.dashboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private GradientDrawable mGradientDrawable;
    private ArrayList<Product> mProductData;
    private Context mContext;


    ProductAdapter(Context context, ArrayList<Product> sportsData) {
        this.mProductData = sportsData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.avanza);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product currentProduct = mProductData.get(position);

        //Bind the data to the views
        holder.bindTo(currentProduct);
    }


    @Override
    public int getItemCount() {
        return mProductData.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private TextView mTitleText;
        private TextView mInfoText;
        private TextView mDescriptionText;
        private ImageView mProductImage;
        private Context mContext;
        //private Product mCurrentProduct;
        private GradientDrawable mGradientDrawable;

        ProductViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.product);
            mInfoText = (TextView)itemView.findViewById(R.id.price);
            mDescriptionText = (TextView)itemView.findViewById(R.id.description);
            mProductImage = (ImageView)itemView.findViewById(R.id.product_image);


            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Product currentProduct){
            //Populate the textviews with data
            mTitleText.setText(currentProduct.getTitle());
            mInfoText.setText(currentProduct.getInfo());
            mDescriptionText.setText(currentProduct.getDescription());

            //Get the current sport
          //  mCurrentProduct = currentProduct;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentProduct.
                    getImageResource()).placeholder(mGradientDrawable).into(mProductImage);
        }

        @Override
        public void onClick(View view) {
        }


    }


}

