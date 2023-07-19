package com.ltp.globalsuperstore.service;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.StoreRepository;

import java.util.List;

public class StoreService {
    StoreRepository  storeRepository = new StoreRepository();

public Item getItem(int index){
    return storeRepository.getItem( index );
}

    public void addItem(Item grade){
        storeRepository.addItem( grade );
    }
    public void  updateItem(Item grade, int index){
        storeRepository. updateItem( grade,index );
    }
    public List<Item> getItems(){
        return storeRepository.getItems();
    }
    public int getItemIndex(String id) {
        for (int i = 0; i < getItems().size(); i++) {
            if (getItem(i).getId( ).equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }public Item getItemById(String id){
    int index = getItemIndex (id);
    return  index == Constants.NOT_FOUND ? new Item() : getItem(index);
}
    public void  submitItem(Item item){
        int index = getItemIndex( item.getId() );
        if (index == Constants.NOT_FOUND) {
            addItem(item);
        } else {
            updateItem(item,index);
        }
    }
}