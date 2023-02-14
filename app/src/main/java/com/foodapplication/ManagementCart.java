package com.foodapplication;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

public class ManagementCart {
    Context context;
    TinyDB tinyDB;

    public ManagementCart(CartActivity cartActivity) {
        this.context = context;
        this.tinyDB = tinyDB;
    }
    //1:09:23
    public  void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood = getListCart();
        boolean existAlready = false;
        int n=0;
        for (int i=0;i<listFood.size();i++){
            if (listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }
        if (existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }else {
            listFood.add(item);
        }
//        tinyDB.putListObject("CartList",listFood);
        Toast.makeText(context,"Added to your cart",Toast.LENGTH_LONG).show();
    }

    private ArrayList<FoodDomain> getListCart() {
        return null;
    }
    public  void minusNumberFood(ArrayList<FoodDomain> listfood, int position,ChangeNumberItemsListener changeNumberItemsListener){
        if (listfood.get(position).getNumberInCart()==1){
            listfood.remove(position);
        }else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.change();
    }
    public void plusNumberFood(ArrayList<FoodDomain> listfood,int position,ChangeNumberItemsListener changeNumberItemsListener){
        listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList",listfood);
        changeNumberItemsListener.change();
    }
    public Double getTotalCost(){
        ArrayList<FoodDomain> listfood2=getListCart();
        double cost =0;
        for (int i =0;i<listfood2.size();i++){
            cost=cost+(listfood2.get(i).getCost()*listfood2.get(i).getNumberInCart());

        }
        return  cost;
    }

//    private ArrayList<FoodDomain> getListCart() {
//    return tinyDB.getListObject("CartList");
//    }
}
