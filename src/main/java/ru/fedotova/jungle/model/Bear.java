package ru.fedotova.jungle.model;

public class Bear{
    //300 здоровья
    //100 энергии
    //коэффициент 2.5

    private int health = 300;
    private int energy = 100;

    private float k = 2.5f;

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth(){
        return this.health;
    }
    public void setEnergy(int energy){
        this.energy = energy;
    }
    public int getEnergy(){
        return this.energy;
    }

    public float getK() {
        return k;

    }
}
