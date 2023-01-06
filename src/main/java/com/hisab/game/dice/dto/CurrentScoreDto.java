package com.hisab.game.dice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * It's a data transfer object (DTO) that represents the current score of a player
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CurrentScoreDto {
    private String name;
    @JsonIgnore
    private int age;
    private int totalScore;
}
