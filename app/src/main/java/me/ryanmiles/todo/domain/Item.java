package me.ryanmiles.todo.domain;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Ryanm14 on 8/15/2015.
 */
public class Item extends SugarRecord<Item> {
    private String title;

    public Item() {

    }

    public Item(String title) {
        this.title = title;
    }

    public static List<Item> getItems() {
        return Item.listAll(Item.class);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
