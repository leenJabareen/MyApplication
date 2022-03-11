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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class CartAdapter extends ArrayAdapter<Item> {
    FirebaseDatabase database=FirebaseDatabase.getInstance("https://leen-s-application-default-rtdb.europe-west1.firebasedatabase.app/");
    private FirebaseAuth mAuth= FirebaseAuth.getInstance();
    String UID=mAuth.getUid();
    DatabaseReference myRef=database.getReference("Cart/"+UID);
    private Context context;// the page that the datas are shown in it
    private int resource;// how tidy the data is

    // דריסה ב view
    private TextView price;
    public CartAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
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
            ImageView imageView = view.findViewById(R.id.imageItemCart);
            TextView textView=view.findViewById(R.id.descreptionCart);
            TextView textView2=view.findViewById(R.id.priceCart);
            Button itemButton=view.findViewById(R.id.delete);
            itemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "this Item was added to shopping card", Toast.LENGTH_SHORT).show();
                    myRef.push().setValue(item);
                }
            });
            imageView.setImageResource(getItem(position).getResid());
            textView.setText(getItem(position).getDescriotion());
            textView2.setText(getItem(position).getPrice()+" ");
        }
        return view;
    }
}
