package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VerDetallesContacto extends AppCompatActivity {
    TextView viewNombre;
    TextView viewApellido;
    TextView viewTelefono;
    TextView viewMail;
    TextView viewDireccion;
    TextView viewfechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles_contacto);
        Bundle extras = getIntent().getExtras();
        ContactoClass contactoSeleccionado = extras.getParcelable("contacto");

        viewNombre = (TextView) findViewById(R.id.viewNombre);
        viewNombre.setText(contactoSeleccionado.getNombre());

        viewApellido = (TextView) findViewById(R.id.viewApellido);
        viewApellido.setText(contactoSeleccionado.getApellido());

        viewTelefono = (TextView) findViewById(R.id.viewTelefono);
        viewTelefono.setText(contactoSeleccionado.getTelefono());

        viewMail = (TextView) findViewById(R.id.viewMail);
        viewMail.setText(contactoSeleccionado.getEmail());

        viewDireccion = (TextView) findViewById(R.id.viewDireccion);
        viewDireccion.setText(contactoSeleccionado.getDireccion());

        viewfechaNacimiento = (TextView) findViewById(R.id.viewfechaNacimiento);
        viewfechaNacimiento.setText(contactoSeleccionado.getFechaNacimiento());

    }



}