package com.joaoparedes.clicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.joaoparedes.clicker.adapters.UpgradeAdapter;
import com.joaoparedes.clicker.models.Cookie;
import com.joaoparedes.clicker.models.Upgrade;
import com.joaoparedes.clicker.repositories.UpgradeRepository;

public class UpgradeActivity extends AppCompatActivity {


    private RecyclerView recyclerViewUpgrades;
    private Button retorna;
    private TextView cookies;

    Cookie cookie = Cookie.getInstance();
    UpgradeRepository ur = UpgradeRepository.getInstance();

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 1*1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);

        recyclerViewUpgrades = findViewById(R.id.upgrade_recyclerView);
        retorna = findViewById(R.id.upgrade_retorna_button);
        cookies = findViewById(R.id.upgrade_cookies);


        handler.postDelayed( runnable = () -> {
            cookie.cookieSegundo();
            cookies.setText(String.valueOf(cookie.getNumeroCookies()) + "  Cookies");
            handler.postDelayed(runnable, delay);
        }, delay);


        recyclerViewUpgrades.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        );

        recyclerViewUpgrades.setAdapter(new UpgradeAdapter(ur.getAll()));

        retorna.setOnClickListener(view -> finish());
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

}