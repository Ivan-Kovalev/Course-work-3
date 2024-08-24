package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.NotificationTask;

@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {

    @Query(value = "SELECT * FROM notification_task WHERE DATE (date) = DATE(CURRENT_TIMESTAMP)", nativeQuery = true)
    NotificationTask findNotificationTaskByDate();

}
