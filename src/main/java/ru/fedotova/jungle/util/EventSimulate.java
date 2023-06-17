package ru.fedotova.jungle.util;

import ru.fedotova.jungle.model.Bear;

public class EventSimulate {
    /* 1 поспал  +60 энергии
    2 гулял по лесу -25 энергии
    3 поймал рыбу -30 энергии  здоровье  + k*5
    4 попал в капкан -50здоровья
    5 залез на дерево -35энергии
    6 поел меда здоровье +k*3 +15энергии
    7 напал охотник -150 здоровья
    8 поплавал -40энергии
    9 погрелся на солнце +30энергии
    10 вырыл коренья здоровье + k*2   -20энергии

     */
    public void startSimulation(Bear bear){
        while (checkStatus(bear)) {
            int eventNumber = (int) (Math.random()*100);
            if (eventNumber >=0 && eventNumber < 10){
                sleep(bear);
            } else if (eventNumber >=10 && eventNumber < 20) {
                walk(bear);
            } else if (eventNumber >=20 && eventNumber < 30) {
                getFish(bear);
            } else if (eventNumber >=30 && eventNumber < 40){
                hitTrap(bear);
            } else if (eventNumber >=40 && eventNumber < 50) {
                climbTree(bear);
            } else if (eventNumber >=50 && eventNumber < 60) {
                eatHoney(bear);
            } else if (eventNumber >=60 && eventNumber < 70) {
                hunterAttack(bear);
            } else if (eventNumber >=70 && eventNumber < 80) {
                swim(bear);
            } else if (eventNumber >=80 && eventNumber < 90) {
                sunbathe(bear);
            } else if (eventNumber >=90 && eventNumber <= 100) {
                digRoots(bear);
            }
        }
        System.out.println("Медведь умер");

    }
    private void sleep(Bear bear){
        int energy = bear.getEnergy()+60;
        if (energy > 100){
            energy = 100;
        }
        bear.setEnergy(energy);
        checkEnergy(bear);

        System.out.println("Медведь поспал + 60 энергии. Текущая энергия: " + bear.getEnergy());
    }
    private void walk(Bear bear){
        int energy = bear.getEnergy() - 25;
        if (energy<0){
            energy = 0;
        }
        bear.setEnergy(energy);
        checkEnergy(bear);
        System.out.println("Медведь гулял по лесу. -25 энергии. Текущая энергия:" + bear.getEnergy());
    }
    private void getFish(Bear bear) {
        int energy = bear.getEnergy() - 30;
        if (energy < 0) {
            energy = 0;
        }
        bear.setEnergy(energy);
        int health = bear.getHealth() + (int) (bear.getK()*5);
        if (health > 300) {
            health = 300;
        }
        bear.setHealth(health);
        checkEnergy(bear);
        System.out.println("Медведь поймал рыбу. -30 энергии, " + (int) (bear.getK()*5) + " здоровья. Текущая энергия:" + bear.getEnergy() +
                ". Текущее здоровье:" + bear.getHealth());


    }

    private void hitTrap(Bear bear){
            int health = bear.getHealth() - 50;
            if (health < 0){
                health = 0;
            }
            bear.setHealth(health);
            checkEnergy(bear);
            System.out.println("Медведь попал в капкан. -50 здоровья. Текущее здоровье:" + bear.getHealth());
    }
    private void climbTree(Bear bear){
            int energy = bear.getEnergy() - 35;
            if (energy<0){
                energy = 0;
            }
            bear.setEnergy(energy);
            checkEnergy(bear);
            System.out.println("Медведь залез на дерево. -35 энергии. Текущая энергия:" + bear.getEnergy());
    }
    private void eatHoney(Bear bear){
            int energy = bear.getEnergy()+15;
            if (energy > 100) {
                energy = 100;
            }
            bear.setEnergy(energy);
            int health = bear.getHealth() + (int) (bear.getK()*3);

            health = health + 10;
            if (health > 300) {
                health = 300;
            }
            bear.setHealth(health);
            checkEnergy(bear);
            System.out.println("Медведь поел мед. +15 энергии, " + (int) (bear.getK()*3) + " здоровья. Текущая энергия:" + bear.getEnergy() +
                    ". Текущее здоровье:" + bear.getHealth());
    }

    private void hunterAttack(Bear bear){
                int health = bear.getHealth() - 150;
                if (health < 0){
                    health = 0;
                }
                bear.setHealth(health);
                checkEnergy(bear);
                System.out.println("На медведя напал охотник. -150 здоровья. Текущее здоровье:" + bear.getHealth());
    }
    private void swim(Bear bear){
        int energy = bear.getEnergy() - 40;
        if (energy<0){
            energy = 0;
        }
        bear.setEnergy(energy);
        checkEnergy(bear);
        System.out.println("Медведь поплавал. -40 энергии. Текущая энергия:" + bear.getEnergy());
    }
    private void sunbathe(Bear bear){
        int energy = bear.getEnergy() + 30;
        if (energy > 100){
            energy = 100;
        }
        bear.setEnergy(energy);
        checkEnergy(bear);
        System.out.println("Медведь погрелся на солнце. + 30 энергии. Текущая энергия: " + bear.getEnergy());
    }
    private void digRoots(Bear bear) {
        int energy = bear.getEnergy() - 20;
        if (energy < 0) {
            energy = 0;
        }
        bear.setEnergy(energy);
        int health = bear.getHealth() + (int) (bear.getK()*2);
        if (health > 300) {
            health = 300;
        }
        bear.setHealth(health);
        checkEnergy(bear);
        System.out.println("Медведь вырыл коренья. -20 энергии, " +(int) (bear.getK()*2) + "здоровья. Текущая энергия:" + bear.getEnergy() +
                ". Текущее здоровье:" + bear.getHealth());


    }
    private boolean checkStatus(Bear bear){
        if (bear.getHealth() <= 0){
            return false;
        }
        else{
            return true;
        }
    }
    private void checkEnergy(Bear bear){
        if (bear.getEnergy()<=0){
            int health = bear.getHealth() - 5;
            if (health < 0) {
                health = 0;
            }
            bear.setHealth(health);
        }
    }



}
