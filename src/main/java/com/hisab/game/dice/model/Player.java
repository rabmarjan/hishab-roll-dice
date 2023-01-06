package com.hisab.game.dice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hisab.game.dice.utils.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.lang.annotation.Annotation;

import static com.hisab.game.dice.utils.Column.unique;

/**
 * It's a POJO that represents a player
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player{
    private int id;
    @NotNull
    private String name;
    @NotNull
    private int age;
    @JsonIgnore
    private int totalScore = -1;


}
