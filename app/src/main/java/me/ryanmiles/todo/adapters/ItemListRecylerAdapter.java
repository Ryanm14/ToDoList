package me.ryanmiles.todo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import me.ryanmiles.todo.domain.Item;
import me.ryanmiles.todolist.R;


public class ItemListRecylerAdapter extends RecyclerView.Adapter<ItemListRecylerAdapter.MyViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<Item> items = new ArrayList<>();
    Item item = new Item();

    public ItemListRecylerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        items = (ArrayList<Item>) Item.getItems();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_card_layout, parent, false);
        return (new MyViewHolder(view));
    }


    @Override
    public void onBindViewHolder(ItemListRecylerAdapter.MyViewHolder holder, int position) {
        Item item = items.get(position);
        holder.title.setText(item.getTitle());
        //holder.itemView.setOnClickListener(new OpenItem(position));
        holder.relativeLayout.setTag(position);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RelativeLayout cb = (RelativeLayout) v;
                int pos = (int) cb.getTag();
                removeItem(pos);
            }
        });
    }


    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(int pos) {
        Item d = items.get(pos);
        d = Item.findById(Item.class, d.getId());
        d.delete();
        items.remove(pos);
        notifyDataSetChanged();
    }

    public void setItemList(ArrayList<Item> itemlist) {
        items.addAll(itemlist);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        View itemView;
        TextView title;
        RelativeLayout relativeLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            title = (TextView) itemView.findViewById(R.id.title_text_view);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.card_layout);
        }
    }

   /* class OpenItem implements View.OnClickListener {
        private int position;

        public OpenItem(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(context, ChatActivity.class);
            i.putExtra(ChatActivity.EXTRA_CHAT_GROUP, items.get(position));
            context.startActivity(i);
        }
    }


    */

}
