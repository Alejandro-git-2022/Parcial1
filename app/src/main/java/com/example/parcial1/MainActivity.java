package com.example.parcial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlaza los elementos de la interfaz con las variables Java
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        Button continueButton = findViewById(R.id.continueButton);

        // Establece el listener para el botón de continuar
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtiene el texto ingresado en los EditText
                String name = editTextName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();

                // Crear un Intent para iniciar la actividad CalcularTotal
                Intent intent = new Intent(MainActivity.this, CalcularTotal.class);
                intent.putExtra("NAME", name);
                startActivity(intent);
            }
        });
    }
}
