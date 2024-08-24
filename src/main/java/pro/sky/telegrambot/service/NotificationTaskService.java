package pro.sky.telegrambot.service;

import pro.sky.telegrambot.model.NotificationTask;

import java.time.LocalDateTime;

public interface NotificationTaskService {

    void save(NotificationTask task);

    NotificationTask findNotificationTaskByDate();

}
