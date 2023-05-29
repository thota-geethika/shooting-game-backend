package com.example.m2p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ShootingController {

    @Autowired
    ShootingService shootingService;

    @GetMapping("/heroHealth")
    public Integer getHeroHealth()
    {
        return shootingService.getHeroHealth();
    }

    @GetMapping("/villainHealth")
    public Integer getVillainHealth()
    {
        return shootingService.getVillainHealth();
    }

//    @GetMapping("/villain/armourState")
//    public boolean getArmourState()
//    {
//        return shootingService.getArmourState();
//    }

    @PutMapping("/shoots/hero")
    public Integer shootsHero()
    {
        return shootingService.shootsHero();
    }

    @PutMapping("/villain/armour")
    public boolean enableVillainArmour()
    {
        shootingService.setArmourState();
        return shootingService.getArmourState();
    }

    @PutMapping("/shoots/villain")
    public Integer shootsVillain()
    {
        return shootingService.shootsVillain();
    }



}
