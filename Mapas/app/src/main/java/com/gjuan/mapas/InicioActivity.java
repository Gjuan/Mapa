package com.gjuan.mapas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InicioActivity extends AppCompatActivity {
    private ListView lista;
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File file = new File(ruta_fotos);

    private EditText nombres, telefono, ciudad, mensaje;
    private Button btnPresionar, enviar;
    private  AlertDialog.Builder msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Resources res = getResources();
        file.mkdirs();
        final String lenguajes[] = {"JavaScript","C#","Java","Python","PHP","Node Js"};

        lista = (ListView)findViewById(R.id.list);
        nombres = (EditText)findViewById(R.id.txtNombres);
        telefono = (EditText)findViewById(R.id.txtTelefono);
        ciudad = (EditText)findViewById(R.id.txtCiudad);
        btnPresionar = (Button)findViewById(R.id.btnPresionar);
        mensaje = (EditText) findViewById(R.id.msg);
        enviar = (Button) findViewById(R.id.enviar);
        msg  = new AlertDialog.Builder(this);

        final ArrayAdapter<String> lengProg = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lenguajes);
        lista.setAdapter(lengProg);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(InicioActivity.this,lenguajes[position], Toast.LENGTH_LONG).show();
            }
        });


        btnPresionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg.setTitle("Información");
                msg.setMessage("Nombres: " + nombres.getText().toString() +
                        "\nCédula: " + telefono.getText().toString() +
                        "\nCiudad: " + ciudad.getText().toString());
                msg.setPositiveButton("Listo",null);
                msg.create();
                msg.show();
            }
        });

        TabHost pestana=(TabHost)findViewById(android.R.id.tabhost);
        pestana.setup();

        TabHost.TabSpec spec;

        spec = pestana.newTabSpec("lista");
        spec.setContent(R.id.list);
        spec.setIndicator("",res.getDrawable(android.R.drawable.ic_menu_compass));
        pestana.addTab(spec);

        spec = pestana.newTabSpec("toast");
        spec.setContent(R.id.toast);
        spec.setIndicator("",res.getDrawable(android.R.drawable.ic_input_get));
        pestana.addTab(spec);

        spec = pestana.newTabSpec("notificar");
        spec.setContent(R.id.notificar);
        spec.setIndicator("",res.getDrawable(android.R.drawable.ic_dialog_info));
        pestana.addTab(spec);

        pestana.setCurrentTab(1);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    public void envio(View view){
        Intent i = new Intent(this,NotificarActivity.class);
        i.putExtra("mensaje", mensaje.getText().toString());
        startActivity(i);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.estudiante) {
            Intent it = new Intent(this, EstudianteActivity.class);
            startActivity(it);
        }
        if (id == R.id.empleado) {
            Intent i = new Intent(this, EmpleadoActivity.class);
            startActivity(i);
        }


        if (id == R.id.camara) {
            tiempo t=new tiempo();
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            //Creamos una carpeta en la memoria del terminal
            File imagesFolder = new File(Environment.getExternalStorageDirectory(), "Fotos_Android");
            imagesFolder.mkdirs();
            //añadimos el nombre de la imagen
            File image = new File(imagesFolder, "foto"+t.verHora()+".jpg");
            Uri uriSavedImage = Uri.fromFile(image);
            //Le decimos al Intent que queremos grabar la imagen
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
            //Lanzamos la aplicacion de la camara con retorno (forResult)
            startActivityForResult(cameraIntent, 1);
        }

        if (id == R.id.mapa) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
