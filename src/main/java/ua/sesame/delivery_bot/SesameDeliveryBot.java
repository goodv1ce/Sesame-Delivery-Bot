package ua.sesame.delivery_bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ua.sesame.delivery_bot.service.BotService;

@Component
public class SesameDeliveryBot extends TelegramLongPollingBot {
    private final String botUsername;
    private final BotService botService;

    public SesameDeliveryBot(@Value("${telegram.bot.token}") String botToken,
                             @Value("${telegram.bot.username}") String botUsername,
                             BotService botService) {
        super(botToken);
        this.botService = botService;
        this.botUsername = botUsername;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(botService.processUpdate(update));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }
}
