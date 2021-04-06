package com.example.exercise_1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercise_1.register;

public class MainActivity extends AppCompatActivity {
    Button btnlogin, btnregistrasi;
    EditText edemail, edpassword;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = findViewById(R.id.btSignin);
        edemail = findViewById(R.id.edEmail);
        edpassword = findViewById(R.id.edPassword);
        btnregistrasi = findViewById(R.id.btdaftar);

        btnregistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), register.class);
                startActivity(i);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
     @Override
            public void onClick(View v) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();
                String email = "Meliodas";
                String pass = "saintloco123";

                if (nama.isEmpty() || password.isEmpty()) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email & Password wajib diisi!",
                            Toast.LENGTH_LONG);
                    t.show();

                } else {

                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        t.show();
                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        i.putExtras(b);
                        startActivity(i);

                    } else {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal" , Toast.LENGTH_LONG);
                        t.show();

                    }
                }
            }
        });
    }
}