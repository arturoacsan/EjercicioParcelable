package com.example.ejercicioiintent;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class Main2Activity extends Activity {
    TextView txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnRegresar = (Button) findViewById(R.id.btnRegresar);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("NOMBRE");
        String telefono = extras.getString("TELEFONO");
        String correo = extras.getString("CORREO");
        txtNombre.setText(nombre.toUpperCase()+" "+telefono+" "+correo);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(), MainActivity.class);
                i2.putExtra("MAYUS",txtNombre.getText().toString());
                startActivity(i2);
            }
        });
    }
}