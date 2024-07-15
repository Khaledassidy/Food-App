package com.example.foodapp.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.Cart;
import com.example.foodapp.R;

public class CartActivity extends AppCompatActivity{

    ImageView back_btn_cart;
    TextView subtotal_text,delivery_value,totla_tax_vlaue,totla_cart,cart_empty_error;
    RecyclerView rercyle_cart;
    Button button_copon,place_order;
    EditText editTextText;
    double tax;
    NestedScrollView scroll;
    CartAddapter cartAddapter;
    ActivityResultLauncher<Intent> activityResultLauncher;


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
        cart_empty_error=findViewById(R.id.cart_empty_error);
        scroll=findViewById(R.id.scroll);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activityResultLauncher=registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode()==RESULT_OK){
                            intlist();
                            calculateCart();
                        }
                        else {
                            Log.d("naya","uiniin");

                        }
                        Log.d("naya","uiniin");


                    }
                }
        );
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        setvariable();
        calculateCart();
        intlist();
    }



    private void intlist() {
        if (Cart.getInstance().isEmpty()) {
            cart_empty_error.setVisibility(View.VISIBLE);
            scroll.setVisibility(View.GONE);
        } else {
            cart_empty_error.setVisibility(View.GONE);
            scroll.setVisibility(View.VISIBLE);
        }


            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
            rercyle_cart.setLayoutManager(layoutManager);
            cartAddapter = new CartAddapter(getApplicationContext(), Cart.getInstance().getcartItem(), new ClickListner() {
                @Override
                public void onclick(View view, int position, boolean flag, Foods foods) {
                    if (flag) { // plus
                        Cart.getInstance().additem(getApplicationContext(), foods);
                    } else { // minus
                        Cart.getInstance().deleteitem(getApplicationContext(), foods);
                    }
                    MainActivity.notification();
                    calculateCart();
                    cartAddapter.notifyItemChanged(position);
                }
            });
            rercyle_cart.setAdapter(cartAddapter);



        cartAddapter.setclick(new Clickevent() {
            @Override
            public void onclick(Foods foods, int position) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra("cart",foods);
                if (foods != null) {
                    activityResultLauncher.launch(intent);
                }
            }
        });
    }

    private void calculateCart() {

        double percenttax=0.2; //percent tax 2%
        tax=Math.round(Cart.getInstance().getSubtotal()*percenttax*100.0)/100;

        double total=Math.round((Cart.getInstance().getSubtotal()+tax+Cart.getInstance().getdeliveryfees())*100.0)/100;
        double itemtotal=Math.round(Cart.getInstance().getSubtotal()*100)/100;

        delivery_value.setText("$"+Cart.getInstance().getdeliveryfees()+"");
        totla_tax_vlaue.setText("$"+tax);
        totla_cart.setText("$"+total);
        subtotal_text.setText("$"+itemtotal);
    }

    private void setvariable() {
        back_btn_cart.setOnClickListener(v->{
            finish();
        });
    }




}