package com.foodapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ManageProduct extends AppCompatActivity {
    ListView listViewProduct;
    List<SanPham> data=new ArrayList<>();
    SanPhamAdapter spadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_product_activity);
        listViewProduct= (ListView) findViewById(R.id.productView);
//        data.add(new SanPham(1,"https://cdn.tgdd.vn/2020/12/CookRecipe/Avatar/suon-xao-chua-ngot-cong-thuc-chia-se-tu-nguoi-dung-thumbnail.jpg","Suon xao chua ngot",1,30.000));
//        data.add(new SanPham(2,"https://cdn.tgdd.vn/2020/12/CookRecipe/Avatar/suon-xao-chua-ngot-cong-thuc-chia-se-tu-nguoi-dung-thumbnail.jpg","Suon xao chua ngot",1,30.000));
//        data.add(new SanPham(3,"https://cdn.tgdd.vn/2020/12/CookRecipe/Avatar/suon-xao-chua-ngot-cong-thuc-chia-se-tu-nguoi-dung-thumbnail.jpg","Suon xao chua ngot",1,30.000));
//        data.add(new SanPham(4,"https://cdn.tgdd.vn/2020/12/CookRecipe/Avatar/suon-xao-chua-ngot-cong-thuc-chia-se-tu-nguoi-dung-thumbnail.jpg","Suon xao chua ngot",1,30.000));
//        data.add(new SanPham(5,"https://cdn.tgdd.vn/2020/12/CookRecipe/Avatar/suon-xao-chua-ngot-cong-thuc-chia-se-tu-nguoi-dung-thumbnail.jpg","Suon xao chua ngot",1,30.000));
        ProcessDatabase.getInstance(this);
        registerForContextMenu(listViewProduct);
        data = ModifySanPham.getProductList();
        spadapter= new SanPhamAdapter(ManageProduct.this,data);
        listViewProduct.setAdapter(spadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuoption,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menucontext,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addoption:
                addDish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        switch (item.getItemId()) {
            case R.id.edit:
                AlertDialog.Builder b1 = new AlertDialog.Builder(ManageProduct.this);
                View v1 = LayoutInflater.from(ManageProduct.this).inflate(R.layout.modifierdish, null);
                EditText thumbnailImg = (EditText) v1.findViewById(R.id.inputImg);
                EditText nameDish = (EditText) v1.findViewById(R.id.inputdish);
                EditText quantity1 = (EditText) v1.findViewById(R.id.inputQuantity);
                EditText cost1 = (EditText) v1.findViewById(R.id.inputCost);
                b1.setView(v1);
                b1.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String thumbnail = thumbnailImg.getText().toString();
                        String name = nameDish.getText().toString();
                        int quantity = Integer.parseInt(quantity1.getText().toString());
                        double cost = Double.parseDouble(cost1.getText().toString());
                        SanPham sp = new SanPham(thumbnail, name, quantity, cost);
                        data.set(index,sp);
                        spadapter.notifyDataSetChanged();
                        ModifySanPham.update(data.get(index));
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
                break;
            case R.id.delete:
                ModifySanPham.delete(data.get(index).getId());
                data.remove(index);
                spadapter.notifyDataSetChanged();
                break;
        }

        return super.onContextItemSelected(item);
    }
    public void addDish(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);// Tao bang su kien du lieu builder
        View v = LayoutInflater.from(ManageProduct.this).inflate(R.layout.modifierdish,null);//Hợp nhất -ListView với in_country
        EditText dishName=(EditText) v.findViewById(R.id.inputdish);
        EditText imgProduct=(EditText) v.findViewById(R.id.inputImg);
        EditText quantity=(EditText) v.findViewById(R.id.inputQuantity);
        EditText cost=(EditText) v.findViewById(R.id.inputCost);
        builder.setView(v);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String thumbnail= imgProduct.getText().toString();
                String name=dishName.getText().toString();
                int iquantity=Integer.parseInt(quantity.getText().toString());
                double icost=Double.parseDouble(cost.getText().toString());
                SanPham sp= new SanPham(thumbnail,name,iquantity,icost);
                ModifySanPham.insert(sp);
                data.add(sp);
                // thay đổi trên dữ liệu đầu vào
                // thay đổi trên adapter
                spadapter.notifyDataSetChanged();
            }
        }).setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }

}