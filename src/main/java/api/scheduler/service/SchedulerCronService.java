package api.scheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@EnableScheduling
@Service
public class SchedulerCronService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerCronService.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * *", zone = "America/Sao_Paulo") //a cada 5 segundos
    public void exampleSchedulerCron1() {
        LOGGER.info("Momento exampleSchedulerCron1: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 0 0 ? * MON#1", zone = "America/Sao_Paulo") //a primeira segunda-feira do mês à meia-noite.
    public void exampleSchedulerCron2() {
        LOGGER.info("Momento exampleSchedulerCron2: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 0 0 1W * *", zone = "America/Sao_Paulo") //primeiro dia útil do mês à meia-noite.
    public void exampleSchedulerCron3() {
        LOGGER.info("Momento exampleSchedulerCron3: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 0 12 * * *", zone = "America/Sao_Paulo") //todos os dias ao meio dia
    public void exampleSchedulerCron4() {
        LOGGER.info("Momento exampleSchedulerCron4: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 0 * * * *", zone = "America/Sao_Paulo") //a cada hora
    public void exampleSchedulerCron5() {
        LOGGER.info("Momento exampleSchedulerCron5: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }
}
