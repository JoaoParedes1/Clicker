package com.joaoparedes.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    public static int numeroCookies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_jogar);
        numeroCookies = 0;


        btn.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Tem certeza que deseja jogar esse jogo?");
            builder.setCancelable(true);
            builder.setPositiveButton(
                    "Sim",
                    (dialog, id) -> {
                        dialog.dismiss();
                        Intent intent = new Intent(
                                getApplicationContext(),
                                GameActivity.class
                        );

                        startActivity(intent);

                    });
            AlertDialog alert = builder.create();
            alert.show();

        });

    }
}