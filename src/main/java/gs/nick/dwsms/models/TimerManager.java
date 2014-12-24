package gs.nick.dwsms.models;

import io.dropwizard.lifecycle.Managed;
import java.util.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nick
 */
public class TimerManager implements Managed {

    private MyTimerTask task;
    private Timer timer;
    private long frequency;
    private Logger log;

    public TimerManager(int seconds) {
        frequency = 1000 * seconds;
        log = LoggerFactory.getLogger(TimerManager.class);
    }

    @Override
    public void start() throws Exception {
        timer = new Timer();
        task = new MyTimerTask();
        timer.schedule(task, 1000, frequency);
        log.info("Scheduled task will run every " + (frequency/1000) + " seconds");
    }

    @Override
    public void stop() throws Exception {
        timer.cancel();
        log.info("Shutdown of scheduled task");
    }

}
