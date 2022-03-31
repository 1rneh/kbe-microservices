package com.henri.kbe.adapter.clients;

import com.henri.kbe.adapter.http.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.validation.constraints.NotNull;

@Service
@RequiredArgsConstructor
public class OpenWeatherApiClient {

    public static final String EXTERNAL_API = "https://api.openweathermap.org/data/2.5/weather?q={country}&APPID={APPID}";
    public static final String APPID = "280621c54f79329a9f0e3d235559e54d";

    private final RestTemplate restTemplate;

    public ResponseEntity<Object> checkoutWeather(@NotNull String country) {

        if (country == null) throw new ApiException("Country/city must not be null. Getting weather data failed.");

        Object response = restTemplate.getForObject(
                EXTERNAL_API,
                Object.class,
                country,
                APPID);

        return new ResponseEntity(response, HttpStatus.OK);
    }
}
