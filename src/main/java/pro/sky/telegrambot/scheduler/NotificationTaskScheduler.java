package pro.sky.telegrambot.scheduler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.service.NotificationTaskService;

import static pro.sky.telegrambot.utils.NotificationTaskPatternsAndConstant.CURRENT_TIME_TO_MINUTES;

@RequiredArgsConstructor
@Component
public class NotificationTaskScheduler {

    private final NotificationTaskService notificationTaskService;
    private final TelegramBot telegramBot;

    @Scheduled(cron = "0 0/1 * * * *")
    public void run() {
        NotificationTask task = notificationTaskService.getCurrentTask(CURRENT_TIME_TO_MINUTES);
        if (task != null) {
            SendMessage message = new SendMessage(task.getChatId(), "Ваше напоминание:\n" + task.getMessage());
            telegramBot.execute(message);
        }
    }
}
