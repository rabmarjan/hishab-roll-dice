package com.hisab.game.dice.controller;

import com.hisab.game.dice.dto.CurrentScoreDto;
import com.hisab.game.dice.dto.ScoreDto;
import com.hisab.game.dice.dto.StartGameDto;
import com.hisab.game.dice.model.Player;
import com.hisab.game.dice.service.CurrentScoreService;
import com.hisab.game.dice.service.GameService;
import com.hisab.game.dice.utils.HttpClient;
import com.hisab.game.dice.utils.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * It's a controller class that takes the name of the player as input and rolls the dice
 */
@RestController
@Slf4j
public class StartGameController {
    @Value("${service.properties.game-win}")
    private int gameWin;
    @Autowired
    private HttpClient httpClient;
  //  @Autowired
  //  private PlayersCurrentScore playersCurrentScore;
    @Autowired
    private GameService gameService;
    @Autowired
    private CurrentScoreService currentScore;
      public static int playrerCurrentScore = 0;

    @PostMapping("/api/v1/game-start")
    public ResponseEntity<Message> rollDice(@RequestBody StartGameDto startGame) {

        ScoreDto diceNumber = httpClient.rollDice();
        log.info("Game win score configurable from application property file {}", gameWin);
//        CurrentScoreDto currentScoreDto = playersCurrentScore.currentScore(startGame.name());
        playrerCurrentScore += diceNumber.score();
        for (Player player : gameService.getPlayers()) {

            if (player.getName().equals(startGame.name())) {
                for (CurrentScoreDto scores: currentScore.getCurrentPlayersScore()){
                    scores.setTotalScore(5);
                    log.info("Current Player name {}, score {}", player.getName(), playrerCurrentScore);

                    log.info(" Marjan player {} Hello hello  score {}",player.getName(), playrerCurrentScore);
                    log.info("Hello {}", playrerCurrentScore + diceNumber.score());
                //    playrerCurrentScore = scores.getTotalScore();
                        if(diceNumber.score() < 6) {
                            if(scores.getTotalScore() < 0 ) {
                                scores.setTotalScore(0);
                            }else {
                                scores.setTotalScore(diceNumber.score());
                            }
                        }
                    if (diceNumber.score() != 6){
                        if(scores.getTotalScore() > 0){
                            scores.setTotalScore(diceNumber.score());
                        }

                    }
                //        playrerCurrentScore = scores.getTotalScore();
                }
                 {

                    log.info("Player name: {}, Total Score: {}, Current Value of Dice: {}", startGame.name(), playrerCurrentScore, diceNumber.score());
                    return new ResponseEntity<>(new Message(String.format("Your dice score: %d, try next time", diceNumber.score())), HttpStatus.OK);
                }
            }
           //     else {
         //       return new ResponseEntity<>(new Message("Player does not exists"), HttpStatus.NOT_FOUND);
       //     }
            //    var i = play.totalScore() + totalScoreOfUser;
        }
        log.info("Player name: {startGame.name()}, Total Score: {totalScoreOfUser}, Current Value of Dice: {diceNumber.score()}");
        return new ResponseEntity<>(new Message(String.format("Your score: %d", diceNumber.score())), HttpStatus.OK);
    }
}
