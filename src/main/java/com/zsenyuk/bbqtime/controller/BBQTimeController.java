package com.zsenyuk.bbqtime.controller;

import com.zsenyuk.bbqtime.model.DoBBQ;
import com.zsenyuk.bbqtime.model.WeatherData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping(path = "/api")
public class BBQTimeController {

    @CrossOrigin
    @PostMapping(path = "/weatherData")
    public @ResponseBody DoBBQ getWeatherData(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {

        String url = "https://api.openweathermap.org/data/2.5/onecall?lat=" + lat +
                "&lon=" + lon + "&exclude=hourly,daily&appid=ea305d9a9362485b8bf56c11c1707694";
        RestTemplate restTemplate = new RestTemplate();
        WeatherData result = restTemplate.getForObject(url, WeatherData.class);

        return calculateDecision(result.getSumPrecipitation(), result.getTempInCelsius());


    }

    public DoBBQ calculateDecision(double temp, double precipitation){
        if (precipitation < 2 && temp >= 20) {
            return new DoBBQ(true);
        } else {
            return new DoBBQ(false);
        }
    }
}
