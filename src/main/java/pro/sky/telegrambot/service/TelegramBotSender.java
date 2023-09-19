package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TelegramBotSender {

    private final Logger logger = LoggerFactory.getLogger(TelegramBotSender.class);
    private final TelegramBot telegramBot;

    public TelegramBotSender(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void send(Long chatId, String messageText) {

        SendMessage message = new SendMessage(chatId, messageText);
        SendResponse response = telegramBot.execute(message);
        if (!response.isOk()) {

            logger.error("Error occurred during sending massage, response = {}", response);
        } else {
            logger.info("Massage has been successfully send for chatId = {}", chatId);
        }
    }

}
