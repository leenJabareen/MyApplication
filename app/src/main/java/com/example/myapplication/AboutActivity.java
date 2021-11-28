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
import android.widget.TextView;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class AboutActivity extends AppCompatActivity {
 //private Button gotog;
    private final int ID_HOME=1;
    private final int ID_CART=2;
    private final int ID_SETTING=3;
    private final int ID_PROFILE=4;


    //private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // gotog=findViewById(R.id.gotog);
        setContentView(R.layout.activity_about);
       /* cardView=findViewById(R.id.cardView);
        cardView.setRadius(5.0f);
        cardView.setCardElevation(11.0f);
        cardView.setUseCompatPadding(true);
*/
        TextView selected_page=findViewById(R.id.selected_page);
        MeowBottomNavigation bottomNavigation=findViewById(R.id.bottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_HOME,R.drawable.home));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_CART,R.drawable.shoppingcart));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_SETTING,R.drawable.settings));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_PROFILE,R.drawable.account));

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(AboutActivity.this, "clicked item: "+item.getId(), Toast.LENGTH_SHORT).show();

            }
        });
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                String name;
                switch(item.getId()){
                    case ID_HOME:name="Home";
                    break;
                    case ID_SETTING:name="settings";
                    break;
                    case ID_PROFILE:name="profile";
                    break;
                    case ID_CART:name="shopping Cart";
                    break;
                    default: name="";
                }
              selected_page.setText(getString(R.string.main_page_selsected,name));
            }
        });

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