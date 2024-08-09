package com.example.foodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.Activity.DetailActivity;
import com.example.foodapp.Activity.MainActivity;
import com.example.foodapp.CostumeClick.Clickevent;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.bestfood;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class Food_list_Adapter extends RecyclerView.Adapter<Food_list_Adapter.viewholder> {
    ArrayList<Foods> items;
    Context context;
    Clickevent clickListner;


    public Food_list_Adapter(Clickevent clickListner,ArrayList<Foods> items) {

        this.items = items;
        this.clickListner=clickListner;

    }

    @NonNull
    @Override
    public Food_list_Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(context).inflate(R.layout.view_holder_list_food,parent,false);

//        viewholder viewholder=new viewholder(inflate);
//        return viewholder;
        //or
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Food_list_Adapter.viewholder holder, int position) {
        holder.title_text.setText(items.get(position).getTitle());
        holder.price_text.setText(String.format(Locale.getDefault(), "$%.2f", items.get(position).getPrice()));
        Glide.with(context).load(Uri.parse(items.get(position).getImagepath())).transform(new CenterCrop(),new RoundedCorners(30)).into(holder.pic);
        holder.num_starr.setText(items.get(position).getStar()+"");
        holder.time.setText(items.get(position).getTimeValue()+" min");
        DatabaseAcces.getInstance(context).openRead();
       Foods foods1= DatabaseAcces.getInstance(context).FetchFoods(items.get(position).getId());
       DatabaseAcces.getInstance(context).close();
       if(foods1!=null && foods1.isIncart()){
           if(foods1.getNumberInCart()==1){
               holder.minus_btn1.setText("");
               holder.minus_btn1.setBackgroundResource(R.drawable.delete_1_svgrepo_com);

           } else if (foods1.getNumberInCart()!=-1) {
               holder.minus_btn1.setBackgroundResource(R.color.orange);
               holder.minus_btn1.setText("━");
           }
           holder.buttonplus.setVisibility(View.VISIBLE);
           holder.buttonplus.setText(String.valueOf(foods1.getNumberInCart()));
           holder.contact_quntity1.setVisibility(View.GONE);
           MainActivity.notification(context);
       }else{
           holder.buttonplus.setVisibility(View.VISIBLE);
           holder.buttonplus.setText("+");
           holder.contact_quntity1.setVisibility(View.GONE);
           MainActivity.notification(context);

       }

        holder.buttonplus.setOnClickListener(v->{
            DatabaseAcces.getInstance(context).openRead();
            Foods foods= DatabaseAcces.getInstance(context).FetchFoods(items.get(position).getId());
            DatabaseAcces.getInstance(context).close();
            if(foods!=null && !foods.isIncart()){
                holder.minus_btn1.setBackgroundResource(R.drawable.delete_1_svgrepo_com);
                foods.setNumberInCart(1);
               foods.setIncart(true);
               holder.number_item1.setText(String.valueOf(foods.getNumberInCart()));
               DatabaseAcces.getInstance(context).openWrite();
               DatabaseAcces.getInstance(context).InsertCart(foods);
               DatabaseAcces.getInstance(context).close();
                holder.buttonplus.setText(String.valueOf(foods.getNumberInCart()));
                holder.buttonplus.setVisibility(View.GONE);
                holder.contact_quntity1.setVisibility(View.VISIBLE);
                MainActivity.notification(context);

            }else{
                holder.buttonplus.setVisibility(View.GONE);
                holder.contact_quntity1.setVisibility(View.VISIBLE);
                holder.number_item1.setText(String.valueOf(foods.getNumberInCart()));
                MainActivity.notification(context);

            }




        });

        holder.plus_item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAcces.getInstance(context).openRead();
                Foods foods= DatabaseAcces.getInstance(context).FetchFoods(items.get(position).getId());
                DatabaseAcces.getInstance(context).close();
                if(foods.isIncart()) {
                    foods.setNumberInCart(foods.getNumberInCart() + 1);
                    if(foods.getNumberInCart()>1){
                        holder.minus_btn1.setBackgroundResource(R.color.orange);
                        holder.minus_btn1.setText("━");

                    } else if (foods.getNumberInCart()==1) {
                        holder.minus_btn1.setText("");
                        holder.minus_btn1.setBackgroundResource(R.drawable.delete_1_svgrepo_com);

                    }
                    DatabaseAcces.getInstance(context).openWrite();
                    DatabaseAcces.getInstance(context).UpdateCart(foods);
                    DatabaseAcces.getInstance(context).close();
                    holder.number_item1.setText(String.valueOf(foods.getNumberInCart()));
                    MainActivity.notification(context);
                }



            }
        });
        holder.minus_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAcces.getInstance(context).openRead();
                Foods foods= DatabaseAcces.getInstance(context).FetchFoods(items.get(position).getId());
                DatabaseAcces.getInstance(context).close();
                if(foods!=null){
                    if(foods.isIncart() && foods.getNumberInCart()>1){
                        foods.setNumberInCart(foods.getNumberInCart()-1);
                        if(foods.getNumberInCart()==1){
                            holder.minus_btn1.setText("");
                            holder.minus_btn1.setBackgroundResource(R.drawable.delete_1_svgrepo_com);

                        } else if (foods.getNumberInCart()!=-1) {
                            holder.minus_btn1.setBackgroundResource(R.color.orange);
                            holder.minus_btn1.setText("━");
                        }
                        holder.number_item1.setText(String.valueOf(foods.getNumberInCart()));
                        DatabaseAcces.getInstance(context).openWrite();
                        DatabaseAcces.getInstance(context).UpdateCart(foods);
                        DatabaseAcces.getInstance(context).close();
                        MainActivity.notification(context);

                    } else if (foods.isIncart() && foods.getNumberInCart()==1){
                        holder.minus_btn1.setBackground(Drawable.createFromPath("android.resource://com.example.foodapp/drawable/delete_1_svgrepo_com"));
                        foods.setNumberInCart(0);
                        foods.setIncart(false);
                        holder.number_item1.setText(String.valueOf(foods.getNumberInCart()));
                        DatabaseAcces.getInstance(context).openWrite();
                        DatabaseAcces.getInstance(context).DeleteCart(foods);
                        DatabaseAcces.getInstance(context).close();
                        holder.contact_quntity1.setVisibility(View.GONE);
                        holder.buttonplus.setVisibility(View.VISIBLE);
                        holder.buttonplus.setText("+");
                        MainActivity.notification(context);



                    }
                }



            }
        });
        MainActivity.notification(context);
    }


    public void additem(Foods food){
        if(items!=null){
            items.add(food);
            notifyDataSetChanged();
        }

    }

    public void deleteitem(int postion){

        items.remove(postion);
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title_text, price_text,num_starr,time,buttonplus,minus_btn1,number_item1,plus_item1;
        ImageView pic;
        ConstraintLayout contact_quntity1;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.text_title);
            price_text = itemView.findViewById(R.id.price_text);
            pic = itemView.findViewById(R.id.imageView_food);
            num_starr=itemView.findViewById(R.id.rate_txt);
            time=itemView.findViewById(R.id.time_text);
            buttonplus=itemView.findViewById(R.id.plus_btn);
            contact_quntity1=itemView.findViewById(R.id.contact_quntity1);
            minus_btn1=itemView.findViewById(R.id.minus_btn1);
            number_item1=itemView.findViewById(R.id.number_item1);
            plus_item1=itemView.findViewById(R.id.plus_item1);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            clickListner.onclick(items.get(getAdapterPosition()).getId(),items.get(getAdapterPosition()),getAdapterPosition());

        }
    }
}
