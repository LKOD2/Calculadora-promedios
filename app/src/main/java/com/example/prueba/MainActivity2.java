package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private TextView textTitulo;
    private TextView nombreElement;
    private TextView apellidoElement;
    private TextView rutElement;
    private TextView carreraElement;

    private EditText asignatura1Element;
    private EditText nota1Asignatura1Element;
    private EditText nota2Asignatura1Element;

    private EditText asignatura2Element;
    private EditText nota1Asignatura2Element;
    private EditText nota2Asignatura2Element;

    private Button botonVolver;
    private Button botonSiguiente;

    String nombre = "", apellido = "", rut = "", carrera = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);



        Intent intent = getIntent();
        nombre = intent.getStringExtra("extra-nombre");
        apellido = intent.getStringExtra("extra-apellido");
        rut = intent.getStringExtra("extra-rut");
        carrera = intent.getStringExtra("extra-carrera");

        nombreElement = findViewById(R.id.textViewNombrePantalla2);
        nombreElement.setText("Nombre: " + nombre);
        apellidoElement = findViewById(R.id.textViewApellidoPantalla2);
        apellidoElement.setText("Apellido: " + apellido);
        rutElement = findViewById(R.id.textViewRutPantalla2);
        rutElement.setText("Rut: " + rut);
        carreraElement = findViewById(R.id.textViewCarreraPantalla2);
        carreraElement.setText("Carrera: " + carrera);

        botonVolver = findViewById(R.id.buttonVolver);
        botonSiguiente = findViewById(R.id.buttonSiguiente);


        volver();
        validar();

    }

    private void calcular(){

    }

    private void validar() {

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                asignatura1Element = findViewById(R.id.editTextAsignatura1);
                nota1Asignatura1Element = findViewById(R.id.editTextAsignatura1Nota1);
                nota2Asignatura1Element = findViewById(R.id.editTextAsignatura1Nota2);

                asignatura2Element = findViewById(R.id.editTextAsignatura2);
                nota1Asignatura2Element = findViewById(R.id.editTextAsignatura2Nota1);
                nota2Asignatura2Element = findViewById(R.id.editTextAsignatura2Nota2);

                String asignatura1 = asignatura1Element.getText().toString().trim();
                String nota1Asignatura1 = nota1Asignatura1Element.getText().toString().trim();
                String nota2Asignatura1 = nota2Asignatura1Element.getText().toString().trim();

                String asignatura2 = asignatura2Element.getText().toString().trim();
                String nota1Asignatura2 = nota1Asignatura2Element.getText().toString().trim();
                String nota2Asignatura2 = nota2Asignatura2Element.getText().toString().trim();

                boolean isValid = true;

                double nota1A1 = 0, nota2A1 = 0, nota1A2 = 0, nota2A2 = 0;

                if (asignatura1.isEmpty()) {
                    asignatura1Element.setError("Ingresa un valor");
                    isValid = false;
                }

                if (nota1Asignatura1.isEmpty()) {
                    nota1Asignatura1Element.setError("Ingresa un valor");
                    isValid = false;
                } else {
                    try {
                        nota1A1 = Double.parseDouble(nota1Asignatura1);
                        if (nota1A1 < 1 || nota1A1 > 7) {
                            nota1Asignatura1Element.setError("Ingresa una nota entre 1 y 7");
                            isValid = false;
                        }
                    } catch (NumberFormatException e) {
                        nota1Asignatura1Element.setError("Ingresa un número válido");
                        isValid = false;
                    }
                }

                if (nota2Asignatura1.isEmpty()) {
                    nota2Asignatura1Element.setError("Ingresa un valor");
                    isValid = false;
                } else {
                    try {
                        nota2A1 = Double.parseDouble(nota2Asignatura1);
                        if (nota2A1 < 1 || nota2A1 > 7) {
                            nota2Asignatura1Element.setError("Ingresa una nota entre 1 y 7");
                            isValid = false;
                        }
                    } catch (NumberFormatException e) {
                        nota2Asignatura1Element.setError("Ingresa un número válido");
                        isValid = false;
                    }
                }

                if (asignatura2.isEmpty()){
                    asignatura2Element.setError("Ingresa un valor");
                    isValid = false;
                }

                if (nota1Asignatura2.isEmpty()) {
                    nota1Asignatura2Element.setError("Ingresa un valor");
                    isValid = false;
                } else {
                    try {
                        nota1A2 = Double.parseDouble(nota1Asignatura2);
                        if (nota1A2 < 1 || nota1A2 > 7) {
                            nota1Asignatura2Element.setError("Ingresa una nota entre 1 y 7");
                            isValid = false;
                        }

                    } catch (Exception e) {
                        nota1Asignatura2Element.setError("Ingresa un numero valido");
                        isValid = false;
                    }
                }

                if (nota2Asignatura2.isEmpty()) {
                    nota2Asignatura2Element.setError("Ingresa un valor");
                    isValid = false;
                } else {
                    try {
                        nota2A2 = Double.parseDouble(nota2Asignatura2);
                        if (nota2A2 < 1 || nota2A2 > 7){
                            nota2Asignatura2Element.setError("Ingresa una nota entre 1 y 7");
                            isValid = false;
                        }
                    } catch (Exception e) {
                        nota2Asignatura2Element.setError("Ingresa un numero valido");
                        isValid = false;
                    }
                }

                if (isValid) {
                    double promedio1 = (nota1A1 + nota2A1) / 2;
                    double promedio2 = (nota1A2 + nota2A2) / 2;

                    double promedioTotal = (promedio1 + promedio2) / 2;


                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

                    intent.putExtra("extra-nombre", nombre);
                    intent.putExtra("extra-apellido", apellido);
                    intent.putExtra("extra-rut", rut);
                    intent.putExtra("extra-carrera", carrera);

                    intent.putExtra("asignatura1", asignatura1);
                    intent.putExtra("promedio1", promedio1);
                    intent.putExtra("signatura2", asignatura2);
                    intent.putExtra("promedio2", promedio2);

                    intent.putExtra("promedioTotal", promedioTotal);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity2.this, "mensaje", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    private void volver(){

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}