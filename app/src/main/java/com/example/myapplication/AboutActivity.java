package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AboutActivity extends AppCompatActivity {
    //private Button gotog;
    // private final int ID_HOME=1;
    // private final int ID_CART=2;
    // private final int ID_SETTING=3;
    // private final int ID_PROFILE=4;

    //private CardView cardView;
    private FirebaseAuth maFirebaseAuth=FirebaseAuth.getInstance();
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://leen-s-application-default-rtdb.europe-west1.firebasedatabase.app/");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // gotog=findViewById(R.id.gotog);
        setContentView(R.layout.activity_about);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        String UID=maFirebaseAuth.getUid();
        DatabaseReference myRef = database.getReference("users/"+UID);
        Toast.makeText(this, "UDI"+UID, Toast.LENGTH_SHORT).show();
        Log.d("LEEEEEN", UID);
        myRef.push().setValue(new Item("this is my first item",R.drawable.img_2,true,50));

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.homeFragment:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.cartFragment:
                            selectedFragment = new CartFragment();
                            break;

                        case R.id.profileFragment:
                            selectedFragment = new profileFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, selectedFragment).commit();
                return true;
                }
            };

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