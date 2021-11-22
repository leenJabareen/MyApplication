package com.example.myapplication;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, DialogInterface.OnClickListener {

// הגדרת תכונות
    private static final String TAG = "FIREBASE";
    private EditText editTextName, editTextPassword;
    private Button buttonLogin;
    private ImageView imagerow;
    private FirebaseAuth mAuth;
    private Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // returns a refrence to the instance of the project firebase
        mAuth = FirebaseAuth.getInstance();  // لكي نستطيع الوصول الى الفاير بيس الخاص بالبرويكت من العنان الذي في جوجل
        // this will start the service which in turn will the music
        musicIntent=new Intent(this,MusicService.class);
        startService(musicIntent);

        //findViewById returns reference to the object with the specefied id
        imagerow=findViewById(R.id.imagerow);
        editTextName=findViewById(R.id.editTextName);
        editTextPassword=findViewById(R.id.editTextPassword);
       //sets the required button to response to long click ,otherwise wont
        imagerow.setOnLongClickListener(this);

        SharedPreferences sp=getSharedPreferences("setting",MODE_PRIVATE); // mode private فقط الابلكاتسيا يمكنها الوصول الر هاي الاابلكاتسيا وبتغدر تغييرها
        String email=sp.getString("email","");
        String password=sp.getString("password", "");

        if(!email.equals("")&& !password.equals("")){
            editTextName.setText(email);
            editTextPassword.setText(password);

        }

    }


    public void login(View view) {
        //Intent intent=new Intent(this, AboutActivity.class);
        if(!editTextName.getText().toString().equals(""))

         {
             //saving email and password of user in a local file for future use
            // create sp file
            SharedPreferences sp=getSharedPreferences("setting",MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor= sp.edit();
            //write the wanted setting
            editor.putString("email",editTextName.getText().toString()); //
            editor.putString("password",editTextPassword.getText().toString());

            //save and close file
            editor.commit(); // save שינויים
            //ntent.putExtra("name",editTextName.getText().toString());

            login(editTextName.getText().toString(),editTextPassword.getText().toString());

           // startActivity(intent);// ورثت من السوبر كلاس
        }
    }
// clears the email and password input on long click by user
    @Override
    public boolean onLongClick(View view) {
       editTextName.setText("");
       editTextPassword.setText("");
        return true;
    }
    // بتوخد ايميل وباسوورد من الايديت تيكست وبتبعثهن للبعولا تاعت الفاير بيس عن طريق الانستانس
    //




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
    public void login(String email,String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i=new Intent(MainActivity.this,AboutActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}