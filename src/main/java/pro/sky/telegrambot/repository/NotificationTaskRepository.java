package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.model.NotificationTask;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {

    @Query(value = "SELECT * FROM notification_task nt WHERE to_char(nt.date, 'YYYY-MM-DD HH24:MI') = to_char(cast(:dateTime as timestamp), 'YYYY-MM-DD HH24:MI')", nativeQuery = true)
    List<NotificationTask> findNotificationTaskByDate(@Param("dateTime") LocalDateTime dateTime);
}
