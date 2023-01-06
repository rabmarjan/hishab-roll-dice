package com.hisab.game.dice.controller;

import com.hisab.game.dice.dto.CurrentScoreDto;
import com.hisab.game.dice.service.CurrentScoreService;
import com.hisab.game.dice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * It returns a list of CurrentScoreDto objects
 */
@RestController
public class RetriveScoreController {
    @Autowired
    private CurrentScoreService currentScore;
    @Autowired
    private GameService gameService;

    /**
     * It returns a list of CurrentScoreDto objects
     *
     * @return A list of CurrentScoreDto objects
     */
    @GetMapping("/api/v1/current-score")
    public List<CurrentScoreDto> getCurrentScore(){
        return currentScore.getCurrentScore();
       // return currentScore.getCurrentPlayersScore();
    }
}
