package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.NotificationTask;

import java.time.LocalDateTime;

@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {

//    @Query(value = "SELECT * FROM notification_task WHERE TIME(date) = TIME(CURRENT_TIMESTAMP)", nativeQuery = true)
//    NotificationTask getCurrentTask();

    NotificationTask findNotificationTaskByDate(LocalDateTime dateTime);

}
