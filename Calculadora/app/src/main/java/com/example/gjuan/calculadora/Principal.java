package com.example.gjuan.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
EditText n1,n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        n1 = (EditText)findViewById(R.id.Textuno);
        n2=(EditText)findViewById(R.id.Txtdos);


        Button suma = (Button) findViewById(R.id.btnsuma);
        Button resta=(Button)findViewById(R.id.btnresta);
        Button multiplicacion=(Button)findViewById(R.id.btnmultiplicacion);
        Button division=(Button)findViewById(R.id.btndivision);
   final TextView res=(TextView)findViewById(R.id.Txtresul);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1=new Float(n1.getText().toString());
                float num2=new Float(n2.getText().toString());

                res.setText("RESULTADO ES: "+(num1+num2));
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1=new Float(n1.getText().toString());
                float num2=new Float(n2.getText().toString());

                res.setText("RESULTADO ES: "+(num1-num2));
            }
        });
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1=new Float(n1.getText().toString());
                float num2=new Float(n2.getText().toString());

                res.setText("RESULTADO ES: "+(num1*num2));
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float num1=new Float(n1.getText().toString());
                float num2=new Float(n2.getText().toString());

                res.setText("RESULTADO ES: "+(num1/num2));
            }
        });
    }
}
