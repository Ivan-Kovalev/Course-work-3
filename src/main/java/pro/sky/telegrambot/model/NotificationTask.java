package pro.sky.telegrambot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class NotificationTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long chatId;
    private String message;
    private LocalDateTime date;

    public NotificationTask(Long chatId, String message, LocalDateTime date) {
        this.chatId = chatId;
        this.message = message;
        this.date = date;
    }
}
