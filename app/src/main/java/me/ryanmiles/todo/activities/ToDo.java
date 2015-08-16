package me.ryanmiles.todo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import me.ryanmiles.todo.fragments.ToDoToday;
import me.ryanmiles.todolist.R;

public class ToDo extends AppCompatActivity {

    ToDoToday toDoTodayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);
        if (savedInstanceState == null) {
            toDoTodayFragment = new ToDoToday();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.todo_frame, toDoTodayFragment)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_to_do, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
