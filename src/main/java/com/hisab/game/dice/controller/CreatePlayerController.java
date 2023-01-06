package com.hisab.game.dice.controller;

import com.hisab.game.dice.dto.PlayerDto;
import com.hisab.game.dice.model.Player;
import com.hisab.game.dice.service.GameService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * It takes a player object, validates it, and then creates a list of players
 */
@RestController
@Slf4j
public class CreatePlayerController {
    @Autowired
    private GameService gameService;

    /**
     * It takes a player object, validates it, and then creates a list of players
     *
     * @param player This is the player object that is passed in the request body.
     * @return A list of players
     */
    @PostMapping("/api/v1/create-player")
    public List<Player> createPlayer(@Valid @RequestBody Player player){
        List<Player> players= gameService.createPlayers(player);
        return players;
    }
}
