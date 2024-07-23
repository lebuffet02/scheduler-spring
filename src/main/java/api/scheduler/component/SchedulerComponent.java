package api.scheduler.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@EnableScheduling
@Component
public class SchedulerComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerComponent.class);

    @Scheduled(fixedRate = 5000)
    public void exampleScheduler1() {
        //LOGGER.info("The time is now {}", dateFormat.format(new Date()));
        LOGGER.info("The time is now {}", new Date());
    }
}
