package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AgregarContacto extends AppCompatActivity {

    private EditText txtNombre, txtApellido, txtTelefono, txtEmail, txtDireccion, txtFechaNacimiento;
    private Spinner spnTelefono, spnEmail;
    private Button btnContinuar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        AgregarItemsSpinner();
        Inicializar();
        SetClickListener();
    }

    private void AgregarItemsSpinner(){
        Spinner spinnerTelefono = findViewById(R.id.spnTelefono);
        Spinner spinnerEmail = findViewById(R.id.spnEmail);

        List<String> items = new ArrayList<>();
        items.add("Casa");
        items.add("Trabajo");
        items.add("Móvil");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTelefono.setAdapter(adapter);
        spinnerEmail.setAdapter(adapter);
    }

    private void Inicializar(){
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);

        spnTelefono = findViewById(R.id.spnTelefono);
        spnEmail = findViewById(R.id.spnEmail);

        btnContinuar = findViewById(R.id.btnContinuar);
    }

    private void SetClickListener(){
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Obtener los valores ingresados en los campos de texto
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String email = txtEmail.getText().toString();
                String direccion = txtDireccion.getText().toString();
                String fechaNacimiento = txtFechaNacimiento.getText().toString();
                String telefonoSeleccionado = spnTelefono.getSelectedItem().toString();
                String emailSeleccionado = spnEmail.getSelectedItem().toString();

                //validaciones
                boolean val = validar(nombre, apellido, telefono, email, direccion, fechaNacimiento, telefonoSeleccionado, emailSeleccionado);
                if(!val){
                    return;
                }

                // Almacenar la info en una clase
                ContactoClass nuevoContacto = new ContactoClass();
                nuevoContacto.setId(1);
                nuevoContacto.setNombre(nombre);
                nuevoContacto.setApellido(apellido);
                nuevoContacto.setTelefono(telefono);
                nuevoContacto.setEmail(email);
                nuevoContacto.setDireccion(direccion);
                nuevoContacto.setFechaNacimiento(fechaNacimiento);
                nuevoContacto.setSpnEmail(emailSeleccionado);
                nuevoContacto.setSpnTelefono(telefonoSeleccionado);

                nuevoContacto.setCheckArte(0);
                nuevoContacto.setCheckDeportes(0);
                nuevoContacto.setCheckMusica(0);
                nuevoContacto.setCheckTecnologia(0);
                nuevoContacto.setRecibirInformacion(0);

                // Iniciar la siguiente actividad con animación
                Intent intent = new Intent(AgregarContacto.this, AgregarContactoDos.class);
                intent.putExtra("contacto", nuevoContacto);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }

            public boolean validar(String nombre, String apellido, String telefono, String email, String direccion,
                                   String fechaNacimiento, String telefonoSeleccionado, String emailSeleccionado){

                if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || email.isEmpty() ||
                        direccion.isEmpty() || fechaNacimiento.isEmpty()) {
                    Toast.makeText(AgregarContacto.this, "Por favor, complete todos los campos.", Toast.LENGTH_LONG).show();
                    return false;
                }
                else if (!nombre.matches("[a-zA-Z]+") || !apellido.matches("[a-zA-Z]+")) {
                    Toast.makeText(AgregarContacto.this, "Los campos de nombre y apellido solo deben contener letras.", Toast.LENGTH_LONG).show();
                    return false;
                }
                else if (!telefono.matches("[0-9]+")) {
                    Toast.makeText(AgregarContacto.this, "El campo de teléfono solo debe contener números.", Toast.LENGTH_LONG).show();
                    return false;
                }
                else if (!isValidEmail(email)) {
                    Toast.makeText(AgregarContacto.this, "Por favor, ingrese un email válido.", Toast.LENGTH_LONG).show();
                    return false;
                }
                else if (!isValidDate(fechaNacimiento)) {
                    Toast.makeText(AgregarContacto.this, "Por favor, ingrese una fecha de nacimiento válida. En formato dd-MM-yyyy", Toast.LENGTH_LONG).show();
                    return false;
                }
                else{
                    return true;
                }
            }

            private boolean isValidEmail(String email) {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
            }

            private boolean isValidDate(String date) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                dateFormat.setLenient(false);

                try {
                    dateFormat.parse(date);
                    return true;
                } catch (ParseException e) {
                    return false;
                }
            }

        });
    }
}