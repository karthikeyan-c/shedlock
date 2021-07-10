package com.kc.shedlock;


import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FXSchedule {

    @Scheduled(cron = "* */15 * * * *")
    //@Scheduled(fixedRate = 15000)
    @SchedulerLock(name = "FX_RATE_FETCH", lockAtMostFor = "14m", lockAtLeastFor = "14m")
    public void scheduledTask() {
        // Fetch FX rate from TDS and save in DB.
        log.info("FX rate fetch start from TDS ....");
//        Thread.sleep(2000);
//        log.info("FX rate fetch completed from TDS ....");
    }
}
