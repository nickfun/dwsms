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

    private final MessageSenderTask task;
    private Timer timer;
    private final long frequency;
    private final Logger log;

    public TimerManager(int seconds, MessageSenderTask toRun) {
        frequency = 1000 * seconds;
        log = LoggerFactory.getLogger(TimerManager.class);
        task = toRun;
    }

    @Override
    public void start() throws Exception {
        timer = new Timer();
        timer.schedule(task, 1000, frequency);
        log.info("Scheduled task will run every " + (frequency/1000) + " seconds");
    }

    @Override
    public void stop() throws Exception {
        timer.cancel();
        log.info("Shutdown of scheduled task");
    }

}
