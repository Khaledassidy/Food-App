package com.example.foodapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.foodapp.Domain.Category;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Domain.Location;
import com.example.foodapp.Domain.Price;
import com.example.foodapp.Domain.Time;
import com.example.foodapp.R;

import java.util.ArrayList;

public class DatabaseAcces {
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;
    private static DatabaseAcces instance;


    private DatabaseAcces(Context context){
        this.openHelper=new Database(context);
    }

    public static DatabaseAcces getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAcces(context);
        }
        return instance;
    }

    public boolean openWrite(){
        this.database=this.openHelper.getWritableDatabase();
        return true;
    }
    public void openRead(){
        this.database=this.openHelper.getReadableDatabase();
    }

    public void close(){
        if(this.database!=null && openWrite()){
            this.database.close();
        }
    }

    public boolean InsertFood(Foods foods){
        ContentValues values=new ContentValues();
        values.put(Database.FOODS_TB_CategoryId,foods.getCategoryId());
        values.put(Database.FOODS_TB_Description,foods.getDescription());
        values.put(Database.FOODS_TB_Imagepath,foods.getImagepath());
        values.put(Database.FOODS_TB_Price,foods.getPrice());
        values.put(Database.FOODS_TB_Star,foods.getStar());
        values.put(Database.FOODS_TB_TimeValue,foods.getTimeValue());
        values.put(Database.FOODS_TB_Title,foods.getTitle());
        values.put(Database.FOODS_TB_incart,foods.isIncart());
        values.put(Database.FOODS_TB_numberInCart,foods.getNumberInCart());
        values.put(Database.FOODS_TB_LocationId,foods.getLocationId());
        values.put(Database.FOODS_TB_PriceId,foods.getPriceId());
        values.put(Database.FOODS_TB_TimeId,foods.getTimeId());
        values.put(Database.FOODS_TB_BESTFOOD,foods.isBestFood());
        long result=database.insert(Database.FOODS_TABLE_NAME,null,values);
        return result!=-1;
    }


    public boolean InsertCart(Foods foods){
        ContentValues values=new ContentValues();
        values.put(Database.CART_TB_CategoryId,foods.getCategoryId());
        values.put(Database.CART_TB_Description,foods.getDescription());
        values.put(Database.CART_TB_Imagepath,foods.getImagepath());
        values.put(Database.CART_TB_Price,foods.getPrice());
        values.put(Database.CART_TB_Star,foods.getStar());
        values.put(Database.CART_TB_TimeValue,foods.getTimeValue());
        values.put(Database.CART_TB_Title,foods.getTitle());
        values.put(Database.CART_TB_id,foods.getId());
        boolean incart=foods.isIncart();
        int y=0;
        if(incart){
            y=1;
        }else {
            y=0;
        }
        Log.d("khaledass",y+"");
        values.put(Database.CART_TB_incart,y);
        values.put(Database.CART_TB_numberInCart,foods.getNumberInCart());
        values.put(Database.CART_TB_LocationId,foods.getLocationId());
        values.put(Database.CART_TB_PriceId,foods.getPriceId());
        values.put(Database.CART_TB_TimeId,foods.getTimeId());
        int i=0;
        if(foods.isBestFood()==true){
            i=1;
        }else{
            i=0;
        }
        values.put(Database.CART_TB_BESTFOOD,i);
        long result=database.insert(Database.CART_TABLE_NAME,null,values);
        Log.d("khaledass",result+""+foods.getTitle());

        return result!=-1;
    }

    public boolean InsertCategory(Category category){
        ContentValues values=new ContentValues();
        values.put(Database.CATEGORY_TABLE_NAME,category.getName());
        values.put(Database.CATEGORY_TB_imagepath,category.getImagepath());
        long result=database.insert(Database.CATEGORY_TABLE_NAME,null,values);
        return result!=-1;
    }

    public boolean InsertTime(Time time){
        ContentValues values=new ContentValues();
        values.put(Database.TIME_TB_VALUE,time.getValue());
        long result=database.insert(Database.TIME_TABLE_NAME,null,values);
        return result!=-1;
    }

    public boolean InsertLocation(Location location){
        ContentValues values=new ContentValues();
        values.put(Database.LOCATION_TB_LOCATION,location.getLoc());
        long result=database.insert(Database.LOCATION_TABLE_NAME,null,values);
        return result!=-1;
    }


    public boolean InsertPrice(Price price){
        ContentValues values=new ContentValues();
        values.put(Database.PRICE_TB_VALUE,price.getValue());
        long result=database.insert(Database.PRICE_TABLE_NAME,null,values);
        return result!=-1;
    }

    public boolean UpdateFood(Foods foods){
        ContentValues values=new ContentValues();
        values.put(Database.FOODS_TB_CategoryId,foods.getCategoryId());
        values.put(Database.FOODS_TB_Description,foods.getDescription());
        values.put(Database.FOODS_TB_Imagepath,foods.getImagepath());
        values.put(Database.FOODS_TB_Price,foods.getPrice());
        values.put(Database.FOODS_TB_Star,foods.getStar());
        values.put(Database.FOODS_TB_TimeValue,foods.getTimeValue());
        values.put(Database.FOODS_TB_Title,foods.getTitle());
        values.put(Database.FOODS_TB_incart,foods.isIncart());
        values.put(Database.FOODS_TB_numberInCart,foods.getNumberInCart());
        values.put(Database.FOODS_TB_LocationId,foods.getLocationId());
        values.put(Database.FOODS_TB_PriceId,foods.getPriceId());
        values.put(Database.FOODS_TB_TimeId,foods.getTimeId());
        values.put(Database.FOODS_TB_BESTFOOD,foods.isBestFood());
        String[] args={String.valueOf(foods.getId())};
        long result=database.update(Database.FOODS_TABLE_NAME,values,"id=?",args);
        return result>0;
    }

    public boolean UpdateCart(Foods foods){
        ContentValues values=new ContentValues();
        values.put(Database.CART_TB_CategoryId,foods.getCategoryId());
        values.put(Database.CART_TB_Description,foods.getDescription());
        values.put(Database.CART_TB_Imagepath,foods.getImagepath());
        values.put(Database.CART_TB_Price,foods.getPrice());
        values.put(Database.CART_TB_Star,foods.getStar());
        values.put(Database.CART_TB_TimeValue,foods.getTimeValue());
        values.put(Database.CART_TB_Title,foods.getTitle());
        values.put(Database.CART_TB_incart,foods.isIncart());
        values.put(Database.CART_TB_numberInCart,foods.getNumberInCart());
        values.put(Database.CART_TB_LocationId,foods.getLocationId());
        values.put(Database.CART_TB_PriceId,foods.getPriceId());
        values.put(Database.CART_TB_TimeId,foods.getTimeId());
        values.put(Database.CART_TB_BESTFOOD,foods.isBestFood());

        String [] args={String.valueOf(foods.getId())};
        long result=database.update(Database.CART_TABLE_NAME,values,"id=?",args);
        return result!=-1;
    }

    public boolean UpdateCategory(Category category){
        ContentValues values=new ContentValues();
        values.put(Database.CATEGORY_TABLE_NAME,category.getName());
        values.put(Database.CATEGORY_TB_imagepath,category.getImagepath());
        String [] args={String.valueOf(category.getId())};
        long result=database.update(Database.CATEGORY_TABLE_NAME,values,"id=?",args);
        return result!=-1;
    }

    public boolean UpdateTime(Time time){
        ContentValues values=new ContentValues();
        values.put(Database.TIME_TB_VALUE,time.getValue());
        String [] args={String.valueOf(time.getId())};
        long result=database.update(Database.TIME_TABLE_NAME,values,"id=?",args);
        return result!=-1;
    }

    public boolean UpdateLocation(Location location){
        ContentValues values=new ContentValues();
        values.put(Database.LOCATION_TB_LOCATION,location.getLoc());
        String[] args={String.valueOf(location.getId())};
        long result=database.update(Database.LOCATION_TABLE_NAME,values,"id=?",args);
        return result!=-1;
    }


    public boolean UpdatePrice(Price price){
        ContentValues values=new ContentValues();
        values.put(Database.PRICE_TB_VALUE,price.getValue());
        String[] args={String.valueOf(price.getId())};
        long result=database.update(Database.PRICE_TABLE_NAME,values,"id=?",args);
        return result!=-1;
    }

    public long getFoodCount(){
        return DatabaseUtils.queryNumEntries(database,Database.FOODS_TABLE_NAME);
    }
    public long getCartCount(){
        return DatabaseUtils.queryNumEntries(database,Database.CART_TABLE_NAME);
    }
    public long getCategoryCount(){
        return DatabaseUtils.queryNumEntries(database,Database.CATEGORY_TABLE_NAME);
    }
    public long getTimeCount(){
        return DatabaseUtils.queryNumEntries(database,Database.TIME_TABLE_NAME);
    }
    public long getLocationCount(){
        return DatabaseUtils.queryNumEntries(database,Database.LOCATION_TABLE_NAME);
    }
    public long getPriceCount(){
        return DatabaseUtils.queryNumEntries(database,Database.PRICE_TABLE_NAME);
    }
    public boolean DeleteFood(Foods foods){
        String[] args={String.valueOf(foods.getId())};
        int result=database.delete(Database.FOODS_TABLE_NAME,"id=?",args);
        return result>0;
    }
    public boolean DeleteCart(Foods foods){
        String[] args={String.valueOf(foods.getId())};
        int result=database.delete(Database.CART_TABLE_NAME,"id=?",args);
        return result>0;
    }

    public boolean DeleteCategory(Category category){
        String[] args={String.valueOf(category.getId())};
        int result=database.delete(Database.CATEGORY_TABLE_NAME,"id=?",args);
        return result>0;
    }

    public boolean DeleteTime(Time time){
        String[] args={String.valueOf(time.getId())};
        int result=database.delete(Database.TIME_TABLE_NAME,"id=?",args);
        return result>0;
    }

    public boolean DeleteLocation(Location location){
        String[] args={String.valueOf(location.getId())};
        int result=database.delete(Database.LOCATION_TABLE_NAME,"id=?",args);
        return result>0;
    }

    public boolean DeletePrice(Price price){
        String[] args={String.valueOf(price.getId())};
        int result=database.delete(Database.PRICE_TABLE_NAME,"id=?",args);
        return result>0;
    }

    public ArrayList<Foods> GetallFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                Log.d("maya",title);

                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }


        return foods;
    }

    public ArrayList<Foods> GetallCart(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.CART_TABLE_NAME,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.CART_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.CART_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.CART_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.CART_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.CART_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_BESTFOOD));
                Log.d("khaledass",title);
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Category> GetallCategory(){
        ArrayList<Category> category=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.CATEGORY_TABLE_NAME,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CATEGORY_TB_ID));
                String name_category=cursor.getString(cursor.getColumnIndexOrThrow(Database.CATEGORY_TB_NAME));
                String image_category=cursor.getString(cursor.getColumnIndexOrThrow(Database.CATEGORY_TB_imagepath));
                Category category1=new Category(Category_id, image_category,name_category);
                category.add(category1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return category;
    }

    public ArrayList<Time> GetallTime(){
        ArrayList<Time> time=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.TIME_TABLE_NAME,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int Time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.TIME_TB_ID));
                String value=cursor.getString(cursor.getColumnIndexOrThrow(Database.TIME_TB_VALUE));
                Time time1=new Time(Time_id,value+" min");
                time.add(time1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return time;
    }

    public ArrayList<Location> GetallLocation(){
        ArrayList<Location> locations=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.LOCATION_TABLE_NAME,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.LOCATION_TB_ID));
                String value=cursor.getString(cursor.getColumnIndexOrThrow(Database.LOCATION_TB_LOCATION));
                Location location=new Location(location_id,value);
                locations.add(location);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return locations;
    }

    public ArrayList<Price> GetallPrice(){
        ArrayList<Price> prices=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.PRICE_TABLE_NAME,null);
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.PRICE_TB_ID));
                String value=cursor.getString(cursor.getColumnIndexOrThrow(Database.PRICE_TB_VALUE));
                Price price=new Price(price_id,"$"+value+"$");
                prices.add(price);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return prices;
    }

    public ArrayList<Foods> SearchFoodTitle(String modelSearch){
        ArrayList<Foods> foods=new ArrayList<>();
        Foods foods1;
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_Title+" LIKE ?",new String[]{"%"+modelSearch+"%"});
        if(cursor!=null && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }
                Cursor cursor1=database.rawQuery("SELECT * FROM "+Database.CART_TABLE_NAME+" WHERE "+Database.CART_TB_Title+" LIKE ?",new String[]{"%"+modelSearch+"%"});
                if(cursor1!=null  && cursor1.moveToFirst()) {
                    do {
                        int numberincart = cursor1.getInt(cursor1.getColumnIndexOrThrow(Database.CART_TB_numberInCart));
                        incart = cursor1.getInt(cursor1.getColumnIndexOrThrow(Database.CART_TB_incart));
                        if (incart == 1) {
                            incart1 = true;
                        } else {
                            incart1 = false;
                        }
                        foods1 = new Foods(Category_id, description, image_path, price, star, time_value, title, incart1, numberincart, id, location_id, price_id, time_id, bestfood1);
                        foods.add(foods1);

                        cursor1.close();
                    }while (cursor1.moveToNext());
                }else{
                    foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                    foods.add(foods1);


                }


            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;


    }

    public ArrayList<Foods> GetHalfBestFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor1=database.rawQuery("SELECT COUNT(*) FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_BESTFOOD+" = ?",new String[]{String.valueOf(1)});
        int count=0;
        if (cursor1 != null && cursor1.moveToFirst()) {
            count = cursor1.getInt(0);
            cursor1.close();
        }
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_BESTFOOD+" = ?"+" LIMIT ?",new String[]{String.valueOf(1),String.valueOf(count/2)});
        if(cursor!=null && cursor1!=null && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetBestFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_BESTFOOD+" = ?",new String[]{String.valueOf(1)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        Log.d("lion",foods.size()+"");
        return foods;
    }

    public ArrayList<Foods> GetPizzaFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(0)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetBurgerFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(1)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetChickenFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(2)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetSuchiFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(3)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetMeatFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(4)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetHotdogFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(5)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetDrinkFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(6)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public ArrayList<Foods> GetMoreFoods(){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(8)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }


    public ArrayList<Foods> GetCategoryFoods(int postion){
        ArrayList<Foods> foods=new ArrayList<>();
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(postion)});
        if(cursor!=null  && cursor.moveToFirst()){
            do {
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.CART_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    incart1=false;
                }

                Foods foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);
                foods.add(foods1);

            }while (cursor.moveToNext());
            cursor.close();
        }
        return foods;
    }

    public Foods FetchFoods(int food_id){
        Foods foods1=null;
        Cursor cursor=database.rawQuery("SELECT * FROM "+Database.FOODS_TABLE_NAME+" WHERE "+Database.FOODS_TB_id+" = ?",new String[]{String.valueOf(food_id)});
        if(cursor!=null  && cursor.moveToFirst()){
            Log.d("alihhh","hi");
                int Category_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_CategoryId));
                String description=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Description));
                String image_path=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Imagepath));
                double price=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Price));
                double star=cursor.getDouble(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Star));
                int time_value=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeValue));
                String title=cursor.getString(cursor.getColumnIndexOrThrow(Database.FOODS_TB_Title));
                int incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_incart));
                boolean incart1=false;
                if(incart==1){
                    incart1=true;
                }
                else{
                    incart1=false;
                }
                int number_incart=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_numberInCart));
                int id =cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_id));
                int location_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_LocationId));
                int price_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_PriceId));
                int time_id=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_TimeId));
                int bestfood=cursor.getInt(cursor.getColumnIndexOrThrow(Database.FOODS_TB_BESTFOOD));
                boolean bestfood1=false;
                if(bestfood==1){
                    bestfood1=true;
                }
                else{
                    bestfood1=false;
                }

                     Cursor cursor1=database.rawQuery("SELECT * FROM "+Database.CART_TABLE_NAME+" WHERE "+Database.CART_TB_id+" = ?",new String[]{String.valueOf(food_id)});
                    if(cursor1!=null  && cursor1.moveToFirst()) {
                        int numberincart = cursor1.getInt(cursor1.getColumnIndexOrThrow(Database.CART_TB_numberInCart));
                        incart=cursor1.getInt(cursor1.getColumnIndexOrThrow(Database.CART_TB_incart));
                        if(incart==1){
                            incart1=true;
                        }
                        else{
                            incart1=false;
                        }
                        foods1 = new Foods(Category_id, description, image_path, price, star, time_value, title, incart1, numberincart, id, location_id, price_id, time_id, bestfood1);
                        cursor1.close();
                    }else{
                        foods1=new Foods(Category_id,description,image_path,price,star,time_value,title,incart1,number_incart,id,location_id,price_id,time_id,bestfood1);

                    }




               Log.d("khaledass",incart1+"");



            cursor.close();


        }
        Log.d("alisss",foods1.getTitle());
        return foods1;
    }

    public double getSubtotal(){
        double subtotal=0;
        openRead();
        ArrayList<Foods> arrayList=GetallCart();
        close();
        for (Foods item:arrayList){
            subtotal+=item.getPrice()*item.getNumberInCart();
        }
        return subtotal;
    }

    public int getnumberofcartinallitem(){
        int x=0;
        openRead();
        ArrayList<Foods> arrayList=GetallCart();
        close();
        for (Foods item:arrayList){
            x+=item.getNumberInCart();
        }
        return x;
    }

    public String GetCategoryformid(int id){
        String name=null;
        Cursor cursor=database.rawQuery("SELECT "+Database.CATEGORY_TB_NAME +" FROM " + Database.CATEGORY_TABLE_NAME+" JOIN "+Database.FOODS_TABLE_NAME+" ON "+Database.CATEGORY_TB_ID+"="+Database.FOODS_TB_CategoryId+" WHERE "+Database.FOODS_TB_CategoryId+" = ?",new String[]{String.valueOf(id)});
        if(cursor!=null && cursor.moveToFirst()){

                String name_category=cursor.getString(cursor.getColumnIndexOrThrow(Database.CATEGORY_TB_NAME));
                Log.d("khaledassidi",name_category+"");
                name=name_category;

        }
        cursor.close();

        return name;
    }

    //insert into food table mn 5elel l content provider
    public long insertprovider(ContentValues contentValues){
       return database.insert(Database.FOODS_TABLE_NAME,null,contentValues);


    }
    //update into food table mn 5elel l content provider
    public int updateprovider(ContentValues contentValues,String s,String[] strings){
        return database.update(Database.FOODS_TABLE_NAME,contentValues,s,strings);


    }

    public int Deleteprovider(String whereClause,String[] whereValues){
        return database.delete(Database.FOODS_TABLE_NAME,whereClause,whereValues);

    }

    public Cursor getCursorForAllFood(){
        Cursor cursor=database.query(Database.FOODS_TABLE_NAME,new String[]{Database.FOODS_TB_CategoryId,Database.FOODS_TB_Description,Database.FOODS_TB_Imagepath,Database.FOODS_TB_Price,Database.FOODS_TB_Star,Database.FOODS_TB_TimeValue,Database.FOODS_TB_Title,Database.FOODS_TB_incart,Database.FOODS_TB_numberInCart,Database.FOODS_TB_id,Database.FOODS_TB_LocationId,Database.FOODS_TB_PriceId,Database.FOODS_TB_TimeId,Database.FOODS_TB_BESTFOOD},null,null,null,null,null);
        return cursor;
    }

    public Cursor getCursorForSpecificPlace(int id_category){
        Cursor cursor=database.query(Database.FOODS_TABLE_NAME,new String[]{Database.FOODS_TB_CategoryId,Database.FOODS_TB_Description,Database.FOODS_TB_Imagepath,Database.FOODS_TB_Price,Database.FOODS_TB_Star,Database.FOODS_TB_TimeValue,Database.FOODS_TB_Title,Database.FOODS_TB_incart,Database.FOODS_TB_numberInCart,Database.FOODS_TB_id,Database.FOODS_TB_LocationId,Database.FOODS_TB_PriceId,Database.FOODS_TB_TimeId,Database.FOODS_TB_BESTFOOD},Database.FOODS_TB_CategoryId+" =?",new String[]{String.valueOf(id_category)},null,null,null);
        return cursor;
    }

    public Cursor getCursorCount(){
        Cursor cursor=database.rawQuery("SELECT COUNT(*) FROM "+Database.FOODS_TABLE_NAME,null);
        return cursor;
    }





















}
