package edu.unal.parkslotapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class win_parking_lot_view extends AppCompatActivity {

    private TextView disponibles;
    private Button slot1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_parking_lot_view);

        disponibles = findViewById(R.id.textEmmptySpaceCount);
        slot1 = findViewById(R.id.Slot1);

        disponibles.setText("100");

        slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarSoltar();
            }
        });
    }

    private void seleccionarSoltar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(win_parking_lot_view.this);
        builder.setTitle("Parqueadero");
        builder.setMessage("¿Que desea hacer?")
                .setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Si selecciona", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Desocupar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Si desocupa", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).show();
    }
}
