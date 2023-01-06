package com.hisab.game.dice.service;

import com.hisab.game.dice.controller.StartGameController;
import com.hisab.game.dice.dto.CurrentScoreDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * It's a class that gets the current score of the game.
 */
@Service
@Slf4j
public class CurrentScoreService {
    @Autowired
    private GameService gameService;
    @Autowired
    private StartGameController startGameController;
    private List<CurrentScoreDto> currentPlayerScore = new ArrayList<>();

    /**
     * > We're getting a list of players from the game service, mapping each player to a CurrentScoreDto, and returning the
     * list of CurrentScoreDto's
     *
     * @return A list of CurrentScoreDto objects
     */
    public List<CurrentScoreDto> getCurrentScore(){
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();
        currentPlayerScore = gameService.getPlayers()
                .stream()
                .map(score -> {
                    CurrentScoreDto scoreDto = new CurrentScoreDto();
                    scoreDto.setName(score.getName()) ;
                    if(scoreDto.getName() == score.getName()){
                        scoreDto.setTotalScore(startGameController.playrerCurrentScore);
                        log.info("I am true");
                    }else {
                        startGameController.playrerCurrentScore = 0;
                    }

                    log.info("Current score {}", startGameController.playrerCurrentScore);
                //    scoreDto.setAge(score.getAge());
           //   log.info("Marjan Score {}", StartGameController.playrerCurrentScore);
                    return scoreDto;
                })
                .collect(Collectors.toList());
        return currentPlayerScore;
    }
public List<CurrentScoreDto> getCurrentPlayersScore(){
        return currentPlayerScore;
  }
}
