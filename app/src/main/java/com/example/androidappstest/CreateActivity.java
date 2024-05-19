package com.example.androidappstest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.androidappstest.databasehelper;

public class CreateActivity extends AppCompatActivity {

    EditText nama_input, alamat_input, nik_input, tempat_lahir, tanggal_lahir, agama, telepon;
    Button update_button, delete_button;
    String nama_txt;
    String alamat_txt;
    String nik_txt;
    String id_txt;
    String tempat_lahir_txt;
    String tanggal_lahir_txt;
    String agama_txt;
    String telepon_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        nama_input = findViewById(R.id.nama_update);
        alamat_input = findViewById(R.id.alamat_update);
        nik_input = findViewById(R.id.nik_update);
        tempat_lahir = findViewById(R.id.tempat_lahir_update);
        tanggal_lahir = findViewById(R.id.tanggal_lahir_update);
        agama = findViewById(R.id.agama_update);
        telepon = findViewById(R.id.tlp_update);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        getAndSetData();
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databasehelper myDB =  new databasehelper(addData.ths);
                nama_txt = nama_input.getText().toString().trim();
                alamat_txt = alamat_input.getText().toString().trim();
                tempat_lahir_txt = tempat_lahir.getText().toString().trim();
                tanggal_lahir_txt = tanggal_lahir.getText().toString().trim();
                agama_txt = agama.getText().toString().trim();
                telepon_txt = telepon.getText().toString().trim();
                int nik_int = Integer.valueOf(nik_input.getText().toString().trim());
                myDB.addData(nama_txt, alamat_txt, nik_txt, tempat_lahir_txt, tanggal_lahir_txt, agama_txt, telepon_txt);
            }
        });
    }

    void getAndSetData() {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("nama") && getIntent().hasExtra("alamat") && getIntent().hasExtra("nik")){
            // GET DATA FROM INTENT
            id_txt = getIntent().getStringExtra("id");
            nama_txt = getIntent().getStringExtra("nama");
            alamat_txt = getIntent().getStringExtra("alamat");
            nik_txt = getIntent().getStringExtra("nik");
            tempat_lahir_txt = getIntent().getStringExtra("tempat_lahir");
            tanggal_lahir_txt = getIntent().getStringExtra("tanggal_lahir");;
            agama_txt = getIntent().getStringExtra("agama"); ;
            telepon_txt = getIntent().getStringExtra("telepon");;

            // SET INTENT DATA
            nama_input.setText(nama_txt);
            nik_input.setText(nik_txt);
            alamat_input.setText(alamat_txt);
            tempat_lahir.setText(tempat_lahir_txt);
            tanggal_lahir.setText(tanggal_lahir_txt);
            agama.setText(agama_txt);
            telepon.setText(telepon_txt);
        }else{
            Toast.makeText(this, "Data Tidak Ditemukan", Toast.LENGTH_SHORT).show();

        }
    }
}