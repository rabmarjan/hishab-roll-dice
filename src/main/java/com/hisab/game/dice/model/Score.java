package com.hisab.game.dice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {
    private int id;
    private int totalScore;
    private Player playerScore;

}
