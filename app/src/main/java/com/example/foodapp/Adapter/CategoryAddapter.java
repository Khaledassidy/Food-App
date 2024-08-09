package com.example.foodapp.Adapter;

import static android.app.Activity.RESULT_FIRST_USER;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.example.foodapp.Activity.List_FoodActivity;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Category;
import com.example.foodapp.R;

import java.util.ArrayList;

public class CategoryAddapter extends RecyclerView.Adapter<CategoryAddapter.viewholder> {
    ArrayList<Category> items;
    Context context;

    public CategoryAddapter(ArrayList<Category> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryAddapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View inflate= LayoutInflater.from(context).inflate(R.layout.viewholde_category,parent,false);

//        viewholder viewholder=new viewholder(inflate);
//        return viewholder;
        //or
        return new viewholder(inflate);
    }




    @Override
    public void onBindViewHolder(@NonNull CategoryAddapter.viewholder holder, int position) {
        holder.title_text.setText(items.get(position).getName());

        switch(position){
            case 0:{
                holder.pic.setBackgroundResource(R.drawable.category1_back);
                break;
            }
            case 1:{holder.pic.setBackgroundResource(R.drawable.category2_back);
                break;
            }
            case 2:{holder.pic.setBackgroundResource(R.drawable.category3_back);

                break;
            }
            case 3:{holder.pic.setBackgroundResource(R.drawable.category4_back);
                break;
            }
            case 4:{holder.pic.setBackgroundResource(R.drawable.category5_back);
                break;
            }
            case 5:{holder.pic.setBackgroundResource(R.drawable.category6_back);
                break;
            }
            case 6:{holder.pic.setBackgroundResource(R.drawable.category7_back);
                break;
            }
            case 7:{holder.pic.setBackgroundResource(R.drawable.category8_back);
                break;
            }



        }
        Glide.with(context).load(Uri.parse(items.get(position).getImagepath())).into(holder.pic);




    }


    public void additem(Category category){
        items.add(category);
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

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title_text;
        ImageView pic;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            title_text=itemView.findViewById(R.id.name_category);
            pic=itemView.findViewById(R.id.image_category);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, List_FoodActivity.class);
            intent.putExtra("name",items.get(getAdapterPosition()).getName());
            intent.putExtra("position",getAdapterPosition());
            intent.putExtra("Result",RESULT_FIRST_USER);

            context.startActivity(intent);
        }
    }
}
