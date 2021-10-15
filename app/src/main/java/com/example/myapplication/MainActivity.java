package com.example.myapplication;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, DialogInterface.OnClickListener {


private EditText editTextName, editTextPassword;
private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById returns reference to the object with the specefied id
        buttonLogin=findViewById(R.id.buttonLogin);
        editTextName=findViewById(R.id.editTextName);
        editTextPassword=findViewById(R.id.editTextPassword);
       //sets the required button to response to long click ,otherwise wont
        buttonLogin.setOnLongClickListener(this);

        SharedPreferences sp=getSharedPreferences("setting",MODE_PRIVATE);
        String email=sp.getString("email","");
        String password=sp.getString("password", "");

        if(!email.equals("")&& !password.equals("")){
            editTextName.setText(email);
            editTextPassword.setText(password);
        }
    }


    public void login(View view) {
        Intent intent=new Intent(this, AboutActivity.class);
        if(!editTextName.getText().toString().equals(""))

         {
             //saving email and password of user in a local file for future use
            // create sp file
            SharedPreferences sp=getSharedPreferences("setting",MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor= sp.edit();
            //write the wanted setting
            editor.putString("email",editTextName.getText().toString());
            editor.putString("password",editTextPassword.getText().toString());

            //save the close file
            editor.commit();
            intent.putExtra("name",editTextName.getText().toString());
            startActivity(intent);// ورثت من السوبر كلاس
        }
    }
// clears the email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
       editTextName.setText("");
       editTextPassword.setText("");
        return true;
    }
    public void SignUp(View view){
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
      if(which==dialog.BUTTON_POSITIVE){
          super.onBackPressed();
          dialog.cancel();
      }
      if (which==dialog.BUTTON_NEGATIVE){
          dialog.cancel();
      }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES",this);
        builder.setNegativeButton("No",this);
        AlertDialog dialog =builder.create();
        dialog.show();
    }
}