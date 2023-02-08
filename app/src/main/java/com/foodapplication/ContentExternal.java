package com.foodapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ContentExternal extends AppCompatActivity {
    ImageView meatDish,saladDish,dessert,soupDish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_external);
        meatDish = (ImageView) findViewById(R.id.meatDish);
        saladDish = (ImageView) findViewById(R.id.saladDish);
        dessert =(ImageView) findViewById(R.id.dessert);
        soupDish = (ImageView) findViewById(R.id.soupDish);
        meatDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ContentExternal.this,"Login Successfully",Toast.LENGTH_LONG).show();
                Intent i = new Intent(ContentExternal.this, MeatListView.class);
                startActivity(i);
            }
        });
        dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContentExternal.this, DessertListView.class);
                startActivity(i);
            }
        });

    }
}
