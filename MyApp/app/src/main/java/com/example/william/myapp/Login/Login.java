package com.example.william.myapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.william.myapp.R;
import com.example.william.myapp.main.MainActivity;

/**
 * Created by william on 8/7/17.
 */

public class Login extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button SignUp;
    LayoutInflater layoutInflater;
    private int counter =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Username = (EditText) findViewById(R.id.UserName);
        Password = (EditText) findViewById(R.id.Password);
        SignUp = (Button) findViewById(R.id.SignUp);





        Username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int x = Username.length();

                if(x>2) {

                    SignUp.setVisibility(View.VISIBLE);
                     Log.d("Value", String.valueOf(x));

                }else{
                    SignUp.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });






    }

    public void Login(View view){
        Intent i = new Intent(Login.this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
