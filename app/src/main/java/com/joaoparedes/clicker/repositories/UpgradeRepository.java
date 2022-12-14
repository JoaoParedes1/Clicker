package com.joaoparedes.clicker.repositories;

import com.joaoparedes.clicker.models.Upgrade;

import java.util.ArrayList;

public class UpgradeRepository {

    private static UpgradeRepository repository;
    private boolean init = false;
    private ArrayList<Upgrade> upgrades = new ArrayList<>();

    public static UpgradeRepository getInstance(){

        if(repository == null){
            repository = new UpgradeRepository();

            repository.save(new Upgrade("Click",1,"Aumenta o efeito dos clicks!", 1,true,10));
            repository.save(new Upgrade("Ajudante",1,"Alguem clicando com você!", 1,false,50));
            repository.save(new Upgrade("Fabrica",1,"Fabrica para criar mais cookies automaticamente!", 5,false,100));
            repository.save(new Upgrade("Vitoria",99,"Compre este item para completar o jogo", 2,false,1000));
        }
        return repository;
    }

    private UpgradeRepository(){ }

    public void save(Upgrade upgrade){
        upgrades.add(upgrade);
    }

    public void saveInIndex(Upgrade upgrade, int position){
        upgrades.add(position, upgrade);
    }

    public void delete(Upgrade upgrade){
        upgrades.remove(upgrade);
    }

    public ArrayList<Upgrade> getAll(){
        return upgrades;
    }

    public Upgrade getByIndex(int index){
        return upgrades.get(index);
    }
}
