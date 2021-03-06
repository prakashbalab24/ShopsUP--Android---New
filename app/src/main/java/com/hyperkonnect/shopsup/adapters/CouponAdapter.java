package com.hyperkonnect.shopsup.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hyperkonnect.shopsup.modules.coupons.Activity_CouponDetails;
import com.hyperkonnect.shopsup.R;
import com.hyperkonnect.shopsup.model.CouponModel;

import java.util.List;

/**
 * Created by prakash-bala on 30/1/17.
 */

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.MyViewHolder> {

    private Context mContext;
    private List<CouponModel> couponModelList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleShots;
        public ImageView thumbnail;
        public CardView cardView;

        public MyViewHolder(View view) {
            super(view);
            titleShots = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.image);
            cardView = (CardView)view.findViewById(R.id.card_view);
        }
    }


    public CouponAdapter(Context mContext, List<CouponModel> couponModelList) {
        this.mContext = mContext;
        this.couponModelList = couponModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.coupon_card, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        CouponModel couponModel = couponModelList.get(position);
        holder.titleShots.setText(couponModel.getCouponShots());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, Activity_CouponDetails.class);
                mContext.startActivity(intent);
            }
        });
        //TODO
        //Image view should use dynamic images from server
        // loading album cover using Glide library
        //.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
         return couponModelList.size();
    }
}