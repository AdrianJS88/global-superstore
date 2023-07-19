package com.ltp.globalsuperstore.repository;

import com.ltp.globalsuperstore.Item;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
   private List<Item> items = new ArrayList<>();
   public  Item getItem(int index){
      return items.get( index );
   }
   public void addItem(Item grade){
      items.add( grade );
   }
   public void updateItem(Item grade,int index){
      items.set( index,grade );
   }
   public List<Item> getItems(){
      return  items;
   }
}
