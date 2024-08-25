package pro.sky.telegrambot.utils;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

@UtilityClass
public class NotificationTaskPatternsAndConstant {

    public static final Pattern PATTERN = Pattern.compile("(\\d{2}\\.\\d{2}\\.\\d{4}\\s\\d{2}:\\d{2})(\\s+)(.+)");

//    public static final LocalDateTime CURRENT_TIME_TO_MINUTES = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);

    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static final String BAD_REQUEST_TIME_FORMATTER = "Неверный формат даты и времени!\nОтправь корректный формат напоминания!";

    public static final String WELCOME_MESSAGE = "Привет, я могу сделать для тебя напоминание!\nНапиши напоминание в формате:\nдд.мм.гггг чч:мм -текст напоминания-";

    public static void sendMessage(TelegramBot telegramBot, Long chatId, String text) {
        SendMessage message = new SendMessage(chatId, text);
        telegramBot.execute(message);
    }
}
