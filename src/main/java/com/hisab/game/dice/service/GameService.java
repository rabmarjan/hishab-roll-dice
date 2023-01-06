package com.hisab.game.dice.service;

import com.hisab.game.dice.converter.PlayerConverter;
import com.hisab.game.dice.dto.PlayerDto;
import com.hisab.game.dice.model.Player;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * The GameService class is a service class that contains a list of players and a converter class that converts the player
 * entity to a player DTO
 */
@Service
@Slf4j
public class GameService {

    public List<Player> playersList = new ArrayList<>();
    public static List<PlayerDto> players = new ArrayList<>();

    private final PlayerConverter playerConverter;

    @Autowired
    public GameService(PlayerConverter playerConverter) {
        this.playerConverter = playerConverter;
    }


    /**
     * The function takes a player object as a parameter and converts it to a playerDto object. It then checks if the
     * player list is empty and if it is, it adds the playerDto object to the list and returns the list. If the list is not
     * empty, it checks if the playerDto object already exists in the list and if it does, it returns the list. If the
     * playerDto object does not exist in the list, it adds it to the list and returns the list
     *
     * @param player The object that will be converted to a DTO.
     * @return A list of players
     */
    public List<Player> createPlayers(@Valid Player player) {
        for (Player person : playersList) {
            if (person.getName().contains(player.getName())) {
                //playersList.add(player);
                log.info("Player name: {} already exists.", player.getName());
                return playersList;
            }
        }
        if(playersList.size() <= 3) {
            playersList.add(player);
            log.info("Player name: {}, age: {} created", player.getName(), player.getAge());
        }
        players = playersList
                .stream()
                .map(playerConverter::convertEntityToDto)
                .collect(Collectors.toList());
        return playersList;

    }

    public List<Player> getPlayers() {
        return playersList;
//                .stream()
//                .map(playerConverter::convertEntityToDto)
//                .collect(Collectors.toList());
    }
}
