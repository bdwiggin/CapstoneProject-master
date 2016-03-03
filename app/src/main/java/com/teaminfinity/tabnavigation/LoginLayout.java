package com.teaminfinity.tabnavigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BrandonWiggins on 01/03/2016.
 */
public class LoginLayout  extends Activity {
    EditText ET_NAME,ET_PASS;
    String login_name,login_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ET_NAME = (EditText)findViewById(R.id.editTextLogin);
        ET_PASS = (EditText)findViewById(R.id.editTextLoginPass);
    }


    public void onButtonClick(View view) {
        if (view.getId() == R.id.textViewForgot) {
            Intent i = new Intent(LoginLayout.this, ForgotPassword.class);
            startActivity(i);

        }
        if (view.getId() == R.id.loginButton){
            Intent i = new Intent(LoginLayout.this,MainActivity.class);
            startActivity(i);
        }
    }
public void userReg(View view){

    startActivity(new Intent(this,CreateProfile.class));
}


    public void loginButton(View view){
        login_name = ET_NAME.getText().toString();
        login_pass = ET_PASS.getText().toString();
        String method = "login";
        BackgroundActivity backgroundActivity = new BackgroundActivity(this);
        backgroundActivity.execute(method,login_name,login_pass);

    }



    }



