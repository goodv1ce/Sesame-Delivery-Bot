package ua.sesame.delivery_bot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
@RequiredArgsConstructor
public class DeliveryBotApplication implements CommandLineRunner {
	private final SesameDeliveryBot sesameDeliveryBot;

	public static void main(String[] args) {
		SpringApplication.run(DeliveryBotApplication.class, args);
	}


	@Override
	public void run(String... args) {
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
			telegramBotsApi.registerBot(sesameDeliveryBot);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
