package com.example.centropokemon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleEntrenador extends AppCompatActivity {
    private ImageView foto;
    private TextView id, nombre, edad, ciudad, sexo;
    private Intent intent;
    private Bundle bundle;
    private Entrenador p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_entrenador);

        foto = findViewById(R.id.imgFotoDetalle);
        nombre = findViewById(R.id.lblNombreDetalle);
        sexo = findViewById(R.id.lblSexoDetalle);
        id = findViewById(R.id.lblIdDetalle);
        edad = findViewById(R.id.lblEdadDetalle);
        ciudad = findViewById(R.id.lblCiudadDetalle);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");
        String ide, nom, ed, ciu, sex;
        int fot;

        fot = bundle.getInt("foto");
        foto.setImageResource(fot);
        ide = bundle.getString("id");
        id.setText(ide);
        nom = bundle.getString("nombre");
        nombre.setText(nom);
        ed = bundle.getString("edad");
        edad.setText(ed);
        ciu = bundle.getString("ciudad");
        id.setText(ciu);
        sex = bundle.getString("sexo");
        sexo.setText(sex);

        p = new Entrenador(fot, nom, ed, ciu, sex, ide);
    }
    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.eliminar_entrenador));
        builder.setMessage(getString(R.string.seguro));
        positivo =  getString(R.string.si);
        negativo = getString(R.string.no);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                p.eliminarEn();
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
        Intent intent = new Intent(DetalleEntrenador.this, InicioActivity.class);
        startActivity(intent);
    }
}