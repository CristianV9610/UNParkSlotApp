package edu.unal.parkslotapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class win_parking_lot_list extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_parking_lot_list);
    }
    public void Cyt(View view) {
        setContentView(R.layout.win_parking_lot_view);

    }
}
