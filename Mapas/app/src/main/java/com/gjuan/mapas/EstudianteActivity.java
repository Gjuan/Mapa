package com.gjuan.mapas;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class EstudianteActivity extends AppCompatActivity {
    EditText nombre,apellido;
    RadioButton mascl,feme;
    String gene;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);
        nombre=(EditText)findViewById(R.id.Nom);
        apellido=(EditText)findViewById(R.id.Ape);
        mascl=(RadioButton)findViewById(R.id.Masculino);
        feme=(RadioButton)findViewById(R.id.Femenino);



    }
    public void enviando(View view){

        if(mascl.isChecked()){
            gene="Masculino";
        }else if(feme.isChecked()){
            gene="Femenino";
        }
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Información");
        msg.setMessage("Su nombre es: " + nombre.getText() + "\nSu apellido es:" + apellido.getText() + "\nSu género es: " + gene);
        msg.setPositiveButton("Listo",null);
        msg.create();
        msg.show();
    }
}
