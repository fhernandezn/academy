package rest.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.api.APIRequester;
import rest.api.APIResponse;
import rest.api.APIUrlComposer;

@RestController
@RequestMapping("/rest")
public class ApiRestController {

    //@RequestParam(value="name", defaultValue="World"

    @RequestMapping("/list")
    public String listHotels() throws IOException, NoSuchAlgorithmException {
        APIUrlComposer composer = new APIUrlComposer("list");
        composer.addParam("city", "Chihuahua");
        composer.addParam("stateProvinceCode", "CUU");
        composer.addParam("countryCode", "MX");
        composer.addParam("arrivalDate", "09/04/2015");
        composer.addParam("departureDate", "09/05/2015");
        composer.addParam("room1", "4");

        APIResponse response = new APIRequester().doRequest(composer.getUrl());
        return response.toString();
    }

    @RequestMapping("/info")
    public String getHotelInfo(@RequestParam(value="hotelId", defaultValue = "-1") String hotelId) throws IOException, NoSuchAlgorithmException {
        APIUrlComposer composer = new APIUrlComposer("info");
        composer.addParam("hotelId", hotelId);
        composer.addParam("options", "HOTEL_SUMMARY");

        APIResponse response = new APIRequester().doRequest(composer.getUrl());
        return response.toString();
    }

    @RequestMapping("/*")
    public String onError(){
        return "{\"error\":\"not found\"}";
    }

}