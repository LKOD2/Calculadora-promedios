package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText rut;
    private EditText carrera;
    private Button enviar;
    private Button borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.editTextNombre);
        apellido = findViewById(R.id.editTextApellido);
        rut = findViewById(R.id.editTextRut);
        carrera = findViewById(R.id.editTextCarrera);
        enviar = findViewById(R.id.buttonEnviar);
        borrar = findViewById(R.id.buttonBorrar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDatos();
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarDatos();
            }
        });



    }
    private void validarDatos(){
        String nombreTexto = nombre.getText().toString();
        String apellidoTexto = apellido.getText().toString();
        String rutText = rut.getText().toString();
        String carreraText = carrera.getText().toString();

        if (nombreTexto.isEmpty()){
            nombre.setError("Ingresa el nombre");
            return;
        }
        if (apellidoTexto.isEmpty()){
            apellido.setError("Ingresa el apellido");
            return;
        }
        if (rutText.isEmpty()){
            rut.setError("ingresa el rut");
            return;
        }else if (rutText.length() != 9){
            rut.setError("Ingresa un rut valido");
            return;
        }
        if (carreraText.isEmpty()){
            carrera.setError("Ingresa una carrera");
            return;
        }

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("extra-nombre", nombreTexto);
        intent.putExtra("extra-apellido", apellidoTexto);
        intent.putExtra("extra-rut", rutText);
        intent.putExtra("extra-carrera", carreraText);
        startActivity(intent);
    }

    private void limpiarDatos(){
        nombre.setText("");
        apellido.setText("");
        rut.setText("");
        carrera.setText("");
    }
}