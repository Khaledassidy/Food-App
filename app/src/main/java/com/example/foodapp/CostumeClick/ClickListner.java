package com.example.foodapp.CostumeClick;

import android.view.View;

import com.example.foodapp.Domain.Foods;

public interface ClickListner {
     void onclick(View view,int position,boolean flag,Foods foods);
}
