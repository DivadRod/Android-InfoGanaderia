package com.example.infoganaderia;

//import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrarseActivity extends AppCompatActivity {

    //Declare an instance of FirebaseAuth
    private FirebaseAuth mAuth;

    private EditText correo;
    private EditText password;
    private EditText passwordConfirmation;

    //TAG
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //ACTIVITY
        setContentView(R.layout.activity_registrarse);


        //Activity item variables
        correo = findViewById(R.id.correo);
        password = findViewById(R.id.password);
        passwordConfirmation = findViewById(R.id.passwordConfirmation);


        //In the onCreate() method, initialize the FirebaseAuth instance.
        mAuth = FirebaseAuth.getInstance();
    }


    //When initializing your Activity, check to see if the user is currently signed in.
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.

        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    public void registrarUsuario(View view){

        if(password.getText().toString().equals(passwordConfirmation.getText().toString())){

            //if(password.getTextSize() < 6){

                    mAuth.createUserWithEmailAndPassword(
                            correo.getText().toString().trim(),
                            password.getText().toString().trim()

                    ).addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();


                            Toast.makeText(getApplicationContext(), "Usuario Creado",
                                    Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                            Log.d(TAG, task.getException().toString());

                            Toast.makeText(getApplicationContext(), task.getException().toString(),
                                    Toast.LENGTH_SHORT).show();

                            //updateUI(null);
                        }

                        // ...
                    });
                    /*
             } else {
                Toast.makeText(this, "El passwords need to be 6 characters", Toast.LENGTH_SHORT).show();
             }*/
            }else{
                Toast.makeText(this, "El passwords do not match", Toast.LENGTH_SHORT).show();
            }

    }


}