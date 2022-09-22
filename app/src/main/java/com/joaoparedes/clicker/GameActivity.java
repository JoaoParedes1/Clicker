package com.joaoparedes.clicker;

import static com.joaoparedes.clicker.MainActivity.click;
import static com.joaoparedes.clicker.MainActivity.cps;
import static com.joaoparedes.clicker.MainActivity.numeroCookies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView quantText;
    private ImageButton cookieButton;
    private Button upgrades;


    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1*1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        cookieButton = findViewById(R.id.game_image_button);
        quantText = findViewById(R.id.game_cookies);
        quantText.setText(String.valueOf(numeroCookies));
        upgrades = findViewById(R.id.upgrades_button);


        cookieButton.setOnClickListener(view -> {
            view.startAnimation(new AlphaAnimation(1F, 0.7F));
            numeroCookies +=click;
            quantText.setText(String.valueOf(numeroCookies));
        });


        upgrades.setOnClickListener(view -> {
            Intent intent = new Intent(
                    getApplicationContext(),
                    UpgradeActivity.class
            );

            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        handler.postDelayed( runnable = () -> {
            numeroCookies +=cps;
            quantText.setText(String.valueOf(numeroCookies));
            handler.postDelayed(runnable, delay);
        }, delay);

    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

}