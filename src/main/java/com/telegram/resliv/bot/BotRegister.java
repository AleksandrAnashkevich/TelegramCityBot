package com.telegram.resliv.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class BotRegister {
    private CityBot cityBot;
    private TelegramBotsApi telegramBotsApi;

    @Autowired
    public BotRegister(CityBot cityBot, TelegramBotsApi telegramBotsApi){
        try{
            telegramBotsApi.registerBot(cityBot);
        } catch (TelegramApiException ex){
            ex.printStackTrace();
        }

    }
}




