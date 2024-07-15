package com.example.foodapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.foodapp.Activity.DetailActivity;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class Food_list_Adapter extends RecyclerView.Adapter<Food_list_Adapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public Food_list_Adapter(ArrayList<Foods> items) {
        this.items = items;
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
        Glide.with(context).load(items.get(position).getImagepath()).transform(new CenterCrop(),new RoundedCorners(30)).into(holder.pic);
        holder.time.setText(items.get(position).getTimeValue()+"min");
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
        TextView title_text, price_text,num_starr,time;
        ImageView pic;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.text_title);
            price_text = itemView.findViewById(R.id.price_text);
            pic = itemView.findViewById(R.id.imageView_food);
            num_starr=itemView.findViewById(R.id.rate_txt);
            time=itemView.findViewById(R.id.time_text);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, DetailActivity.class);
            intent.putExtra("object",items.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }
}
