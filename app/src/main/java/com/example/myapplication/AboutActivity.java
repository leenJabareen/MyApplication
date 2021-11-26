package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
 //private Button gotog;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // gotog=findViewById(R.id.gotog);
        setContentView(R.layout.activity_about);
        cardView=findViewById(R.id.cardView);
        cardView.setRadius(5.0f);
        cardView.setCardElevation(11.0f);
        cardView.setUseCompatPadding(true);


    }
   // inflates the design of the required menu on the top of the activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu, menu); // put 2 xmls ine each other
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settingsMenu:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exitMenu:
             //close the app
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
   /* public void gotogallery(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }*/
}