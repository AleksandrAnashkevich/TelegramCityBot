package com.telegram.resliv.bot;

import com.telegram.resliv.bot.utils.BotCommand;
import com.telegram.resliv.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class CityBot extends TelegramLongPollingBot {
    private final String BOT_USER_NAME = "CityMessageReslivbot";
    private final String TOKEN = "1132435302:AAGILmsnnbZSTGMLcF7jqZbHuZP1fmXZ9zo";

    @Autowired
    CityService cityService;

    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

        final long chat_id = update.getMessage().getChatId();
        final String message = update.getMessage().getText();
        SendMessage sendMessage = new SendMessage().setChatId(chat_id);
        BotCommand command = new BotCommand(message, cityService);

        sendMessage.setText(command.answer());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return BOT_USER_NAME;
    }

    public String getBotToken() {
        return TOKEN;
    }
}
