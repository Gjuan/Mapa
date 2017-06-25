package com.gjuan.mapas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EmpleadoActivity extends AppCompatActivity {
    Button calcular;
    Spinner horas_extr;
    EditText nombre, apellido,sueldo,suel_hor;
    TextView mostrar;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleado);

        volver=(Button)findViewById(R.id.v);
        calcular=(Button)findViewById(R.id.calcula);
        horas_extr=(Spinner) findViewById(R.id.horaex);
        nombre=(EditText) findViewById(R.id.Nombre);
        apellido=(EditText) findViewById(R.id.Apellido);
        sueldo=(EditText) findViewById(R.id.Sueldo);
        suel_hor=(EditText) findViewById(R.id.Suel_hora);
        mostrar=(TextView) findViewById(R.id.mostrar);

        final String[]horas_extra={"2","5","8","10","20"};
        ArrayAdapter <String> he=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,horas_extra);
        horas_extr.setAdapter(he);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double hora_seleccionada=0;
                if (horas_extr.getSelectedItem().toString().equals("2")){
                    hora_seleccionada=2;
                }else if(horas_extr.getSelectedItem().toString().equals("5")){
                    hora_seleccionada=5;
                }else if(horas_extr.getSelectedItem().toString().equals("8")){
                    hora_seleccionada=8;
                }else if(horas_extr.getSelectedItem().toString().equals("10")) {
                    hora_seleccionada = 10;
                }else if(horas_extr.getSelectedItem().toString().equals("20")) {
                    hora_seleccionada = 20;
                }
                double total ;

                total=(hora_seleccionada*Double.parseDouble(suel_hor.getText().toString()))+Double.parseDouble(sueldo.getText().toString());
                mostrar.setText("Nombre:"+nombre.getText().toString()+"\n Apellido : "+apellido.getText().toString()+"Total: "+total);
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
