package com.gkemon.ecommerceapp.Adapers;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gkemon.ecommerceapp.Listener.RecyclerItemClickListener;
import com.gkemon.ecommerceapp.Model.ConfirmItem;
import com.gkemon.ecommerceapp.Model.DeliveryItems;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;

/**
 * Created by Gk emon on 2/16/2018.
 */

public class ConfirmAdapter extends RecyclerView.Adapter<ConfirmViewHolder> {
    private RecyclerItemClickListener recyclerItemClickListener;

    public ArrayList<ConfirmItem> ConfirmItemList;

    public ConfirmAdapter(ArrayList<ConfirmItem> itemListPrice) {
        Log.d("GK", String.valueOf(itemListPrice.size()) + " is the size");
        ConfirmItemList = itemListPrice;
        Log.d("GK", String.valueOf(ConfirmItemList.size()) + " is the size");
    }

    @Override
    public ConfirmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.confirm_items, parent, false);
        Log.d("GK", "in onCreateViewHolder");
        final ConfirmViewHolder holder = new ConfirmViewHolder(view);
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
    public void onBindViewHolder(final ConfirmViewHolder holder, int position) {

        String price="$ "+String.valueOf(ConfirmItemList.get(position).getPrices());
        holder.price.setText(price);
        holder.size.setText(ConfirmItemList.get(position).getSize());
        holder.name.setText(ConfirmItemList.get(position).getProductName());
        holder.coverImageView.setTag(ConfirmItemList.get(position).getImageResource());
        holder.coverImageView.setImageResource(ConfirmItemList.get(position).getImageResource());

    }


    @Override
    public int getItemCount() {
        Log.d("GK", String.valueOf(ConfirmItemList.size()) + " is the size in getItemCount");
        return ConfirmItemList.size();
    }
}
    class ConfirmViewHolder extends RecyclerView.ViewHolder {

        public TextView price;
        public TextView name;
        public TextView size;
        public ImageView coverImageView;

        public ConfirmViewHolder(View v) {
            super(v);
            price = (TextView) v.findViewById(R.id.price);
            name = (TextView) v.findViewById(R.id.productName);
            size = (TextView) v.findViewById(R.id.size);
            coverImageView = (ImageView) v.findViewById(R.id.confirmImage);
        }
    }


