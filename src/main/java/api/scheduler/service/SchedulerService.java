package api.scheduler.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Slf4j
@EnableScheduling
@Service
public class SchedulerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerService.class);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 5000) // não leva em consideração a última execução se definirmos um fixedRate de cinco segundos para a nossa tarefa e a mesma demorar três segundo para executar, a próxima execução será em apenas dois segundos
    public void exampleScheduler1() {
        LOGGER.info("Momento exampleScheduler1: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }

    @Scheduled(fixedDelay = 2000) // executa 2 segundos depois da tarefa ter sido executada
    public void exampleScheduler2() {
        LOGGER.info("Momento exampleScheduler2: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            LOGGER.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }

    @Scheduled(fixedRate = 2000, initialDelay = 1000)
    public void exampleScheduler3() {
        LOGGER.info("Momento exampleScheduler3: {}", DATE_TIME_FORMATTER.format(LocalDateTime.now()));
    }
}