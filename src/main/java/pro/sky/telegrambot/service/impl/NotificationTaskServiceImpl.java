package pro.sky.telegrambot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.NotificationTaskRepository;
import pro.sky.telegrambot.service.NotificationTaskService;

import java.util.List;



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
    public List<NotificationTask> findNotificationTaskByDate() {
        return notificationTaskRepository.findNotificationTaskByDate();
    }
}
