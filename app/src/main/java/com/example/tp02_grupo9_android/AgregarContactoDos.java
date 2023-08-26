package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class AgregarContactoDos extends AppCompatActivity {

    private ContactoClass nuevoContacto;
    private Button btnGuardar;
    private RadioGroup radioGroup;
    private CheckBox checkDeportes, checkMusica, checkArte, checkTecnologia;
    private Switch switchDeseo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto_dos);
        RecuperarInfoActivity();
        Inicializar();

        // Obtener referencia al RadioGroup y al primer RadioButton
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton primerRadioButton = findViewById(R.id.radio_PrimarioIncompleto);
        primerRadioButton.setChecked(true);


        SetClickListener();
    }

    private void RecuperarInfoActivity(){
        nuevoContacto = getIntent().getParcelableExtra("contacto");
    }

    private void Inicializar(){
        radioGroup = findViewById(R.id.radioGroup);
        checkDeportes = findViewById(R.id.check_Deportes);
        checkArte = findViewById(R.id.checkArte);
        checkMusica = findViewById(R.id.check_Musica);
        checkTecnologia = findViewById(R.id.check_Tecnologia);
        switchDeseo = findViewById(R.id.swt_Deseo);

        btnGuardar = findViewById(R.id.btn_Guardar);
    }

    private void SetClickListener(){
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validaciones
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                String nivelEstudios = selectedRadioButton.getText().toString();

                Integer chkDeporte = 0, chkArte = 0, chkMusica = 0, chkTecnologia = 0, swtDeseo = 0;
                if(checkDeportes.isChecked()) chkDeporte = 1;
                if(checkArte.isChecked()) chkArte = 1;
                if(checkMusica.isChecked()) chkMusica = 1;
                if(checkTecnologia.isChecked()) chkTecnologia = 1;
                if(switchDeseo.isChecked()) swtDeseo = 1;


                nuevoContacto.setRadioEstudio(nivelEstudios);
                nuevoContacto.setCheckDeportes(chkDeporte);
                nuevoContacto.setCheckArte(chkArte);
                nuevoContacto.setCheckMusica(chkMusica);
                nuevoContacto.setCheckTecnologia(chkTecnologia);
                nuevoContacto.setRecibirInformacion(swtDeseo);

                // GUARDARLOS EN LA MATRIZ
                if (ContactoGlobal.listaContactos == null) {
                    ContactoGlobal.listaContactos = new ContactoClass[]{nuevoContacto};
                } else {

                    // Crear un nuevo array con espacio para el nuevo objeto
                    ContactoClass[] nuevosContactos = new ContactoClass[ContactoGlobal.listaContactos.length + 1];
                    System.arraycopy(ContactoGlobal.listaContactos, 0, nuevosContactos, 0, ContactoGlobal.listaContactos.length);
                    nuevosContactos[ContactoGlobal.listaContactos.length] = nuevoContacto;
                    ContactoGlobal.listaContactos = nuevosContactos;
                }

                Toast.makeText(AgregarContactoDos.this, "Se ha ingresado un nuevo Contacto", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AgregarContactoDos.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}