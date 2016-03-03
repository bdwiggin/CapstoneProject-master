package com.teaminfinity.tabnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BrandonWiggins on 01/03/2016.
 */
public class CreateProfile  extends Activity {

    EditText et_firstname, et_lastname, et_email, et_age,et_height,et_inches,et_weight,et_username,et_password;
    String editTextRFirstname,editTextRLastname,editTextEmail,editTextRAge,editTextRHeight,editTextRInches,editTextRWeight,editTextRUsername,editTextRPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration2_layout);

        et_firstname = (EditText)findViewById(R.id.editTextRFirstname);
        et_lastname = (EditText)findViewById(R.id.editTextRLastname);
        et_email = (EditText)findViewById(R.id.editTextEmail);
        et_age = (EditText)findViewById(R.id.editTextRAge);
        et_height = (EditText)findViewById(R.id.editTextRHeight);
        et_inches = (EditText)findViewById(R.id.editTextRInches);
        et_weight = (EditText)findViewById(R.id.editTextRWeight);
        et_username = (EditText)findViewById(R.id.editTextRUsername);
        et_password = (EditText)findViewById(R.id.editTextRPassword);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.textViewMain) {
            Intent i = new Intent(CreateProfile.this, MainActivity.class);
            startActivity(i);

        }
    }

 public void userReg(View view){
     editTextRFirstname = et_firstname.getText().toString();
     editTextRLastname = et_lastname.getText().toString();
     editTextEmail = et_email.getText().toString();
     editTextRAge = et_age.getText().toString();
     editTextRHeight = et_height.getText().toString();
     editTextRInches = et_inches.getText().toString();
     editTextRWeight = et_weight.getText().toString();
     editTextRUsername = et_username.getText().toString();
     editTextRPassword = et_password.getText().toString();
     String method = "register";
     BackgroundActivity backgroundActivity = new BackgroundActivity(this);
     backgroundActivity.execute(method,editTextRFirstname,editTextRLastname,editTextEmail,editTextRAge,editTextRHeight,editTextRInches,editTextRWeight,editTextRUsername,editTextRPassword);
     finish();



 }




}