package edu.unal.parkslotapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.*;

import java.util.HashMap;
import java.util.Map;

public class win_parking_lot_list extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private int cantidadParqueaderos = 0;
    private TextView disponibles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_parking_lot_list);
    }
    public void Cyt(View view) {
        setContentView(R.layout.win_parking_lot_view);

        disponibles = findViewById(R.id.textEmmptySpaceCount);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("CYT").addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Boolean Slot1 = (Boolean) snapshot.child("Slot1").getValue();
                    if(Slot1){
                        cantidadParqueaderos++;
                        disponibles.setText(String.valueOf(cantidadParqueaderos));
                    }
                    Boolean Slot2 = (Boolean) snapshot.child("Slot2").getValue();
                    if(Slot2){
                        cantidadParqueaderos++;
                        disponibles.setText(String.valueOf(cantidadParqueaderos));
                    }
                    Boolean Slot3 = (Boolean) snapshot.child("Slot3").getValue();
                    if(Slot3){
                        cantidadParqueaderos++;
                        disponibles.setText(String.valueOf(cantidadParqueaderos));
                    }
                    Boolean Slot4 = (Boolean) snapshot.child("Slot4").getValue();
                    if(Slot4){
                        cantidadParqueaderos++;
                        disponibles.setText(String.valueOf(cantidadParqueaderos));
                    }
                    Boolean Slot5 = (Boolean) snapshot.child("Slot5").getValue();
                    if(Slot5){
                        cantidadParqueaderos++;
                        disponibles.setText(String.valueOf(cantidadParqueaderos));
                    }
                    Boolean Slot6 = (Boolean) snapshot.child("Slot6").getValue();
                    if(Slot6){
                        cantidadParqueaderos++;
                        disponibles.setText(String.valueOf(cantidadParqueaderos));
                    }
                    cantidadParqueaderos = 0;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        findViewById(R.id.Slot1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarSoltar("Slot1");
            }
        });
        findViewById(R.id.Slot2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarSoltar("Slot2");
            }
        });
        findViewById(R.id.Slot3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarSoltar("Slot3");
            }
        });
        findViewById(R.id.Slot4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarSoltar("Slot4");
            }
        });
        findViewById(R.id.Slot5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarSoltar("Slot5");
            }
        });
        findViewById(R.id.Slot6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarSoltar("Slot6");
            }
        });
    }

    private void seleccionarSoltar(String numSlot){
        AlertDialog.Builder builder = new AlertDialog.Builder(win_parking_lot_list.this);
        builder.setTitle("Parqueadero");
        builder.setMessage("¿Que desea hacer?")
                .setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Map<String,Object> slotMap = new HashMap<>();
                        slotMap.put(numSlot,false);
                        mDatabase.child("CYT").updateChildren(slotMap);
                    }
                })
                .setNegativeButton("Desocupar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Map<String,Object> slotMap = new HashMap<>();
                        slotMap.put(numSlot,true);
                        mDatabase.child("CYT").updateChildren(slotMap);
                        dialog.dismiss();
                    }
                }).show();
    }
}
