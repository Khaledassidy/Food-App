package com.example.foodapp.Adapter;


import android.content.Context;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.foodapp.Activity.DetailActivity;
import com.example.foodapp.Database.Database;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Category;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.R;

import java.util.ArrayList;
import java.util.Locale;

public class SearchAddapter extends RecyclerView.Adapter<SearchAddapter.viewholder> {
    ArrayList<Foods> items;
    Context context;

    public SearchAddapter(ArrayList<Foods> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.viewholder_search, parent, false);
//        viewholder viewholder=new viewholder(inflate);
//        return viewholder;
        //or
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
            holder.title_search.setText(items.get(position).getTitle());
            holder.price_item_search.setText("$ "+String.valueOf(items.get(position).getPrice()));
            Glide.with(context).load(items.get(position).getImagepath()).into(holder.pic_search);
            DatabaseAcces.getInstance(context).openRead();
            holder.category_name.setText("in category/"+DatabaseAcces.getInstance(context).GetCategoryformid(items.get(position).getCategoryId()));
            DatabaseAcces.getInstance(context).close();





    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView pic_search;
        TextView title_search, price_item_search, category_name;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            pic_search = itemView.findViewById(R.id.pic_search);
            title_search = itemView.findViewById(R.id.title_search);
            price_item_search = itemView.findViewById(R.id.price_item_search);
            category_name = itemView.findViewById(R.id.category);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("id_food", items.get(getAdapterPosition()).getId());
            intent.putExtra("name", category_name.getText().toString());
            context.startActivity(intent);
        }
    }

}