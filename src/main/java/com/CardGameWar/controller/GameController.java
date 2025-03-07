package com.CardGameWar.controller;

import com.CardGameWar.service.WarGame.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private Game game;

    @GetMapping("/compare")
    public String compareCards(){
        return game.compareCards();
    }

    @GetMapping("/war")
    public String war() {
        return game.war();
    }
}
