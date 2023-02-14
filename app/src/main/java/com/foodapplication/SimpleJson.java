package com.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleJson extends AppCompatActivity {
    EditText edname,edcost,edquantity;
    ImageView image;
    Button display_btn;
    String json="{\n" +
            "  \"id\":1,\n" +
            "  \"name\":\"vit quay\",\n" +
            "  \"thumbnail\":\"https://cdn-img-v2.webbnc.net/uploadv2/web/14/14961/product/2020/12/17/10/40/1608175388_1607074692_vit-quay-bac-kinh_nguyen-con_01.png\",\n" +
            "  \"quantity\":1,\n" +
            "  \"cost\":20.00\n" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthijson);
        image=(ImageView) findViewById(R.id.imagejson);
        edname = (EditText) findViewById(R.id.edname);
        edcost = (EditText) findViewById(R.id.edcost);
        edquantity =(EditText) findViewById(R.id.edquantity);
        display_btn=(Button) findViewById(R.id.display_btn);
        display_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    JSONObject ob= new JSONObject(json);
                    String ten=ob.getString("name");
                    String anh=ob.getString("thumbnail");
                    int soluong=ob.getInt("quantity");
                    double gia=ob.getDouble("cost");
                    // Sau khi lay thong tin trong JSON ra thi day len cac edit text
                    edname.setText(ten);
                    edquantity.setText(String.valueOf(soluong));
                    edcost.setText(String.valueOf(gia));
                    Picasso.get().load(anh).into(image);
                } catch (JSONException e) {
                    throw  new RuntimeException(e);
//                    e.printStackTrace();
                }
            }
        });
    }
}