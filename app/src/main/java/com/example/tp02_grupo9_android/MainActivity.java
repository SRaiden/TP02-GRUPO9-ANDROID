package com.example.tp02_grupo9_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barranavegacion2, menu);

        // Como estoy en la misma activity oculto el item
        MenuItem itemMenuPrincipal = menu.findItem(R.id.itemMenuPrincipal);
        itemMenuPrincipal.setVisible(false);


        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemAgregar){
            startActivity(new Intent(MainActivity.this, AgregarContacto.class));
        }
        if(id == R.id.itemListar){
            startActivity(new Intent(MainActivity.this, VerContactos.class));
        }
        if(id == R.id.itemMenuPrincipal){
            startActivity(new Intent(MainActivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

   /* @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barranavegacion, menu);
        Toast.makeText(this, "entro1", Toast.LENGTH_SHORT).show();
        return super.onCreateOptionsMenu(menu);
    }*/


}