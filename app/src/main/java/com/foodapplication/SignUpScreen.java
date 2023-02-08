package com.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpScreen extends AppCompatActivity {
    Button button_ok;
    EditText signup_nameinput,signup_phone,signup_emailinput,signup_passinput,confirmpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signup_screen);
        signup_passinput=(EditText) findViewById(R.id.signup_passinput);
        signup_emailinput=(EditText) findViewById(R.id.signup_emailinput);
        confirmpass=(EditText) findViewById(R.id.confirmpass);
        signup_nameinput=(EditText) findViewById(R.id.signup_nameinput);
        signup_phone=(EditText) findViewById(R.id.signup_phone);
        button_ok=(Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=signup_emailinput.getText().toString();
                String name=signup_nameinput.getText().toString();
                String telphone=signup_phone.getText().toString();
                String password=signup_passinput.getText().toString();
                String matkhauxacthuc=confirmpass.getText().toString();
                if (!(password.equalsIgnoreCase(matkhauxacthuc))){
                    Toast.makeText(SignUpScreen.this,"Wrong password",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i=new Intent();
                    i.putExtra("name",name);
                    i.putExtra("telphone",telphone);
                    i.putExtra("email",email);
                    i.putExtra("password",password);
                    setResult(LoginScreen.REGIS_CODE,i);
                    SharedPreferences s= getSharedPreferences("D05",MODE_PRIVATE);
                    SharedPreferences.Editor edit=s.edit();
                    edit.putString("name",name);
                    edit.putString("email",email);
                    edit.putString("phone number",telphone);
                    edit.putString("password",password);
                    edit.commit();
                    finish();
                }
            }
        });
    }
}