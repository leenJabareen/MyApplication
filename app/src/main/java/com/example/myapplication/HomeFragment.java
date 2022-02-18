package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**/
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        CardView card_view =root.findViewById(R.id.booksCard); // creating a CardView and assigning a value.
        CardView card_view2=root.findViewById((R.id.elecrtronicCard));
        CardView card_view3=root.findViewById(R.id.womenCard);
        CardView card_view4=root.findViewById((R.id.menCard));
        CardView card_view5=root.findViewById(R.id.babyStuffCard) ;
        CardView card_view6=root.findViewById(R.id.shoesCard);


        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), ArraylistActivity.class);
                i.putExtra("category","books");
                startActivity(i);
            }
        });
        card_view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), ArraylistActivity.class);
                i.putExtra("category","electronic");

                startActivity(i);
            }
        });
        card_view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), ArraylistActivity.class);
                i.putExtra("category","women");
                startActivity(i);
            }
        });
        card_view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), ArraylistActivity.class);
                i.putExtra("category","men");
                startActivity(i);
            }
        });
        card_view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), ArraylistActivity.class);
                i.putExtra("category","babyStuff");
                startActivity(i);
            }
        });
        card_view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(root.getContext(), ArraylistActivity.class);
                i.putExtra("category","shoes");
                startActivity(i);
            }
        });
        return root;
    }

}