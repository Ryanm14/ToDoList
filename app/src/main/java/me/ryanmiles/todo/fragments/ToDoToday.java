package me.ryanmiles.todo.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.ryanmiles.todo.adapters.ItemListRecylerAdapter;
import me.ryanmiles.todo.domain.Item;
import me.ryanmiles.todolist.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ToDoToday extends Fragment {
    Item item;
    List<Item> item_list;
    ItemListRecylerAdapter adapter;
    public ToDoToday() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_to_do_today, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.chatgroup_recycler_view);


        //Fill with mocked data for testing UI
        adapter = new ItemListRecylerAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        ButterKnife.bind(this, view);
        adapter.notifyDataSetChanged();
        return view;
    }

    public void addItem(Item item) {
        adapter.addItem(item);
        adapter.notifyDataSetChanged();
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
                addItem(item);
                dialog.dismiss();

            }
        });


        dialog.show();
    }


}
