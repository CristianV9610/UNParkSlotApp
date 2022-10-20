package edu.unal.parkslotapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.PublicKey;

public class registro extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText signinEmail;
    private EditText signinUser;
    private EditText signinPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_siginin);
        mAuth = FirebaseAuth.getInstance();
        signinEmail = findViewById(R.id.signinEmail);
        signinUser = findViewById(R.id.signinUser);
        signinPassword = findViewById(R.id.signinPassword);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }
    public void onloggClick(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);

    }
    public void registroUsuario(View view){
        /*
        mAuth.createUserWithEmailAndPassword()
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCustomToken:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                            Toast.makeText(CustomAuthActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });*/

    }

}