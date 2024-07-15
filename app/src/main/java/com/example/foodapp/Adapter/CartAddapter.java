package com.example.foodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.Activity.DetailActivity;
import com.example.foodapp.CostumeClick.ClickListner;
import com.example.foodapp.CostumeClick.ClickListnerplus;
import com.example.foodapp.CostumeClick.Clickevent;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class CartAddapter extends RecyclerView.Adapter<CartAddapter.viewholder> {
    Context context;
    ArrayList<Foods>arrayList;
    Clickevent clickListner;
    ClickListner clickListner1;
    boolean flag=true;

    public CartAddapter(Context context, ArrayList<Foods> arrayList, ClickListner clickListner) {
        this.context = context;
        this.arrayList = arrayList;
        this.clickListner1=clickListner;
    }


    public void setclick(Clickevent clickListner){
        this.clickListner=clickListner;
    }


    @NonNull
    @Override
    public CartAddapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.viewholder_cart,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAddapter.viewholder holder, int position) {

        if(arrayList.get(position)!=null){
            holder.title_cart.setText(arrayList.get(position).getTitle());
            holder.price_item_cart.setText(String.format(Locale.getDefault(), "$%.2f", arrayList.get(position).getPrice()));
            Glide.with(context).load(arrayList.get(position).getImagepath()).into(holder.pic_cart);
            holder.totalt_price_cart.setText(String.format(Locale.getDefault(), "$%.2f",arrayList.get(position).getNumberInCart()*arrayList.get(position).getPrice()));
            holder.quntity_item_cart.setText(String.valueOf(arrayList.get(position).getNumberInCart()));

            holder.plus_item_cart.setOnClickListener(v->{
                flag=true;
                clickListner1.onclick(v,position,flag,arrayList.get(position));
                notifyItemChanged(position);
                flag=false;

            });

            holder.minus_button_cart.setOnClickListener(v->{
                flag=false;
                clickListner1.onclick(v,position,flag,arrayList.get(position));
                notifyItemChanged(position);
                flag=true;
            });


        }






    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView pic_cart;
        TextView title_cart,price_item_cart,quntity_item_cart,totalt_price_cart,minus_button_cart,plus_item_cart;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            pic_cart=itemView.findViewById(R.id.pic_cart);
            title_cart=itemView.findViewById(R.id.title_cart);
            price_item_cart=itemView.findViewById(R.id.price_item_cart);
            quntity_item_cart=itemView.findViewById(R.id.quntity_item_cart);
            totalt_price_cart=itemView.findViewById(R.id.totalt_price_cart);
            minus_button_cart=itemView.findViewById(R.id.minus_button_cart);
            plus_item_cart=itemView.findViewById(R.id.plus_item_cart);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
           if(clickListner!=null){
               clickListner.onclick(arrayList.get(getAdapterPosition()),getAdapterPosition());
           }

        }
    }
}

