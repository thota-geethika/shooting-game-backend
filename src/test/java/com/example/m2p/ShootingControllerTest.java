package com.example.m2p;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShootingController.class)
public class ShootingControllerTest {

    @MockBean
    ShootingService shootingService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldGetHealthOfTheHero() throws Exception
    {
        Mockito.when(shootingService.getHeroHealth()).thenReturn(100);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/heroHealth"))
                .andExpect(status().isOk())
                .andExpect(content().string("100"));
    }

    @Test
    public void shouldGetHealthOfTheVillain() throws Exception
    {
        Mockito.when(shootingService.getVillainHealth()).thenReturn(100);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/villainHealth"))
                .andExpect(status().isOk())
                .andExpect(content().string("100"));
    }

    @Test
    public void shouldDecreaseTheHealthOfHeroByTwentyWhenVillainAttacks() throws Exception
    {
        Mockito.when(shootingService.shootsHero()).thenReturn(80);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/shoots/hero"))
                .andExpect(status().isOk())
                .andExpect(content().string("80"));
    }

    @Test
    public void shouldEnableArmourUponClickingArmourButton() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/villain/armour"))
                .andExpect(status().isOk());

        verify(shootingService).setArmourState();
    }

    @Test
    public void shouldDisableTheArmourWhenClickedAgain() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/villain/armour"))
                .andExpect(status().isOk());

        verify(shootingService).setArmourState();

    }


    @Test
    public void shouldDecreaseVillainHealthByTwentyWhenArmourIsOff() throws Exception
    {
        when(shootingService.shootsVillain()).thenReturn(80);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/shoots/villain"))
                .andExpect(status().isOk())
                .andExpect(content().string("80"));
    }

    @Test
    public void shouldDecreaseVillainHealthByTenWhenArmourIsOn() throws Exception
    {
        when(shootingService.shootsVillain()).thenReturn(90);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/shoots/villain"))
                .andExpect(status().isOk())
                .andExpect(content().string("90"));
    }

}
