package com.example.infoganaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToIniciar(View view){
        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);
    }


    public void goToRegister(View view){
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);
    }


    public void goToNoticias(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://todosobreganado.com/category/noticias-sobre-ganaderia"));
        startActivity(i);
    }

    public void goToTipos(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://todosobreganado.com/tipos-de-ganaderia/"));
        startActivity(i);
    }

    public void goToRazas(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://todosobreganado.com/razas/"));
        startActivity(i);
    }

    public void goToConsejos(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://todosobreganado.com/consejos/"));
        startActivity(i);
    }

    public void goToBooks(View view){
        Intent i = new Intent(this, LibrosActivity.class);
        startActivity(i);
    }
}