package com.example.foodapp.Activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;


import com.example.foodapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    ImageView image_intro_login,image_facebook,image_google,image_twitter;
    TextView text_food,text_app,text_forgetpassword,text_or,you_are_not_user,text_signup,error;
    TextInputEditText textinput_email_login,textinput_pass_login;
    TextInputLayout textinput_layout_login_email,textinput_layout_loginpass;
    AppCompatButton login_button;
    View view,view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
        image_intro_login=findViewById(R.id.image_intro_login);
        image_facebook=findViewById(R.id.image_facebook);
        image_google=findViewById(R.id.image_google);
        image_twitter=findViewById(R.id.image_twitter);
        you_are_not_user=findViewById(R.id.you_are_not_user);
        text_signup=findViewById(R.id.text_signup);
        text_food=findViewById(R.id.text_food);
        text_app=findViewById(R.id.text_app);
        text_food=findViewById(R.id.text_food);
        text_forgetpassword=findViewById(R.id.text_forgetpassword);
        textinput_email_login=findViewById(R.id.textinput_email_login);
        textinput_pass_login=findViewById(R.id.textinput_pass_login);
        textinput_layout_login_email=findViewById(R.id.textinput_layout_login);
        textinput_layout_loginpass=findViewById(R.id.textinput_layout_login1);
        login_button=findViewById(R.id.login_button);
        view=findViewById(R.id.view);
        view2=findViewById(R.id.view2);
        text_or=findViewById(R.id.text_or);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setvariable();

        text_signup.setOnClickListener(v->{
            Intent intent=new Intent(getApplicationContext(), SignupActivity.class);
            startActivity(intent);
        });

    }

    private void setvariable() {

      textinput_pass_login.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            //beforeTextChanged is called before the text is actually modified. This means you'd be checking the length of the old text, not the text after the user's change.
             //Imagine the EditText currently contains the text "Android".
              //Now, the user places the cursor between "o" and "i" and types the word "great" to replace the "i". Here's how the beforeTextChanged parameters would look:
              //s: "Android" (the text before the change)
              //start: 5 (the index of the "i", where the change starts)
              //count: 1 (the number of characters being replaced, which is just the "i")
              //after: 5 (the length of the new text being inserted, "great")

          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            //is called for every single character change. If the user types "hello", onTextChanged would be called 5 times, once for each letter. This can be excessive if you only need to check the length after the entire change is complete.
              //but in this way there are some error emple if user enter password and they want to change only one charcter so this can also run
              //before represents the number of characters that were present at the start position before the change occurred.
              //When before is Not Zero:
              //The before parameter becomes relevant when the user is modifying existing text, such as:
              //Deleting characters: If the user deletes a character, before would be 1 (or more, depending on how many characters are deleted).
              //Replacing text: If the user selects a portion of text and types over it, before would represent the number of characters that were replaced. E
              if(s.length()==0){
                  //error.setVisibility(View.INVISIBLE);
                  textinput_layout_loginpass.setError(null);

              }
              else{
                  if(s.length()<8){
                      textinput_layout_loginpass.setError("your password must be 8 character");
//                      error.setText("your password must be 8 character");
//                      error.setVisibility(View.VISIBLE);
                  } else if (s.length()>8) {
//                      error.setVisibility(View.INVISIBLE);
                      textinput_layout_loginpass.setError(null);

                  } else if (s.length()==8) {
//                      error.setVisibility(View.INVISIBLE);
                      textinput_layout_loginpass.setError(null);

                  }
              }



          }


          @Override
          public void afterTextChanged(Editable s) {

              //we use the afterTextChanged method because we want to check the length of the text after the change has been applied.
              //its give you final state
              //Imagine the EditText initially contains the text "Hello". The user then selects the word "Hello" and types "Hi" to replace it. How afterTextChanged Works:
              //Timing: This method is called after the entire text modification is complete.
              //Parameter: It receives an Editable object s which represents the final text content of the EditText after the change. In our scenario, the afterTextChanged method would be called once with the following:
              //s: "Hi" (the final text in the EditText after the replacement) Key Points:
              //afterTextChanged gives you access to the complete and final text after the user has made their changes.
              //It's the ideal place to perform actions based on the final state of the text, such as:
          }
      });

        textinput_email_login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()==0){
                    //error.setVisibility(View.INVISIBLE);
                    textinput_layout_login_email.setError(null);

                }else{
                    if(!s.toString().contains("@hotmail.com")){
                        textinput_layout_login_email.setError("Email must be contain @hotmail.com");
                    } else{
                        textinput_layout_login_email.setError(null);

                    }

                }


                }


            @Override
            public void afterTextChanged(Editable s) {



            }
        });


        login_button.setOnClickListener(v->{
          Intent intent=new Intent(getApplicationContext(), MainActivity.class);
          String password=textinput_pass_login.getText().toString();
          String email=textinput_email_login.getText().toString();
          if(email.isEmpty() || password.isEmpty()) {
//              error.setText("please write the email and password");
//              error.setVisibility(View.VISIBLE);
              if (email.isEmpty()) {
                  textinput_email_login.setError("This field is required");

              }  if (password.isEmpty()) {
                  textinput_pass_login.setError("This field is required");

              }


          }  else {
              textinput_email_login.setError(null);
              textinput_pass_login.setError(null);

          }
                if(!password.isEmpty() && !email.isEmpty() && textinput_email_login.getText().toString().contains("@hotmail.com" ) ){
                    textinput_layout_login_email.setError(null);

                    if (password.length() < 8) {
                        textinput_layout_loginpass.setError("your password must be 8 character");
//                  error.setText("your password must be 8 character");
//                  error.setVisibility(View.VISIBLE);
                    } else if (password.length() > 8) {
//                  error.setVisibility(View.INVISIBLE);
                        textinput_layout_loginpass.setError(null);
                        startActivity(intent);
                        finish();
                    } else if (password.length() == 8) {
//                  error.setVisibility(View.INVISIBLE);
                        textinput_layout_loginpass.setError(null);
                        startActivity(intent);
                        finish();


                    }
                }else if (!email.isEmpty()  && !textinput_email_login.getText().toString().contains("@hotmail.com" )){
                    textinput_layout_login_email.setError("Email must be contain @hotmail.com");

                }



      });

//        textinput_layout_login_email.addOnEndIconChangedListener(new TextInputLayout.OnEndIconChangedListener() {
//            @Override
//            public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int previousIcon) {
//                if(previousIcon==textInputLayout.END_ICON_PASSWORD_TOGGLE){
//                    boolean flag=textInputLayout.isEndIconVisible();
//                    if(flag){
//                        Toast.makeText(LoginActivity.this, "password visible", Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Toast.makeText(LoginActivity.this, "password not visible", Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//            }
//        });
//




    }
}