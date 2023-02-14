package com.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;
import android.app.ActionBar;

public class MeatListView extends AppCompatActivity {
    LinearLayout linearclickbbq,clickchicken,clicksbacon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meat_list_view);

        linearclickbbq = (LinearLayout) findViewById(R.id.linearclickbbq);
        linearclickbbq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MeatListView.this, ShowDetailsActivity.class);
                startActivity(i);
            }
        });
        clickchicken =(LinearLayout) findViewById(R.id.clickchicken);
        clickchicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MeatListView.this, ShowDetails2Activity.class);
                startActivity(i);
            }
        });
        clicksbacon = (LinearLayout) findViewById(R.id.clicksbacon);
        clicksbacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MeatListView.this, ShowDetails3Activity.class);
                startActivity(i);
            }
        });
    }


//    soupDish = (ImageView) findViewById(R.id.soupDish);
//        meatDish.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(ContentExternal.this,"Login Successfully",Toast.LENGTH_LONG).show();
//            Intent i = new Intent(ContentExternal.this, MeatListView.class);
//            startActivity(i);
//        }
//    });


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menuoption,menu);
        return super.onCreateOptionsMenu(menu);
    }
}