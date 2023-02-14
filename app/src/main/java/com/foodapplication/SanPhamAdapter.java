package com.foodapplication;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SanPhamAdapter extends BaseAdapter {
    Activity a;
    List<SanPham> data;

    public SanPhamAdapter(Activity a, List<SanPham> data) {
        this.a = a;
        this.data = data;
    }

    @Override
    public int getCount() {
        // Vi du lieu dau vao minh da dua list san pham
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=a.getLayoutInflater().inflate(R.layout.itemrow,null);
        TextView name= view.findViewById(R.id.nameProduct);
        TextView quantity=view.findViewById(R.id.quantityProduct);
        TextView cost=view.findViewById(R.id.costProduct);
        ImageView imgProduct=view.findViewById(R.id.imgProduct);
        SanPham product=data.get(i);
        // Vi ten san pham con dang trongs nen can setText cho no
        name.setText(product.getName());
        quantity.setText(String.valueOf(product.getQuantity()));
        cost.setText(String.valueOf(product.getCost()));
        Picasso.get().load(product.getThumbnail()).into(imgProduct);
        return view;
    }
}
