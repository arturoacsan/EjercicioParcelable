package com.example.ejercicioiintent;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class Main2Activity extends Activity {
    public datos d = new datos();
    TextView txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnRegresar = (Button) findViewById(R.id.btnRegresar);
        txtNombre = (TextView) findViewById(R.id.txtNombre);
        d = getIntent().getExtras().getParcelable("datos");

        txtNombre.setText(d.getNombre().toUpperCase()+" "+d.getApellido().toUpperCase()+" "+d.getCorreo().toUpperCase()+" "+d.getColor().toUpperCase());
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(), MainActivity.class);
                i2.putExtra("datos",d);
                startActivity(i2);
            }
        });
    }
}