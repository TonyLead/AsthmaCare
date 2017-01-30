package com.asthmacare.asus.asthma.view.loginingview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.asthmacare.asus.asthma.R;
import com.asthmacare.asus.asthma.presenter.presenterlogining.PresenterLogin;
import com.asthmacare.asus.asthma.view.registrationview.RegistrationActivity;


public class LoginActivity extends AppCompatActivity {
    private Button regitrationButton;
    private Button connectButton;
    private EditText loginEditText;
    private EditText passwordEditText;
    private PresenterLogin presenterLogin;
    private String login;
    private String password;
    private LoginActivity loginActivity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginEditText = (EditText) findViewById(R.id.email_login_editText);
        passwordEditText = (EditText) findViewById(R.id.password_login_editText);



        regitrationButton = (Button) findViewById(R.id.register_button);
        connectButton = (Button) findViewById(R.id.connect_button);
        connectButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                login = loginEditText.getText().toString();
                password = passwordEditText.getText().toString();
                presenterLogin = new PresenterLogin(login,password,LoginActivity.this);
            }
        });






        regitrationButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        //code below block button while user not write login and password in filds for input

          TextWatcher mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {
                checkFieldsForEmptyValues();
            }
        };

        loginEditText.addTextChangedListener(mTextWatcher);
        passwordEditText.addTextChangedListener(mTextWatcher);
        checkFieldsForEmptyValues();
    }



    void checkFieldsForEmptyValues(){


        String s1 = loginEditText.getText().toString();
        String s2 = passwordEditText.getText().toString();

        if(s1.equals("")|| s2.equals("")){
            connectButton.setClickable(false);

        } else {
            connectButton.setClickable(true);

        }
    }


}



