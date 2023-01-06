package com.hisab.game.dice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * It's a data transfer object (DTO) that represents a player
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {
    private String name;
    @JsonIgnore
    private int age;
    private int totalScore;
}