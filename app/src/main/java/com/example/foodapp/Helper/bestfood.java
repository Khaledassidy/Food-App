package com.example.foodapp.Helper;

import android.content.Context;

import com.example.foodapp.Domain.Foods;

import java.util.ArrayList;

public class bestfood {
    private static bestfood instance;
    private static  ArrayList<Foods> arrayList;
    private static  ArrayList<Foods> arrayList_temporary;
    private static  ArrayList<Foods> arrayList_seeall;
    private static  ArrayList<Foods> arrayList_pizza;
    private static  ArrayList<Foods> arrayList_burger;
    private static  ArrayList<Foods> arrayList_hotdog;
    private static  ArrayList<Foods> arrayList_suchi;
    private static  ArrayList<Foods> arrayList_meat;
    private static  ArrayList<Foods> arrayList_chicken;
    private static  ArrayList<Foods> arrayList_more;
    Context context;
    int postion;
    public static int x=0;
    public bestfood(){
        arrayList=new ArrayList<>();
        arrayList_temporary=new ArrayList<>();
        arrayList_seeall=new ArrayList<>();
        arrayList_pizza=new ArrayList<>();
        arrayList_burger=new ArrayList<>();
        arrayList_hotdog=new ArrayList<>();
        arrayList_suchi=new ArrayList<>();
        arrayList_meat=new ArrayList<>();
        arrayList_chicken=new ArrayList<>();
        arrayList_more=new ArrayList<>();
    }

    public  boolean  additem1( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem3( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_seeall){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_seeall.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem2( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_temporary){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_temporary.add(foods);

            }

        }
        return itemexist;


    } public  boolean  setrue( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_temporary){
                if(existingitem.getId()==foods.getId()){
                    foods.setIncart(true);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setIncart(true);

            }

        }
        return itemexist;


    }public  boolean  sefalse( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_temporary){
                if(existingitem.getId()==foods.getId()){
                    foods.setIncart(false);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setIncart(false);

            }

        }
        return itemexist;


    }public  boolean  additem4( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_pizza){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_pizza.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem5( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_burger){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_burger.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem6( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_hotdog){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_hotdog.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem7( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_meat){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_meat.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem8( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_chicken){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_chicken.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem9( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_suchi){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_suchi.add(foods);

            }

        }
        return itemexist;


    }
    public  boolean  additem10( Foods foods){
        boolean itemexist=false;
        if(foods!=null){
            for (Foods existingitem:arrayList_more){
                if(existingitem.getId()==foods.getId()){
                    int newQuantity= foods.getNumberInCart();
                    existingitem.setNumberInCart(newQuantity);
                    itemexist = true;
                    break;
                }
            }
            if(!itemexist){
                foods.setNumberInCart(1);
                arrayList_more.add(foods);

            }

        }
        return itemexist;


    }


    public boolean deleteitem(Foods foods){
        boolean itemdelete=false;
        if (foods != null) {
            for (Foods existingItem : arrayList) {
                if (existingItem.getId() == foods.getId()) {
                    int newQuantity = foods.getNumberInCart();
                    existingItem.setNumberInCart(newQuantity);
                    if (existingItem.getNumberInCart() == 0) {
                        itemdelete=true;
                        foods.setNumberInCart(1);
                    }
                    break;
                }
            }



        }
        return itemdelete;

    }
public boolean deleteitem1(Foods foods){
        boolean itemdelete=false;
        if (foods != null) {
            for (Foods existingItem : arrayList_temporary) {
                if (existingItem.getId() == foods.getId()) {
                    int newQuantity = foods.getNumberInCart();
                    existingItem.setNumberInCart(newQuantity);
                    if (existingItem.getNumberInCart() == 0) {
                        Cart.getInstance().deleteitem(context,foods);
                        itemdelete=true;
                        foods.setNumberInCart(1);
                    }
                    break;
                }
            }



        }
        return itemdelete;

    }



    public static bestfood getInstance() {
        if(instance==null){
            instance=new bestfood();

        }
        return instance;
    }






    public ArrayList<Foods> getorginalfoodItem(){
        return arrayList;
    }
    public ArrayList<Foods> getseeallItem(){
        return arrayList_seeall;
    }
    public ArrayList<Foods> getorginalfoodpizza(){
        return arrayList_pizza;
    }
    public ArrayList<Foods> getseeallfoodItem(){
        return arrayList_seeall;
    }
    public ArrayList<Foods> gettemporaryfoodItem(){
        return arrayList_temporary;
    }
    public ArrayList<Foods> getburgerfoodItem(){
        return arrayList_burger;
    }
    public ArrayList<Foods> gethotdogfoodItem(){
        return arrayList_hotdog;
    }
    public ArrayList<Foods> getchickenfoodItem(){
        return arrayList_chicken;
    }
    public ArrayList<Foods> getmeatfoodItem(){
        return arrayList_meat;
    }
    public ArrayList<Foods> getmorefoodItem(){
        return arrayList_more;
    }
    public ArrayList<Foods> getsuchifoodItem(){
        return arrayList_suchi;
    }

    public int size(){
        return arrayList.size();
    }
    public int size1(){
        return arrayList_temporary.size();
    }

    public boolean isEmpty(){
        if(arrayList.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    } public boolean isEmpty1(){
        if(arrayList_temporary.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    public void clear(){
        arrayList.clear();
    }
    public void clear1(){
        arrayList_temporary.clear();
    }
}
