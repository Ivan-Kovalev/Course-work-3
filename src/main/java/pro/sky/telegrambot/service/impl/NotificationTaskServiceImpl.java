package pro.sky.telegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.NotificationTaskRepository;
import pro.sky.telegrambot.service.NotificationTaskService;
import pro.sky.telegrambot.utils.NotificationTaskPatternsAndConstant;

import java.time.LocalDateTime;
import java.util.List;

import static pro.sky.telegrambot.utils.NotificationTaskPatternsAndConstant.CURRENT_TIME_TO_MINUTES;


@Service
@RequiredArgsConstructor
public class NotificationTaskServiceImpl implements NotificationTaskService {

    private final NotificationTaskRepository notificationTaskRepository;


    @Override
    public void save(NotificationTask task) {
        task.setId(null);
        notificationTaskRepository.save(task);
    }

    @Override
    public NotificationTask findNotificationTaskByDate() {
        return notificationTaskRepository.findNotificationTaskByDate();
    }
}
