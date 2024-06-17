package ua.sesame.delivery_bot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.sesame.delivery_bot.SesameDeliveryBot;
import ua.sesame.delivery_bot.commands.factory.CommandFactory;

@Service
@RequiredArgsConstructor
public class BotService {
    private final CommandFactory commandFactory;

    public SendMessage processUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());
            return message;
        }
        return null;
    }
}
