package me.ryanmiles.todo.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.ryanmiles.todo.domain.Item;
import me.ryanmiles.todolist.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ToDoToday extends Fragment {
    @Bind(R.id.show_items)
    TextView items;
    Item item;
    List<Item> item_list;

    public ToDoToday() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do_today, container, false);
        ButterKnife.bind(this, view);
        updateItems();
        return view;
    }

    @OnClick(R.id.fab)
    public void newItem() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setTitle("Title");

        Button button = (Button) dialog.findViewById(R.id.add_new_task);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText edit = (EditText) dialog.findViewById(R.id.newTask);
                item = new Item(edit.getText().toString());
                item.save();
                updateItems();
                dialog.dismiss();

            }
        });


        dialog.show();
    }

    private void updateItems() {
        item_list = Item.listAll(Item.class);
        for (Item itemy : item_list) {
            items.append("\n" + itemy.getTitle());
        }
    }
}
