package ua.sesame.delivery_bot.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessageHandler {
    void handle(Update update);
}
