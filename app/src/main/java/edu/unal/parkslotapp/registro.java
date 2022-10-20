package edu.unal.parkslotapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.PublicKey;

public class registro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText signinEmail;
    //private EditText signinUser;
    private EditText signinPassword;
    private EditText signinPassword1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_siginin);
        mAuth = FirebaseAuth.getInstance();
        signinEmail = findViewById(R.id.signinEmail);
        signinPassword = findViewById(R.id.signinPassword);
        signinPassword1 = findViewById(R.id.signinPassword1);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void onloggClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void registroUsuario(View view){
        if (signinPassword.getText().toString().equals(signinPassword1.getText().toString())){
            mAuth.createUserWithEmailAndPassword(signinEmail.getText().toString(), signinPassword.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(), "Usuario creado con exito .", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(getApplicationContext(), win_parking_lot_list.class);
                                startActivity(intent);
                              //  updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(getApplicationContext(), "Registro fallido !!.", Toast.LENGTH_SHORT).show();
                                //updateUI(null);
                            }
                        }
                    });
        }else{
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }


    }

}