package com.hisab.game.dice.utils;

import com.hisab.game.dice.config.FeignConfig;
import com.hisab.game.dice.dto.ScoreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "roll-dice", url = "http://developer-test.hishab.io/api/v1/roll-dice", configuration = FeignConfig.class)
public interface HttpClient {
    @RequestMapping(method = RequestMethod.GET)
    ScoreDto rollDice();
}



