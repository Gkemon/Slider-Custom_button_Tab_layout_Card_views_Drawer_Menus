package com.gkemon.ecommerceapp.Fragments;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gkemon.ecommerceapp.Adapers.DeliveryAdapter;
import com.gkemon.ecommerceapp.Adapers.ItemsAdapter;
import com.gkemon.ecommerceapp.Listener.RecyclerItemClickListener;
import com.gkemon.ecommerceapp.Model.DeliveryItems;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;
import java.util.Locale;


public class shipingFragments extends Fragment implements RecyclerItemClickListener {
   public static ArrayList<DeliveryItems> listitems = new ArrayList<>();

    private View rootView;
    public RecyclerView recyclerViewForDelivery;
    public Typeface typeface;
    public LinearLayoutManager linearLayoutManager;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7;
    public static ArrayList<String> price;
    public static ArrayList<String> method;
    public int imageResource[]={R.drawable.cycle,R.drawable.bike,R.drawable.truck,R.drawable.plan};




    public shipingFragments() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        listitems = new ArrayList<>();
//        price =new ArrayList<>();
//        method =new ArrayList<>();
//
//        price.add("09$");
//        price.add("19$");
//        price.add("29$");
//        price.add("39$");
//
//        method.add("REGULAR");
//        method.add("MEDIUM");
//        method.add("EXPRESS");
//        method.add("OVER NIGHT");
//        initializeList();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        price =new ArrayList<>();
//        method =new ArrayList<>();
//
//        price.add("09$");
//        price.add("19$");
//        price.add("29$");
//        price.add("39$");
//
//        method.add("REGULAR");
//        method.add("MEDIUM");
//        method.add("EXPRESS");
//        method.add("OVER NIGHT");
//        initializeList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        price =new ArrayList<>();
        method =new ArrayList<>();

        price.add("09$");
        price.add("19$");
        price.add("29$");
        price.add("39$");

        method.add("REGULAR");
        method.add("MEDIUM");
        method.add("EXPRESS");
        method.add("OVER NIGHT");
        initializeList();

//        imageResource.add(R.drawable.cycle);
//        imageResource.add(R.drawable.bike);
//        imageResource.add(R.drawable.truck);
//        imageResource.add(R.drawable.plan);
//



        rootView = inflater.inflate(R.layout.shiping_fragment_payment, container, false);

        textView1 = (TextView) rootView.findViewById(R.id.t1);
        textView2 = (TextView) rootView.findViewById(R.id.t2);
        textView3 = (TextView) rootView.findViewById(R.id.t3);
        textView4 = (TextView) rootView.findViewById(R.id.t5);
        textView5 = (TextView) rootView.findViewById(R.id.t6);
        textView6 = (TextView) rootView.findViewById(R.id.t7);
        textView7 = (TextView) rootView.findViewById(R.id.t8);

        AssetManager am = getActivity().getAssets();
        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "MavenPro-Regular.ttf"));

        textView1.setTypeface(typeface);
        textView2.setTypeface(typeface);
        textView3.setTypeface(typeface);
        textView4.setTypeface(typeface);
        textView5.setTypeface(typeface);
        textView6.setTypeface(typeface);
        textView7.setTypeface(typeface);

       // VIEWS
        recyclerViewForDelivery = (RecyclerView) rootView.findViewById(R.id.deliveryRecycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        DeliveryAdapter deliveryAdapter = new DeliveryAdapter(listitems);
        recyclerViewForDelivery.setHasFixedSize(true);

       // itemsAdapter.setOnItemClickListener(this);
        recyclerViewForDelivery.setAdapter(deliveryAdapter);
        recyclerViewForDelivery.setLayoutManager(linearLayoutManager);




        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onItemClick(int position, View view) {

    }

    @Override
    public void onItemLongPressed(int position, View view) {

    }

    public void initializeList() {
        listitems.clear();
        for(int i =0;i<4;i++){
            DeliveryItems item = new DeliveryItems(imageResource[i],price.get(i),method.get(i));
            Log.d("GK",String.valueOf(imageResource[i])+" "+price.get(i)+" "+method.get(i));
            listitems.add(item);
        }
    }


}
// class DevileryAdapter extends RecyclerView.Adapter<DeliveryViewHolder> {
//
//    private RecyclerItemClickListener recyclerItemClickListener;
//
//    public ArrayList<DeliveryItems> deliveryItems;
//
//    public DevileryAdapter(ArrayList<DeliveryItems> itemListPrice) {
//        Log.d("GK",String.valueOf(itemListPrice.size())+" is the size");
//        this.deliveryItems = itemListPrice;
//        Log.d("GK",String.valueOf(deliveryItems.size())+" is the size");
//    }
//
//    @Override
//    public DeliveryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // create a new view
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.delivery_items_layout,null);
//        Log.d("GK","in onCreateViewHolder");
//        final DeliveryViewHolder holder = new DeliveryViewHolder(view);
//        //CLICK LISTENER
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int adapterPos = holder.getAdapterPosition();
//                if (adapterPos != RecyclerView.NO_POSITION) {
//                    if (recyclerItemClickListener != null) {
//                        recyclerItemClickListener.onItemClick(adapterPos, holder.itemView);
//                    }
//                }
//            }
//        });
//        return holder;
//    }
//
//    public void setOnItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
//        this.recyclerItemClickListener = recyclerItemClickListener;
//    }
//
//    @Override
//    public void onBindViewHolder(final DeliveryViewHolder holder, int position) {
//
//        Log.d("GK",deliveryItems.get(position).getPrice());
//        Log.d("GK",deliveryItems.get(position).getMethod());
//        Log.d("GK",String.valueOf(deliveryItems.get(position).getImageResource()));
//
//        holder.price.setText(deliveryItems.get(position).getPrice());
//        holder.method.setText(deliveryItems.get(position).getMethod());
//        holder.coverImageView.setImageResource(deliveryItems.get(position).getImageResource());
//        holder.coverImageView.setTag(deliveryItems.get(position).getImageResource());
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return deliveryItems.size();
//    }
//}

// class DeliveryViewHolder extends RecyclerView.ViewHolder {
//
//    public TextView price;
//    public TextView method;
//    public ImageView coverImageView;
//
//    public DeliveryViewHolder(View v) {
//        super(v);
//        price = (TextView) v.findViewById(R.id.price);
//        method = (TextView) v.findViewById(R.id.method);
//        coverImageView=(ImageView) v.findViewById(R.id.coverPicOfDevlivery);
//    }
//}

