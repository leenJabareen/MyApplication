package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private static final String TAG ="FIREBASE" ;
    private EditText editTextTextPassword, editTextTextEmailAddress,editTextName;
    private FirebaseAuth maFirebaseAuth=FirebaseAuth.getInstance();
    //write a message to the dataBase
    // gets the root of the real time database in the FB console
    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://leen-s-application-default-rtdb.europe-west1.firebasedatabase.app/");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth=FirebaseAuth.getInstance();
        editTextTextEmailAddress=findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword=findViewById(R.id.editTextTextPassword);
        editTextName=findViewById(R.id.editTextName);

    }
    public void Submit(View view) {
        signup(editTextTextEmailAddress.getText().toString(),editTextTextPassword.getText().toString());
    }



    public void submit(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        if (!editTextTextEmailAddress.getText().toString().equals("")) {
            //saving email and password of user in a local file for future use
            //create sp file
            SharedPreferences sp = getSharedPreferences("settings", MODE_PRIVATE);
            //open editor for editing
            SharedPreferences.Editor editor = sp.edit();
            //write the wanted settings
            editor.putString("email", editTextTextEmailAddress.getText().toString());
            editor.putString("password", editTextTextPassword.getText().toString());
            //save and close file
            editor.commit();
            intent.putExtra("email", editTextTextEmailAddress.getText().toString());
            signup(editTextTextEmailAddress.getText().toString(),editTextTextPassword.getText().toString());
            //startActivity(intent);
        }

    }
    public void signup(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            DatabaseReference myRef = database.getReference("profiles/"+user.getUid());//getRefrence returns a root
                            String key = myRef.push().getKey();
                            User u1 = new User(editTextName.getText().toString(),email,password);
                            u1.setKey(key);
                            myRef = database.getReference("profiles/"+user.getUid()+"/"+key);
                            myRef.setValue(u1);

                            Intent i =new Intent (SignUpActivity.this,MainActivity.class);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
}