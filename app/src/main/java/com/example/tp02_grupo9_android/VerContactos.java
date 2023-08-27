package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerContactos extends AppCompatActivity {

    private ListView listViewContactos;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_contactos);

        verContactos();
        setClickListener();
        volver();
    }

    private void verContactos(){
        listViewContactos = findViewById(R.id.listViewContactos);

        ContactoClass[] listaContactos = ContactoGlobal.listaContactos;

        if(listaContactos != null){
            ArrayList<String> nombresYCorreos = new ArrayList<>();
            for (ContactoClass contacto : listaContactos) {
                String nombreYCorreo = contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getEmail();
                nombresYCorreos.add(nombreYCorreo);
            }

            // Crea un ArrayAdapter y configura el ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombresYCorreos);
            listViewContactos.setAdapter(adapter);
        }else{
            Toast.makeText(this, "No hay Contactos Ingresados", Toast.LENGTH_LONG).show();
        }

    }

    private void setClickListener(){
        listViewContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtén el contacto seleccionado
                ContactoClass contactoSeleccionado = ContactoGlobal.listaContactos[position];

                // Inicia la actividad de detalles y pasa el contacto como extra
                Intent intent = new Intent(VerContactos.this, VerDetallesContacto.class);
                intent.putExtra("contacto", contactoSeleccionado);
                startActivity(intent);
            }
        });
    }

    private void volver(){
        btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresa al menú principal
                Intent intent = new Intent(VerContactos.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}