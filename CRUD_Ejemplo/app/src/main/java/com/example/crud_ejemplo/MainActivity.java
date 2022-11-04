package com.example.crud_ejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText ETCodigo, ETEtiqueta, ETPrecio;
    private Button BTNRegistrar, BTNConsultar, BTNModificar, BTNEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETCodigo = findViewById(R.id.CampoCode);
        ETEtiqueta = findViewById(R.id.CampoEtiqueta);
        ETPrecio = findViewById(R.id.CampoPrecio);

        BTNRegistrar = findViewById(R.id.btnRegistrar);
        BTNConsultar = findViewById(R.id.btnBuscar);
        BTNModificar = findViewById(R.id.btnEditar);
        BTNEliminar = findViewById(R.id.btnEliminar);

        BTNRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "administracion", null, 1 );
                SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
                String codigo = ETCodigo.getText().toString();
                String etiqueta = ETEtiqueta.getText().toString();
                String precio = ETPrecio.getText().toString();

                ContentValues registro = new ContentValues();
                registro.put("codigo", codigo);
                registro.put("descripcion", etiqueta);
                registro.put("precio", precio);

                baseDeDatos.insert("articulos", null, registro);
                baseDeDatos.close();

                ETCodigo.setText("");
                ETEtiqueta.setText("");
                ETPrecio.setText("");
            }
        });
    }
}