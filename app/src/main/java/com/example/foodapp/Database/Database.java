package com.example.foodapp.Database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class Database extends SQLiteAssetHelper {
    public static final String DB_NAME="Food.db";
    public static final int DB_VERSION=1;

    public static final String FOODS_TABLE_NAME="Foods";
    public static final String CATEGORY_TABLE_NAME="Category";
    public static final String CART_TABLE_NAME="Cart";
    public static final String TIME_TABLE_NAME="Time";
    public static final String LOCATION_TABLE_NAME="Location";
    public static final String PRICE_TABLE_NAME="PRICE";



    public static final String FOODS_TB_CategoryId="CategoryId";
    public static final String FOODS_TB_Description="Description";
    public static final String FOODS_TB_Imagepath="Imagepath";
    public static final String FOODS_TB_Price="Price";
    public static final String FOODS_TB_Star="Star";
    public static final String FOODS_TB_TimeValue="TimeValue";
    public static final String FOODS_TB_Title="Title";
    public static final String FOODS_TB_incart="incart";
    public static final String FOODS_TB_numberInCart="numberInCart";
    public static final String FOODS_TB_id="id";
    public static final String FOODS_TB_LocationId="LocationId";
    public static final String FOODS_TB_PriceId="PriceId";
    public static final String FOODS_TB_TimeId="TimeId";
    public static final String FOODS_TB_BESTFOOD="bestfood";

    public static final String CATEGORY_TB_ID="id_category";
    public static final String CATEGORY_TB_NAME="name";
    public static final String CATEGORY_TB_imagepath="imagepath";

    public static final String LOCATION_TB_ID="id";
    public static final String LOCATION_TB_LOCATION="location";


    public static final String TIME_TB_ID="id";
    public static final String TIME_TB_VALUE="Value";

    public static final String PRICE_TB_ID="id";
    public static final String PRICE_TB_VALUE="Value";

    public static final String CART_TB_CategoryId="CategoryId";
    public static final String CART_TB_Description="Description";
    public static final String CART_TB_Imagepath="Imagepath";
    public static final String CART_TB_Price="Price";
    public static final String CART_TB_Star="Star";
    public static final String CART_TB_TimeValue="TimeValue";
    public static final String CART_TB_Title="Title";
    public static final String CART_TB_incart="incart";
    public static final String CART_TB_numberInCart="numberInCart";
    public static final String CART_TB_id="id";
    public static final String CART_TB_LocationId="LocationId";
    public static final String CART_TB_PriceId="PriceId";
    public static final String CART_TB_TimeId="TimeId";
    public static final String CART_TB_BESTFOOD="bestfood";


    public Database(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }







}
