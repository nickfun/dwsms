package gs.nick.dwsms.models;

import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nick
 */
public class MyTimerTask extends TimerTask {

    private Logger log;

    public MyTimerTask() {
        log = LoggerFactory.getLogger(MyTimerTask.class);
    }

    @Override
    public void run() {
        log.info("TimerTask RUN RUN RUN");
    }

}
