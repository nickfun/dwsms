package gs.nick.dwsms.models;

import org.joda.time.LocalDateTime;

/**
 *
 * @author nick
 */
public class TxtMessage {

    public String to;
    public String from;
    public String body;
    public LocalDateTime send;

    public boolean isValid() {
        return send != null
                && to != null
                && from != null
                && body != null
                && body.length() <= 160;
    }
}
