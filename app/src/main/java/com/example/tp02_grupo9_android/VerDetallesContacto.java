package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class VerDetallesContacto extends AppCompatActivity {
    TextView viewNombre, viewApellido, viewTelefono, viewMail, viewDireccion, viewfechaNacimiento;
    TextView rbEstudio, chkHobbie, deseoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalles_contacto);

        cargarDetalles();
    }


    //--------------------------------------------------------------//


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barranavegacion2, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemAgregar){
            startActivity(new Intent(VerDetallesContacto.this, AgregarContacto.class));
        }
        if(id == R.id.itemListar){
            startActivity(new Intent(VerDetallesContacto.this, VerContactos.class));
        }
        if(id == R.id.itemMenuPrincipal){
            startActivity(new Intent(VerDetallesContacto.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    //-------------------------------------------------------------//

    private void cargarDetalles(){
        Bundle extras = getIntent().getExtras();
        ContactoClass contactoSeleccionado = extras.getParcelable("contacto");

        viewNombre = (TextView) findViewById(R.id.viewNombre);
        viewNombre.setText("Nombre:" + contactoSeleccionado.getNombre());

        viewApellido = (TextView) findViewById(R.id.viewApellido);
        viewApellido.setText("Apellido:" + contactoSeleccionado.getApellido());

        viewTelefono = (TextView) findViewById(R.id.viewTelefono);
        viewTelefono.setText("Tel.: " + contactoSeleccionado.getTelefono() + " - " + contactoSeleccionado.getSpnTelefono());

        viewMail = (TextView) findViewById(R.id.viewMail);
        viewMail.setText("Email: " + contactoSeleccionado.getEmail() + " - " + contactoSeleccionado.getSpnEmail());

        viewDireccion = (TextView) findViewById(R.id.viewDireccion);
        viewDireccion.setText("Direccion: " + contactoSeleccionado.getDireccion());

        viewfechaNacimiento = (TextView) findViewById(R.id.viewfechaNacimiento);
        viewfechaNacimiento.setText("Fecha Nac.: " + contactoSeleccionado.getFechaNacimiento());

        rbEstudio = (TextView) findViewById(R.id.viewrbEstudios);
        rbEstudio.setText("Estudios: " + contactoSeleccionado.getRadioEstudio());

        String hobbie = "";
        if(contactoSeleccionado.getCheckArte() == 1){ hobbie = hobbie + "Arte - ";}
        if(contactoSeleccionado.getCheckDeportes() == 1){ hobbie = hobbie + "Deporte - ";}
        if(contactoSeleccionado.getCheckMusica() == 1){ hobbie = hobbie + "Musica - ";}
        if(contactoSeleccionado.getCheckTecnologia() == 1){ hobbie = hobbie + "Tecnologia - ";}

        if (hobbie.length() >= 3) {
            hobbie = hobbie.substring(0, hobbie.length() - 3);
        } else {
            hobbie = "";
        }

        chkHobbie = (TextView) findViewById(R.id.viewchkHobbies);
        chkHobbie.setText("Hobbies.: " + hobbie);

        String deseo = "NO";
        if(contactoSeleccionado.getRecibirInformacion() == 1){ deseo = "SI";}
        deseoInfo = (TextView) findViewById(R.id.viewRecibirInfo);
        deseoInfo.setText("Recibir Info?: " + deseo);
    }


}