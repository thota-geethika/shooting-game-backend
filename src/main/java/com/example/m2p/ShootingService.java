package com.example.m2p;

import org.springframework.stereotype.Service;

@Service
public class ShootingService {

    HeroCharacter heroCharacter = new HeroCharacter();

    Villain villain = new Villain();
    public Integer getHeroHealth() {
        return heroCharacter.getHealth();
    }

    public Integer getVillainHealth() {
        return villain.getHealth();
    }

    public boolean getArmourState()
    {
        return villain.getArmour();
    }


    public Integer shootsHero() {
        Integer currentHeroHealth = heroCharacter.getHealth();
        currentHeroHealth -= 20;
        heroCharacter.setHealth(currentHeroHealth);
        return currentHeroHealth;
    }

    public void setArmourState() {
        villain.setArmour();
    }

    public Integer shootsVillain() {
        Integer currentVillainHealth = villain.getHealth();

        if(villain.getArmour())
        {
            currentVillainHealth -= 10;
        }
        else
        {
            currentVillainHealth -= 20;
        }

        villain.setHealth(currentVillainHealth);
        return currentVillainHealth;
    }
}


