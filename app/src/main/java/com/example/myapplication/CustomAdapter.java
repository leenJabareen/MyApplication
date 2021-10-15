package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
// we take usually the data from the furebase but we havent learn it yet
public class CustomAdapter extends ArrayAdapter<Item> {

    private Context context;// the page that the datas are shown in it
    private int resource;// how tidy the data is
// דריסה ב view
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
        this.context =context;
        this.resource=resource;//this the item row resource ,the design for each row
    }
 //returns the view after building it
    // the output of tghe viw is all the page
    //builds meshachbel and returns the view
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null)
            //put all the data and tidy it in the page(view) and the template(design)
            view = LayoutInflater.from(context).inflate(resource, parent, false);
        Item item = getItem(position); //methodnfrom the android studio
        if (item != null) {
            ImageView imageView = view.findViewById(R.id.imageItem);
            TextView textView=view.findViewById(R.id.textview1);
            Button itemButton=view.findViewById(R.id.ItemButton);
            itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "this Item was added to shopping card", Toast.LENGTH_SHORT).show();
                                              }
            });
                    imageView.setImageResource(item.getResid());
            textView.setText(item.getDescriotion());
        }
        return view;
    }
}
