package com.telegram.resliv.bot.utils;

import com.telegram.resliv.model.City;
import com.telegram.resliv.service.CityService;

import java.util.ArrayList;
import java.util.List;

public class BotCommand {
    private String message;
    private CityService cityService;

    public BotCommand(String message, CityService cityService) {
        this.message = message;
        this.cityService = cityService;
    }

    public String answer() {
        if (message.equals("/start")) {
            return BotMessage.messageStart;
        }

        if (message.equals("/info")) {
            return BotMessage.messageInfo;
        }

        if (message.equals("/all")) {
            return getAllCity();
        }

        if (isAdd(message)) {
            return addCity();
        }
        if ((isUpdate(message)) && (!isMsg(message))) {
            return updateCity();
        }

        if ((isUpdate(message)) && (isMsg(message))) {
            return updateMsg();
        }

        if(isDelete(message)){
            return deleteCity();
        }

        if (cityService.getByName(message) != null) {
            return cityService.getByName(message).getMessage();
        }

        return BotMessage.messageError;
    }

    private boolean isAdd(String text) {
        return text.indexOf("/add") != -1;
    }


    private boolean isUpdate(String text) {
        return text.indexOf("/update") != -1;
    }

    private boolean isMsg(String text) {
        return text.indexOf("\"") != -1;
    }

    private boolean isDelete(String text) {
        return text.indexOf("/delete") != -1;
    }


    private String getAllCity() {
        List<String> list = new ArrayList<>();

        List<City> cities = cityService.getAll();

        for (City city : cities) {
            list.add(city.getName());
        }

        return list.toString().substring(1, list.toString().length() - 1);
    }

    private String addCity() {
        String nameCity = message.substring(message.indexOf(" "), message.indexOf(":")).trim();
        String msg = message.trim().substring(message.indexOf("\"") + 1, message.length()-1);
        City city=cityService.getByName(nameCity);
        if (city==null){
            city=new City();
            city.setName(nameCity);
            city.setMessage(msg);
            cityService.addCity(city);
            return BotMessage.messageAdd;
        }
        return BotMessage.messageError;

    }

    private String updateCity() {
        String nameCity = message.substring(message.indexOf(" "), message.indexOf(">")).trim();
        String newCity = message.substring(message.indexOf(">") + 1, message.length()).trim();
        City city=cityService.getByName(nameCity);
        if (city!=null){
            city.setName(newCity);
            cityService.update(city);
            return BotMessage.messageUpdate;
        }
        return BotMessage.messageError;
    }

    private String updateMsg() {
        String nameCity = message.substring(message.indexOf(" "), message.indexOf(">")).trim();
        String msg = message.trim().substring(message.indexOf("\"") + 1, message.length()-1);
        City city=cityService.getByName(nameCity);
        if (city!=null){
            city.setMessage(msg);
            cityService.update(city);
            return BotMessage.messageUpdate;
        }
        return BotMessage.messageError;
    }

    private String deleteCity(){
        String nameCity=message.substring(message.indexOf(" "),message.length()).trim();
        City city=cityService.getByName(nameCity);
        if (city!=null){
            cityService.delete(city.getId());
            return BotMessage.messageDelete;
        }
        return BotMessage.messageError;
    }
}
