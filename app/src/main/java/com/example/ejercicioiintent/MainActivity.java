package com.example.ejercicioiintent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText nombre,telefono,correo;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAceptar=(Button)findViewById(R.id.btnEnviar);
        nombre =(EditText)findViewById(R.id.edtNombre);
        telefono=(EditText)findViewById(R.id.edtTelefono);
        correo = (EditText)findViewById(R.id.edtCorreo);
        text = (TextView)findViewById(R.id.textView);
        String nombreM = "";
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            nombreM = extras.getString("MAYUS").toLowerCase();
            text.setText(nombreM);
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("NOMBRE",nombre.getText().toString());
                i.putExtra("TELEFONO",telefono.getText().toString());
                i.putExtra("CORREO",correo.getText().toString());
                startActivity(i);
            }
        });
    }
}