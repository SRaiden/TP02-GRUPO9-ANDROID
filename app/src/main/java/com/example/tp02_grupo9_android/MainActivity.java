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

    public void Ejercicio1(View view)
    {
        startActivity(new Intent(MainActivity.this, AgregarContacto.class));
    }

    public void Ejercicio2(View view)
    {
        startActivity(new Intent(MainActivity.this, VerContactos.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barranavegacion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemAgregar){
            startActivity(new Intent(MainActivity.this, AgregarContacto.class));
        }
        if(id == R.id.itemListar){
            startActivity(new Intent(MainActivity.this, VerContactos.class));
        }
        return super.onOptionsItemSelected(item);
    }
}