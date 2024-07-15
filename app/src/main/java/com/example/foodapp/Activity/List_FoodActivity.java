package com.example.foodapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.foodapp.Adapter.Food_list_Adapter;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.R;

import java.util.ArrayList;

public class List_FoodActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView textView;
    ImageView imageView;
    int position=0;
    String name="";
    Food_list_Adapter foodListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);
        recyclerView=findViewById(R.id.food_list_view);
        imageView=findViewById(R.id.bak_btn);
        textView=findViewById(R.id.title_text);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        getintent();
        getint();
        getbestfood();



    }



    private void getbestfood() {
        Intent intent=getIntent();
        if(intent!=null) {
            ArrayList<Foods> bestfood = (ArrayList<Foods>) intent.getSerializableExtra("bestfood");
            foodListAdapter = new Food_list_Adapter(bestfood);
            if(bestfood!=null) {
                Foods foods1_more = new Foods(0, "Pasta Carbonara is a rich Italian dish made with spaghetti or fettuccine, tossed in a creamy sauce of eggs, Pecorino Romano cheese, and crispy pancetta. The heat of the pasta lightly cooks the eggs, creating a silky texture that clings to each strand. Traditionally seasoned with black pepper, this dish offers a comforting blend of flavors that is both indulgent and satisfying. Perfect for a quick weeknight dinner or a special occasion!", true, 46, 0, 16.99, R.drawable.pastacarbonara, 0, 3.5, 0, 10, "Pasta Carbonara", 1);
                Foods foods2_more = new Foods(0, "The Quinoa Salad Bowl is a nutritious and vibrant dish, featuring a base of fluffy quinoa mixed with a colorful array of fresh vegetables such as cherry tomatoes, cucumbers, bell peppers, and red onions. Tossed with leafy greens like spinach or arugula, it’s enhanced with a tangy lemon vinaigrette. Topped with creamy avocado slices and a sprinkle of feta cheese or nuts, this salad is a wholesome, protein-packed option perfect for a light lunch or dinner.", true, 0, 0, 10.99, R.drawable.quinoasaladbowl, 0, 3.5, 0, 10, "Quinoa Saladbowl", 1);
                Foods foods1_chicken = new Foods(0, "Garlic Parmesan Chicken is a savory and satisfying dish featuring tender chicken breasts coated in a flavorful blend of garlic, grated Parmesan cheese, and herbs. Baked until golden and crispy, the chicken is juicy and infused with rich, aromatic flavors. This delectable dish is perfect as a main course, served with a side of steamed vegetables or a fresh garden salad. Each bite offers a delightful combination of cheesy goodness and garlicky perfection.", true, 0, 0, 10.99, R.drawable.garlicparmesanchicken, 0, 3.5, 0, 10, "Garlic Parmesan Chicken", 1);
                foodListAdapter.additem(foods1_more);
                foodListAdapter.additem(foods2_more);
                foodListAdapter.additem(foods1_chicken);
                textView.setText("Best Food Today's");
                recyclerView.setAdapter(foodListAdapter);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
                recyclerView.setLayoutManager(layoutManager);
            }
        }
    }

    private void getint() {
        ArrayList<Foods> arrayList_pizza=new ArrayList<>();
        ArrayList<Foods> arrayList_burger=new ArrayList<>();
        ArrayList<Foods> arrayList_chicken=new ArrayList<>();
        ArrayList<Foods> arrayList_suchi=new ArrayList<>();
        ArrayList<Foods> arrayList_meat=new ArrayList<>();
        ArrayList<Foods> arrayList_hotdog=new ArrayList<>();
        ArrayList<Foods> arrayList_drink=new ArrayList<>();
        ArrayList<Foods> arrayList_more=new ArrayList<>();

        Foods foods1_pizza=new Foods(0,"Pizza Margherita is a classic Italian dish featuring a thin, crispy crust topped with fresh tomato sauce, creamy mozzarella cheese, and fragrant basil leaves. The vibrant colors of red, white, and green reflect the Italian flag. Simple yet delicious, this pizza highlights the quality of its ingredients, offering a fresh and balanced flavor profile. It's a favorite for those who appreciate authentic Italian cuisine.\n",true,0,-17,10.99, R.drawable.vegetarianpadthai,0,3.5,0,10,"Vegetarian Pad Thai",1);
        Foods foods2_pizza=new Foods(1,"BBQ Chicken Delight is a savory pizza topped with tender grilled chicken, drizzled with tangy barbecue sauce. Enhanced with red onions and a blend of mozzarella and cheddar cheeses, it offers a perfect balance of sweet and smoky flavors. Finished with fresh cilantro, this pizza is a crowd-pleaser, perfect for BBQ lovers seeking a delightful twist on traditional pizza!",true,-16,1,15.99, R.drawable.bbqchickendelight,1,4,1,10,"BBQ Chicken Delight",1);
        Foods foods3_pizza=new Foods(2,"Meat Feast Pizza is a hearty delight loaded with an assortment of savory meats, including pepperoni, sausage, ham, and crispy bacon. Each slice is generously topped with gooey mozzarella cheese and a rich tomato sauce, creating a mouthwatering combination. Perfect for meat lovers, this pizza offers a satisfying blend of flavors and textures in every bite. Ideal for sharing or indulging solo, it's a true feast for the senses.",true,-15,2,18.99, R.drawable.meatfeastpizza,2,4,2,15,"Meat Feast Pizza",1);
        Foods foods4_pizza=new Foods(3,"Pepperoni Pizza is a classic favorite featuring a crispy crust topped with a rich tomato sauce and melted mozzarella cheese. Generously layered with spicy, thinly sliced pepperoni, this pizza offers a delightful combination of savory flavors and a hint of spice. Each bite is both satisfying and comforting, making it a go-to choice for pizza lovers. Perfect for gatherings or a casual night in, it's an iconic dish that never goes out of style.",true,-14,3,20.99, R.drawable.pepperonilovers,3,4.5,3,10,"Pepperoni Pizza",1);
        Foods foods5_pizza=new Foods(4,"Hawaiian Paradise pizza combines the sweetness of juicy pineapple with savory ham on a golden, crispy crust. Topped with melted mozzarella and a hint of tangy tomato sauce, this pizza offers a delicious blend of flavors. The contrast between the sweet and salty elements creates a tropical experience with every bite. Perfect for those looking to add a little sunshine to their meal!",true,13,4,22.99, R.drawable.hawaiianparadise,4,3,4,5,"hawaiian paradise",1);
        Foods foods6_pizza=new Foods(5,"The Margherita Pizza is a timeless favorite, featuring a thin, crispy crust topped with a simple yet delicious combination of fresh tomato sauce, creamy mozzarella cheese, and aromatic basil leaves. Drizzled with a touch of extra virgin olive oil and lightly seasoned with sea salt, this pizza celebrates the essence of traditional Italian flavors. Perfectly baked until the cheese is melted and bubbly, it offers a light and satisfying meal.",true,-12,5,25.99, R.drawable.margherita,5,4,5,18,"Margherita",1);
        Foods foods7_pizza=new Foods(6,"The Veggies Supreme is a vibrant, nutrient-packed delight featuring a medley of fresh bell peppers, crisp spinach, juicy tomatoes, sweet corn, and tender mushrooms, all atop a bed of quinoa or whole-grain rice. Tossed in a zesty lemon vinaigrette, this dish bursts with flavors and colors, offering a wholesome and satisfying meal for any veggie lover. Perfectly seasoned with herbs and a hint of garlic, it's a celebration of garden-fresh goodness.",true,-11,5,19.99, R.drawable.veggiesupreme,6,4.5,6,14,"veggies supreme",1);
        Foods foods8_pizza=new Foods(7,"Mediterranean Joy is a vibrant dish featuring a delightful combination of fresh ingredients like olives, feta cheese, cherry tomatoes, cucumbers, and bell peppers. Tossed in a tangy olive oil and lemon dressing, it celebrates the flavors of the Mediterranean. This refreshing salad is often served over a bed of mixed greens or paired with grilled meats, making it a perfect choice for a light yet satisfying meal. Enjoy the taste of sunshine and health in every bite!",true,-10,5,30.99, R.drawable.mediterraneanjoy,7,4.8,7,24,"Mediterranean joy",1);
        Foods foods9_pizza=new Foods(8,"The Margherita Flatbread is a classic Italian-inspired dish featuring a crispy, thin crust topped with a rich tomato sauce, fresh mozzarella, and fragrant basil leaves. Drizzled with a touch of extra virgin olive oil and a sprinkle of sea salt, this flatbread offers a simple yet delicious combination of flavors. Perfectly baked to a golden-brown perfection, it’s a light and satisfying option for any meal.",true,-9,6,24.99, R.drawable.margheritaflatbread,8,3.6,8,12,"margherita flat bread",1);
        Foods foods10_pizza=new Foods(9,"The Meat Feast Pizza is a hearty and indulgent creation loaded with an assortment of savory meats. It features a robust tomato sauce base, generously topped with pepperoni, sausage, ham, bacon, and ground beef, all covered with a blend of melted mozzarella and cheddar cheeses. Each bite offers a rich and flavorful experience, making it the ultimate choice for meat lovers. Baked to perfection with a crispy crust, it’s a satisfying and decadent treat.",true,-8,7,29.99, R.drawable.meatfeastpizza,9,2.9,9,19,"meat feast pizza",1);


        Foods foods1_burger=new Foods(0,"Bacon and cheese is a classic comfort food combination that elevates any dish. Crispy, savory bacon pairs perfectly with rich, melted cheese, creating a mouthwatering blend of flavors. Whether in burgers, sandwiches, or baked dishes, this duo adds indulgence and depth. Ideal for satisfying cravings, it's a beloved choice for many!",true,-7,0,10.99, R.drawable.baconandcheesen,0,3.5,0,10,"Bacon and Cheesen",1);
        Foods foods2_burger=new Foods(1,"BBQ Ranch Delight is a flavorful fusion of tangy barbecue sauce and creamy ranch dressing, creating a perfect balance of sweet and savory. Topped with grilled chicken, fresh veggies, and a sprinkle of cheese, this dish is a crowd-pleaser. It's ideal for those seeking a zesty twist on classic comfort food. Enjoy it as a pizza, salad, or dip for a delicious experience!",true,-6,1,15.99, R.drawable.bbqranchdelight,1,4,1,10,"BBQ Ranch Delight",1);
        Foods foods3_burger=new Foods(2,"Chicken Avocado Bliss features tender, grilled chicken paired with creamy avocado, offering a deliciously rich and nutritious combination. Served on a bed of fresh greens or as a topping on a flavorful base, this dish is accented with zesty lime dressing for an extra kick. Perfect for a light lunch or a satisfying dinner, it's both refreshing and hearty. Enjoy the taste of wholesome goodness in every bite!",true,-5,2,18.99, R.drawable.chickenavocadobliss,2,4,2,15,"Chicken Avocado Bliss",1);
        Foods foods4_burger=new Foods(3,"The Classic Beef Burger is a timeless favorite, featuring a juicy, grilled beef patty nestled in a soft bun. Topped with fresh lettuce, ripe tomatoes, and crunchy pickles, it's complemented by a dollop of tangy ketchup and creamy mayonnaise. This mouthwatering burger offers a satisfying blend of flavors and textures, making it perfect for any burger lover. Enjoy it with a side of crispy fries for the ultimate meal experience!",true,-4,3,20.99, R.drawable.classicbeefburger,3,4,3,10,"Classic Beef Burger",1);
        Foods foods5_burger=new Foods(4,"The Spicy Jalapeno Burger is a fiery twist on the classic, featuring a succulent beef patty topped with sliced jalapeños for a kick of heat. Complemented by melted cheese and zesty chipotle mayo, this burger offers a bold flavor profile. Nestled in a toasted bun with fresh lettuce and tomato, it's perfect for those who crave a little extra spice in their meal. Ideal for spice lovers, this burger promises a thrilling dining experience!",true,-3,4,22.99, R.drawable.spicyjalapenoburger,4,3.5,4,4,"Spicy Jalapeno Burger",1);
        Foods foods6_burger=new Foods(5,"The Teriyaki Pineapple Pleasure is a mouthwatering burger that features a juicy grilled chicken patty glazed with sweet teriyaki sauce. Topped with fresh pineapple slices and crisp lettuce, it offers a delightful blend of savory and sweet flavors. Served on a toasted bun with a hint of mayo, this burger transports your taste buds to a tropical paradise. Perfect for those seeking a unique and refreshing twist on the classic burger!",true,5,5,25.99, R.drawable.teriyakipineapplepleasure,5,5,5,20,"Teriyaki Pineapple Pleasure",1);
        Foods foods7_burger=new Foods(6,"The Veggie Extra Vaganza is a vibrant and hearty pizza loaded with a colorful array of fresh vegetables. Topped with a rich tomato sauce and melted mozzarella cheese, it features bell peppers, mushrooms, onions, olives, and spinach, all baked to perfection. This delicious pizza is a delightful option for vegetarians and anyone craving a lighter yet satisfying meal. Each slice bursts with flavor, making it a favorite for health-conscious pizza lovers!",true,-2,6,19.99, R.drawable.veggieextravaganza,6,3.7,6,20,"Veggie Extra Vaganza",1);
        Foods foods8_burger=new Foods(7,"The Mushroom Swiss Delight is a savory burger featuring a juicy beef patty topped with melted Swiss cheese and sautéed mushrooms. Each bite offers a rich, earthy flavor complemented by a touch of garlic and butter. Served on a toasted bun with fresh lettuce and tomato, this burger provides a delightful combination of textures and tastes. Perfect for mushroom lovers seeking a gourmet twist!",true,-1,7,23.99, R.drawable.mushroomswissdelight,7,4.6,7,20,"Mushroom Swiss Delight",1);


        Foods foods1_chicken=new Foods(0,"Garlic Parmesan Chicken features juicy chicken pieces coated in a flavorful blend of garlic, Parmesan cheese, and herbs. Baked or pan-seared, the chicken develops a crispy, golden crust while remaining tender inside. The rich, savory notes of garlic and cheesy goodness make it a delightful dish. Perfect served with pasta or a fresh salad!",true,0,0,10.99, R.drawable.garlicparmesanchicken,0,3.5,0,10,"Garlic Parmesan Chicken",1);
        Foods foods2_chicken=new Foods(1,"Honey Mustard Glazed Tenders are succulent chicken strips marinated and baked to perfection. Coated in a sweet and tangy honey mustard glaze, they offer a delightful balance of flavors with a hint of spice. These tenders are crispy on the outside and tender on the inside, making them a perfect appetizer or main dish. Served with a side of dipping sauce, they are sure to please any crowd!",true,1,1,15.99, R.drawable.honeymustardglazedtenders,1,4,1,10,"Honey Mustard Glazedtenders",1);
        Foods foods3_chicken=new Foods(2,"Korean BBQ Short Ribs are tender beef ribs marinated in a savory-sweet blend of soy sauce, garlic, and sesame oil. Grilled to perfection, they offer a delightful smoky flavor with a hint of sweetness. Often garnished with green onions and sesame seeds, these ribs are juicy and rich, making them a popular choice for BBQ lovers. Enjoy them with steamed rice and pickled vegetables for an authentic experience!",true,2,2,18.99, R.drawable.koreanbbqshortribs,2,4,2,15,"korean BBQ Short ribs",1);
        Foods foods4_chicken=new Foods(3,"Korean Fried Chicken is known for its crispy, golden exterior and juicy meat inside. Double-fried for extra crunch, it’s often coated in a sweet and spicy sauce made from gochujang (Korean chili paste) and garlic. This dish is typically served with pickled radishes and a side of beer, making it a popular choice for casual gatherings. Each bite delivers a delightful balance of heat and flavor!",true,3,3,20.99, R.drawable.koreanfriedchicken,3,4,3,10,"korean Fried Chicken",1);
        Foods foods5_chicken=new Foods(4,"Lemon Pepper Chicken features tender, juicy chicken marinated in a zesty blend of fresh lemon juice, black pepper, and aromatic herbs. Grilled or baked to perfection, it offers a refreshing citrus flavor with a hint of spice. This dish is perfect for those seeking a light, flavorful meal, often served with vegetables or rice for a complete dining experience. Enjoy it as a delightful main course or a savory addition to salads!",true,4,4,22.99, R.drawable.lemonpepperchicken,4,3,4,4,"Lemon Pepper Chicken",1);
        Foods foods6_chicken=new Foods(5,"Original Crispy Chicken is a classic dish known for its golden, crunchy coating and juicy, tender meat. Marinated for extra flavor, it's fried to perfection, offering a satisfying crunch with each bite. This dish is often served with a side of dipping sauces and can be paired with fries or a fresh salad for a hearty meal. Perfect for comfort food lovers!",true,5,5,25.99, R.drawable.originalcrispychicken,5,5,5,20,"Original Crispy Chicken",1);
        Foods foods7_chicken=new Foods(6,"Chicken Biscuit features a crispy, seasoned fried chicken breast nestled between two fluffy, buttery biscuits. This savory dish is often complemented by a drizzle of honey or a spread of creamy butter. Ideal for breakfast or brunch, it's a comforting and satisfying option that blends savory and slightly sweet flavors in every bite. Perfect for a hearty start to your day!",true,6,6,19.99, R.drawable.southernstylechickenbiscuit,6,5,5,20,"Chicken Biscuit",1);
        Foods foods8_chicken=new Foods(7,"Spicy Buffalo Wings are crispy chicken wings tossed in a tangy and fiery buffalo sauce, delivering a bold kick of heat. Typically served with celery sticks and a side of creamy blue cheese or ranch dressing for dipping, these wings are perfect for game days or casual gatherings. Their irresistible crunch and spicy flavor make them a favorite among wing lovers!",true,7,7,23.99, R.drawable.spicybuffalowings,7,5,5,20,"Spicy Buffalo Wings",1);
        Foods foods9_chicken=new Foods(8,"Feta Stuffed Chicken features tender chicken breasts filled with creamy feta cheese, herbs, and spinach, offering a delightful burst of flavor. This dish is often seasoned with Mediterranean spices and baked to perfection, resulting in a juicy exterior and a savory, cheesy filling. Perfect for a wholesome dinner, it's both elegant and easy to prepare!",true,8,8,25.99, R.drawable.spinachandfetastuffedchicken,8,5,5,20,"feta Stuffed Chicken",1);
        Foods foods10_chicken=new Foods(9,"Teriyaki Chicken Wings are juicy, tender wings coated in a sweet and savory teriyaki sauce. Marinated to enhance flavor, they are grilled or baked until caramelized and sticky. These wings offer a delightful balance of sweetness and umami, making them a perfect appetizer or party snack. Enjoy them with sesame seeds and green onions for an extra touch!",true,9,9,11.99, R.drawable.teriyakichickenwings,9,5,5,20,"Spicy Buffalo Wings",1);
        Foods foods11_chicken=new Foods(10,"Teriyaki Glazed Chicken Thighs feature succulent, tender chicken thighs marinated in a rich teriyaki sauce. Grilled or baked to perfection, they are coated in a sweet and savory glaze that caramelizes beautifully. This dish offers a delightful balance of flavors, making it a favorite for weeknight dinners or special occasions. Serve with rice and steamed vegetables for a complete meal!",true,10,10,13.99, R.drawable.teriyakiglazedchickenthighs,10,5,5,20,"Teriyaki Glazed Chickenthighs",1);


        Foods foods1_suchi=new Foods(0,"Bacon Wrapped Filet Mignon is a luxurious cut of beef, known for its tenderness and rich flavor, wrapped in crispy bacon. The bacon adds a smoky, savory element that enhances the steak's natural richness. Typically grilled or pan-seared, it’s often finished in the oven for a perfect medium-rare. Served with a side of vegetables or a gourmet sauce, it's a steakhouse favorite that promises indulgence with every bite!",true,11,0,10.99, R.drawable.baconwrappedfiletmignon,0,3.5,0,10,"Bacon Wrapped Filetmignon",1);
        Foods foods2_suchi=new Foods(1,"The California Roll is a popular sushi dish that features a combination of fresh flavors. Made with sushi rice, imitation crab (or real crab), cucumber, and avocado, it's typically rolled in seaweed (nori) and often topped with sesame seeds. This roll is known for its mild taste, making it a great introduction to sushi for beginners. Served with soy sauce, wasabi, and pickled ginger, it’s a delightful and colorful option in Japanese cuisine!",true,12,1,15.99, R.drawable.californiaroll,0,4.5,1,15,"California Roll",1);
        Foods foods3_suchi=new Foods(2,"The Dragon Roll is a visually stunning sushi creation that often features eel (unagi) or shrimp tempura at its core, wrapped in sushi rice and seaweed. It is typically topped with thin slices of avocado to resemble dragon scales and drizzled with sweet eel sauce and spicy mayo for added flavor. Garnished with tobiko (fish roe) or sesame seeds, this roll combines rich and savory tastes, making it a favorite among sushi lovers. Its artistic presentation adds a touch of elegance to any sushi platter!",true,13,2,19.99, R.drawable.dragonroll,2,2.5,0,15,"Dragon Roll",1);
        Foods foods4_suchi=new Foods(3,"The Four Cheese Delight is a rich and indulgent pizza that features a blend of four distinct cheeses, typically including mozzarella, cheddar, parmesan, and gorgonzola. This combination creates a creamy, savory flavor profile with varying textures, from the melty mozzarella to the tangy gorgonzola. Baked to perfection, the crust is golden and crispy, providing the perfect base for the cheese medley. It’s a delightful choice for cheese lovers looking for a satisfying and cheesy treat!",true,14,3,25.99, R.drawable.fourcheesedelight,3,3.5,0,20,"Fourcheese Delight",1);
        Foods foods5_suchi=new Foods(4,"The Rainbow Roll is a vibrant sushi creation featuring a variety of colorful ingredients. Typically made with fresh fish such as tuna, salmon, and avocado, it's often topped with slices of different sashimi to create a visually stunning dish. The roll is usually complemented by a drizzle of sweet soy sauce or a spicy mayo for added flavor. Each bite offers a delightful mix of textures and tastes, making it a favorite among sushi enthusiasts. Enjoy this artistic roll for a fresh and flavorful sushi experience!",true,15,4,22.99, R.drawable.rainbowroll,4,3,0,20,"Rain Bowroll",1);
        Foods foods6_suchi=new Foods(5,"Salmon Nigiri is a classic sushi dish consisting of a slice of fresh, raw salmon draped over a mound of seasoned sushi rice. The rice is often lightly shaped by hand, providing a perfect base for the silky salmon. This dish highlights the rich, buttery flavor of the salmon, complemented by a hint of wasabi or soy sauce. It's a simple yet elegant option, celebrated for its fresh taste and delicate presentation, making it a favorite among sushi lovers. Enjoy it as part of a sushi platter or on its own for a delightful experience!",true,16,5,30.99, R.drawable.salmonnigiri,5,3.5,0,10,"Salmon Nigiri",1);
        Foods foods7_suchi=new Foods(6,"A Sashimi Platter features an exquisite selection of thinly sliced raw fish and seafood, beautifully arranged for presentation. This dish typically includes varieties like tuna, salmon, and yellowtail, highlighting the freshness and quality of the ingredients. Served with soy sauce, wasabi, and pickled ginger, each slice offers a delicate balance of flavors. The simplicity of sashimi allows the natural taste of the fish to shine, making it a favorite among sushi enthusiasts. Perfect for sharing or enjoying as an elegant appetizer!",true,17,5,20.99, R.drawable.sashimiplatter,5,4.5,0,15,"Sashimi Platter",1);
        Foods foods8_suchi=new Foods(7,"The Spicy Tuna Roll is a popular sushi choice that combines fresh, diced tuna with spicy mayonnaise for a flavorful kick. Wrapped in sushi rice and nori, it often includes cucumber for crunch. This roll is topped with sesame seeds or spicy sauce, enhancing its vibrant flavor profile. Perfect for those who enjoy a little heat with their sushi experience!",true,18,5,25.99, R.drawable.spicytunaroll,5,4.5,0,30,"Spicy Tunaroll",1);
        Foods foods9_suchi=new Foods(8,"Shrimp Scampi features succulent shrimp sautéed in a rich garlic butter sauce, often enhanced with white wine and a hint of lemon. Typically served over pasta or with crusty bread, this dish combines the sweetness of shrimp with aromatic herbs like parsley. It's a classic Italian-American favorite, perfect for seafood lovers seeking a quick and delicious meal.",true,19,5,32.99, R.drawable.shrimpscampi,5,4.5,0,15,"Shrimp Scampi",1);
        Foods foods10_suchi=new Foods(9,"The Tempura Shrimp Roll is a delicious sushi creation featuring crispy tempura-fried shrimp wrapped in sushi rice and nori. Often accompanied by fresh vegetables like avocado and cucumber, this roll offers a delightful contrast of textures—crispy on the outside and tender on the inside. It's typically served with soy sauce, wasabi, and pickled ginger, making it a favorite among sushi enthusiasts.",true,20,5,21.99, R.drawable.tempurashrimproll,5,4.5,0,15,"Tempura Shrimproll",1);
        Foods foods11_suchi=new Foods(10,"Thai Red Curry is a fragrant and flavorful dish made with a rich coconut milk base and aromatic red curry paste. Typically featuring ingredients like tender chicken, shrimp, or tofu, it is combined with fresh vegetables such as bell peppers and basil. The dish is known for its perfect balance of sweet, spicy, and savory notes, often served with steamed jasmine rice for a satisfying meal.",true,21,5,32.99, R.drawable.thairedcurry,5,4.5,0,15,"Thaired curry",1);
        Foods foods12_suchi=new Foods(11,"Vegetarian Pad Thai is a popular Thai stir-fried noodle dish that features rice noodles tossed with fresh vegetables, such as bean sprouts, carrots, and scallions. Flavored with a tangy sauce made from tamarind, soy sauce, and a hint of lime, it's often garnished with crushed peanuts and fresh cilantro. This dish is not only vibrant and delicious but also offers a satisfying balance of textures and flavors, making it a favorite among vegetarians and noodle lovers alike.",true,22,5,32.99, R.drawable.vegetarianpadthai,5,4.5,0,15,"Vegetarian Padthai",1);
        Foods foods13_suchi=new Foods(12,"A Veggie Roll is a delightful sushi option filled with a variety of fresh vegetables, such as cucumber, avocado, and bell peppers, wrapped in sushi rice and nori (seaweed). Often accompanied by a light dipping sauce, it’s a refreshing and healthy choice, perfect for those seeking a vegetarian sushi experience. The colorful ingredients provide a satisfying crunch and a burst of flavor in every bite.",true,23,5,32.99, R.drawable.veggieroll,5,4.5,0,15,"Veggie Roll",1);


        Foods foods1_meat=new Foods(0,"Beef Stir-Fry with Broccoli is a savory dish featuring tender strips of beef sautéed with vibrant broccoli florets. Tossed in a flavorful soy sauce blend, it combines sweet and umami notes with a hint of garlic and ginger. This quick-cooking dish is often served over rice or noodles, making it a satisfying and nutritious meal, rich in protein and vegetables. Perfect for a hearty weeknight dinner!",true,24,0,20.99, R.drawable.beefstirfrywithbroccoli,0,3.5,0,10,"Beef Stirfry With Broccoli",1);
        Foods foods2_meat=new Foods(0,"Grilled Ribeye Steak is a succulent cut of beef known for its rich marbling and intense flavor. Cooked to perfection on the grill, it develops a beautifully charred crust while remaining tender and juicy inside. Seasoned simply with salt and pepper, this steak is often served with sides like roasted vegetables or mashed potatoes, making it a classic choice for steak lovers. Ideal for a special occasion or a satisfying weeknight meal!",true,25,0,35.99, R.drawable.grilledribeyesteak,0,3.5,0,10,"Grilled Ribeyesteak",1);
        Foods foods3_meat=new Foods(0,"Pan-Seared Garlic Butter Sirloin is a deliciously rich and flavorful dish featuring tender sirloin steak seared to perfection. Cooked in a skillet, it’s enhanced with a fragrant garlic butter sauce that infuses the meat with savory goodness. The quick cooking method ensures a perfect crust while keeping the inside juicy and tender. Served with a side of vegetables or potatoes, it's a delightful meal for any steak enthusiast!",true,26,0,55.99, R.drawable.pansearedgarlicbuttersirloin,0,3.5,0,10,"Panseared Garlic Buttersirloin",1);
        Foods foods4_meat=new Foods(0,"Smoked BBQ Brisket is a mouthwatering dish featuring beef brisket slowly smoked to achieve a rich, smoky flavor. The low-and-slow cooking method tenderizes the meat, resulting in melt-in-your-mouth texture. It’s typically seasoned with a blend of spices and served with tangy barbecue sauce, making it a perfect choice for BBQ lovers. Ideal for gatherings, it pairs well with coleslaw, baked beans, or cornbread!",true,27,0,50.99, R.drawable.smokedbbqbrisket,0,3.5,0,10,"Smoked BBQ Brisket",1);
        Foods foods5_meat=new Foods(0,"Spicy Moroccan Lamb Chops are succulent lamb chops marinated in a blend of aromatic spices like cumin, coriander, and paprika. Grilled to perfection, they offer a delightful mix of heat and savory flavors, often enhanced with fresh herbs like mint or cilantro. This dish is typically served with couscous or a vibrant salad, making it a flavorful choice for a unique dining experience!",true,28,0,40.99, R.drawable.spicymoroccanambchops,0,3.5,0,10,"Spicy Moroccanambchops",1);
        Foods foods6_meat=new Foods(0,"Stuffed Bell Peppers with ground turkey feature vibrant bell peppers filled with a savory mixture of ground turkey, rice, onions, and spices. Baked until tender, they offer a healthy and flavorful meal that's both satisfying and colorful. This dish is often topped with cheese for added richness and served with a side salad for a complete dinner. Perfect for a wholesome weeknight meal!",true,29,0,30.99, R.drawable.stuffedbellpepperswithgroundturkey,0,3.5,0,10,"Stuffed Bellpepper Swithgroundturkey",1);

        Foods foods1_hotdog=new Foods(0,"The Chicago Style Hot Dog is a classic American dish known for its unique and vibrant toppings. It features a beef frankfurter served in a poppy seed bun, topped with mustard, chopped onions, bright green relish, a slice of tomato, a pickle spear, and sport peppers. This iconic hot dog is famously \"dragged through the garden,\" highlighting its fresh ingredients. Ketchup is notably absent, as it’s considered a culinary faux pas in Chicago!",true,30,0,15.99, R.drawable.chicagostylehotdog,0,3.5,0,10,"Chicago Stylehotdog",1);
        Foods foods2_hotdog=new Foods(1,"The Classic Beef Hot Dog is a quintessential favorite, featuring a grilled or boiled beef frankfurter nestled in a soft bun. It's typically garnished with mustard, ketchup, diced onions, and relish. This timeless combination offers a savory and satisfying treat that's beloved for its simplicity and nostalgic appeal.",true,31,0,18.99, R.drawable.classicbeefhotdog,0,3.5,0,10,"Classic Beefhotdog",1);
        Foods foods3_hotdog=new Foods(2,"The Kimchi Hot Dog is a delicious fusion of flavors, featuring a juicy sausage topped with spicy, tangy kimchi. Served in a soft bun, it often includes sriracha or mayo for an extra kick. This unique twist combines classic street food with the bold taste of Korean cuisine, making it a must-try for adventurous eaters!",true,32,0,16.99, R.drawable.kimchihotdog,0,3.5,0,10,"kimchi hotdog",1);
        Foods foods4_hotdog=new Foods(3,"The Reuben Style Hot Dog is a creative twist on the classic Reuben sandwich. It features a savory hot dog topped with tangy sauerkraut, creamy Thousand Island dressing, and melted Swiss cheese. Served in a warm bun, this dish combines the rich flavors of the traditional Reuben with the satisfying bite of a hot dog, making it a delicious and indulgent treat!",true,33,0,20.99, R.drawable.reubenstylehotdog,0,3.5,0,10,"Reuben Stylehotdog",1);
        Foods foods5_hotdog=new Foods(4,"The Chicago Style Hot Dog is a iconic culinary classic, featuring an all-beef hot dog nestled in a poppy seed bun. Topped with yellow mustard, bright green relish, chopped onions, a slice of tomato, a dill pickle spear, and sport peppers, it offers a vibrant mix of flavors and textures. Notably, it's served without ketchup, embodying the true spirit of Chicago's hot dog culture!",true,34,0,13.99, R.drawable.kimchihotdog,0,3.5,0,10,"Chicago Stylehotdog",1);
        Foods foods6_hotdog=new Foods(5,"The Hawaiian BBQ Hot Dog is a tropical twist on the classic favorite, featuring a juicy all-beef hot dog topped with a sweet and tangy pineapple BBQ sauce. It's garnished with fresh pineapple chunks, crispy bacon bits, and a drizzle of creamy coleslaw for added crunch. This delightful fusion brings together the savory and sweet elements, offering a deliciously unique flavor experience that transports you straight to the islands!",true,35,0,17.99, R.drawable.hawaiianbbqdog,0,3.5,0,10,"Hawaiian BBQ Hotdog",1);
        Foods foods7_hotdog=new Foods(6,"The Kimchi Hot Dog combines a savory all-beef hot dog with spicy, tangy kimchi for an exciting flavor kick. Topped with a drizzle of sriracha mayo and fresh green onions, it offers a delightful blend of heat and crunch. This fusion dish adds a Korean twist to the classic hot dog, making it a must-try for adventurous eaters!",true,36,0,14.99, R.drawable.kimchihotdog,0,3.5,0,10,"Kimchi Hotdog",1);
        Foods foods8_hotdog=new Foods(7,"The Veggie Hot Dog with Sauerkraut features a plant-based sausage packed with flavor and topped with tangy sauerkraut. This delicious combination provides a satisfying crunch and a burst of acidity, enhancing the overall taste. Perfect for a light meal or snack, it caters to both vegetarians and those looking for a healthier twist on a classic favorite. Enjoy it with your favorite mustard for an extra kick!",true,37,0,12.99, R.drawable.veggiedogwithsauerkraut,0,3.5,0,10,"Veggie Hotdogwithsauerkraut",1);


        Foods foods1_drink=new Foods(0,"The Berry Blast Smoothie is a refreshing blend of vibrant berries like strawberries, blueberries, and raspberries, combined with creamy yogurt and a splash of honey. This delicious drink is not only packed with antioxidants but also provides a boost of vitamins. Perfect for breakfast or a mid-day snack, it offers a delightful balance of sweetness and tartness. Enjoy it chilled for a revitalizing treat!",true,38,0,7.99, R.drawable.berryblastsmoothie,0,3.5,0,10,"Berryblast smoothie",1);
        Foods foods2_drink=new Foods(1,"Coconut water is a naturally refreshing beverage, extracted from young green coconuts. It's known for its light, slightly sweet flavor and is packed with electrolytes, making it an excellent choice for hydration. Rich in potassium and low in calories, coconut water is often enjoyed after exercise or on hot days. Its subtle taste pairs well with smoothies or can be consumed straight from the coconut for an authentic experience.",true,39,0,5.99, R.drawable.coconutwater,0,3.5,0,10,"Coconut Water",1);
        Foods foods3_drink=new Foods(2,"Mango Tango Slush is a vibrant, tropical beverage that combines the sweet, juicy flavor of ripe mangoes with a refreshing icy texture. Blended to perfection, it's often enhanced with a hint of citrus for a zesty kick. This delightful slush is perfect for cooling off on a warm day or enjoying as a fruity treat. Its bright color and fruity aroma make it visually appealing and deliciously refreshing!",true,40,0,9.99, R.drawable.mangotangoslush,0,3.5,0,10,"Mango Tangoslush",1);
        Foods foods4_drink=new Foods(3,"Mint Lemonade is a refreshing beverage that combines freshly squeezed lemons with the coolness of mint leaves. Sweetened to taste, it's a perfect balance of tangy and sweet, making it an ideal thirst-quencher on hot days. The mint adds a fragrant twist, elevating the classic lemonade experience. Served chilled, this drink is both revitalizing and invigorating!",true,41,0,5.99, R.drawable.mintlemonade,0,3.5,0,10,"Mint Lemonade",1);
        Foods foods5_drink=new Foods(4,"The Espresso Martini is a sophisticated cocktail that blends rich espresso with vodka and coffee liqueur. This energizing drink is shaken with ice to create a frothy texture and served in a sleek martini glass, often garnished with coffee beans. With its bold coffee flavor and a hint of sweetness, it's perfect for coffee lovers looking to enjoy a spirited twist. Ideal for evenings out or as a post-dinner treat!",true,42,0,12.99, R.drawable.espressomartini,0,3.5,0,10,"Espresso Martini",1);
        Foods foods6_drink=new Foods(4,"The Green Tea Latte is a soothing beverage that combines creamy steamed milk with finely ground matcha green tea powder. This vibrant drink is known for its earthy flavor and bright green color, offering a unique blend of sweetness and a hint of bitterness. Rich in antioxidants, it provides a gentle caffeine boost, making it a popular choice for a refreshing pick-me-up. Enjoy it hot or iced for a delightful treat any time of day!",true,43,0,4.99, R.drawable.greentealatte,0,3.5,0,10,"Green Tealatte",1);
        Foods foods7_drink=new Foods(4,"The Green Tea Latte blends creamy steamed milk with matcha green tea powder, creating a rich and vibrant drink. Its earthy flavor is balanced by a subtle sweetness, making it both refreshing and comforting. Packed with antioxidants, this latte offers a gentle energy boost, perfect for any time of day. Enjoy it hot or iced for a delightful treat!",true,44,0,5.99, R.drawable.freshorangejuice,0,3.5,0,10,"Green Tealatte",1);
        Foods foods8_drink=new Foods(4,"The Iced Caramel Macchiato is a delightful blend of rich espresso and creamy milk, layered over ice and topped with a drizzle of sweet caramel. Its bold coffee flavor is complemented by the smoothness of vanilla syrup, creating a refreshing and indulgent drink. Perfect for warm days, it's a delicious treat that balances sweetness with a touch of caffeine. Enjoy it as a pick-me-up or a midday refreshment!",true,45,0,5.99, R.drawable.icedcaramelmacchiato,0,3.5,0,10,"Icedcaramel Macchiato",1);

        Foods foods1_more=new Foods(0,"Pasta Carbonara is a classic Italian dish featuring al dente spaghetti or fettuccine tossed in a creamy sauce made from eggs, cheese (typically Pecorino Romano), pancetta or guanciale, and black pepper. The heat of the pasta gently cooks the eggs, creating a rich, silky texture without the use of cream. It's a comforting, savory dish that's quick to prepare, offering a delicious balance of flavors and textures. Perfect for a satisfying meal any time!",true,46,0,16.99, R.drawable.pastacarbonara,0,3.5,0,10,"Pasta Carbonara",1);
        Foods foods2_more=new Foods(0,"Quinoa Salad Bowl is a nutritious and colorful dish featuring fluffy quinoa as the base, mixed with a variety of fresh vegetables like cherry tomatoes, cucumbers, bell peppers, and red onion. It's often enhanced with leafy greens, herbs such as parsley or cilantro, and a zesty dressing made from olive oil, lemon juice, and spices. This versatile salad can be customized with toppings like avocado, nuts, or feta cheese, making it a delicious and wholesome option for a light meal or side dish.",true,47,0,10.99, R.drawable.quinoasaladbowl,0,3.5,0,10,"Quinoa Saladbowl",1);


        switch (position){
            case 0:{
                foodListAdapter=new Food_list_Adapter(arrayList_pizza);
                foodListAdapter.additem(foods1_pizza);
                foodListAdapter.additem(foods2_pizza);
                foodListAdapter.additem(foods3_pizza);
                foodListAdapter.additem(foods4_pizza);
                foodListAdapter.additem(foods5_pizza);
                foodListAdapter.additem(foods6_pizza);
                foodListAdapter.additem(foods7_pizza);
                foodListAdapter.additem(foods8_pizza);
                foodListAdapter.additem(foods9_pizza);
                foodListAdapter.additem(foods10_pizza);
                recyclerView.setAdapter(foodListAdapter);
                break;
            }
            case 1:{
                foodListAdapter=new Food_list_Adapter(arrayList_burger);
                foodListAdapter.additem(foods1_burger);
                foodListAdapter.additem(foods2_burger);
                foodListAdapter.additem(foods3_burger);
                foodListAdapter.additem(foods4_burger);
                foodListAdapter.additem(foods5_burger);
                foodListAdapter.additem(foods6_burger);
                foodListAdapter.additem(foods7_burger);
                foodListAdapter.additem(foods8_burger);
                recyclerView.setAdapter(foodListAdapter);
                break;

            }
            case 2:{
                foodListAdapter=new Food_list_Adapter(arrayList_chicken);
                foodListAdapter.additem(foods1_chicken);
                foodListAdapter.additem(foods2_chicken);
                foodListAdapter.additem(foods3_chicken);
                foodListAdapter.additem(foods4_chicken);
                foodListAdapter.additem(foods5_chicken);
                foodListAdapter.additem(foods6_chicken);
                foodListAdapter.additem(foods7_chicken);
                foodListAdapter.additem(foods8_chicken);
                foodListAdapter.additem(foods9_chicken);
                foodListAdapter.additem(foods10_chicken);
                foodListAdapter.additem(foods11_chicken);
                recyclerView.setAdapter(foodListAdapter);
                break;
            }
            case 3:{
                foodListAdapter=new Food_list_Adapter(arrayList_suchi);
                foodListAdapter.additem(foods1_suchi);
                foodListAdapter.additem(foods2_suchi);
                foodListAdapter.additem(foods3_suchi);
                foodListAdapter.additem(foods4_suchi);
                foodListAdapter.additem(foods5_suchi);
                foodListAdapter.additem(foods6_suchi);
                foodListAdapter.additem(foods7_suchi);
                foodListAdapter.additem(foods8_suchi);
                foodListAdapter.additem(foods9_suchi);
                foodListAdapter.additem(foods10_suchi);
                foodListAdapter.additem(foods11_suchi);
                foodListAdapter.additem(foods12_suchi);
                foodListAdapter.additem(foods13_suchi);
                recyclerView.setAdapter(foodListAdapter);
                break;

            }
            case 4:{
                foodListAdapter=new Food_list_Adapter(arrayList_meat);
                foodListAdapter.additem(foods1_meat);
                foodListAdapter.additem(foods2_meat);
                foodListAdapter.additem(foods3_meat);
                foodListAdapter.additem(foods4_meat);
                foodListAdapter.additem(foods5_meat);
                foodListAdapter.additem(foods6_meat);
                recyclerView.setAdapter(foodListAdapter);
                break;
            }
            case 5:{
                foodListAdapter=new Food_list_Adapter(arrayList_hotdog);
                foodListAdapter.additem(foods1_hotdog);
                foodListAdapter.additem(foods2_hotdog);
                foodListAdapter.additem(foods3_hotdog);
                foodListAdapter.additem(foods4_hotdog);
                foodListAdapter.additem(foods5_hotdog);
                foodListAdapter.additem(foods6_hotdog);
                foodListAdapter.additem(foods7_hotdog);
                foodListAdapter.additem(foods8_hotdog);
                recyclerView.setAdapter(foodListAdapter);
                break;
            }
            case 6:{
                foodListAdapter=new Food_list_Adapter(arrayList_drink);
                foodListAdapter.additem(foods1_drink);
                foodListAdapter.additem(foods2_drink);
                foodListAdapter.additem(foods3_drink);
                foodListAdapter.additem(foods4_drink);
                foodListAdapter.additem(foods5_drink);
                foodListAdapter.additem(foods6_drink);
                foodListAdapter.additem(foods7_drink);
                foodListAdapter.additem(foods8_drink);
                recyclerView.setAdapter(foodListAdapter);
                break;
            }

            case 7:{
                foodListAdapter=new Food_list_Adapter(arrayList_more);
                foodListAdapter.additem(foods1_more);
                foodListAdapter.additem(foods2_more);
                recyclerView.setAdapter(foodListAdapter);
                break;


            }
        }


        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void getintent() {
        position=getIntent().getIntExtra("position",0);
        name=getIntent().getStringExtra("name");
        textView.setText(name);
        imageView.setOnClickListener(v->{
            finish();
        });
    }
}