package com.telegram.resliv.bot.utils;

public class BotMessage {
    public final static String messageInfo =
            "Учебный бот\n"
                    + "Команды для запуска\n"
                    + "'/info' Информация\n"
                    + "'/all' Вывести список городов\n"
                    + "'/add city:\"msg\"' Добавить город и сообщение\n"
                    + "'/update oldCity > newCity' Изменить название города\n"
                    + "'/update city > \"msg\"' Изменить сообщение о городе\n"
                    + "'/delete city' Удалить город из БД\n"
                    + "'city' Вывести информацию о городе\n"
                    + "Бот чуствителен к запросам и требует соблюдение синтаксиса";

    public final static String messageStart =
            "Учебный бот\n"
                    + "Введите '/info' для информации";

    public final static String messageError = "Неверный город или комада";

    public final static String messageAdd = "Успешно добавлено";

    public final static String messageUpdate = "Успешно изменено";

    public final static String messageDelete = "Успешно удалено";

    public final static String messageFail= "Неудвчно. Проверьте название";


}
