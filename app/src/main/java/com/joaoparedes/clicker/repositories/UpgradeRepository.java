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

            repository.save(new Upgrade("Click ","Aumenta o efeito dos clicks!", 1,true,10));
            repository.save(new Upgrade("Ajudante ","Alguem clicando com você!", 1,false,50));
            repository.save(new Upgrade("Fabrica ","Fabrica para criar mais cookies automaticamente!", 5,false,100));
            repository.save(new Upgrade("Vitoria","Compre este item para completar o jogo", 2,false,1000));
        }
        return repository;
    }

    private UpgradeRepository(){ }

    public void save(Upgrade gift){
        upgrades.add(gift);
    }

    public void delete(Upgrade gift){
        upgrades.remove(gift);
    }

    public ArrayList<Upgrade> getAll(){
        return upgrades;
    }

    public Upgrade getByIndex(int index){
        return upgrades.get(index);
    }

    public void deleteByIndex(int index){
        upgrades.remove(index);
    }

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }
}
