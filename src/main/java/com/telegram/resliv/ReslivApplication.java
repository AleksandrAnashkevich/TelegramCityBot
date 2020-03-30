package com.telegram.resliv;

import com.telegram.resliv.bot.CityBot;
import com.telegram.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class ReslivApplication {
    static {
        ApiContextInitializer.init();
    }

    public static void main(String[] args) {
        SpringApplication.run(ReslivApplication.class, args);
    }

    @Autowired
    CityService cityService;

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() {


        cityService.getAll().forEach(it -> System.out.println(it));
    }
}
