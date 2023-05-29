package com.example.m2p;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class ShootingServiceTest {

    @Autowired
    private ShootingService shootingService;

    @BeforeEach
    public void setup()
    {
        shootingService.heroCharacter.setHealth(100);
        shootingService.villain.setHealth(100);
        shootingService.villain.armourState = false;
    }

    @Nested
    class InitialHealths{
        @Test
        public void shouldReturnInitialHeroHealthAsHundred(){
            Integer initialHeroHealth = shootingService.heroCharacter.getHealth();
            assertThat(initialHeroHealth).isEqualTo(100);
        }

        @Test
        public void shouldReturnInitialVillainHealthAsHundred(){
            Integer initialVillainHealth = shootingService.villain.getHealth();
            assertThat(initialVillainHealth).isEqualTo(100);
        }
    }

    @Nested
    class VillainShootsHero{
        @Test
        public void shouldReturnEightyWhenVillainShootsHeroOnce(){
            Integer heroHealthAfterShoot = shootingService.shootsHero();
            assertThat(heroHealthAfterShoot).isEqualTo(80);
        }

        @Test
        public void shouldReturnSixtyWhenVillainShootsHeroTwice(){
            shootingService.shootsHero();
            Integer heroHealthAfterTwoShoots = shootingService.shootsHero();
            assertThat(heroHealthAfterTwoShoots).isEqualTo(60);
        }
    }

    @Nested
    class setArmourForVillain{
        @Test
        public void armourShouldBeOffInitially(){
            boolean armourPresence = shootingService.villain.getArmour();
            assertThat(armourPresence).isFalse();
        }

        @Test
        public void shouldOnTheArmourOnClicking(){
            shootingService.villain.setArmour();
            boolean armourPresence = shootingService.getArmourState();
            assertThat(armourPresence).isTrue();
        }

        @Test
        public void armourShouldTurnOffWhenClickedAgain()
        {
            shootingService.setArmourState();
            shootingService.setArmourState();
            boolean armourPresence = shootingService.villain.getArmour();
            assertThat(armourPresence).isFalse();
        }
    }

    @Nested
    class HeroShootsVillain{
        @Test
        public void shouldReturnEightyWhenHeroShootsVillainAndArmourIsOff()
        {
            Integer villainHealthAfterOneShoot = shootingService.shootsVillain();
            assertThat(villainHealthAfterOneShoot).isEqualTo(80);
        }

        @Test
        public void shouldReturnNinetyWhenHeroShootsVillainAndArmourIsOn()
        {
            shootingService.setArmourState();
            Integer villainHealthAfterOneShoot = shootingService.shootsVillain();
            assertThat(villainHealthAfterOneShoot).isEqualTo(90);
        }

        @Test
        public void shouldReturnSixtyWhenHeroShootsVillainTwiceAndArmourIsOff()
        {
            shootingService.shootsVillain();
            Integer villainHealthAfterTwoShoots = shootingService.shootsVillain();
            assertThat(villainHealthAfterTwoShoots).isEqualTo(60);
        }

        @Test
        public void shouldReturnEightyWhenHeroShootsVillainTwiceAndArmourIsOn()
        {
            shootingService.setArmourState();
            shootingService.shootsVillain();
            Integer villainHealthAfterTwoShoots = shootingService.shootsVillain();
            assertThat(villainHealthAfterTwoShoots).isEqualTo(80);
        }

        @Test
        public void shouldReturnSeventyWhenHeroShootsVillainWithArmourOnOnceAndArmourOffOnce()
        {
            shootingService.shootsVillain();
            shootingService.setArmourState();
            Integer villainHealthAfterTwoShoots = shootingService.shootsVillain();
            assertThat(villainHealthAfterTwoShoots).isEqualTo(70);
        }
    }

}
