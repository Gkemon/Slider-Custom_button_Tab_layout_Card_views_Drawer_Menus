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
import com.gkemon.ecommerceapp.Model.PaymentItems;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;

/**
 * Created by Gk emon on 2/16/2018.
 */

public class PaymentAdapter extends RecyclerView.Adapter<PaymentViewHolder> {
    private RecyclerItemClickListener recyclerItemClickListener;

    public ArrayList<PaymentItems> PaymentItems;

    public PaymentAdapter(ArrayList<PaymentItems> itemListPrice) {
        Log.d("GK",String.valueOf(itemListPrice.size())+" is the size");
        PaymentItems = itemListPrice;
        Log.d("GK",String.valueOf(PaymentItems.size())+" is the size");
    }

    @Override
    public PaymentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_items_layout, parent, false);
        Log.d("GK","in onCreateViewHolder");
        final PaymentViewHolder holder = new PaymentViewHolder(view);
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
    public void onBindViewHolder(final PaymentViewHolder holder, int position) {

//        Log.d("GK",deliveryItems.get(position).getPrice());
//        Log.d("GK",deliveryItems.get(position).getMethod());
      //  Log.d("GK",String.valueOf(deliveryItems.get(position).getImageResource()));


        holder.method.setText(PaymentItems.get(position).getMethod());
        holder.coverImageView.setImageResource(PaymentItems.get(position).getImage());

    }



    @Override
    public int getItemCount() {
//        Log.d("GK",String.valueOf(deliveryItems.size())+" is the size in getItemCount");
        return PaymentItems.size();
    }

}

class PaymentViewHolder extends RecyclerView.ViewHolder {


    public TextView method;
    public ImageView coverImageView;

    public PaymentViewHolder(View v) {
        super(v);
        method = (TextView) v.findViewById(R.id.method);
        coverImageView=(ImageView) v.findViewById(R.id.coverPicOfDevlivery);
    }
}

