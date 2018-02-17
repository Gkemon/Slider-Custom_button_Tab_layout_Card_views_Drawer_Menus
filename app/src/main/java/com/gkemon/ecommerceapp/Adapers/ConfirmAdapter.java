package com.gkemon.ecommerceapp.Adapers;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gkemon.ecommerceapp.Listener.RecyclerItemClickListener;
import com.gkemon.ecommerceapp.Model.DeliveryItems;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;

/**
 * Created by Gk emon on 2/16/2018.
 */

public class ConfirmAdapter extends RecyclerView.Adapter<DeliveryViewHolder> {
    private RecyclerItemClickListener recyclerItemClickListener;

    public ArrayList<DeliveryItems> deliveryItems;

    public ConfirmAdapter(ArrayList<DeliveryItems> itemListPrice) {
        Log.d("GK", String.valueOf(itemListPrice.size()) + " is the size");
        deliveryItems = itemListPrice;
        Log.d("GK", String.valueOf(deliveryItems.size()) + " is the size");
    }

    @Override
    public DeliveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.confirm_items, parent, false);
        Log.d("GK", "in onCreateViewHolder");
        final DeliveryViewHolder holder = new DeliveryViewHolder(view);
        //CLICK LISTENER
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = holder.getAdapterPosition();
                if (adapterPos != RecyclerView.NO_POSITION) {
                    if (recyclerItemClickListener != null) {
                        recyclerItemClickListener.onItemClick(adapterPos, holder.itemView);
                    }
                }
            }
        });
        return holder;
    }

    public void setOnItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public void onBindViewHolder(final DeliveryViewHolder holder, int position) {


//        holder.price.setText(deliveryItems.get(position).getPrice());
//        holder.method.setText(deliveryItems.get(position).getMethod());
//        holder.coverImageView.setImageResource(deliveryItems.get(position).getImageResource());
//        holder.coverImageView.setTag(deliveryItems.get(position).getImageResource());
    }


    @Override
    public int getItemCount() {
        Log.d("GK", String.valueOf(deliveryItems.size()) + " is the size in getItemCount");
        return deliveryItems.size();
    }
}
    class ConfirmViewHolder extends RecyclerView.ViewHolder {

        public TextView price;
        public TextView method;
        public ImageView coverImageView;

        public ConfirmViewHolder(View v) {
            super(v);
            price = (TextView) v.findViewById(R.id.price);
            method = (TextView) v.findViewById(R.id.method);
            coverImageView = (ImageView) v.findViewById(R.id.coverPicOfDevlivery);
        }
    }


