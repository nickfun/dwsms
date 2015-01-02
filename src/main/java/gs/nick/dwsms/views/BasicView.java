package gs.nick.dwsms.views;

import io.dropwizard.views.View;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author nick
 */
public class BasicView extends View {

    public BasicView() {
        super("basic-view.ftl");
    }

    public BasicView(String file) {
        super(file);
    }

    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }

}
