package com.example.bd_sqllife;
import android.content.Intent;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bd_sqllife.DBHelper;
import com.example.bd_sqllife.MainActivity;
import com.example.bd_sqllife.R;


public class Registro extends AppCompatActivity {

    EditText et1,et2,et3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registro);
        et1= (EditText) findViewById(R.id.etcod);
        et2= (EditText) findViewById(R.id.etuser);
        et3= (EditText) findViewById(R.id.etcontra);

    }

    public void registrar(View view) {

        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();
        String codigo=et1.getText().toString();
        String usuario=et2.getText().toString();
        String contraseña=et3.getText().toString();

        ContentValues
                values = new ContentValues();
        values.put("codigo",codigo);
        values.put("usuario",usuario);
        values.put("contrasena",contraseña);

        db.insert("usuarios",null,values);
        db.close();

        Intent ven=new Intent(this, MainActivity.class);
        startActivity(ven);
    }

    public void cancelar(View view){
        finish();
    }
}
