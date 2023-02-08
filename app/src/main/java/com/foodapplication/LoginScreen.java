package com.foodapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    final static int REGIS_CODE = 102;
    Button button_signup,button_login;
    EditText login_email,login_password;
    User user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_screen);
        login_email=(EditText) findViewById(R.id.login_email);
        login_password=(EditText) findViewById(R.id.login_password);
        button_login=(Button) findViewById(R.id.button_login);
        button_signup=(Button) findViewById(R.id.button_signup);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user==null)
                {
                    Toast.makeText(LoginScreen.this,"No registered account yet",Toast.LENGTH_LONG).show();
                    return;
                }
                String email=login_email.getText().toString();
                String pass=login_password.getText().toString();
                if (email.equalsIgnoreCase(user.getEmail())&& pass.equalsIgnoreCase(user.getPassword())){
                    Toast.makeText(LoginScreen.this,"Login Successfully",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginScreen.this, ContentExternal.class);
                    startActivity(i);

                }else {
                    Toast.makeText(LoginScreen.this,"Login Failed",Toast.LENGTH_LONG).show();

                }
            }
        });
        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginScreen.this,SignUpScreen.class);
                startActivityForResult(i,REGIS_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REGIS_CODE)
        {
            String name=data.getStringExtra("name");
            String telphone=data.getStringExtra("telphone");
            String email=data.getStringExtra("email");
            String pass= data.getStringExtra("password");
            user= new User(name,telphone,email,pass);
            Toast.makeText(LoginScreen.this, "Sign up successfully", Toast.LENGTH_LONG).show();

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    }
