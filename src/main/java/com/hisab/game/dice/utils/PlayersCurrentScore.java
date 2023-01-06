package com.hisab.game.dice.utils;

import com.hisab.game.dice.config.FeignConfig;
import com.hisab.game.dice.dto.CurrentScoreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "current-score", url = "http://localhost:8080/roll-dice/api/v1/current-score", configuration = FeignConfig.class)
public interface PlayersCurrentScore {
    @RequestMapping(method = RequestMethod.GET)
    CurrentScoreDto currentScore(String name);
}
