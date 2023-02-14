package com.foodapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ModifySanPham {
    // Lop nay chua cac thao tac lien quan den co so du lieu,them,sua,xoa
    public static final String SQL_CREATE_TABLE = "CREATE TABLE products (id integer primary key autoincrement, thumbnail varchar(200), name varchar(200), quantity integer, cost double)";
    public static void insert(SanPham s) {
        SQLiteDatabase sqLiteDatabase=ProcessDatabase.getInstance(null).getWritableDatabase();
        ContentValues v = new ContentValues();// su dung lop ContentValues de ghi thong tin
        v.put("thumbnail", s.getThumbnail());
        v.put("name", s.getName());
        v.put("quantity", s.getQuantity());
        v.put("cost", s.getCost());
        sqLiteDatabase.insert("products", null, v);
    }
    public static void update(SanPham s) {
        SQLiteDatabase sqLiteDatabase= ProcessDatabase.getInstance(null).getWritableDatabase();
        ContentValues v = new ContentValues();// su dung lop ContentValues de ghi thong tin
        v.put("thumbnail", s.getThumbnail());
        v.put("name", s.getName());
        v.put("quantity", s.getQuantity());
        v.put("cost", s.getCost());
        sqLiteDatabase.update("products",v,"id=" +s.getId(),null);
    }
    public static void delete(int id) {
        SQLiteDatabase sqLiteDatabase= ProcessDatabase.getInstance(null).getWritableDatabase();
        ContentValues v = new ContentValues();// su dung lop ContentValues de ghi thong tin

        sqLiteDatabase.delete("products","id=" +id,null);
    }
    public static List<SanPham> getProductList() {
        List<SanPham> list =new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=ProcessDatabase.getInstance(null).getReadableDatabase();
        String sql="select * from products";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        while (cursor.moveToNext())
        {
            @SuppressLint("Range")
            SanPham sanpham = new SanPham(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("thumbnail")), cursor.getString(cursor.getColumnIndex("name")), cursor.getInt(cursor.getColumnIndex("quantity")), cursor.getDouble(cursor.getColumnIndex("cost")));
            list.add(sanpham);
        }
        return list;
    }
}
