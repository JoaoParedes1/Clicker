package com.joaoparedes.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.joaoparedes.clicker.models.Cookie;
import com.joaoparedes.clicker.repositories.UpgradeRepository;

public class GameActivity extends AppCompatActivity {

    private TextView quantText;
    private TextView quantCs;
    private ImageButton cookieButton;
    private Button upgrades;
    Cookie cookie = Cookie.getInstance();

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1*1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        cookieButton = findViewById(R.id.game_image_button);
        quantText = findViewById(R.id.game_cookies);
        quantCs = findViewById(R.id.game_cookies_psecond);
        upgrades = findViewById(R.id.game_upgrades_button);

        cookieButton.setOnClickListener(view -> {
            view.startAnimation(new AlphaAnimation(1F, 0.7F));
            cookie.cookieClick();
            quantText.setText(String.valueOf(cookie.getNumeroCookies()));
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
        quantText.setText(String.valueOf(cookie.getNumeroCookies()));


        handler.postDelayed( runnable = () -> {
            cookie.cookieSegundo();
            quantText.setText(String.valueOf(cookie.getNumeroCookies()));
            quantCs.setText(String.valueOf(cookie.getClick())+ " click\n" + String.valueOf(cookie.getCps()) + " c/s");
            handler.postDelayed(runnable, delay);
        }, delay);

    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

}