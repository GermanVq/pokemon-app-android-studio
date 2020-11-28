package com.example.centropokemon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePokemon extends AppCompatActivity {
    private ImageView foto;
    private TextView id, nombre, entrenador, elemento, nivel;
    private Intent intent;
    private Bundle bundle;
    private Pokemon p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);

        foto = findViewById(R.id.imgFotoDetalle);
        nombre = findViewById(R.id.lblNombreDetalle);
        entrenador = findViewById(R.id.lblEntrenadorDetalle);
        id = findViewById(R.id.lblIdDetalle);
        elemento = findViewById(R.id.lblElementoDetalle);
        nivel = findViewById(R.id.lblNivelDetalle);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");
        String ide, nom, entr, elem, nvl;
        int fot;

        fot = bundle.getInt("foto");
        foto.setImageResource(fot);
        ide = bundle.getString("id");
        id.setText(ide);
        nom = bundle.getString("nombre");
        nombre.setText(nom);
        entr = bundle.getString("entrenador");
        entrenador.setText(entr);
        elem = bundle.getString("elemento");
        elemento.setText(elem);
        nvl = bundle.getString("nivel");
        nivel.setText(nvl);

        p = new Pokemon(fot, ide, nom, entr, elem, nvl);
    }
    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.eliminar_pokemon));
        builder.setMessage(getString(R.string.seguro));
        positivo =  getString(R.string.si);
        negativo = getString(R.string.no);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                p.eliminarPo();
                onBackPressed();
            }
        });
        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DetallePokemon.this, InicioActivity.class);
        startActivity(intent);
    }
}