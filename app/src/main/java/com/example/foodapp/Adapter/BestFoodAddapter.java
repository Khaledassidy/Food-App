package com.example.foodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.Activity.DetailActivity;
import com.example.foodapp.Activity.MainActivity;
import com.example.foodapp.CostumeClick.ClickListner;
import com.example.foodapp.CostumeClick.ClickListnerplus;
import com.example.foodapp.CostumeClick.Clickevent;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Locale;

public  class BestFoodAddapter extends RecyclerView.Adapter<BestFoodAddapter.viewholder> {
    ArrayList<Foods> items;
    Context context;
    Clickevent clickListner;

    public BestFoodAddapter(ArrayList<Foods> items,Clickevent clickListner) {

        this.items = items;
        this.clickListner=clickListner;
    }

    @NonNull
    @Override
    public BestFoodAddapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(context).inflate(R.layout.viewholder_best_deal,parent,false);

//        viewholder viewholder=new viewholder(inflate);
//        return viewholder;
        //or
        return new viewholder(inflate);
    }

    public void setclick(Clickevent clickListner){
        this.clickListner=clickListner;
    }



    @Override
    public void onBindViewHolder(@NonNull BestFoodAddapter.viewholder holder, int position) {
        holder.title_text.setText(items.get(position).getTitle());
//        String.format(...) - This is a tool in Java that helps you create a nicely formatted piece of text (a string).
//                Locale.getDefault() - This tells Java to use the way numbers and currency are usually displayed in your region (like using commas or periods for decimals).
//        "$%.2f" - This is the blueprint for how the price should look:
        holder.price_text.setText(String.format(Locale.getDefault(), "$%.2f", items.get(position).getPrice()));
        holder.time_text.setText(items.get(position).getTimeValue()+" min");
        holder.startext.setText(items.get(position).getStar()+"");
        Glide.with(context).load(Uri.parse(items.get(position).getImagepath())).transform(new CenterCrop(),new RoundedCorners(30)).into(holder.pic);
        holder.plus_button.setOnClickListener(v-> {
            DatabaseAcces.getInstance(context).openRead();
            Foods foods1= DatabaseAcces.getInstance(context).FetchFoods(items.get(position).getId());
            DatabaseAcces.getInstance(context).close();
            if (foods1 != null && !foods1.isIncart()) {
                foods1.setIncart(true);
                foods1.setNumberInCart(1);
                DatabaseAcces.getInstance(context).openWrite();
                boolean flag=DatabaseAcces.getInstance(context).InsertCart(foods1);
                DatabaseAcces.getInstance(context).close();
                notifyDataSetChanged();
                notifyItemChanged(position);
                MainActivity.notification(context);
                Snackbar snackbar1 = Snackbar.make(holder.itemView, "Your item added to Cart", Snackbar.LENGTH_SHORT);
                snackbar1.setTextColor(context.getResources().getColor(R.color.orange));
                snackbar1.setBackgroundTint(context.getResources().getColor(R.color.blue_grey));
                Button snakbar_action = snackbar1.getView().findViewById(com.google.android.material.R.id.snackbar_action);
                snakbar_action.setTextColor(context.getResources().getColor(R.color.orange));
                if(flag==true){
                    snackbar1.show();
                }
                else{
                    snackbar1.dismiss();

                }
                snackbar1.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(foods1!=null && foods1.isIncart()) {
                            foods1.setIncart(false);
                            foods1.setNumberInCart(0);
                            DatabaseAcces.getInstance(context).openWrite();
                            DatabaseAcces.getInstance(context).DeleteCart(foods1);
                            DatabaseAcces.getInstance(context).close();
                            MainActivity.notification(context);
                        }

                    }
                });


            }else{
                Toast.makeText(context, "All Ready in Cart", Toast.LENGTH_SHORT).show();
            }


        });

    }


    public void additem(Foods food){
        items.add(food);
        notifyDataSetChanged();
    }

    public void deleteitem(int postion){
        items.remove(postion);
        notifyDataSetChanged();
    }




    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title_text, price_text, startext, time_text,plus_button;
        ImageView pic;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.title_item);
            price_text = itemView.findViewById(R.id.price_txt);
            startext = itemView.findViewById(R.id.number_star);
            time_text = itemView.findViewById(R.id.time_value);
            pic = itemView.findViewById(R.id.pic);
            plus_button=itemView.findViewById(R.id.plus_button);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if(clickListner!=null){
                clickListner.onclick(items.get(getAdapterPosition()).getId(),items.get(getAdapterPosition()),getAdapterPosition());

            }
        }
    }
}
