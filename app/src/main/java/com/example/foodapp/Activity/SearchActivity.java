package com.example.foodapp.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.Adapter.CategoryAddapter;
import com.example.foodapp.Adapter.SearchAddapter;
import com.example.foodapp.Database.DatabaseAcces;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    TextView textView;
    SearchAddapter searchAddapter;
    CategoryAddapter categoryAddapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        toolbar = findViewById(R.id.toolbar_search);
        recyclerView = findViewById(R.id.rec_search);
        textView = findViewById(R.id.number_search);
        toolbar.setBackgroundResource(R.color.white);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView.setText("Get Inspired");
        DatabaseAcces.getInstance(getApplicationContext()).openRead();

        DatabaseAcces.getInstance(this).openWrite();
        categoryAddapter=new CategoryAddapter(DatabaseAcces.getInstance(this).GetallCategory());

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),4);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoryAddapter);
        DatabaseAcces.getInstance(getApplicationContext()).close();




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menue3,menu);
        //l mafroud na3mel inflate la search view le mawjoude bel menue w ba3da 2a3ml action elo iza l user katab kaza 3meel kaza
        //keef bade 2osal la heda l 3onsour l esmo search view:
        //SearchView searchView;
        //keef bade 2osalo la heda l 3onosur findview by id wala keef ana bade 2a3ml inflate la 3nosour bel meneue
        //bjeeb l menue le mawjoud 3lee heda l 3osnour l search view
        //ma3mel menue dot fee she 3ana esmo finditem() berou7 byeb7as 3an l item le bade yeh bt3te l id taelo bde5el l menue ra2ese
        //SearchView searchView=menu.findItem(R.id.main_search) hay la7ala btjble btrou7 btjeeb l 3onour le howe search view le bel menue  ;

        //ba3den b2olo getactionview ya3ne rou7 jeble l action view l 5asa bel item l esmo mainsearch
        //sho l action view howe 3ebra 3an class berou7 bjeblak mo2sher 3lee lal heda l class le esmo getactionview bas badak ta3mel casting 3lee l2no houn byerj3lak view ma bya3ref eno heda search view l2no hay l method getActionView() btrjelak view
//        SearchView searchView= (SearchView) menu.findItem(R.id.main_search).getActionView();

        //haal2 sar feek tet3mela ma3 l search view seton click listnerr ..etc
        //fe method b2albo esma setsubmitbuttonenabled: bte5od true 2aw false ya3ne hal badak tfa3el zeer submit zer l ersel bhay l 7ale btl3lak sehm z8eer 7ed search view iza da8t 3lee berou7 bya3mel search
//        searchView.setSubmitButtonEnabled(true);
        //ya3ne heda l zer bas tokbous 3lee byefham eno enta kabst 3ala submit button lesh ana bade 2a3ml search 5elel ma howe byoktob w 2aw2at badak ya3mel search bas yokbous kame 3ala l button lesh l2no search 5elel 3amlyet l ketebe byo5od johd kteer l2no 7a tetar kel 3mlyet ketebe trou7 teb7as bel databse kel ma l user yoktob 7arf yrou7 ya3mel search bel databse 2aw yemken ykoun online databse byo5od johd kteer fa enta yemekn badak ya3mel search bas yokbous 3ala hay l button bas enta hala2 3andak 5eyaren ya bas yokbous ya bas bas yoktob
        //bade 2a3ml listner hla2 3ala hay l button
//        searchView.setOnQueryTextListener();:
//        searchView.setOnSearchClickListener();:
//        searchView.setOnSuggestionListener();:
//        searchView.setOnQueryTextFocusChangeListener(); lama yet8ayar l focus 3an l 3osnour nafso
//       haw koloun listner bte2dar test3mleoun ma3 search view

        //fe 3ande 2 function l function l2ola lama l user yokbous 3ala zer submit
        //function tenye l user howe w byektob 3ala search view btetnfaz
        // query ma3neta este3lem setOnQueryTextListener l nous le enta btektobo bel search view howe query este3mel fa houn be2olak bhay lama nous l este3mel listner 3ala l nous l este3lem ya3ne badak ta3mel listner 3ala nous le bekoun de5el l este3lem le howe l search view
        //onQueryTextSubmit:btestd3a lama l user yokbous submit byeb3tlk l string le howe l nous le katabo bel search view
        //onQueryTextChange:hay btestd3a kel ma l user y8ayer nous le bel este3lem ya3ne 5elel 3mlyet l ketebe w byeb3lak l string l howe l nous le maktob bel search view
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });

        //fe 3ande listner tene:
//        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//            @Override
//            public boolean onClose() {
//                return false;
//                //btetstd3a lama enta tekbous 3ala zer l close
//                //btetafed mena ftered enta katabt she w 3meel search fa 3ardlk le badak yeh mafroud ana bas erja3 2a3ml close yrje3lk 3ala item le keno l 2asaseyen heeek btestafed meno
//            }
//        });

//        searchView.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //hal lama ta3mel click 3ala icon search
//
//            }
//        });

        searchView = (SearchView) menu.findItem(R.id.search_search).getActionView();
        searchView.setSubmitButtonEnabled(true);
        searchView.setIconifiedByDefault(false);// Prevent collapsing
        searchView.setIconified(false);
        searchView.onActionViewExpanded();// Force expansion
        searchView.setBackgroundResource(R.color.white);




        //get edittext inside searchview
        EditText searchedittext=(EditText)searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchedittext.setHint("Search in all...");
        searchedittext.setHintTextColor(getResources().getColor(R.color.blue_grey));
        searchedittext.setTextColor(getResources().getColor(R.color.blue_grey));

        ImageView closeButton = (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_close_btn);
        closeButton.setColorFilter(ContextCompat.getColor(this,R.color.orange));

        ImageView search_button= (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_go_btn);
        search_button.setColorFilter(ContextCompat.getColor(this,R.color.orange));

        ImageView search= (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_mag_icon);
        search.setColorFilter(ContextCompat.getColor(this,R.color.orange));

        ImageView button= (ImageView) searchView.findViewById(androidx.appcompat.R.id.search_voice_btn);
        button.setColorFilter(ContextCompat.getColor(this,R.color.orange));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                DatabaseAcces.getInstance(getApplicationContext()).openRead();
                ArrayList<Foods> arrayList= DatabaseAcces.getInstance(getApplicationContext()).SearchFoodTitle(query);
                DatabaseAcces.getInstance(getApplicationContext()).close();
                searchAddapter=new SearchAddapter(arrayList);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(searchAddapter);
                textView.setText(arrayList.size()+" result for"+"''"+query+"''");

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()>0) {
                    if(newText.equals("pizza")){
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetPizzaFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;
                        
                    } else if (newText.equals("burger")) {
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetBurgerFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;
                        
                    } else if (newText.equals("meat")) {
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetMeatFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;
                        
                    } else if (newText.equals("suchi")) {
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetSuchiFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;

                    } else if (newText.equals("hotdog")) {
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetHotdogFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;

                    } else if (newText.equals("chicken")) {
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetChickenFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;

                    } else if (newText.equals("drink")) {
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetDrinkFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;

                    } else if (newText.equals("best food")) {
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).GetBestFoods();
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;
                    } else{
                        DatabaseAcces.getInstance(getApplicationContext()).openRead();
                        ArrayList<Foods> arrayList = DatabaseAcces.getInstance(getApplicationContext()).SearchFoodTitle(newText);
                        DatabaseAcces.getInstance(getApplicationContext()).close();
                        searchAddapter = new SearchAddapter(arrayList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(searchAddapter);
                        textView.setText(arrayList.size()+" result for"+"''"+newText+"''");
                        return true;
                    }


                } else if (newText.length()==0) {
                    DatabaseAcces.getInstance(getApplicationContext()).openRead();

                    DatabaseAcces.getInstance(getApplicationContext()).openWrite();
                    categoryAddapter=new CategoryAddapter(DatabaseAcces.getInstance(getApplicationContext()).GetallCategory());

                    RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),4);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(categoryAddapter);
                    DatabaseAcces.getInstance(getApplicationContext()).close();
                    textView.setText("Get Inspired");
                    return true;
                }
                return false;

            }
        });
       closeButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               searchView.setQuery("",false);
               DatabaseAcces.getInstance(getApplicationContext()).openRead();

               DatabaseAcces.getInstance(getApplicationContext()).openWrite();
               categoryAddapter=new CategoryAddapter(DatabaseAcces.getInstance(getApplicationContext()).GetallCategory());

               RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),4);
               recyclerView.setLayoutManager(layoutManager);
               recyclerView.setAdapter(categoryAddapter);
               DatabaseAcces.getInstance(getApplicationContext()).close();
               textView.setText("Get Inspired");

               
           }
       });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return false;
    }
}