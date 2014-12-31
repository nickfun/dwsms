package gs.nick.dwsms.views;

import io.dropwizard.views.View;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author nick
 */
public class BasicView extends View {

    private String dateFormat;

    public BasicView() {
        super("basic-view.ftl");
    }

    public BasicView(String file) {
        super(file);
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }

}
