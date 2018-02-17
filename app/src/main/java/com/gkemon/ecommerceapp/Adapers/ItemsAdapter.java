package com.gkemon.ecommerceapp.Adapers;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gkemon.ecommerceapp.Model.Items;
import com.gkemon.ecommerceapp.R;
import com.gkemon.ecommerceapp.Listener.RecyclerItemClickListener;

import java.util.ArrayList;


/**
 * Created by uy on 10/28/2017.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsViewHolder> {
    private ArrayList<Items> list;
    private Context context;
    private RecyclerItemClickListener recyclerItemClickListener;
//    public ItemsAdapter(ArrayList<Items> Data) {
//        list = Data;
//    }
    public ItemsAdapter(Context context) {
        this.context=context;
        list = new ArrayList<>();
    }

    private void add(Items item) {
        list.add(item);
        notifyItemInserted(list.size() - 1);
    }


    public void addAll(ArrayList<Items> items) {
        if(items!=null) {
            for (Items i : items) {
                add(i);
            }
        }
    }


    @Override
    public ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        Log.d("GK","in onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cards, parent, false);
        final ItemsViewHolder holder = new ItemsViewHolder(view);
        //CLICK LISTENER
        holder.itemView.findViewById(R.id.card_view_for_items).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPos = holder.getAdapterPosition();
                if (adapterPos != RecyclerView.NO_POSITION) {
                    if (recyclerItemClickListener != null) {
                        recyclerItemClickListener.onItemClick(adapterPos, holder.itemView.findViewById(R.id.card_view_for_items));
                    }
                }
            }
        });

        return holder;
    }
    public void setOnItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

//TODO:set saved icon on onBindViewHolder not onCreateViewHolder
    @Override
    public void onBindViewHolder(final ItemsViewHolder holder, int position) {
        // FOR GENERATING METARIAL COLOR FOR NEWS CARDS SIDE
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}

 class ItemsViewHolder extends RecyclerView.ViewHolder {

    public TextView offer;
    public TextView productName;
    public TextView promotions;
    public ImageView productPic;
    public CardView productCard;

    public ItemsViewHolder(View v) {
        super(v);
        offer = (TextView) v.findViewById(R.id.offer);
        productName = (TextView) v.findViewById(R.id.productName);
        promotions = (TextView) v.findViewById(R.id.promotion);
        productPic=(ImageView)v.findViewById(R.id.productPic);
        productCard=(CardView)v.findViewById(R.id.card_view_for_items);
    }
}