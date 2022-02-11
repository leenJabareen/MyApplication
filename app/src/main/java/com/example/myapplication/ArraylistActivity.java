package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArraylistActivity extends AppCompatActivity {
    // the object of the view-design
    private ListView myListView;
    // the object for the adapter connecting the data to the view
    private CustomAdapter myAdapter;
    //object containing the items to be displayed -Data
    private ArrayList<Item> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arraylist);

         list=new ArrayList<>();
         list.add(new Item("harry piter book",R.drawable.harrypoterbook,16,50));
         list.add(new Item("this is my 2nd item",R.drawable.pastelpink,10,50));
         list.add(new Item("Me before you",R.drawable.mebeforeyou,17,50));
         list.add(new Item("wonder ",R.drawable.wonderbook,6,50));
       //  list.add(new Item("this is my 5th item",R.drawable.pastelpink,7,50));

         //refrence to the list view so it can be programmed
         myListView =findViewById(R.id.myListView);

         //connect adaptor with data
         myAdapter=new CustomAdapter(this,R.layout.item_row,list) ;//thr other side is to design

         //connect adapter with view
        myListView.setAdapter(myAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Item:"+list.get(i),Toast.LENGTH_LONG).show();

            }
        });
myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        list.remove(i);
        myAdapter.notifyDataSetChanged();
        return false;
    }
});
    }
}