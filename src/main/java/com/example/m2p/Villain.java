package com.example.m2p;

public class Villain extends HeroCharacter{

    boolean armourState = false;

    public boolean getArmour()
    {
        return armourState;
    }
    public void setArmour() {
        boolean currentArmourState = getArmour();
        this.armourState = !currentArmourState;
    }




//    @Override
//    public Integer getHealth() {
//        return super.getHealth();
//    }
}
