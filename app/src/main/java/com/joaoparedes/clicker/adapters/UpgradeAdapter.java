package com.joaoparedes.clicker.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joaoparedes.clicker.R;
import com.joaoparedes.clicker.models.Upgrade;

import java.util.ArrayList;

public class UpgradeAdapter extends RecyclerView.Adapter<UpgradeAdapter.UpgradeViewHolder> {

    private ArrayList<Upgrade> upgrades;

    public UpgradeAdapter(ArrayList<Upgrade> upgrades){
        this.upgrades = upgrades;
    }

    @NonNull
    @Override
    public UpgradeViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        View layout = layoutInflater.inflate(
                R.layout.view_upgrade,
                parent,
                false
        );

        return new UpgradeViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull UpgradeViewHolder holder
            , int position) {

        Upgrade upgrade = upgrades.get(position);

//        ImageView imageViewPic = holder.itemView.findViewById(R.id.upgrade_pic);
        TextView textViewTitulo = holder.itemView.findViewById(R.id.upgrade_titulo);
        TextView textViewDesc = holder.itemView.findViewById(R.id.upgrade_desc);

//        imageViewPic.setImageDrawable(upgrade.getFoto());
        textViewTitulo.setText(upgrade.getNome());
        textViewDesc.setText(upgrade.getDesc());
    }

    @Override
    public int getItemCount() {
        return upgrades.size();
    }

    public static class UpgradeViewHolder
            extends RecyclerView.ViewHolder{

        public UpgradeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}