package com.example.parcial1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalcularTotal extends AppCompatActivity {
    private EditText tomateQuantityEditText;
    private EditText cebollaQuantityEditText;
    private TextView totalTomateTextView;
    private TextView totalCebollaTextView;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_total);

        // Enlaza los elementos de la interfaz con las variables Java
        tomateQuantityEditText = findViewById(R.id.tomateQuantityEditText);
        cebollaQuantityEditText = findViewById(R.id.cebollaQuantityEditText);
        Button calculateButton = findViewById(R.id.calculateButton);
        totalTomateTextView = findViewById(R.id.totalTomateTextView);
        totalCebollaTextView = findViewById(R.id.totalCebollaTextView);
        totalTextView = findViewById(R.id.totalTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);

        // Obtener el nombre pasado a través del Intent
        String name = getIntent().getStringExtra("NAME");
        // Mostrar el nombre en el TextView
        nameTextView.setText("Usuario: " + name);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        // Obtener el texto de los EditText y verificar si están vacíos
        String tomateCantidadStr = tomateQuantityEditText.getText().toString().trim();
        String cebollaCantidadStr = cebollaQuantityEditText.getText().toString().trim();


        //Mensaje de error, en caso de no cumplir con los datos
        if (tomateCantidadStr.isEmpty() || cebollaCantidadStr.isEmpty()) {
            // Mostrar un mensaje de error si alguno de los campos está vacío
            Toast.makeText(this, "Por favor ingresa la cantidad de tomate y cebolla", Toast.LENGTH_SHORT).show();
            return; // Salir del método sin intentar calcular el total
        }

        // Convertir las cadenas a enteros
        int tomateCantidad = Integer.parseInt(tomateCantidadStr);
        int cebollaCantidad = Integer.parseInt(cebollaCantidadStr);

        // Definir los precios por unidad
        int precioTomate = 600;
        int precioCebolla = 800;

        // Calcular los totales
        int totalTomate = tomateCantidad * precioTomate;
        int totalCebolla = cebollaCantidad * precioCebolla;
        int total = totalTomate + totalCebolla;

        // Mostrar los totales en los TextView correspondientes
        totalTomateTextView.setText("Total tomate: " + totalTomate);
        totalCebollaTextView.setText("Total cebolla: " + totalCebolla);
        totalTextView.setText("Total: " + total);
    }

}
