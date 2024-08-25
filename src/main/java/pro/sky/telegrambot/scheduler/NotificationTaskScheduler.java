package pro.sky.telegrambot.scheduler;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.service.NotificationTaskService;

import java.util.List;

@RequiredArgsConstructor
@Component
public class NotificationTaskScheduler {

    private final NotificationTaskService notificationTaskService;
    private final TelegramBot telegramBot;

    @Scheduled(cron = "0 0/1 * * * *")
    public void run() {
        List<NotificationTask> tasks = notificationTaskService.findNotificationTaskByDate();
        if (!tasks.isEmpty()) {
            for (NotificationTask task : tasks) {
                SendMessage message = new SendMessage(task.getChatId(), "Ваше напоминание:\n" + task.getMessage());
                telegramBot.execute(message);
            }
        }
    }
}
