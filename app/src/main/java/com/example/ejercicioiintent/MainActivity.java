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
    public datos d = new datos();
    EditText nombre,apellido,correo,color;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAceptar=(Button)findViewById(R.id.btnEnviar);
        Button btnLimpiar=(Button)findViewById(R.id.btnLimpiar);
        nombre =(EditText)findViewById(R.id.edtNombre);
        apellido=(EditText)findViewById(R.id.edtApellido);
        correo = (EditText)findViewById(R.id.edtCorreo);
        color = (EditText)findViewById(R.id.edtColor);
        text = (TextView)findViewById(R.id.textView);
        String nombreM = "";
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            d = extras.getParcelable("datos");
            text.setText(d.getNombre().toLowerCase()+" "+d.getApellido().toLowerCase()+" "+d.getCorreo().toLowerCase()+" "+d.getColor().toLowerCase());
        }

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.setNombre(nombre.getText().toString());
                d.setApellido(apellido.getText().toString());
                d.setCorreo(correo.getText().toString());
                d.setColor(color.getText().toString());
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                i.putExtra("datos",d);
                startActivity(i);
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nombre.setText("");
                apellido.setText("");
                correo.setText("");
                color.setText("");
            }
        });
    }
}