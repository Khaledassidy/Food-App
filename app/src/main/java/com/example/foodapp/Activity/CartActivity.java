package com.example.foodapp.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Adapter.CartAddapter;
import com.example.foodapp.CostumeClick.ClickListner;
import com.example.foodapp.CostumeClick.Clickevent;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.Helper.bestfood;
import com.example.foodapp.R;

public class CartActivity extends AppCompatActivity{

    ImageView back_btn_cart;
    TextView Carttext,subtotal_text,delivery_value,totla_tax_vlaue,totla_cart,cart_empty_error;
    RecyclerView rercyle_cart;
    Button button_copon,place_order;
    EditText editTextText;
    double tax;
    NestedScrollView scroll;
    CartAddapter cartAddapter;
    LinearLayout container_error;
    ActivityResultLauncher<Intent> activityResultLauncher;
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        back_btn_cart=findViewById(R.id.back_btn_cart);
        subtotal_text=findViewById(R.id.subtotal_text);
        delivery_value=findViewById(R.id.delivery_value);
        totla_tax_vlaue=findViewById(R.id.totla_tax_vlaue);
        totla_cart=findViewById(R.id.totla_cart);
        rercyle_cart=findViewById(R.id.rercyle_cart);
        button_copon=findViewById(R.id.button_copon);
        place_order=findViewById(R.id.place_order);
        editTextText=findViewById(R.id.editTextText);
        cart_empty_error=findViewById(R.id.start_shopping);
        container_error=findViewById(R.id.container_error);
        scroll=findViewById(R.id.scroll);
        Carttext=findViewById(R.id.cart_text);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {

                            intlist();
                            calculateCart();


                    }
                }
        );

        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        setvariable();
        calculateCart();
        intlist();
        intl();
    }

    private void intl() {
        DatabaseAcces.getInstance(this).openRead();
        if (DatabaseAcces.getInstance(this).GetallCart().isEmpty()) {
            container_error.setVisibility(View.VISIBLE);
            cart_empty_error.setOnClickListener(v->{
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            });
            scroll.setVisibility(View.GONE);
        } else {
            container_error.setVisibility(View.GONE);
            scroll.setVisibility(View.VISIBLE);
        }
        DatabaseAcces.getInstance(this).close();

    }


    private void intlist() {
        DatabaseAcces.getInstance(this).openRead();
        if (DatabaseAcces.getInstance(this).GetallCart().isEmpty()) {
            container_error.setVisibility(View.VISIBLE);
            cart_empty_error.setOnClickListener(v->{
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            });
            scroll.setVisibility(View.GONE);
        } else {
            container_error.setVisibility(View.GONE);
            scroll.setVisibility(View.VISIBLE);
        }
        DatabaseAcces.getInstance(this).close();



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        rercyle_cart.setLayoutManager(layoutManager);
        DatabaseAcces.getInstance(this).openRead();
        cartAddapter = new CartAddapter(getApplicationContext(), DatabaseAcces.getInstance(this).GetallCart(), new ClickListner() {

            @Override
            public void onclick(View view, int position, boolean flag, Foods foods) {
                if (flag) {
                    if (foods != null) {
                        // plus
                        foods.setIncart(true);
                        foods.setNumberInCart(foods.getNumberInCart() + 1);
                        DatabaseAcces.getInstance(getApplicationContext()).openWrite();
                        DatabaseAcces.getInstance(getApplicationContext()).UpdateCart(foods);
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        calculateCart();
                        cartAddapter.notifyDataSetChanged();
                    }
                } else {
                    if (foods != null) {
                        //minus

                        foods.setNumberInCart(foods.getNumberInCart() - 1);
                        if (foods.getNumberInCart()==0) {
                            foods.setIncart(false);
                            foods.setNumberInCart(0);
                            DatabaseAcces.getInstance(getApplicationContext()).openWrite();
                            DatabaseAcces.getInstance(getApplicationContext()).DeleteCart(foods);
                            DatabaseAcces.getInstance(getApplicationContext()).close();
                            cartAddapter.Delete(foods);
                            calculateCart();
                            cartAddapter.notifyDataSetChanged();
                            //notifyItemRemoved(position): This tells the adapter that an item was removed at a specific position.
                            //notifyItemRangeChanged(position, itemCount): This tells the adapter that a range of items has changed, starting from position and spanning itemCount items.
                            //Let's say you have a list of items in a RecyclerView and you remove an item from position 2. You need to:
                            //
                            //Notify the adapter that an item was removed at position 2.
                            //Notify the adapter that all items from position 2 to the end of the list need to be updated because their positions have changed.
                        } else if (foods.getNumberInCart()>0){
                            foods.setIncart(true);
                            DatabaseAcces.getInstance(getApplicationContext()).openWrite();
                            DatabaseAcces.getInstance(getApplicationContext()).UpdateCart(foods);
                            DatabaseAcces.getInstance(getApplicationContext()).close();
                            calculateCart();
                            cartAddapter.notifyDataSetChanged();
                            //notifyItemChanged(position) is a method in the RecyclerView.Adapter class. It tells the adapter that an item at a specific position has changed and that it should update that item in the RecyclerView.
                            //has changed exple quntity increase
                            //Imagine you have a shopping cart with three items. Each item has a quantity and a total price. When you press the minus button to decrease the quantity of an item, you need to update the view to reflect the new quantity and price.
                            //
                            //Initial State:
                            //
                            //Item 1: Quantity = 2, Total Price = $20
                            //Item 2: Quantity = 1, Total Price = $10
                            //Item 3: Quantity = 3, Total Price = $30
                            //User Action:
                            //
                            //The user presses the minus button on Item 2.
                            //Data Update:
                            //
                            //The quantity of Item 2 is decreased by 1.
                            //New state:
                            //Item 1: Quantity = 2, Total Price = $20
                            //Item 2: Quantity = 0, Total Price = $0
                            //Item 3: Quantity = 3, Total Price = $30
                            //Notify Adapter:
                            //
                            //You call notifyItemChanged(position) where position is the index of Item 2.
                        }


                    }
                }
                MainActivity.notification(getApplicationContext());
                calculateCart();
                intl();
            }
        });
        DatabaseAcces.getInstance(this).close();
        rercyle_cart.setAdapter(cartAddapter);


        cartAddapter.setclick(new Clickevent() {
            @Override
            public void onclick(int id, Foods foods, int postion) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("id_food", foods.getId());
                if (foods != null) {
                    cartAddapter.notifyItemChanged(postion);
                    cartAddapter.notifyDataSetChanged();
                    activityResultLauncher.launch(intent);
                }
            }
        });
    }

    private void calculateCart() {

        double percenttax=0.2; //percent tax 2%
        tax=Math.round(DatabaseAcces.getInstance(this).getSubtotal()*percenttax*100.0)/100;

        double total=Math.round((DatabaseAcces.getInstance(this).getSubtotal()+tax+5)*100.0)/100;
        double itemtotal=Math.round(DatabaseAcces.getInstance(this).getSubtotal()*100)/100;

        delivery_value.setText("$"+5+"");
        totla_tax_vlaue.setText("$"+tax);
        totla_cart.setText("$"+total);
        subtotal_text.setText("$"+itemtotal);
        Carttext.setText("Cart("+DatabaseAcces.getInstance(this).getnumberofcartinallitem()+")");
    }

    private void setvariable() {
        back_btn_cart.setOnClickListener(v->{
            finish();
        });
    }


}