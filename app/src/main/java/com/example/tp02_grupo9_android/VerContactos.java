package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VerContactos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_contactos);

        verContactos();
    }

    private void verContactos(){
        ContactoClass[] contactos = ContactoGlobal.listaContactos;

        for (ContactoClass contacto : contactos) {
            String nombre = contacto.getNombre();
            String apellido = contacto.getApellido();
            String telefono = contacto.getTelefono();
        }
    }
}