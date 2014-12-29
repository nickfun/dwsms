package gs.nick.dwsms.models;

import java.util.TimerTask;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nick
 */
public class MyTimerTask extends TimerTask {

    private final Logger log;
    private final MessageDatabase msgDb;

    public MyTimerTask(MessageDatabase db) {
        log = LoggerFactory.getLogger(MyTimerTask.class);
        msgDb = db;
    }

    @Override
    public void run() {
        TxtMessage msg = msgDb.pop(LocalDateTime.now());
        if (msg == null) {
            log.debug("all messages have been sent, " + msgDb.size() + " remain in queue, NOW is: " + LocalDateTime.now());
        } else {
            log.info("Send the message!!! -- " + msg.body);
            MessageSender.sendMessage(msg);
            run();
        }
    }

}
