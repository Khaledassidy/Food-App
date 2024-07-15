package com.example.foodapp.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.Adapter.BestFoodAddapter;
import com.example.foodapp.Adapter.CategoryAddapter;
import com.example.foodapp.Adapter.Food_list_Adapter;
import com.example.foodapp.CostumeClick.ClickListnerplus;
import com.example.foodapp.Domain.Category;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Domain.Location;
import com.example.foodapp.Domain.Price;
import com.example.foodapp.Domain.Time;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView Welcome_tex_v;
    TextView Name_tex_v;
    TextView text_today_bestfood;
    TextView text_viewall;
    TextView textcatogry;
    static TextView notificationtext;
    ImageView Logout_btn,setting_image,search_image,cart_image,location_image_sp,image_time_sp,image_price_sp;
    EditText editTextText_search;
    Spinner spinner_location_sp,spinner_time_sp,spinner_price_sp;
    RecyclerView recyclerView_bestfood_tody,recyclerView_category;
    ProgressBar progress_tody_best_food,progressBar_category;
    ArrayList<Foods> arrayList_bestfood;
    CoordinatorLayout coordinatorLayout;
    BestFoodAddapter bestFoodAddapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logout_btn=findViewById(R.id.Logout_btn);
        setting_image=findViewById(R.id.setting_image);
        search_image=findViewById(R.id.search_image);
        cart_image=findViewById(R.id.cart_image);
        Welcome_tex_v=findViewById(R.id.Welcome_tex_v);
        Name_tex_v=findViewById(R.id.Name_tex_v);
        text_today_bestfood=findViewById(R.id.text_today_bestfood);
        text_viewall=findViewById(R.id.text_viewall);
        editTextText_search=findViewById(R.id.editTextText_search);
        spinner_location_sp=findViewById(R.id.spinner_location_sp);
        spinner_time_sp=findViewById(R.id.spinner_time_sp);
        spinner_price_sp=findViewById(R.id.spinner_price_sp);
        recyclerView_bestfood_tody=findViewById(R.id.recyclerView_bestfood_tody);
        recyclerView_category=findViewById(R.id.recyclerView_category);
        progress_tody_best_food=findViewById(R.id.progress_tody_best_food);
        progressBar_category=findViewById(R.id.progressBar_category);
        notificationtext=findViewById(R.id.notificationtext);
        coordinatorLayout=findViewById(R.id.main);
        arrayList_bestfood=new ArrayList<>();


        getWindow().setStatusBarColor(getResources().getColor(R.color.white));


        intbestfood();
        intLocation();
        intTime();
        intPrice();
        intcategoryfood();
        notification();
        seeall();
        cart_image.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),CartActivity.class);
            startActivity(intent);
            notificationtext.setVisibility(View.GONE);
        });

        Logout_btn.setOnClickListener(v->{
            finish();
        });

    }

    private void seeall() {
        text_viewall.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(),List_FoodActivity.class);
            if(intent!=null){
                intent.putExtra("bestfood",arrayList_bestfood);
                startActivity(intent);
            }


        });
    }

    public static void notification() {
        if(Cart.getInstance().isEmpty()==true){
            notificationtext.setVisibility(View.GONE);
        }
        else{
            notificationtext.setVisibility(View.VISIBLE);
            notificationtext.setText(Cart.getInstance().size()+"");

        }
        Log.d("khaled",Cart.getInstance().size()+"");
    }

    private void intPrice() {
        ArrayList<Price> arrayList=new ArrayList<>();
        Price price1=new Price(0,"1$-10$");
        Price price2=new Price(1,"10$-20$");
        Price price3=new Price(2,"10$-30$");
        Price price4=new Price(3,"more than 30$");
        Price price5=new Price(4,"more than 40$");
        Price price6=new Price(5,"more than 50$");
        Price price7=new Price(6,"more than 60$");

        ArrayAdapter<Price> arrayAdapter= new ArrayAdapter<>(MainActivity.this,R.layout.sp_items,arrayList);
        arrayAdapter.add(price1);
        arrayAdapter.add(price2);
        arrayAdapter.add(price3);
        arrayAdapter.add(price4);
        arrayAdapter.add(price5);
        arrayAdapter.add(price6);
        arrayAdapter.add(price7);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_price_sp.setAdapter(arrayAdapter);

    }

    private void intTime() {
        ArrayList<Time> arrayList=new ArrayList<>();
        Time time1=new Time(0,"0-10 min");
        Time time2=new Time(1,"10-60 min");
        Time time3=new Time(2,"5-10 min");
        Time time4=new Time(3,"5-15 min");
        Time time5=new Time(4,"30-60 min");
        Time time6=new Time(5,"5-20 min");
        Time time7=new Time(6,"5-30 min");

        ArrayAdapter<Time> arrayAdapter= new ArrayAdapter<>(MainActivity.this,R.layout.sp_items,arrayList);
        arrayAdapter.add(time1);
        arrayAdapter.add(time2);
        arrayAdapter.add(time3);
        arrayAdapter.add(time4);
        arrayAdapter.add(time5);
        arrayAdapter.add(time6);
        arrayAdapter.add(time7);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_time_sp.setAdapter(arrayAdapter);

    }

    private void intLocation() {
        ArrayList<Location> arrayList=new ArrayList<>();
        Location location1=new Location(0,"Achrafieh");
        Location location2=new Location(1,"Badaro");
        Location location3=new Location(2,"Beirut Central District");
        Location location4=new Location(3,"Hamra Street");
        Location location5=new Location(4,"Mazraa District");
        Location location6=new Location(5,"Bourj Hammoud");
        Location location7=new Location(6,"Haret Hreik");
        ArrayAdapter<Location> arrayAdapter= new ArrayAdapter<>(MainActivity.this,R.layout.sp_items,arrayList);
        arrayAdapter.add(location1);
        arrayAdapter.add(location2);
        arrayAdapter.add(location3);
        arrayAdapter.add(location4);
        arrayAdapter.add(location5);
        arrayAdapter.add(location6);
        arrayAdapter.add(location7);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_location_sp.setAdapter(arrayAdapter);


    }

    private void intbestfood() {
        progress_tody_best_food.setVisibility(View.VISIBLE);
        bestFoodAddapter=new BestFoodAddapter(arrayList_bestfood);
        Foods foods=new Foods(0,"Margherita pizza is a classic Italian dish featuring a thin crust topped with vibrant tomato sauce, fresh mozzarella, and aromatic basil leaves. The colors represent the Italian flag: red, white, and green. Traditionally baked in a wood-fired oven, it offers a delightful char and rich flavor. This simple yet delicious pizza is a favorite worldwide.",true,-17,0,10.99, R.drawable.vegetarianpadthai,0,3.5,0,10,"Vegetarian Pad Thai",1);
        Foods foods1=new Foods(1,"BBQ Chicken Delight is a flavorful pizza topped with tender grilled chicken smothered in tangy barbecue sauce. It often features red onions, cilantro, and a blend of cheeses, creating a deliciously smoky and savory profile. This pizza is perfect for those who love a sweet and spicy kick in their meal. It's a crowd-pleaser for any pizza lover!",true,-16,1,15.99, R.drawable.bbqchickendelight,1,4,1,10,"BBQ Chicken Delight",1);
        Foods foods2=new Foods(2,"Meat Feast Pizza is a hearty and indulgent dish loaded with an array of meats, including pepperoni, sausage, ham, and bacon. Each slice offers a rich, savory flavor that satisfies any carnivore's cravings. Topped with gooey cheese and a zesty tomato sauce, it's perfect for those who appreciate a protein-packed pizza experience. Ideal for sharing with friends or enjoying solo!",true,-15,2,18.99, R.drawable.meatfeastpizza,2,4,2,15,"Meat Feast Pizza",1);
        Foods foods3=new Foods(3,"Pepperoni Pizza features a classic combination of a crispy crust topped with zesty tomato sauce and melted mozzarella cheese. Generously adorned with slices of spicy pepperoni, it delivers a delightful balance of savory flavors and a satisfying kick. This beloved favorite is perfect for any occasion, making it a go-to choice for pizza lovers everywhere. Enjoy it fresh from the oven for the best experience!",true,-14,3,20.99, R.drawable.pepperonilovers,3,4,3,10,"Pepperoni Pizza",1);
        Foods foods4=new Foods(4,"Pasta Carbonara is a rich Italian dish made with spaghetti or fettuccine, tossed in a creamy sauce of eggs, Pecorino Romano cheese, and crispy pancetta. The heat of the pasta lightly cooks the eggs, creating a silky texture that clings to each strand. Traditionally seasoned with black pepper, this dish offers a comforting blend of flavors that is both indulgent and satisfying. Perfect for a quick weeknight dinner or a special occasion!",true,46,4,22.99, R.drawable.pastacarbonara,4,3,4,4,"Pasta Carbonara",1);
        Foods foods5=new Foods(5,"Mediterranean Joy is a vibrant dish featuring a delightful combination of fresh ingredients like olives, feta cheese, cherry tomatoes, cucumbers, and bell peppers. Tossed in a tangy olive oil and lemon dressing, it celebrates the flavors of the Mediterranean. This refreshing salad is often served over a bed of mixed greens or paired with grilled meats, making it a perfect choice for a light yet satisfying meal. Enjoy the taste of sunshine and health in every bite!",true,-10,5,25.99, R.drawable.mediterraneanjoy,5,5,5,20,"Mediterranean joy",1);
        bestFoodAddapter.additem(foods);
        bestFoodAddapter.additem(foods1);
        bestFoodAddapter.additem(foods2);
        bestFoodAddapter.additem(foods3);
        bestFoodAddapter.additem(foods4);
        bestFoodAddapter.additem(foods5);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.HORIZONTAL,false);
        recyclerView_bestfood_tody.setLayoutManager(layoutManager);
        progress_tody_best_food.setVisibility(View.GONE);
        recyclerView_bestfood_tody.setAdapter(bestFoodAddapter);
    }

    private void intcategoryfood() {
        progressBar_category.setVisibility(View.VISIBLE);
        ArrayList<Category> arrayList=new ArrayList<>();
        CategoryAddapter categoryAddapter=new CategoryAddapter(arrayList);
        Category category1=new Category(0,R.drawable.btn_1,"Pizza");
        Category category2=new Category(1,R.drawable.btn_2,"Burger");
        Category category3=new Category(2,R.drawable.btn_3,"Chicken");
        Category category4=new Category(3,R.drawable.btn_4,"Sushi");
        Category category5=new Category(4,R.drawable.btn_5,"Meat");
        Category category6=new Category(5,R.drawable.btn_6,"Hotdog");
        Category category7=new Category(6,R.drawable.btn_7,"Drink");
        Category category8=new Category(7,R.drawable.btn_8,"More");
        categoryAddapter.additem(category1);
        categoryAddapter.additem(category2);
        categoryAddapter.additem(category3);
        categoryAddapter.additem(category4);
        categoryAddapter.additem(category5);
        categoryAddapter.additem(category6);
        categoryAddapter.additem(category7);
        categoryAddapter.additem(category8);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),4);
        recyclerView_category.setLayoutManager(layoutManager);
        progressBar_category.setVisibility(View.GONE);
        recyclerView_category.setAdapter(categoryAddapter);
    }



}