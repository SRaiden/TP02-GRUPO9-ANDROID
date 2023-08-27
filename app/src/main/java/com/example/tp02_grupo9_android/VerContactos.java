package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    }

    //--------------------------------------------------------------//


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barranavegacion2, menu);

        // Como estoy en la misma activity oculto el item
        MenuItem itemVerContactos = menu.findItem(R.id.itemListar);
        itemVerContactos.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemAgregar){
            startActivity(new Intent(VerContactos.this, AgregarContacto.class));
        }
        if(id == R.id.itemListar){
            startActivity(new Intent(VerContactos.this, VerContactos.class));
        }
        if(id == R.id.itemMenuPrincipal){
            startActivity(new Intent(VerContactos.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    //-------------------------------------------------------------//


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

}