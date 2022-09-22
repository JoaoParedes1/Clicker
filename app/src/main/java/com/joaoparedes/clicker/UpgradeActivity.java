package com.joaoparedes.clicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UpgradeActivity extends AppCompatActivity {

    private RecyclerView recyclerViewUpgrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade);

        recyclerViewUpgrades = findViewById(R.id.recyclerViewUpgrades);




        recyclerViewUpgrades.setLayoutManager(
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        );
    }
}