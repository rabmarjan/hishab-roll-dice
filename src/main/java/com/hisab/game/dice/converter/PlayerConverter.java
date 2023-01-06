package com.hisab.game.dice.converter;

import com.hisab.game.dice.dto.PlayerDto;
import com.hisab.game.dice.model.Player;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The PlayerConverter class is a Spring component that uses the ModelMapper library to convert a Player entity to a
 * PlayerDto
 */
@Component
public class PlayerConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PlayerDto convertEntityToDto(@Valid Player player) {
        return modelMapper.map(player, PlayerDto.class);

    }
}
