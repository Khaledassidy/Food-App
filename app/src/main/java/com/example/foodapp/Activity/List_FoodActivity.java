package com.example.foodapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.Adapter.Food_list_Adapter;
import com.example.foodapp.CostumeClick.Clickevent;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.bestfood;
import com.example.foodapp.R;

import java.util.ArrayList;

public class List_FoodActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textView;
    ImageView imageView;
    int position=0;
    String name="";
    ArrayList<Foods> arrayList;
    Food_list_Adapter foodListAdapter;
    int result;
    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        recyclerView=findViewById(R.id.food_list_view);
        imageView=findViewById(R.id.bak_btn);
        textView=findViewById(R.id.title_text);
        activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult o) {
                foodListAdapter.notifyDataSetChanged();

            }
        });
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        getintent();
        getint();




    }






    private void getint() {
        if(result==RESULT_FIRST_USER) {
            DatabaseAcces.getInstance(getApplicationContext()).openRead();

            foodListAdapter = new Food_list_Adapter(new Clickevent() {
                @Override
                public void onclick(int id, Foods foods, int postion) {
                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                    intent.putExtra("id_food", foods.getId());
                    intent.putExtra("name", name);
                    activityResultLauncher.launch(intent);


                }
            }, DatabaseAcces.getInstance(this).GetCategoryFoods(position));

            recyclerView.setAdapter(foodListAdapter);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
            recyclerView.setLayoutManager(layoutManager);
            DatabaseAcces.getInstance(getApplicationContext()).close();
        } else if (result==RESULT_OK) {
            Log.d("nesreen","hi");
            DatabaseAcces.getInstance(getApplicationContext()).openRead();
            foodListAdapter=new Food_list_Adapter(new Clickevent() {
                @Override
                public void onclick(int id, Foods foods, int postion) {
                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                    intent.putExtra("id_food", foods.getId());
                    intent.putExtra("name", "Best's Food");
                    activityResultLauncher.launch(intent);
                }
            }, DatabaseAcces.getInstance(getApplicationContext()).GetBestFoods());
            recyclerView.setAdapter(foodListAdapter);
            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
            recyclerView.setLayoutManager(layoutManager);
            DatabaseAcces.getInstance(getApplicationContext()).close();
        }


    }

    private void getintent() {
        position=getIntent().getIntExtra("position",0);
        name=getIntent().getStringExtra("name");
        result=getIntent().getIntExtra("Result",0);
        textView.setText(name);
        imageView.setOnClickListener(v->{
            finish();
        });
    }
}