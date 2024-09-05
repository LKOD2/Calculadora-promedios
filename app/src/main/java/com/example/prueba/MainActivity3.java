package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {


    private TextView nombreElement;
    private TextView apellidoElement;
    private TextView rutElement;
    private TextView carreraElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("extra-nombre");
        String apellido = intent.getStringExtra("extra-apellido");
        String rut = intent.getStringExtra("extra-rut");
        String carrera = intent.getStringExtra("extra-carrera");

        double promedio1 = intent.getDoubleExtra("promedio1", 0.0);

        nombreElement = findViewById(R.id.tv_NombrePantalla3);
        nombreElement.setText("Nombre: " + nombre);
        apellidoElement = findViewById(R.id.tv_ApellidoPantalla3);
        apellidoElement.setText("Apellido: " + apellido);
        rutElement = findViewById(R.id.tv_RutPantalla3);
        rutElement.setText("Rut: " + rut);
        carreraElement = findViewById(R.id.tv_CarreraPantalla3);
        carreraElement.setText("Carrera: " + carrera);
    }
}