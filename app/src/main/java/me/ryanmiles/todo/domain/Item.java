package me.ryanmiles.todo.domain;

import com.orm.SugarRecord;

import java.util.List;

import me.ryanmiles.todo.Constants;

/**
 * Created by Ryanm14 on 8/15/2015.
 */
public class Item extends SugarRecord<Item> {
    private String title;
    private String strike_text;
    private int priority;
    public Item() {

    }

    public Item(String title, int priority) {
        this.title = title;
        strike_text = Constants.STRIKE_FALSE;
        this.priority = priority;
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

    public boolean isStrike() {
        return strike_text.equals(Constants.STRIKE_TRUE);
    }

    public void setStrike(boolean strike) {
        if (strike) {
            strike_text = Constants.STRIKE_TRUE;
        } else {
            strike_text = Constants.STRIKE_FALSE;
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
