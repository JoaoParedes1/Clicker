package com.joaoparedes.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    public static int numeroCookies;
    public static int click;
    public static int cps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_jogar);
        numeroCookies = 0;
        click = 1;
        cps = 1;


        btn.setOnClickListener(view -> {
            Intent intent = new Intent(
                    getApplicationContext(),
                    GameActivity.class
            );

            startActivity(intent);
        });

    }
}