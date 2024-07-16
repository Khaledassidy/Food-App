package com.example.foodapp.Helper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.foodapp.Activity.DetailActivity;
import com.example.foodapp.Activity.MainActivity;
import com.example.foodapp.Adapter.CartAddapter;
import com.example.foodapp.CostumeClick.ClickListner;
import com.example.foodapp.Domain.Foods;

import java.util.ArrayList;

public class Cart {
    private static Cart instance;
    private static  ArrayList<Foods> arrayList;
    private static final double DELEVIRY_FEES=5.00;
    private int lastRemovedItemQuantity;
    private Foods lastRemovedItem;
    public  Cart(){
        arrayList=new ArrayList<>();
    }


    public static Cart getInstance() {
        if(instance==null){
            instance=new Cart();

        }
        return instance;
    }

    public  boolean  additem(Context context,Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity = DetailActivity.num;
                    existingitem.setNumberInCart(newQuantity);
                    Bundle bundle=new Bundle();
                    itemexist = true;
                    toast(context,newQuantity);
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(foods.getNumberInCart());
                arrayList.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem1(Context context,Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity = existingitem.getNumberInCart()+1;
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    toast(context,newQuantity);
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(foods.getNumberInCart());
                arrayList.add(foods);

            }

        }
        return itemexist;


    }

    public boolean deleteitem(Context context,Foods foods){
        boolean itemdelete=false;
        if (foods != null) {
            for (Foods existingItem : arrayList) {
                if (existingItem.getId() == foods.getId()) {
                    int newQuantity = existingItem.getNumberInCart() - 1;
                    existingItem.setNumberInCart(newQuantity);
                    if (foods.getNumberInCart() == 0) {
                        lastRemovedItem=existingItem;
                        lastRemovedItemQuantity=existingItem.getNumberInCart();
                        arrayList.remove(foods);
                        itemdelete=true;
                        foods.setNumberInCart(1);
                    }
                    break;
                }
            }



        }
        return itemdelete;

    }
    public boolean deleteitem1(Context context,Foods foods){
        boolean itemdelete=false;
        if (foods != null) {
            for (Foods existingItem : arrayList) {
                if (existingItem.getId() == foods.getId()) {
                    int newQuantity = existingItem.getNumberInCart();
                    existingItem.setNumberInCart(newQuantity);
                    lastRemovedItem=existingItem;
                    lastRemovedItemQuantity=existingItem.getNumberInCart();
                      arrayList.remove(existingItem);
                        itemdelete=true;
                    }
                    break;
                }
            }
        return itemdelete;





    }
    public void restoreLastRemovedItem() {
        if (lastRemovedItem != null) {
            lastRemovedItem.setNumberInCart(lastRemovedItemQuantity);
            arrayList.add(lastRemovedItem);
            lastRemovedItem = null;
        }
    }





    public  void toast(Context context,int quntity){
       Toast toast=new Toast(context);
       toast.setDuration(Toast.LENGTH_SHORT);
       toast.setText("Already Exist this item now you have "+quntity+" items from this");
       toast.show();
    }


    public ArrayList<Foods> getcartItem(){
        return arrayList;
    }

    public int size(){
        return arrayList.size();
    }

    public double getSubtotal(){
        double subtotal=0;
        for (Foods item:arrayList){
            subtotal+=item.getPrice()*item.getNumberInCart();
        }
        return subtotal;
    }
    public double gettotal(){
        return getSubtotal()+getdeliveryfees();
    }

    public double gettotalwithoutdelivery(){
        return getSubtotal();
    }

    public double getdeliveryfees(){
        return DELEVIRY_FEES;
    }

    public boolean isEmpty(){
        if(arrayList.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    public void clear(){
        arrayList.clear();
    }
}
