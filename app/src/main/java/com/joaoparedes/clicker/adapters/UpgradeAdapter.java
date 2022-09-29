package com.joaoparedes.clicker.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.joaoparedes.clicker.R;
import com.joaoparedes.clicker.models.Cookie;
import com.joaoparedes.clicker.models.Upgrade;
import com.joaoparedes.clicker.repositories.UpgradeRepository;

import java.util.ArrayList;

public class UpgradeAdapter extends RecyclerView.Adapter<UpgradeAdapter.UpgradeViewHolder> {

    private ArrayList<Upgrade> upgrades;
    Cookie cookie = Cookie.getInstance();
    UpgradeRepository ur = UpgradeRepository.getInstance();

    public UpgradeAdapter(ArrayList<Upgrade> upgrades){
        this.upgrades = upgrades;
    }

    @NonNull
    @Override
    public UpgradeViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {

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

        ConstraintLayout constraintLayout = holder.itemView.findViewById(R.id.upgradeView_card);
        TextView textViewTitulo = holder.itemView.findViewById(R.id.upgradeView_titulo);
        TextView textViewVersion = holder.itemView.findViewById(R.id.upgradeView_version);
        TextView textViewDesc = holder.itemView.findViewById(R.id.upgradeView_desc);
        TextView textViewCusto = holder.itemView.findViewById(R.id.upgradeView_custo);

        textViewTitulo.setText(upgrade.getNome());
        textViewVersion.setText(String.valueOf(upgrade.getVersion()));
        textViewDesc.setText(upgrade.getDesc());
        textViewCusto.setText(String.valueOf(upgrade.getCusto()));

        Context context = constraintLayout.getContext();


        if(upgrade.getCusto() <= cookie.getNumeroCookies()) {
            constraintLayout.setAlpha(1f);
            constraintLayout.setClickable(true);

            constraintLayout.setOnClickListener( v-> {
                cookie.setNumeroCookies(cookie.getNumeroCookies() - upgrade.getCusto());

                if(upgrade.getNome() == "Vitoria") {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("Voce ganhou!");
                    builder.setCancelable(true);
                    builder.setPositiveButton(
                            "Oba",
                            (dialog, id) -> {
                                Intent intent = new Intent(Intent.ACTION_MAIN);
                                intent.addCategory(Intent.CATEGORY_HOME);
                                context.startActivity(intent);
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }

                if (upgrade.isClick()) {
                    cookie.setClick(cookie.getClick() + upgrade.getEfeito());
                } else {
                    cookie.setCps(cookie.getCps() + upgrade.getEfeito());
                }
                Upgrade novoUpgrade = new Upgrade(upgrade.getNome(), upgrade.getVersion()+1, upgrade.getDesc(),upgrade.getEfeito()*2,upgrade.isClick(),upgrade.getCusto()*3);

                ur.saveInIndex(novoUpgrade,position);
                ur.delete(upgrade);

                notifyDataSetChanged();
            });

        } else {
            constraintLayout.setAlpha(.5f);
            constraintLayout.setClickable(false);
        }
    }

    @Override
    public int getItemCount() {
        return upgrades.size();
    }

    public static class UpgradeViewHolder extends RecyclerView.ViewHolder{
        public UpgradeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}