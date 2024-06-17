package ua.sesame.delivery_bot.handlers.concrete;

import lombok.RequiredArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import ua.sesame.delivery_bot.commands.factory.CommandFactory;
import ua.sesame.delivery_bot.handlers.MessageHandler;

@RequiredArgsConstructor
public class TextMessageHandler implements MessageHandler {
    private final CommandFactory commandFactory;

    @Override
    public void handle(Update update) {

    }
}
