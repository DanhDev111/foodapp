package com.foodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ManagementCart managementCart;
    TextView totalCostTxt,deliveryTxt,emptyTxt,totalTxt;
    ScrollView scrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        managementCart = new ManagementCart(this);
        initView();

    }
    public void calculatedCard(){
        double delivery=10;
        double total=Math.round(managementCart.getTotalCost()+delivery);
        double itemTotal=Math.round(managementCart.getTotalCost()*100.0)/100.0;
        totalCostTxt.setText("$"+itemTotal);
        deliveryTxt.setText("$"+delivery);
        totalTxt.setText("$"+total);
    }

    public void initView(){
//        totalCostTxt=findViewById(R.id.totalCostTxt);
//        totalTxt=findViewById(R.id.totalTxt);
//        deliveryTxt=findViewById(R.id.deliveryTxt);
//        emptyTxt=findViewById(R.id.emptyTxt);

    }
}