package com.joaoparedes.clicker;

import static com.joaoparedes.clicker.MainActivity.numeroCookies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView quantText;
    private ImageButton cookieButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        cookieButton = findViewById(R.id.game_image_button);
        quantText = findViewById(R.id.game_cookies);
        quantText.setText(String.valueOf(numeroCookies));



        cookieButton.setOnClickListener(view -> {
            numeroCookies +=1;
            quantText.setText(String.valueOf(numeroCookies));
        });

    }

}